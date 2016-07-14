/**
 * MediaController.java cn.vko.peixun.web.communicaion.controller Copyright (c)
 * 2016, .
 */


package site.lovecode.wechat.controller;


import org.apache.struts.util.ModuleException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import site.lovecode.wechat.dto.MediaDto;
import site.lovecode.wechat.dto.MediaNewsReqDto;
import site.lovecode.wechat.module.IMediaModule;
import site.lovecode.wechat.util.Page;

import javax.annotation.Resource;


/**
 * 素材管理
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月18日 
 * @version  1.0.0	 
 */
@Controller
@RequestMapping( "/communication/media" )
public class MediaController extends BaseController {

	@Resource( name = "mediaModuleImpl" )
	private IMediaModule mediaModuleImpl;


	/**
	 * 
	 * 文章管理界面
	 * <p>
	 * 
	 *
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@RequestMapping( "/articleManage" )
	public String articleManage( ) {
		return "/communication/media/media_manage";
	}



	/**
	 *
	 * 文章管理界面
	 * <p>
	 *
	 *
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@ResponseBody
	@RequestMapping( "/articleManageAjax" )
	public String articleManageAjax(@RequestParam("orgId") Long orgId ) {
		Page<MediaDto> mediaNewsPage = mediaModuleImpl.getMediaNewsPage(getPage(),orgId).getBody();
		return callback(mediaNewsPage,"yyyy-MM-dd");
	}


	/**
	 * 
	 * 分页获取素材列表
	 * <p>
	 * 
	 *
	 * @param type
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@RequestMapping( value = "/getMedia" )
	public String getMedia( Integer type ) {
		return callbackSuccess(mediaModuleImpl.getMediaByTypePage(getPage(), type, getOrgId()).getBody());
	}


	/**
	 * 
	 * 修改素材
	 * <p>
	 * TODO(这里可以描述这个方法的执行逻辑，方便看客一目了然的了解代码含义，支持HTML格式化– 可选)
	 *
	 * @param id
	 * @param name
	 * @param title
	 * @param introduction
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@RequestMapping( value = "/modifyMedia" )
	public String modifyMedia(
			Long id, String name, @RequestParam( value = "title", required = false ) String title, @RequestParam(
					value = "introduction", required = false ) String introduction ) {
		return callbackSuccess(mediaModuleImpl.modigyMedia(id, name, title, introduction).getBody());
	}


	/**
	 * 
	 * 删除素材
	 * <p>
	 * 
	 *
	 * @param id
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@RequestMapping( value = "/delMedia" )
	public String delMedia( Long id ) throws ModuleException {
		Boolean result = mediaModuleImpl.deleteMedia(id, getOrgId()).getBody();
		return callback(result, "删除失败");
	}


	/**
	 * 
	 * 添加图文素材
	 * <p>
	 * TODO(这里可以描述这个方法的执行逻辑，方便看客一目了然的了解代码含义，支持HTML格式化– 可选)
	 *
	 * @param dto
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@RequestMapping( value = "/addMediaNews" )
	@ResponseBody
	public String addMediaNews( @RequestBody MediaNewsReqDto dto ) throws ModuleException {
		Boolean result = mediaModuleImpl.addMediaNews(dto).getBody();
		return callback(result, "添加图文素材失败");
	}


	/**
	 * 
	 * 修改图文素材
	 * <p>
	 * 
	 *
	 * @param dto
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	public String medifyMediaNews( MediaNewsReqDto dto ) throws ModuleException {
		Boolean result = mediaModuleImpl.modifyMediaNews(dto).getBody();
		return callback(result, "修改图文素材失败");
	}
}
