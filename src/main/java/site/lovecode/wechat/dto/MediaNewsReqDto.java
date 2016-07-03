/**
 * MediaNewsReqDto.java site.lovecode.wechat.dto Copyright
 * (c) 2016,norman.
 */


package site.lovecode.wechat.dto;


import site.lovecode.wechat.entity.MediaNews;

import java.io.Serializable;
import java.util.List;


/**
 * 图文素材数据载体
 * <p>
 * TODO(这里描述这个类补充说明 – 可选)
 *
 * @author   yangpeng
 * @date	 2016年5月19日 
 * @version  1.0.0	 
 */
public class MediaNewsReqDto implements Serializable {


	private static final long serialVersionUID = 1L;

	private Long id;

	private Long orgId;

	private List<MediaNews> mediaNewsList;


	public Long getId() {
		return id;
	}


	public void setId( Long id ) {
		this.id = id;
	}


	public Long getOrgId() {
		return orgId;
	}


	public void setOrgId( Long orgId ) {
		this.orgId = orgId;
	}


	public List<MediaNews> getMediaNewsList() {
		return mediaNewsList;
	}


	public void setMediaNewsList( List<MediaNews> mediaNewsList ) {
		this.mediaNewsList = mediaNewsList;
	}


}
