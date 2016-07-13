/**
 * MenuController.java cn.vko.peixun.web.communicaion.controller Copyright (c)
 * 2016, .
 */


package site.lovecode.wechat.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import site.lovecode.wechat.dto.MenuReqDto;
import site.lovecode.wechat.module.IMenuModule;

import javax.annotation.Resource;


/**
 * 自定义菜单接口
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月25日
 * @version  1.0.0
 */

@Controller
@RequestMapping( "/communication/menu" )
public class MenuController extends BaseController {

	@Resource
	private IMenuModule menuModuleImpl;


	@RequestMapping( "/createMenu" )
	@ResponseBody
	public String createMenu( MenuReqDto menuReqDto ) {
		return callback(menuModuleImpl.createMenu(menuReqDto, getOrgId()).getBody(), "创建失败");
	}


	@RequestMapping( "/getMenu" )
	public String getMenu() {
		return callbackSuccess(menuModuleImpl.getMenu(getOrgId()).getBody());
	}


	@RequestMapping( "/getMenuOne" )
	@ResponseBody
	public String getMenuOne( Long menuId ) {
		return callbackSuccess(menuModuleImpl.getMenuOne(menuId).getBody());
	}

}
