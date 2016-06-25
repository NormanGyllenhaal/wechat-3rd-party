package site.lovecode.service.impl;

import me.chanjar.weixin.common.exception.WxErrorException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import site.lovecode.support.bean.enums.BusinessInfoEnum1;
import site.lovecode.support.bean.enums.OfficialAccountTypeEnum;
import site.lovecode.util.IdWorker;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by Administrator on 2016/4/8.
 */
@Service
public class WechatThirdPartyServiceImpl implements  WechatThridPartyService {


    private Logger logger = LoggerFactory.getLogger(WechatThirdPartyServiceImpl.class);

    @Resource
    private ComponentVerifyTicketMapper componentVerifyTicketMapper;


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

    @Resource
    private OfficialAccountMapper officialAccountMapper;

    @Resource
    private AuthorizerAccessTokenMapper authorizerAccessTokenMapper;




    /**
     * 保存ComponentVerifyTicket
     *
     * @param xmlDecryptingBean
     */
    @Override
    public void saveComponentVerifyTicket(XmlDecryptingBean xmlDecryptingBean) throws WxErrorException {
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
     * 授权成功后保存用户信息
     *
     * @param authCode
     * @throws IOException
     */
    public AuthorizerInfoBean saveAuthorizerInfo(String authCode) throws Exception {
        //获取用户accessToken和refreshToken
        QueryAuthBean queryAuthBean = wechatThirdPartyClient.queryAuth(authCode);
        //获取公众号用户的基本信息
        AuthorizerInfoBean authorizerInfoBean = wechatThirdPartyClient.getAuthorizerInfo(queryAuthBean.getAuthOrizationInfo().getAuthorizerAppid());
        //查询公众号基本信息表
        OfficialAccount officialAccount = officialAccountMapper.selectOne(new OfficialAccount() {
            {
                setAppid(authorizerInfoBean.getAuthorizeationInfo().getAuthorizerAppid());
            }
        });
        //如果存在记录更新，不存在直接插入
        if (officialAccount != null) {
            officialAccount.setAccountType(OfficialAccountTypeEnum.AUTHORIZATION.key());
            officialAccount.setServiceTypeInfo(authorizerInfoBean.getAuthorizerInfo().getServiceTypeInfo().getId());
            officialAccount.setVerifyTypeInfo(authorizerInfoBean.getAuthorizerInfo().getVerifyTypeInfo().getId());
            officialAccountMapper.updateByPrimaryKeySelective(officialAccount);
        } else {
            officialAccount = new OfficialAccount() {
                {
                    setAppid(authorizerInfoBean.getAuthorizeationInfo().getAuthorizerAppid());
                    setAccountType(OfficialAccountTypeEnum.AUTHORIZATION.key());
                    setServiceTypeInfo(authorizerInfoBean.getAuthorizerInfo().getServiceTypeInfo().getId());
                    setVerifyTypeInfo(authorizerInfoBean.getAuthorizerInfo().getVerifyTypeInfo().getId());
                    setUserName(authorizerInfoBean.getAuthorizerInfo().getUserName());
                    setNickName(authorizerInfoBean.getAuthorizerInfo().getNickName());
                }
            };
            officialAccountMapper.insert(officialAccount);
            //插入授权方公众号信息
        }
        final OfficialAccount finalOfficialAccount = officialAccount;

        //保存授权公众号信息
        authorizerInfoMapper.replace(new AuthorizerInfo() {
            {
                setOfficialAccountId(finalOfficialAccount.getId());
                setAuthorizerAppid(authorizerInfoBean.getAuthorizeationInfo().getAuthorizerAppid());
                setAlias(authorizerInfoBean.getAuthorizerInfo().getAlizs());
                setHeadImg(authorizerInfoBean.getAuthorizerInfo().getHeadImg());
                setQrcodeUrl(authorizerInfoBean.getAuthorizerInfo().getQrcodeUrl());
                setAuthorizationStatus(AuthorizationStatusEnum.AUTHORIZED.key());
            }
        });

        //保存公众号的access_token信息
        authorizerAccessTokenMapper.replace(new AuthorizerAccessToken(finalOfficialAccount.getId(), queryAuthBean.getAuthOrizationInfo().getAuthorizerAppid(), queryAuthBean.getAuthOrizationInfo().getAuthorizerAccessToken(), (queryAuthBean.getAuthOrizationInfo().getExpriesIn()*1000)*System.currentTimeMillis(), queryAuthBean.getAuthOrizationInfo().getAuthorizerRefreshToken(), new Timestamp(System.currentTimeMillis())));


        //保存公众号的权限信息
        Integer num = funcInfoMapper.delete(new FuncInfo() {
            {
                setOfficialAccountId(finalOfficialAccount.getId());
            }
        });
        logger.info("删除旧的权限信息：" + num);
        List<FuncInfo> funcInfoList = queryAuthBean.getAuthOrizationInfo().getFuncInfoList().stream().map(funcInfoObject -> new FuncInfo() {
            {
                setId(IdWorker.getId());
                setFuncName(funcInfoObject.getFuncscopeCategory().getId());
                setOfficialAccountId(finalOfficialAccount.getId());
            }
        }).collect(Collectors.toList());
        funcInfoMapper.batchInsert(funcInfoList);
        //保存公众号的商业信息
        Integer businessInfoNum = businessInfoMapper.delete(new BusinessInfo() {
            {
                setOfficialAccountId(finalOfficialAccount.getId());
            }
        });
        logger.info("删除旧的商业信息：" + businessInfoNum);
        List<BusinessInfo> businessInfoList = Stream.of(new BusinessInfo(IdWorker.getId(), finalOfficialAccount.getId(), BusinessInfoEnum1.OPEN_CARD.key(), authorizerInfoBean.getAuthorizerInfo().getBusinessInfoBean().getOpenCard()), new BusinessInfo(IdWorker.getId(), finalOfficialAccount.getId(), BusinessInfoEnum1.OPEN_PAY.key(), authorizerInfoBean.getAuthorizerInfo().getBusinessInfoBean().getOpenPay()), new BusinessInfo(IdWorker.getId(), finalOfficialAccount.getId(), BusinessInfoEnum1.OPEN_SCAN.key(), authorizerInfoBean.getAuthorizerInfo().getBusinessInfoBean().getOpenScan()), new BusinessInfo(IdWorker.getId(), finalOfficialAccount.getId(), BusinessInfoEnum1.OPEN_SHAKE.key(), authorizerInfoBean.getAuthorizerInfo().getBusinessInfoBean().getOpenShake()), new BusinessInfo(IdWorker.getId(), finalOfficialAccount.getId(), BusinessInfoEnum1.OPEN_STORE.key(), authorizerInfoBean.getAuthorizerInfo().getBusinessInfoBean().getOpenStore())).collect(Collectors.toList());
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
    public String getCompoentLoginUrl() throws IOException, WxErrorException {
        return wechatThirdPartyClient.getAuthOrizationUrl(wechatThirdPartyClient.getPreAuthCode().getPreAuthCode());
    }


    /**
     * 用户取消授权，变更授权状态为取消
     */
    public void changeAuthorizationStatus(String authorizerAppid) {
        logger.info("修改状态");
        authorizerInfoMapper.updateAuthorizationStatus(AuthorizationStatusEnum.UNAUTHORIZED.key(), authorizerAppid);
    }


}
