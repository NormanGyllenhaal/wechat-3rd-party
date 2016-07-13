/**
 * IMediaModuleImpl.java cn.vko.peixun.module.communication.module Copyright (c)
 * 2016, .
 */


package site.lovecode.wechat.module.impl;


import me.chanjar.weixin.common.exception.WxErrorException;
import org.apache.struts.util.ModuleException;
import site.lovecode.wechat.dto.MediaDto;
import site.lovecode.wechat.dto.MediaNewsReqDto;
import site.lovecode.wechat.dto.MediaReqDto;
import site.lovecode.wechat.entity.Media;
import site.lovecode.wechat.module.IMediaModule;
import site.lovecode.wechat.service.IMediaService;
import site.lovecode.wechat.support.common.Response;
import site.lovecode.wechat.util.Page;

import javax.annotation.Resource;
import java.io.File;


/**
 * 素材管理业务逻辑层
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月18日 
 * @version  1.0.0	 
 */
public class MediaModuleImpl extends AbstractModule implements IMediaModule {


	@Resource( name = "mediaServiceImpl" )
	private IMediaService mediaServiceImpl;


	/**
	 * 
	 * 获取图文列表分页
	 * <p>
	 * 
	 *
	 * @param page
	 * @param orgId
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@Override
	public Response<Page<MediaDto>> getMediaNewsPage(Page<MediaDto> page, Long orgId ) {
		return success(mediaServiceImpl.getMediaNewsByPage(page, orgId));
	}


	/**
	 * 
	 * 添加图片或音频文件
	 * <p>
	 * 
	 *
	 * @param orgId 机构id
	 * @param mediaType 媒体类型 图片 img 音频 voice
	 * @param file 文件对象
	 * @param name 文件名称
	 * @param filePath 文件保存路径
	 * @return 成功或失败
	 */
	@Override
	public Response<Boolean> addMedia( Long orgId, String mediaType, File file, String name, String filePath ) throws ModuleException {
		Boolean result = true;
		try {
			mediaServiceImpl.addMedia(orgId, mediaType, file, name, filePath);
		} catch ( WxErrorException e ) {
			result = false;
			e.printStackTrace();
			throw new ModuleException("微信接口调用异常");
		}
		return success(result);
	}


	/**
	 * 
	 * 添加视频素材
	 * <p>
	 * 
	 *
	 * @param mediaReqDto 视频文件参数
	 * @return 成功或失败
	 */
	@Override
	public Response<Boolean> addMediaVideo( MediaReqDto mediaReqDto ) throws ModuleException {
		Boolean result = true;
		try {
			mediaServiceImpl.addMediaVideo(mediaReqDto);
		} catch ( WxErrorException e ) {
			result = false;
			e.printStackTrace();
			throw new ModuleException("微信接口调用异常");
		}
		return success(result);
	}


	/**
	 * 
	 * 按照类型分页获取微信素材
	 * <p>
	 * 
	 *
	 * @param page 分页对象
	 * @param type 素材类型
	 * @param orgId 机构id
	 * @return 
	 */
	@Override
	public Response<Page<Media>> getMediaByTypePage(Page<Media> page, Integer type, Long orgId ) {
		return success(mediaServiceImpl.getMediaPage(page, orgId, type));
	}


	/**
	 * 
	 * 修改素材
	 * <p>
	 * 
	 *
	 * @param id 素材id
	 * @param name 素材名称
	 * @param title 视频素材标题
	 * @param introduction 视频素材介绍
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@Override
	public Response<Media> modigyMedia( Long id, String name, String title, String introduction ) {
		return success(mediaServiceImpl.modigyMedia(id, name, title, introduction));
	}


	/**
	 * 
	 * 删除素材
	 * <p>
	 * TODO(这里可以描述这个方法的执行逻辑，方便看客一目了然的了解代码含义，支持HTML格式化– 可选)
	 *
	 * @param id TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 * @throws WxErrorException 
	 */
	@Override
	public Response<Boolean> deleteMedia( Long id, Long orgId ) throws ModuleException {
		try {
			return success(mediaServiceImpl.deleteMedia(id, orgId));
		} catch ( WxErrorException e ) {
			e.printStackTrace();
			throw new ModuleException("删除失败");
		}
	}


	/**
	 * 
	 * 添加图文素材
	 * <p>
	 * 
	 *
	 * @param dto
	 * @throws WxErrorException TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@Override
	public Response<Boolean> addMediaNews( MediaNewsReqDto dto ) throws ModuleException {
		Boolean result = true;
		try {
			mediaServiceImpl.addMediaNews(dto);
		} catch ( Exception e ) {
			e.printStackTrace();
			result = false;
			throw new ModuleException("添加失败");
		}
		return success(result);
	}


	/**
	 * 
	 * 修改图文素材
	 * <p>
	 * @param dto TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 * @throws WxErrorException 
	 */
	@Override
	public Response<Boolean> modifyMediaNews( MediaNewsReqDto dto ) throws ModuleException {
		Boolean result = true;
		try {
			mediaServiceImpl.modifyMediaNews(dto);
		} catch ( WxErrorException e ) {
			result = false;
			e.printStackTrace();
			throw new ModuleException("修改图文素材");
		}
		return success(result);

	}

}
