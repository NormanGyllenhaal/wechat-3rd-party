package site.lovecode.controller;

import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import site.lovecode.service.WechatService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/4/7.
 */
@Controller
public class WechatController {


    @Resource
    private WechatService wechatService;

    private Logger logger  = LoggerFactory.getLogger(WechatController.class);

    /**
     * 获取用户基本信息
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/getUserInfo.html")
    public ModelAndView getUserInfo(Model model, String code) {

        /*try {
            WxMpOAuth2AccessToken wxMpOAuth2AccessToken;
            wxMpOAuth2AccessToken = wechatClient.getWxMpService().oauth2getAccessToken(code);
            logger.info(wxMpOAuth2AccessToken.toString());
            WxMpUser wxMpUser = wechatClient.getWxMpService().oauth2getUserInfo(wxMpOAuth2AccessToken, null);
            model.addAttribute("user", wxMpUser);
            logger.info(wxMpUser.toString());
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return new ModelAndView("userinfo");*/
        return null;
    }




    /**
     * 用户消息接收
     *
     * @param request
     * @param response
     */
    //@RequestMapping(value = "/$message.html")
    public void get(HttpServletRequest request, HttpServletResponse response) {
       try {
            WxMpXmlMessage msg = WxMpXmlMessage.fromXml(request.getInputStream());
            WxMpXmlOutMessage reMsg = WxMpXmlOutMessage.TEXT()
                    .content("you message is :" + msg.getContent() + "...好讨厌")
                    .fromUser(msg.getToUserName())
                    .toUser(msg.getFromUserName())
                    .build();
            response.getWriter().write(reMsg.toXml());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //微信消息验证

        // 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
        /*String signature;
        signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        PrintWriter out = null;
        try {
            out = response.getWriter();
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，否则接入失败
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                out.print(echostr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
            out = null;
        }*/
    }
}
