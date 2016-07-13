/**
 * ReplySettingController.java cn.vko.peixun.web.communicaion.controller
 * Copyright (c) 2016, .
 */


package site.lovecode.wechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import site.lovecode.wechat.module.IReplySettingModule;

import javax.annotation.Resource;


/**
 * 微信自动回复设置
 * <p>
 *
 *
 * @author   yangpeng
 * @date	 2016年5月13日 
 * @version  1.0.0	 
 */
@RequestMapping( "/communication/replySetting" )
@Controller
public class ReplySettingController extends BaseController {

	@Resource( name = "replySettingModuleImpl" )
	private IReplySettingModule replySettingModuleImpl;


	/**
	 * 
	 * 自动回复设置页面
	 * <p>
	 * 
	 *
	 * @param model
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@RequestMapping( "/replySetting" )
	public String replySetting( Model model ) {
		return "communication/reply/index";
	}


	/**
	 * 
	 * 设置被添加自动回复
	 * <p>
	 * TODO(这里可以描述这个方法的执行逻辑，方便看客一目了然的了解代码含义，支持HTML格式化– 可选)
	 *
	 * @param type
	 * @param content
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@RequestMapping( value = "/addFriendReplySetting" )
	public String addFriendReplySetting( Integer type, String content ) {
		Long oaid = super.getOaid();
		Boolean result = replySettingModuleImpl.addFriendReplySetting(oaid, type, content).getBody();
		return callback(result, "系统异常");
	}


	/**
	 * 
	 * 设置消息自动回复
	 * <p>
	 * TODO(这里可以描述这个方法的执行逻辑，方便看客一目了然的了解代码含义，支持HTML格式化– 可选)
	 *
	 * @param type
	 * @param content
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@RequestMapping( value = "/addAutoReplySetting" )
	public String addAutoReplySetting( Integer type, String content ) {
		Long oaid = super.getOaid();
		Boolean result = replySettingModuleImpl.addAutoReplySetting(oaid, type, content).getBody();
		return callback(result, "系统异常");
	}


}
