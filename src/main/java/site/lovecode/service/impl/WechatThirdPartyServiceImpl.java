package site.lovecode.service.impl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import site.lovecode.client.WechatThirdPartyClient;
import site.lovecode.client.impl.WechatThirdPartyClientImpl;
import site.lovecode.entity.*;
import site.lovecode.mapper.*;
import site.lovecode.service.WechatThridPartyService;
import site.lovecode.support.bean.AuthorizerInfoBean;
import site.lovecode.support.bean.QueryAuthBean;
import site.lovecode.support.bean.XmlDecryptingBean;
import site.lovecode.support.bean.enums.AuthorizationStatusEnum;
import site.lovecode.support.bean.enums.BusinessInfoEnum;
import site.lovecode.util.IdWorker;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by Administrator on 2016/4/8.
 */
@Service
public class WechatThirdPartyServiceImpl implements InitializingBean, WechatThridPartyService {


    private Logger logger = LoggerFactory.getLogger(WechatThirdPartyServiceImpl.class);

    @Resource
    private ComponentVerifyTicketMapper componentVerifyTicketMapper;

    @Resource
    private UserAccessTokenMapper userAccessTokenMapper;

    @Resource
    private WechatThirdPartyConfigMapper wechatThirdPartyConfigMapper;


    @Resource
    private AuthorizerInfoMapper authorizerInfoMapper;

    @Resource
    private WechatThirdPartyClient wechatThirdPartyClient;

    @Resource
    private FuncInfoMapper funcInfoMapper;

   @Resource
    private BusinessInfoMapper businessInfoMapper;



    /**
     * 初始化加载公众号配置信息
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("----加载公众号第三方配置----");
        WechatThirdPartyClientImpl.wechatThirdPartyConfig = wechatThirdPartyConfigMapper.selectByPrimaryKey(1L);
        //获取已经存储的ticket
        ComponentVerifyTicket componentVerifyTicket = componentVerifyTicketMapper.selectOrderByCreateTime(WechatThirdPartyClientImpl.wechatThirdPartyConfig.getComponentAppid());
        if (Optional.ofNullable(componentVerifyTicket).isPresent() && componentVerifyTicket.getDeadline().getTime() > System.currentTimeMillis()) {
            WechatThirdPartyClientImpl.wechatThirdPartyConfig.setComponentVerifyTicket(componentVerifyTicket.getComponentVerifyTicket());
            WechatThirdPartyClientImpl.wechatThirdPartyConfig.setComponentAccessToken(wechatThirdPartyClient.refreshComponentAccessToken().getComponentAccessToken());
        }
        logger.info(WechatThirdPartyClientImpl.wechatThirdPartyConfig.toString());
    }


    /**
     * 保存ComponentVerifyTicket
     *
     * @param xmlDecryptingBean
     */
    @Override
    public void saveComponentVerifyTicket(XmlDecryptingBean xmlDecryptingBean) {
        //更新内存中的componentVerfiyTicket
        WechatThirdPartyClientImpl.wechatThirdPartyConfig.setComponentVerifyTicket(xmlDecryptingBean.getComponentVerifyTicket());
        //检查componentAccessToken是否为空
        if (StringUtils.isEmpty(WechatThirdPartyClientImpl.wechatThirdPartyConfig.getComponentAccessToken())) {
            WechatThirdPartyClientImpl.wechatThirdPartyConfig.setComponentAccessToken(wechatThirdPartyClient.refreshComponentAccessToken().getComponentAccessToken());
        }
        //保存到数据库
        componentVerifyTicketMapper.insert(new ComponentVerifyTicket() {
            {
                setComponentVerifyTicket(xmlDecryptingBean.getComponentVerifyTicket());
                setCreateTime(new Timestamp(Long.parseLong(xmlDecryptingBean.getCreateTime()) * 1000));
                setComponentAppid(xmlDecryptingBean.getAppId());
                setDeadline(new Timestamp(System.currentTimeMillis() + (60 * 60 * 1000)));
            }
        });
    }

