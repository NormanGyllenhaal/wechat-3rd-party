/**
 * MediaDto.java site.lovecode.wechat.dto Copyright (c) 2016,
 *norman.
 */


package site.lovecode.wechat.dto;


import site.lovecode.wechat.entity.Media;
import site.lovecode.wechat.entity.MediaNews;

import java.util.List;

/**
 * 素材信息数据载体
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月18日 
 * @version  1.0.0	 
 */
public class MediaDto extends Media {


	private static final long serialVersionUID = 1L;

	private List<MediaNews> mediaNewsList;


	public List<MediaNews> getMediaNewsList() {
		return mediaNewsList;
	}


	public void setMediaNewsList( List<MediaNews> mediaNewsList ) {
		this.mediaNewsList = mediaNewsList;
	}


}
