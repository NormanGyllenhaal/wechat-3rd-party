package site.lovecode.service;

import me.chanjar.weixin.common.exception.WxErrorException;
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
   void saveComponentVerifyTicket(XmlDecryptingBean xmlDecryptingBean) throws WxErrorException;


    /**
     * 保存用户信息
     * @param authCode
     * @throws IOException
     */
    AuthorizerInfoBean saveAuthorizerInfo(String authCode) throws Exception;




    /**
     * 生成用户的授权页面
     * @return
     * @throws IOException
     */
    String  getCompoentLoginUrl() throws IOException, WxErrorException;


    /**
     *
     * 用户取消授权，变更授权状态为取消
     * @param authorizerAppid
     */
   void changeAuthorizationStatus(String authorizerAppid);
}
