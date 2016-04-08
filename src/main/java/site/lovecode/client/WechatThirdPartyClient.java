package site.lovecode.client;

import site.lovecode.support.bean.*;

import java.io.IOException;

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














}
