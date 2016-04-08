package site.lovecode.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import site.lovecode.client.WechatThirdPartyClient;
import site.lovecode.client.impl.WechatThirdPartyClientImpl;
import site.lovecode.entity.ComponentVerifyTicket;
import site.lovecode.entity.WechatThirdPartyConfig;
import site.lovecode.mapper.ComponentVerifyTicketMapper;
import site.lovecode.mapper.WechatThirdPartyConfigMapper;
import site.lovecode.service.WechatThridPartyService;
import site.lovecode.support.bean.AuthorizerInfoBean;
import site.lovecode.support.bean.QueryAuthBean;
import site.lovecode.support.bean.TicketDecryptingBean;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Optional;

/**
 * Created by Administrator on 2016/4/8.
 */
@Service
public class WechatThirdPartyServiceImpl implements InitializingBean,WechatThridPartyService{


    private Logger logger = LoggerFactory.getLogger(WechatThirdPartyServiceImpl.class);

    @Resource
    private ComponentVerifyTicketMapper componentVerifyTicketMapper;


    @Resource
    private WechatThirdPartyConfigMapper wechatThirdPartyConfigMapper;

    @Resource
    private WechatThirdPartyClient wechatThirdPartyClient;

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
        String componentVerifyTicket = componentVerifyTicketMapper.selectOrderByCreateTime(WechatThirdPartyClientImpl.wechatThirdPartyConfig.getComponentAppid());
        if(Optional.ofNullable(componentVerifyTicket).isPresent()){
            WechatThirdPartyClientImpl.wechatThirdPartyConfig.setComponentVerifyTicket(componentVerifyTicket);
            WechatThirdPartyClientImpl.wechatThirdPartyConfig.setComponentAccessToken(wechatThirdPartyClient.refreshComponentAccessToken().getComponentAccessToken());
        }
        logger.info(WechatThirdPartyClientImpl.wechatThirdPartyConfig.toString());
    }


    /**
     * 保存ComponentVerifyTicket
     *
     * @param ticketDecryptingBean
     */
    @Override
    public void saveComponentVerifyTicket(TicketDecryptingBean ticketDecryptingBean) {
        //更新内存中的componentVerfiyTicket
        WechatThirdPartyClientImpl.wechatThirdPartyConfig.setComponentVerifyTicket(ticketDecryptingBean.getComponentVerifyTicket());
        //保存到数据库
        componentVerifyTicketMapper.insert(new ComponentVerifyTicket() {
            {
                setComponentVerifyTicket(ticketDecryptingBean.getComponentVerifyTicket());
                setCreateTime(new Timestamp(Long.parseLong(ticketDecryptingBean.getCreateTime()) * 1000));
                setComponentAppid(ticketDecryptingBean.getAppId());
            }
        });
    }

    /**
     * 保存用户信息
     * @param authCode
     * @throws IOException
     */
    public void saveAuthorizerInfo(String authCode) throws IOException {
        QueryAuthBean queryAuthBean = wechatThirdPartyClient.queryAuth(authCode);
        AuthorizerInfoBean authorizerInfoBean = wechatThirdPartyClient.getAuthorizerInfo(queryAuthBean.getAuthOrizationInfo().getAuthorizerAppid());
        logger.info(queryAuthBean.toString());
        logger.info(authorizerInfoBean.toString());
    }



    /**
     * 生成用户的授权页面
     * @return
     * @throws IOException
     */
    public String  getCompoentLoginUrl() throws IOException {
        return wechatThirdPartyClient.getAuthOrizationUrl(wechatThirdPartyClient.getPreAuthCode().getPreAuthCode());
    }




}
