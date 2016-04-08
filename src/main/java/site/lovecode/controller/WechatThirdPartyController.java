package site.lovecode.controller;

import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import site.lovecode.client.WechatThirdPartyClient;
import site.lovecode.client.impl.WechatThirdPartyClientImpl;
import site.lovecode.service.WechatThridPartyService;
import site.lovecode.support.bean.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

/**
 * Created by Administrator on 2016/3/25.
 */
@Controller
public class WechatThirdPartyController {



    @Resource
    private WechatThridPartyService wechatThridPartyService;

    private Logger logger = LoggerFactory.getLogger(WechatThirdPartyController.class);

    private static final String FORMAT = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";


    /**
     * 首页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/index.html")
    public ModelAndView index(Model model) {
        return new ModelAndView("index");
    }


    /**
     * 微信授权事件接收
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/receiveTicket.html")
    @ResponseBody
    public String receiveTicket(HttpServletRequest request, HttpServletResponse response) {
        try {
                WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(WechatThirdPartyClientImpl.wechatThirdPartyConfig.getToken(), WechatThirdPartyClientImpl.wechatThirdPartyConfig.getEncodeingAesKey(), WechatThirdPartyClientImpl.wechatThirdPartyConfig.getComponentAppid());
                TicketEncryptingBean ticketEncryptingBean = (TicketEncryptingBean) new XStream() {
                    {
                        processAnnotations(TicketEncryptingBean.class);
                    }
                }.fromXML(request.getInputStream());
                String result = wxBizMsgCrypt.decryptMsg(request.getParameter("msg_signature"), request.getParameter("timestamp"), request.getParameter("nonce"), String.format(FORMAT, ticketEncryptingBean.getEncrypt()));
                logger.info("解密后明文: " + result);
                TicketDecryptingBean ticketDecryptingBean = (TicketDecryptingBean) new XStream() {
                    {
                        processAnnotations(TicketDecryptingBean.class);
                    }
                }.fromXML(result);
                logger.info(ticketDecryptingBean.toString());
                //保存componentVerifyTicket

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }


    /**
     * 授权后的回调url，微信第三方授权跳转页面，可以获取到授权码
     */
    @RequestMapping(value = "/getAuthCode.html")
    public ModelAndView getAuthCode(HttpServletRequest request, Model model) {
        try {
            wechatThridPartyService.saveAuthorizerInfo(request.getParameter("auth_code"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("authCode");
    }


    /**
     * 授权链接生成页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/getAuthorization.html")
    public ModelAndView getAuthorization(Model model) {
        try {
            model.addAttribute("url",wechatThridPartyService.getCompoentLoginUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("getAuthorization");
    }




    @RequestMapping(value = "/getAllMessage.html")
    public void getAllMessage(HttpServletRequest request, HttpServletResponse response) {

    }

}