    /**
     * 保存用户信息
     *
     * @param authCode
     * @throws IOException
     */
    public AuthorizerInfoBean saveAuthorizerInfo(String authCode) throws Exception {
        QueryAuthBean queryAuthBean = wechatThirdPartyClient.queryAuth(authCode);
        //保存公众号的access_token信息
        UserAccessToken userAccessToken = userAccessTokenMapper.selectOne(new UserAccessToken(){
            {
                setAuthorizerAppid(queryAuthBean.getAuthOrizationInfo().getAuthorizerAppid());
            }
        });
        UserAccessToken newUserAccessToken = new UserAccessToken(queryAuthBean.getAuthOrizationInfo().getAuthorizerAppid(),queryAuthBean.getAuthOrizationInfo().getAuthorizerAccessToken(),queryAuthBean.getAuthOrizationInfo().getExpriesIn(),queryAuthBean.getAuthOrizationInfo().getAuthorizerRefreshToken(),new Timestamp(System.currentTimeMillis()));
        if(userAccessToken!=null){
            newUserAccessToken.setId(userAccessToken.getId());
        }

        AuthorizerInfoBean authorizerInfoBean = wechatThirdPartyClient.getAuthorizerInfo(queryAuthBean.getAuthOrizationInfo().getAuthorizerAppid());
        //保存公众号基本信息

        AuthorizerInfo info = authorizerInfoMapper.selectOne(new AuthorizerInfo(){
            {
                setAuthorizerAppid(queryAuthBean.getAuthOrizationInfo().getAuthorizerAppid());
            }
        });
        AuthorizerInfo authorizerInfo = new AuthorizerInfo() {
            {
                setAuthorizerAppid(authorizerInfoBean.getAuthorizeationInfo().getAuthorizerAppid());
                setNickName(authorizerInfoBean.getAuthorizerInfo().getNickName());
                setAlias(authorizerInfoBean.getAuthorizerInfo().getAlizs());
                setHeadImg(authorizerInfoBean.getAuthorizerInfo().getHeadImg());
                setQrcodeUrl(authorizerInfoBean.getAuthorizerInfo().getQrcodeUrl());
                setServiceTypeInfo(authorizerInfoBean.getAuthorizerInfo().getServiceTypeInfo().getId());
                setVerifyTypeInfo(authorizerInfoBean.getAuthorizerInfo().getVerifyTypeInfo().getId());
                setUserName(authorizerInfoBean.getAuthorizerInfo().getUserName());
                setAuthorizationStatus(AuthorizationStatusEnum.AUTHORIZED.key());
            }
        };
        if(info!=null){
            authorizerInfo.setId(info.getId());
        }
        authorizerInfoMapper.replace(authorizerInfo);
        logger.info(authorizerInfo.toString());

        //保存公众号的权限信息
        Integer num = funcInfoMapper.delete(new FuncInfo(){
            {
                setAuthorizerInfoId(authorizerInfo.getId());
            }
        });
        logger.info("删除旧的权限信息："+num);
        List<FuncInfo> funcInfoList = queryAuthBean.getAuthOrizationInfo().getFuncInfoList().stream().map(funcInfoObject -> new FuncInfo() {
            {
                setId(IdWorker.getId());
                setFuncName(funcInfoObject.getFuncscopeCategory().getId());
                setAuthorizerInfoId(authorizerInfo.getId());
            }
        }).collect(Collectors.toList());
        funcInfoMapper.batchInsert(funcInfoList);
        //保存公众号的商业信息
       Integer businessInfoNum = businessInfoMapper.delete(new BusinessInfo(){
            {
                setAuthorizerInfoId(authorizerInfo.getId());
            }
        });
        logger.info("删除旧的商业信息："+ businessInfoNum);
        List<BusinessInfo> businessInfoList = Stream.of(new BusinessInfo(IdWorker.getId(),authorizerInfo.getId(),BusinessInfoEnum.OPEN_CARD.key(),authorizerInfoBean.getAuthorizerInfo().getBusinessInfoBean().getOpenCard()),new BusinessInfo(IdWorker.getId(),authorizerInfo.getId(),BusinessInfoEnum.OPEN_PAY.key(),authorizerInfoBean.getAuthorizerInfo().getBusinessInfoBean().getOpenPay()),new BusinessInfo(IdWorker.getId(),authorizerInfo.getId(),BusinessInfoEnum.OPEN_SCAN.key(),authorizerInfoBean.getAuthorizerInfo().getBusinessInfoBean().getOpenScan()),new BusinessInfo(IdWorker.getId(),authorizerInfo.getId(),BusinessInfoEnum.OPEN_SHAKE.key(),authorizerInfoBean.getAuthorizerInfo().getBusinessInfoBean().getOpenShake()),new BusinessInfo(IdWorker.getId(),authorizerInfo.getId(),BusinessInfoEnum.OPEN_STORE.key(),authorizerInfoBean.getAuthorizerInfo().getBusinessInfoBean().getOpenStore())).collect(Collectors.toList());
        businessInfoMapper.batchInsert(businessInfoList);
        logger.info(funcInfoList.toString());
        return authorizerInfoBean;
    }


    /**
     * 生成用户的授权页面
     *
     * @return
     * @throws IOException
     */
    public String getCompoentLoginUrl() throws IOException {
        return wechatThirdPartyClient.getAuthOrizationUrl(wechatThirdPartyClient.getPreAuthCode().getPreAuthCode());
    }



    /**
     * 用户取消授权，变更授权状态为取消
     */
    public void changeAuthorizationStatus(String authorizerAppid){
           logger.info("修改状态");
           authorizerInfoMapper.updateAuthorizationStatus(AuthorizationStatusEnum.UNAUTHORIZED.key(),authorizerAppid);
    }




}
