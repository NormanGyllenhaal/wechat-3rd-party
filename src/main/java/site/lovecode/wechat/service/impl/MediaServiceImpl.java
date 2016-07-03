/**
 * MediaServiceImpl.java site.lovecode.wechat.service.impl
 * Copyright (c) 2016, norman.
 */


package site.lovecode.wechat.service.impl;


import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.WxMpMaterial;
import me.chanjar.weixin.mp.bean.WxMpMaterialArticleUpdate;
import me.chanjar.weixin.mp.bean.WxMpMaterialNews;
import me.chanjar.weixin.mp.bean.WxMpMaterialNews.WxMpMaterialNewsArticle;
import me.chanjar.weixin.mp.bean.result.WxMpMaterialUploadResult;
import org.springframework.stereotype.Service;
import site.lovecode.wechat.client.WechatClient;
import site.lovecode.wechat.client.WechatFactory;
import site.lovecode.wechat.dto.MediaDto;
import site.lovecode.wechat.dto.MediaNewsReqDto;
import site.lovecode.wechat.dto.MediaReqDto;
import site.lovecode.wechat.entity.Media;
import site.lovecode.wechat.entity.MediaNews;
import site.lovecode.wechat.mapper.MediaMapper;
import site.lovecode.wechat.mapper.MediaNewsMapper;
import site.lovecode.wechat.mapper.OrgOfficialAccountMapper;
import site.lovecode.wechat.service.IMediaService;
import site.lovecode.wechat.support.enums.EnumConstants;
import site.lovecode.wechat.support.enums.MediaShowCoverPicOfEnum;
import site.lovecode.wechat.util.Page;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 素材管理业务层
 * <p>
 *
 *
 * @author   yangpeng
 * @date	 2016年5月18日 
 * @version  1.0.0	 
 */
@Service
public class MediaServiceImpl  implements IMediaService {


	@Resource
	private MediaMapper mediaMapper;

	@Resource
	private MediaNewsMapper mediaNewsMapper;

	@Resource
	private WechatFactory wechatFactory;

	@Resource
	private OrgOfficialAccountMapper orgOfficialAccountMapper;


	/**
	 * 
	 * 分页获取图文素材
	 * <p>
	 * 
	 *
	 * @param page 分页对象
	 * @param orgId 公众号id
	 * @return 分页对象
	 */
	@Override
	public Page<MediaDto> getMediaNewsByPage(Page<MediaDto> page, Long orgId) {
		mediaMapper.selectJoinMediaNews(page, getOaid(orgId), EnumConstants.MediaTypeOfEnum.news.key(), EnumConstants.MediaMediaTypeOfEnum.forever.key());
		return page;
	}


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
	@Override
	public void addMedia( Long orgId, String mediaType, File file, String name, String filePath )
		throws WxErrorException {
		Long oaid = orgOfficialAccountMapper.getOfficialAccountIdByOrgId(orgId);
		WechatClient wechatClient = wechatFactory.getInstance(oaid);
		WxMpMaterial material = new WxMpMaterial();
		material.setFile(file);
		material.setName(name);
		WxMpMaterialUploadResult result = wechatClient.materialFileUpload(mediaType, material);
		Integer type = EnumConstants.MediaTypeOfEnum.valueOf(mediaType).key();
		mediaMapper.insertSelective(new Media() {

			private static final long serialVersionUID = 1L;

			{
				setOfficialAccountId(oaid);
				setType(type);
				setMediaId(result.getMediaId());
				setPath(filePath);
				setName(name);
				if ( type.equals(EnumConstants.MediaTypeOfEnum.img.key()) ) {
					setUrl(result.getUrl());
				}
				setMediaType(EnumConstants.MediaMediaTypeOfEnum.forever.key());
			}
		});
	}


