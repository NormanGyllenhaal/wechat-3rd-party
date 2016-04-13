package site.lovecode.client;

import site.lovecode.support.bean.*;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/1.
 */
public interface WechatThirdPartyClient {

    /**
     * 获取刷新component_access_token
     *
     * @return
     */
    public ComponentAccessTokenBean refreshComponentAccessToken();



    /**
     * 获取预授权码pre_auth_code
     *
     * @return
     * @throws IOException
     */
    public PreAuthCodeBean getPreAuthCode() throws IOException;



    /**
     * 获取授权页面地址
     *
     * @param perAuthCode
     * @return
     */
    public String getAuthOrizationUrl( String perAuthCode);



    /**
     * 使用授权码换取公众号的接口调用凭据和授权信息
     *
     * @param authorizationCode
     * @return
     * @throws IOException
     */
    public QueryAuthBean queryAuth(String authorizationCode) throws IOException;



    /**
     * 获取授权方公账号信息
     * @param authorizerAppid
     * @return
     */
    public AuthorizerInfoBean getAuthorizerInfo(String authorizerAppid) throws IOException;


    /**
     * 获取（刷新）授权公众号的接口调用凭据（令牌）
     * @param authorizerAppid
     * @param authorizerRefreshToken
     * @return
     */
    public AuthorizerTokenBean refreshAuthorizerToken(String authorizerAppid,String authorizerRefreshToken);


    /**
     * 获取授权方的选项设置信息
     * @param authorizerAppid
     * @param optionName
     * @return
     */
    public GetAuthorizerOptionBean getAuthorizerOption(String authorizerAppid,String optionName);


    /**
     * 设置授权方选项信息
     * @param authorizerAppid
     * @param maps
     */
     public void setAuthorizerOption(String authorizerAppid,Map<String,String> maps);



}
