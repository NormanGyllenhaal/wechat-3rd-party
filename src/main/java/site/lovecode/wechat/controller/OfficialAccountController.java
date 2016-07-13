package site.lovecode.wechat.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import site.lovecode.wechat.dto.OfficialAccountReqDto;
import site.lovecode.wechat.module.IOfficialAccountModule;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/4/15.
 */
@Controller
@RequestMapping( "/communication" )
public class OfficialAccountController extends BaseController {


	@Resource( name = "officialAccountModuleImpl" )
	private IOfficialAccountModule officialAccountModuleImpl;


	/**
	 * 
	 * 手动绑定公众号表单页面
	 * <p>
	 * 
	 *
	 * @return 
	 */
	@RequestMapping( "/binding" )
	public String binding() {
		return "communication/authorization/binding";
	}


	/**
	 * 帮助页面
	 * @return
     */
	@RequestMapping("/help")
	public String help(){
		return "communication/authorization/help";
	}


	/**
	 * 
	 * 接收公众号表单信息
	 * <p>
	 * @param officialAccountReqDto 公众号信息
	 * @return 
	 */
	@RequestMapping( "/toBinding" )
	@ResponseBody
	public String toBinding( OfficialAccountReqDto officialAccountReqDto ) {
		logger.info(officialAccountReqDto.toString());
		officialAccountModuleImpl.saveOfficialAccountInfo(officialAccountReqDto);
		return callbackSuccess("success");
	}


}
