package site.lovecode.service;

import site.lovecode.support.bean.AuthorizerInfoBean;
import site.lovecode.support.bean.XmlDecryptingBean;

import java.io.IOException;

/**
 * Created by Administrator on 2016/4/8.
 */
public interface WechatThridPartyService {

    /**
     * 保存 component_verify_ticket
     *
     * @param xmlDecryptingBean
     */
    public void saveComponentVerifyTicket(XmlDecryptingBean xmlDecryptingBean);


    /**
     * 保存用户信息
     * @param authCode
     * @throws IOException
     */
    public AuthorizerInfoBean saveAuthorizerInfo(String authCode) throws Exception;




    /**
     * 生成用户的授权页面
     * @return
     * @throws IOException
     */
    public String  getCompoentLoginUrl() throws IOException;


    /**
     *
     * 用户取消授权，变更授权状态为取消
     * @param authorizerAppid
     */
    public void changeAuthorizationStatus(String authorizerAppid);
}
