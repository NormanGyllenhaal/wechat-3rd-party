package site.lovecode.service;

import site.lovecode.support.bean.TicketDecryptingBean;

import java.io.IOException;

/**
 * Created by Administrator on 2016/4/8.
 */
public interface WechatThridPartyService {

    /**
     * 保存 component_verify_ticket
     *
     * @param ticketDecryptingBean
     */
    public void saveComponentVerifyTicket(TicketDecryptingBean ticketDecryptingBean);


    /**
     * 保存用户信息
     * @param authCode
     * @throws IOException
     */
    public void saveAuthorizerInfo(String authCode) throws IOException;




    /**
     * 生成用户的授权页面
     * @return
     * @throws IOException
     */
    public String  getCompoentLoginUrl() throws IOException;
}
