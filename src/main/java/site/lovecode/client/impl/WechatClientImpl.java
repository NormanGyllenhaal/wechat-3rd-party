package site.lovecode.client.impl;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxMenu;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.WxMpCustomMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import site.lovecode.client.WechatClient;

/**
 * Created by Administrator on 2016/3/30.
 */
@Service
public class WechatClientImpl implements WechatClient {

    private Logger logger = LoggerFactory.getLogger(WechatClientImpl.class);

    @Override
    public String getAccessToken(String apWpid, String appsecret) throws Exception {
        return null;
    }

    @Override
    public String getOpenId(String appid, String secret, String code) throws Exception {
        return null;
    }

    @Override
    public String getUser(String access_token, String openid) throws Exception {
        return null;
    }


    @Override
    public WxMpService getWxMpService() {
        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId("wxa0803d1acc6a603a"); // 设置微信公众号的appid
        config.setSecret("706702fb42c55f793ddb6b206ec4f348"); // 设置微信公众号的app corpSecret
        config.setToken("..."); // 设置微信公众号的token
        config.setAesKey("..."); // 设置微信公众号的EncodingAESKey
        config.setOauth2redirectUri("http://148vp79959.iok.la/weixin-tool-1.0-SNAPSHOT/getMessage.html");
        WxMpService wxService = new WxMpServiceImpl();
        wxService.setWxMpConfigStorage(config);
        return wxService;
    }


    public WxMpService getWxMpService(String appId,String secret,String token,String aeskey){
        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId(appId); // 设置微信公众号的appid
        config.setSecret(secret); // 设置微信公众号的app corpSecret
        config.setToken(token); // 设置微信公众号的token
        config.setAesKey(aeskey); // 设置微信公众号的EncodingAESKey
        WxMpService wxService = new WxMpServiceImpl();
        wxService.setWxMpConfigStorage(config);
        return wxService;
    }

    @Override
    public Boolean setMenu(WxMenu wxMenu) {
        try {
            getWxMpService().menuCreate(wxMenu);
            return true;
        } catch (WxErrorException e) {
            e.printStackTrace();
            return false;
        }

    }


    public WxMenu getMenu() throws WxErrorException {
        return getWxMpService().menuGet();
    }


    public void setMessage(String openId) throws WxErrorException {
        WxMpCustomMessage message = WxMpCustomMessage
                .TEXT()
                .toUser(openId)
                .content("what's the matter")
                .build();
        getWxMpService().customMessageSend(message);
    }







}
