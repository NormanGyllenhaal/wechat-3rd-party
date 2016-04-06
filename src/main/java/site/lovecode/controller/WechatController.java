package site.lovecode.controller;

import com.alibaba.fastjson.JSON;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.thoughtworks.xstream.XStream;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.util.xml.XStreamInitializer;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import site.lovecode.client.WechatClient;
import site.lovecode.client.WechatThirdPartyClient;
import site.lovecode.client.impl.WechatThirdPartyClientImpl;
import site.lovecode.support.bean.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Administrator on 2016/3/25.
 */
@Controller
public class WechatController {


    @Resource
    private WechatClient wechatClient;
    @Resource
    private WechatThirdPartyClient wechatThirdPartyClient;

    private Logger logger = LoggerFactory.getLogger(WechatController.class);


    /**
     * 首页
     * @param model
     * @return
     */
    @RequestMapping(value = "/index.html")
    public ModelAndView index(Model model) {
        return new ModelAndView("index");
    }


    /**
     * 微信授权事件接收
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/receiveTicket.html")
    @ResponseBody
    public String receiveTicket(HttpServletRequest request, HttpServletResponse response) {
        try {
            String str = null;
            StringBuilder sb = new StringBuilder();
            BufferedReader rd = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            while ((str = rd.readLine()) != null) {
                sb.append(str);
            }
            logger.info("打印消息：" + sb.toString());

            String msgSignature = request.getParameter("msg_signature");
            String nonce = request.getParameter("nonce");
            String timestamp = request.getParameter("timestamp");
            logger.info(msgSignature+","+nonce+","+timestamp);

            String encodingAesKey = WechatThirdPartyClientImpl.wechatThirdPartyConfig.getEncodingAesKey();
            String token = WechatThirdPartyClientImpl.wechatThirdPartyConfig.getToken();
            String appId = WechatThirdPartyClientImpl.wechatThirdPartyConfig.getComponentAppid();

            WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
            XStream xStream = XStreamInitializer.getInstance();
            xStream.processAnnotations(new Class[]{TicketEncryptingBean.class});
            TicketEncryptingBean ticketEncryptingBean = (TicketEncryptingBean) xStream.fromXML(sb.toString());

            String format = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";
            String fromXML = String.format(format, ticketEncryptingBean.getEncrypt());
            String result = pc.decryptMsg(msgSignature, timestamp, nonce, fromXML);

            logger.info("解密后明文: " + result);
            XStream decryptingXStram = XStreamInitializer.getInstance();
            decryptingXStram.processAnnotations(TicketDecryptingBean.class);
            TicketDecryptingBean ticketDecryptingBean = (TicketDecryptingBean) decryptingXStram.fromXML(result);
            logger.info("----------javaBean:"+ticketDecryptingBean.toString());
            //保存componentVerifyTicket
            wechatThirdPartyClient.saveComponentVerifyTicket(ticketDecryptingBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }


    /**
     * 获取用户基本信息
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/getUserInfo.html")
    public ModelAndView getUserInfo(Model model, String code) {
        logger.info(code);
        try {
            WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wechatClient.getWxMpService().oauth2getAccessToken(code);
            logger.info(wxMpOAuth2AccessToken.toString());
            WxMpUser wxMpUser = wechatClient.getWxMpService().oauth2getUserInfo(wxMpOAuth2AccessToken, null);
            model.addAttribute("user", wxMpUser);
            logger.info(wxMpUser.toString());
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return new ModelAndView("userinfo");
    }


    @RequestMapping(value = "/getAllMessage.html")
    public void getAllMessage(HttpServletRequest request, HttpServletResponse response) {

    }


    /**
     * 微信第三方授权跳转页面
     */
    @RequestMapping(value="/getAuthCode.html")
    public ModelAndView getAuthCode(HttpServletRequest request,Model model){
        String authCode = request.getParameter("auth_code");
        try {
            String componentAccessToken = wechatThirdPartyClient.getComponentAccessToken().getComponentAccessToken();
            String info = wechatThirdPartyClient.queryAuth(authCode,componentAccessToken);
            QueryAuthBean queryAuthBean = JSON.parseObject(info, QueryAuthBean.class);
            logger.info(queryAuthBean.toString());
            String userInfo = wechatThirdPartyClient.getQuthorizerInfo(componentAccessToken,queryAuthBean.getAuthOrizationInfo().getAuthorizerAppid());
            AuthorizerInfoBean authorizerInfoBean = JSON.parseObject(userInfo,AuthorizerInfoBean.class);
            logger.info(authorizerInfoBean.toString());
            model.addAttribute("info",info);
            model.addAttribute("userInfo",userInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("authCode");
    }

    /**
     *
     * 授权链接生成页面
     * @param model
     * @return
     */
    @RequestMapping(value="/getAuthorization.html")
    public ModelAndView getAuthorization(Model model){
        ComponentAccessTokenBean componentAccessTokenBean = null;
        try {
            componentAccessTokenBean = wechatThirdPartyClient.getComponentAccessToken();
            logger.info(componentAccessTokenBean.toString());
            PreAuthCodeBean preAuthCodeBean = wechatThirdPartyClient.getPreAuthCode(componentAccessTokenBean.getComponentAccessToken());
            logger.info(preAuthCodeBean.toString());
            String url = wechatThirdPartyClient.getAuthOrizationUrl(preAuthCodeBean.getPreAuthCode(),"http://310517fd.nat123.net/weixin-tool-1.0-SNAPSHOT/getAuthCode.html");
          model.addAttribute("url",url);
        } catch (IOException e) {
            e.printStackTrace();
        }
          return new ModelAndView("getAuthorization");
    }


    /**
     * 用户消息接收
     * @param request
     * @param response
     */
    @RequestMapping(value = "/message.html")
    public void get(HttpServletRequest request, HttpServletResponse response) {
        try {
            WxMpXmlMessage msg = WxMpXmlMessage.fromXml(request.getInputStream());
            WxMpXmlOutMessage reMsg = WxMpXmlOutMessage.TEXT()
                        .content("you message is :"+msg.getContent()+"...好讨厌")
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
