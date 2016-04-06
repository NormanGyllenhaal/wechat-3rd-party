package site.lovecode.client;

import site.lovecode.support.bean.ComponentAccessTokenBean;
import site.lovecode.support.bean.PreAuthCodeBean;
import site.lovecode.support.bean.TicketDecryptingBean;

import java.io.IOException;

/**
 * Created by Administrator on 2016/4/1.
 */
public interface WechatThirdPartyClient {


    public ComponentAccessTokenBean getComponentAccessToken() throws IOException;



    /**
     * 获取预授权码
     *
     * @param componentAccessToken
     * @return
     * @throws IOException
     */
    public PreAuthCodeBean getPreAuthCode(String componentAccessToken) throws IOException;



    /**
     * 获取授权页面地址
     *
     * @param perAuthCode
     * @param redirectUri
     * @return
     */
    public String getAuthOrizationUrl( String perAuthCode, String redirectUri);



    /**
     * 使用授权码换取公众号的接口调用凭据和授权信息
     *
     * @param authorizationCode
     * @param componentAccessToken
     * @return
     * @throws IOException
     */
    public String queryAuth(String authorizationCode, String componentAccessToken) throws IOException;



    /**
     * 获取授权方公账号信息
     * @param componentAccessToken
     * @param authorizerAppid
     * @return
     */
    public String getQuthorizerInfo( String componentAccessToken,String authorizerAppid);


    /**
     * 保存 component_verify_ticket
     *
     * @param ticketDecryptingBean
     */
    public void saveComponentVerifyTicket(TicketDecryptingBean ticketDecryptingBean);



    /**
     * 获取 ComponentVerifyTicket
     */
    public String getComponentVerifyTicket();


}
