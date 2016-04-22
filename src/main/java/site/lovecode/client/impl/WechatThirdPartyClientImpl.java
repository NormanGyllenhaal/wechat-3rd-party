package site.lovecode.client.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import site.lovecode.client.WechatThirdPartyClient;
import site.lovecode.entity.WechatThirdPartyConfig;
import site.lovecode.support.bean.*;
import site.lovecode.support.bean.constant.WechatParameterConstant;
import site.lovecode.support.bean.constant.WechatUrlConstant;
import site.lovecode.util.HttpUtil;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2016/4/1.
 */
@Service
public class WechatThirdPartyClientImpl implements WechatThirdPartyClient {


    private Logger logger = LoggerFactory.getLogger(WechatThirdPartyClientImpl.class);


    public static WechatThirdPartyConfig wechatThirdPartyConfig;


    /**
     * 过期时间点
     */
    private static Long deadline;


    /**
     * 获取component_access_token
     *
     * @return
     * @throws IOException
     */
    public String getComponentAccessToken() throws IOException, WxErrorException {
        if (!Optional.ofNullable(deadline).isPresent()||deadline < System.currentTimeMillis()) {
            logger.info("component_access_token过期，刷新component_assess_token");
            return refreshComponentAccessToken().getComponentAccessToken();
        } else {
            return wechatThirdPartyConfig.getComponentAccessToken();
        }
    }


    /**
     * 刷新component_access_token
     *
     * @return
     */
    public ComponentAccessTokenBean refreshComponentAccessToken() throws WxErrorException {
        ComponentAccessTokenBean componentAccessTokenBean = JSON.parseObject(HttpUtil.doPostSSL(WechatUrlConstant.API_COMPONENT_TOKEN, new JSONObject() {
            {
                put(WechatParameterConstant.COMPONENT_APPID, wechatThirdPartyConfig.getComponentAppid());
                put(WechatParameterConstant.COMPONENT_APPSECRET, wechatThirdPartyConfig.getComponentAppsecret());
                put(WechatParameterConstant.COMPONENT_VERIFY_TICKET, wechatThirdPartyConfig.getComponentVerifyTicket());
            }
        }.toJSONString()), ComponentAccessTokenBean.class);
        deadline = System.currentTimeMillis() + (componentAccessTokenBean.getExpiresIn() * 1000);
        return componentAccessTokenBean;
    }


    /**
     * 获取预授权码
     *
     * @return
     * @throws IOException
     */
    public PreAuthCodeBean getPreAuthCode() throws WxErrorException, IOException {
        return JSON.parseObject(HttpUtil.doPostSSL(new StringBuffer(WechatUrlConstant.API_CREATE_PREAUTHCODE).append(getComponentAccessToken()).toString(), new JSONObject() {
            {
                put(WechatParameterConstant.COMPONENT_APPID, wechatThirdPartyConfig.getComponentAppid());
            }
        }.toJSONString()), PreAuthCodeBean.class);
    }


    /**
     * 获取授权页面地址
     *
     * @param perAuthCode
     * @return
     */
    public String getAuthOrizationUrl(String perAuthCode) {
        return Stream.of(WechatUrlConstant.COMPONENT_LOGIN_PAGE, WechatParameterConstant.COMPONENT_APPID, "=", wechatThirdPartyConfig.getComponentAppid(), "&pre_auth_code=", perAuthCode, "&redirect_uri=",wechatThirdPartyConfig.getRedirectUrl()).reduce("", String::concat);
    }



    /**
     * 使用授权码换取公众号的接口调用凭据和授权信息
     *
     * @param authorizationCode
     * @return
     * @throws IOException
     */
    public QueryAuthBean queryAuth(String authorizationCode) throws IOException, WxErrorException {
        return JSON.parseObject(HttpUtil.doPostSSL(new StringBuffer(WechatUrlConstant.API_QUERY_AUTH).append(getComponentAccessToken()).toString(), new JSONObject() {
            {
                put(WechatParameterConstant.COMPONENT_APPID, wechatThirdPartyConfig.getComponentAppid());
                put(WechatParameterConstant.AUTHORIZATION_CODE, authorizationCode);
            }
        }.toJSONString()), QueryAuthBean.class);
    }


