package site.lovecode.controller;

import com.thoughtworks.xstream.XStream;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import site.lovecode.client.WechatFactory;
import site.lovecode.client.impl.WechatThirdPartyClientImpl;
import site.lovecode.service.WechatThridPartyService;
import site.lovecode.support.bean.AuthorizerInfoBean;
import site.lovecode.support.bean.WechatXmlMessage;
import site.lovecode.support.bean.XmlDecryptingBean;
import site.lovecode.support.bean.enums.AuthorizationInfoTypeEnum;
import site.lovecode.support.bean.singleton.MessageRouterSingleton;
import site.lovecode.util.WechatCryptUtil;
import site.lovecode.util.WechatMsgCryptUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/3/25.
 */
@Controller
public class WechatThirdPartyController {


    @Resource
    private WechatThridPartyService wechatThridPartyService;

    private Logger logger = LoggerFactory.getLogger(WechatThirdPartyController.class);


    @Resource
    private WechatFactory wechatFactory;


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
            String result = WechatMsgCryptUtil.WechatMsgDecrypt(request.getInputStream(), request.getParameter("msg_signature"), request.getParameter("timestamp"), request.getParameter("nonce"));
            logger.info("解密后明文: " + result);
            XmlDecryptingBean xmlDecryptingBean = XmlDecryptingBean.getBean(result);
            logger.info(xmlDecryptingBean.toString());
            //如果是ticket推送消息，保存componentVerifyTicket
            if (xmlDecryptingBean.getInfoType().equals(AuthorizationInfoTypeEnum.COMPONENT_VERIFY_TICKET.desc())) {
                wechatThridPartyService.saveComponentVerifyTicket(xmlDecryptingBean);
            }
            //如果是取消授权通知
            if (xmlDecryptingBean.getInfoType().equals(AuthorizationInfoTypeEnum.UNAUTHORIZED.desc())) {
                wechatThridPartyService.changeAuthorizationStatus(xmlDecryptingBean.getAuthorizerAppid());
            }
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
            AuthorizerInfoBean authorizerInfo = wechatThridPartyService.saveAuthorizerInfo(request.getParameter("auth_code"));
            model.addAttribute("info", authorizerInfo);
        } catch (Exception e) {
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
    public ModelAndView getAuthorization(Model model) throws WxErrorException {
        try {
            model.addAttribute("url", wechatThridPartyService.getCompoentLoginUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("getAuthorization");
    }



    /**
     * 接收授权方微信消息
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/{appid}/getAllMessage.html")
    public void getAllMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("收到你的消息了呦");
        WxMpXmlMessage msg = WechatXmlMessage.fromEncryptedXml(request.getInputStream(), WechatThirdPartyClientImpl.wechatThirdPartyConfig, request.getParameter("timestamp"), request.getParameter("nonce"), request.getParameter("msg_signature"));
        logger.info(msg.toString());
        WxMpXmlOutMessage reMsg = MessageRouterSingleton.getInstance().getWxMpMessageRouter(msg.getToUserName()).route(msg);
        if (reMsg != null) {
            response.getWriter().write(WechatCryptUtil.toEncryptedXml(WechatThirdPartyClientImpl.wechatThirdPartyConfig, reMsg));
        } else {
            response.getWriter().write("success");
        }
    }




}
