package site.lovecode.wechat.controller;


import org.apache.struts.util.ModuleException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import site.lovecode.wechat.dto.AuthorizerInfoDto;
import site.lovecode.wechat.module.IWechatThirdPartyModule;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2016/3/25.
 */
@Controller
@RequestMapping( value = "/communication" )
public class WechatThirdPartyController extends BaseController {


	@Resource( name = "wechatThirdPartyModuleImpl" )
	private IWechatThirdPartyModule wechatThirdPartyModuleImpl;


	/**
	 * 微信授权事件接收url
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 * @throws IOException 
	 */
	@RequestMapping( value = "/receiveTicket.html" )
	@ResponseBody
	public String receiveTicket(HttpServletRequest request, HttpServletResponse response ) throws Exception {
		logger.info("接收微信推送");
		String str = null;
		StringBuilder sb = new StringBuilder();
		BufferedReader rd = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
		while ( (str = rd.readLine()) != null ) {
			sb.append(str);
		}
		wechatThirdPartyModuleImpl.receiveTicket(
			sb.toString(), request.getParameter("msg_signature"), request.getParameter("timestamp"),
			request.getParameter("nonce"));
		return "success";
	}


	/**
	 * 授权后的回调url，微信第三方授权跳转页面，可以获取到授权码
	 * @throws Exception 
	 * 
	 */
	@RequestMapping( value = "/getAuthCode.html" )
	public String getAuthCode(HttpServletRequest request, Model model ) throws Exception {
		logger.info("授权成功，保存数据");
		AuthorizerInfoDto authorizerInfoDto = wechatThirdPartyModuleImpl.getAuthCode(request.getParameter("auth_code"))
				.getBody();
		model.addAttribute("info", authorizerInfoDto);
		return "communication/authorization/auth_code";
	}


	/**
	 * 授权链接生成页面
	 *
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping( value = "/getAuthorization.html" )
	public String getAuthorization( Model model ) throws Exception {
		logger.info("获取授权");
		model.addAttribute("url", wechatThirdPartyModuleImpl.getAuthorization().getBody());
		return "communication/authorization/get_authorization";
	}


	/**
	 * 接收授权方微信消息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping( value = "/{appid}/getAllMessage.html" )
	public void getAllMessage(HttpServletRequest request, HttpServletResponse response ) throws IOException {
		String str = null;
		StringBuilder sb = new StringBuilder();
		BufferedReader rd = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
		while ( (str = rd.readLine()) != null ) {
			sb.append(str);
		}
		String msg = wechatThirdPartyModuleImpl.getAllMessage(
			sb.toString(), request.getParameter("msg_signature"), request.getParameter("timestamp"),
			request.getParameter("nonce")).getBody();
		response.getWriter().write(msg);
	}


	/**
	 * 
	 * 刷新用户数据
	 * <p>
	 * 
	 *
	 * @param oaid
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@RequestMapping( value = "/refreshData" )
	@ResponseBody
	public String refreshData( Long oaid ) throws ModuleException {
		Boolean result = wechatThirdPartyModuleImpl.refershData(oaid).getBody();
		if ( result ) {
			return callbackSuccess(null);
		} else {
			return callbackFail("刷新数据异常");
		}
	}

	@RequestMapping(value="/authorizationAppid")
	@ResponseBody
	public String cancelAuthorization(String authorizationAppid){
		Boolean result = wechatThirdPartyModuleImpl.cancelAuthorization(authorizationAppid).getBody();
		return callback(result,"取消操作失败");
	}


}