    /**
     * 获取授权方公账号信息
     *
     * @param authorizerAppid
     * @return
     */
    public AuthorizerInfoBean getAuthorizerInfo(String authorizerAppid) throws IOException, WxErrorException {
        return JSON.parseObject(HttpUtil.doPostSSL(new StringBuilder(WechatUrlConstant.API_GET_AUTHORIZER_INFO).append(getComponentAccessToken()).toString(), new JSONObject() {
            {
                put(WechatParameterConstant.COMPONENT_APPID, wechatThirdPartyConfig.getComponentAppid());
                put(WechatParameterConstant.AUTHORIZER_APPID, authorizerAppid);
            }
        }.toJSONString()), AuthorizerInfoBean.class);
    }

    /**
     * 获取（刷新）授权公众号的接口调用凭据（令牌）
     * @param authorizerAppid
     * @param authorizerRefreshToken
     * @return
     */
    @Override
    public AuthorizerTokenBean refreshAuthorizerToken(String authorizerAppid, String authorizerRefreshToken) throws WxErrorException {
        return JSON.parseObject(HttpUtil.doPostSSL(Stream.of(WechatUrlConstant.API_AUTHORIZER_TOKEN,wechatThirdPartyConfig.getComponentAccessToken()).reduce("",String::concat),new JSONObject(){
            {
                put(WechatParameterConstant.COMPONENT_APPID,wechatThirdPartyConfig.getComponentAppid());
                put(WechatParameterConstant.AUTHORIZER_APPID,authorizerAppid);
                put(WechatParameterConstant.AUTHORIZER_REFRESH_TOKEN,authorizerRefreshToken);
            }
        }.toJSONString()),AuthorizerTokenBean.class);
    }


    /**
     * 获取授权方的选项设置信息
     * @param authorizerAppid
     * @param optionName
     * @return
     */
    @Override
    public GetAuthorizerOptionBean getAuthorizerOption(String authorizerAppid, String optionName) throws WxErrorException {
        return JSON.parseObject(HttpUtil.doPostSSL(Stream.of(WechatUrlConstant.API_GET_AUTHORIZER_OPTION,wechatThirdPartyConfig.getComponentAccessToken()).reduce("",String::concat),new JSONObject(){
            {
                put(WechatParameterConstant.COMPONENT_APPID,wechatThirdPartyConfig.getComponentAppid());
                put(WechatParameterConstant.AUTHORIZER_APPID,authorizerAppid);
                put(WechatParameterConstant.OPTION_NAME,optionName);
            }
        }.toJSONString()),GetAuthorizerOptionBean.class);
    }



    /**
     * 设置授权方选项信息
     * @param authorizerAppid
     * @param maps
     */
    @Override
    public void setAuthorizerOption(String authorizerAppid, Map<String, String> maps)  {
       maps.forEach((key, value) -> {
           try {
               HttpUtil.doPostSSL(Stream.of(WechatUrlConstant.API_SET_AUTHORIZER_OPTION, wechatThirdPartyConfig.getComponentAccessToken()).reduce("", String::concat), new JSONObject() {
                   {
                       put(WechatParameterConstant.COMPONENT_APPID, wechatThirdPartyConfig.getComponentAppid());
                       put(WechatParameterConstant.AUTHORIZER_APPID, authorizerAppid);
                       put(WechatParameterConstant.OPTION_NAME, key);
                       put(WechatParameterConstant.OPTION_VALUE, value);
                   }
               }.toJSONString());
           } catch (WxErrorException e) {
               e.printStackTrace();
           }
       });
    }


}
