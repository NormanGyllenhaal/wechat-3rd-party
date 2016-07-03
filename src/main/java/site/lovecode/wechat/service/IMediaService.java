/**
 * IMediaService.java site.lovecode.wechat.service Copyright (c)
 * 2016, norman.
 */


package site.lovecode.wechat.service;


import me.chanjar.weixin.common.exception.WxErrorException;
import site.lovecode.wechat.dto.MediaDto;
import site.lovecode.wechat.dto.MediaNewsReqDto;
import site.lovecode.wechat.dto.MediaReqDto;
import site.lovecode.wechat.entity.Media;
import site.lovecode.wechat.util.Page;

import java.io.File;


/**
 * 素材业务层接口
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月18日 
 * @version  1.0.0	 
 */
public interface IMediaService {


	/**
	 * 
	 * 分页获取图文素材
	 * <p>
	 * 
	 *
	 * @param page 分页对象
	 * @param oaid 公众号id
	 * @return 分页对象
	 */
	public Page<MediaDto> getMediaNewsByPage(Page<MediaDto> page, Long oaid);


	/**
	 * 
	 * 添加图片或声音素材
	 * <p>
	 * 
	 *
	 * @param orgId
	 * @param mediaType
	 * @param file
	 * @param name
	 * @param filePath
	 * @throws WxErrorException TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	public void addMedia(Long orgId, String mediaType, File file, String name, String filePath)
		throws WxErrorException;


	/**
	 * 
	 * 添加视频素材
	 * <p>
	 * TODO(这里可以描述这个方法的执行逻辑，方便看客一目了然的了解代码含义，支持HTML格式化– 可选)
	 *
	 * @param mediaReqDto
	 * @throws WxErrorException TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	public void addMediaVideo(MediaReqDto mediaReqDto) throws WxErrorException;


	/**
	 * 
	 * 按类型分页获取素材
	 * <p>
	 * 
	 *
	 * @param page 分页对象
	 * @param orgId 机构id
	 * @param type 素材类型
	 * @return page
	 */
	public Page<Media> getMediaPage(Page<Media> page, Long orgId, Integer type);


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
	public Media modigyMedia(Long id, String name, String title, String introduction);


	/**
	 * 
	 * 删除素材
	 * <p>
	 * TODO(这里可以描述这个方法的执行逻辑，方便看客一目了然的了解代码含义，支持HTML格式化– 可选)
	 *
	 * @param id TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 * @throws WxErrorException 
	 */
	public Boolean deleteMedia(Long id, Long orgId) throws WxErrorException;


	/**
	 * 
	 * 添加图文素材
	 * <p>
	 * 
	 *
	 * @param dto
	 * @throws WxErrorException TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	public void addMediaNews(MediaNewsReqDto dto) throws WxErrorException;


	/**
	 * 
	 * 修改图文素材
	 * <p>
	 * 1.如果有新增的图文素材，
	 *   删除微信端素材
	 *   提交新素材获取图文media_id 
	 *   更新数据库中的值
	 * 2.如果没有新增的图文素材
	 *   调用修改图文素材接口更新素材
	 *   更新数据库中的信息
	 *
	 * @param dto TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 * @throws WxErrorException 
	 */
	public void modifyMediaNews(MediaNewsReqDto dto) throws WxErrorException;

}