	/**
	 * 
	 * 添加视频素材
	 * <p>
	 * 
	 *
	 * @param mediaReqDto
	 * @throws WxErrorException TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@Override
	public void addMediaVideo( MediaReqDto mediaReqDto ) throws WxErrorException {
		Long oaid = orgOfficialAccountMapper.getOfficialAccountIdByOrgId(mediaReqDto.getOrgId());
		WechatClient wechatClient = wechatFactory.getInstance(oaid);
		WxMpMaterial material = new WxMpMaterial(
				mediaReqDto.getName(), mediaReqDto.getFile(), mediaReqDto.getVideoTitle(),
				mediaReqDto.getVideoIntroduction());
		WxMpMaterialUploadResult result = wechatClient.materialFileUpload(EnumConstants.MediaTypeOfEnum.video.desc(), material);
		mediaMapper.insertSelective(new Media() {

			private static final long serialVersionUID = 1L;

			{
				setOfficialAccountId(oaid);
				setType(EnumConstants.MediaTypeOfEnum.video.key());
				setMediaId(result.getMediaId());
				setPath(mediaReqDto.getFilePath());
				setName(mediaReqDto.getName());
				setTitle(mediaReqDto.getVideoTitle());
				setIntroduction(mediaReqDto.getVideoIntroduction());
				setMediaType(EnumConstants.MediaMediaTypeOfEnum.forever.key());
			}
		});
	}


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
	@Override
	public Page<Media> getMediaPage( Page<Media> page, Long orgId, Integer type ) {
		mediaMapper.selectByTypePage(page, getOaid(orgId), type);
		return page;
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
	public Media modigyMedia( Long id, String name, String title, String introduction ) {
		Media media = mediaMapper.selectByPrimaryKey(id);
		media.setName(name);
		if ( media.getType().equals(EnumConstants.MediaTypeOfEnum.video.key()) ) {
			media.setTitle(title);
			media.setIntroduction(introduction);
		}
		mediaMapper.updateByPrimaryKeySelective(media);
		return media;
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
	public Boolean deleteMedia( Long id, Long orgId ) throws WxErrorException {
		Media media = mediaMapper.selectByPrimaryKey(id);
		WechatClient wechatClient = wechatFactory.getInstance(getOaid(orgId));
		wechatClient.materialDelete(media.getMediaId());
		int result = mediaMapper.deleteByPrimaryKey(id);
		if ( result > 0 ) {
			return true;
		} else {
			return false;
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
	public void addMediaNews( MediaNewsReqDto dto ) throws WxErrorException {
		WxMpMaterialUploadResult result = addMediaNewsToWechat(dto);
		Media media = new Media() {

			private static final long serialVersionUID = 1L;

			{
				setOfficialAccountId(getOaid(dto.getOrgId()));
				setMediaId(result.getMediaId());
				setType(EnumConstants.MediaTypeOfEnum.video.key());
				setMediaType(EnumConstants.MediaMediaTypeOfEnum.forever.key());
			}
		};
		mediaMapper.insertSelective(media);
		dto.getMediaNewsList().forEach(mediaNews -> {
			mediaNews.setMyMediaId(media.getId());
		});
		mediaNewsMapper.batchInsert(dto.getMediaNewsList());
	}


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
	@Override
	public void modifyMediaNews( MediaNewsReqDto dto ) throws WxErrorException {
		WechatClient wechatClient = wechatFactory.getInstance(getOaid(dto.getOrgId()));
		Boolean flag = false;
		List<MediaNews> insertList = new ArrayList<>();
		List<MediaNews> updateList = new ArrayList<>();
		for ( MediaNews mediaNews : dto.getMediaNewsList() ) {
			if ( mediaNews.getId() == null ) {
				insertList.add(mediaNews);
				flag = true;
			} else {
				updateList.add(mediaNews);
			}
		}
		Media media = mediaMapper.selectByPrimaryKey(dto.getId());
		if ( flag ) {
			wechatClient.materialDelete(media.getMediaId());
			WxMpMaterialUploadResult result = addMediaNewsToWechat(dto);
			media.setMediaId(result.getMediaId());
			mediaMapper.updateByPrimaryKey(media);
			mediaNewsMapper.batchUpdateSelective(updateList);
			insertList.forEach(mediaNews -> {
				mediaNews.setMyMediaId(media.getId());
			});
			mediaNewsMapper.batchInsert(insertList);
		} else {
			List<WxMpMaterialArticleUpdate> articleUpdateList = dto.getMediaNewsList().stream()
					.map(news -> new WxMpMaterialArticleUpdate() {

						private static final long serialVersionUID = 1L;

						{
							setMediaId(media.getMediaId());
							setIndex(news.getOrderNum());
							setArticles(new WxMpMaterialNews.WxMpMaterialNewsArticle() {

								{
									setAuthor(news.getAuthor());
									setContent(news.getContent());
									setContentSourceUrl(news.getContentSourceUrl());
									setDigest(news.getDigest());
									setShowCoverPic(MediaShowCoverPicOfEnum.getBoolean(news.getShowCoverPic()));
									setThumbMediaId(news.getThumbMediaId());
									setTitle(news.getTitle());
								}
							});
						}
					}).collect(Collectors.toList());
			articleUpdateList.forEach(articleUpdate -> {
				try {
					wechatClient.materialNewsUpdate(articleUpdate);
				} catch ( Exception e ) {
					e.printStackTrace();
				}
			});
			mediaNewsMapper.batchUpdateSelective(dto.getMediaNewsList());
		}
	}


	private WxMpMaterialUploadResult addMediaNewsToWechat( MediaNewsReqDto dto ) throws WxErrorException {
		WechatClient wechatClient = wechatFactory.getInstance(getOaid(dto.getOrgId()));
		WxMpMaterialNews news = new WxMpMaterialNews();
		List<WxMpMaterialNewsArticle> collect = dto.getMediaNewsList().stream()
				.map(mediaNews -> new WxMpMaterialNews.WxMpMaterialNewsArticle() {

					{
						setAuthor(mediaNews.getAuthor());
						setContent(mediaNews.getContent());
						setContentSourceUrl(mediaNews.getContentSourceUrl());
						setDigest(mediaNews.getDigest());
						setShowCoverPic(MediaShowCoverPicOfEnum.getBoolean(mediaNews.getShowCoverPic()));
						setThumbMediaId(mediaNews.getThumbMediaId());
						setTitle(mediaNews.getTitle());
					}
				}).collect(Collectors.toList());
		collect.forEach(article -> {
			news.addArticle(article);
		});
		WxMpMaterialUploadResult result = wechatClient.materialNewsUpload(news);
		return result;
	}


	Long getOaid( Long orgId ) {
		return orgOfficialAccountMapper.getOfficialAccountIdByOrgId(orgId);
	}


}
