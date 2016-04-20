package site.lovecode.client.impl;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import site.lovecode.client.WechatThirdPartyClient;
import site.lovecode.entity.AuthorizerAccessToken;
import site.lovecode.mapper.AuthorizerAccessTokenMapper;
import site.lovecode.support.bean.AuthorizerTokenBean;
import site.lovecode.support.bean.config.WechatConfig;

import javax.annotation.Resource;
import java.sql.Timestamp;


/**
 * Created by Administrator on 2016/3/30.
 */
@Service("wechatAuthorizationClient")
public class WechatAuthorizationClient extends WxMpServiceImpl {

    private Logger logger = LoggerFactory.getLogger(WechatAuthorizationClient.class);

    @Resource
    private WechatThirdPartyClient wechatThirdPartyClient;

    @Resource
    private AuthorizerAccessTokenMapper authorizerAccessTokenMapper;


    @Override
    public String getAccessToken(boolean forceRefresh) throws WxErrorException {
        if (forceRefresh) {
            wxMpConfigStorage.expireAccessToken();
        }
        if (wxMpConfigStorage.isAccessTokenExpired()) {
            synchronized (globalAccessTokenRefreshLock) {
                if (wxMpConfigStorage.isAccessTokenExpired()) {
                    WechatConfig wechatConfig = (WechatConfig) wxMpConfigStorage;
                    AuthorizerTokenBean authorizerTokenBean = wechatThirdPartyClient.refreshAuthorizerToken(wechatConfig.getAppId(), wechatConfig.getRefreshToken());
                    wxMpConfigStorage.updateAccessToken(authorizerTokenBean.getAuthorizerAccessToken(), authorizerTokenBean.getExpiresIn());
                    logger.info("更新数据库中的值");
                    authorizerAccessTokenMapper.updateToken(new AuthorizerAccessToken() {
                        {
                            setAuthorizerAppid(wechatConfig.getAppId());
                            setCreateTime(new Timestamp(System.currentTimeMillis()));
                            setAuthorizerRefreshToken(authorizerTokenBean.getAuthorizerRefreshToken());
                            setAuthorizerAccessToken(authorizerTokenBean.getAuthorizerAccessToken());
                            setExpiresIn((authorizerTokenBean.getExpiresIn() * 1000) + System.currentTimeMillis());
                        }
                    });

                }
            }
        }
        return wxMpConfigStorage.getAccessToken();
    }
}
