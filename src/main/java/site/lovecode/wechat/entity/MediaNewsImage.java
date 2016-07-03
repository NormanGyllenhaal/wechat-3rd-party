package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table( name = "WX_MEDIA_NEWS_IMAGE" )
public class MediaNewsImage implements Identity, Serializable {

	@Id
	private Long id;

	/**
	 * 图文素材id,关联图文素材信息表
	 */
	private Long mediaNewsId;

	/**
	 * 图片url
	 */
	private String url;

	/**
	 * 图片顺序
	 */
	private Integer num;

	private static final long serialVersionUID = 1L;


	/**
	 * @return id
	 */
	@Override
	public Long getId() {
		return id;
	}


	/**
	 * @param id
	 */
	@Override
	public void setId( Long id ) {
		this.id = id;
	}


	/**
	 * 获取图文素材id,关联图文素材信息表
	 *
	 * @return mediaNewsId - 图文素材id,关联图文素材信息表
	 */
	public Long getMediaNewsId() {
		return mediaNewsId;
	}


	/**
	 * 设置图文素材id,关联图文素材信息表
	 *
	 * @param mediaNewsId 图文素材id,关联图文素材信息表
	 */
	public void setMediaNewsId( Long mediaNewsId ) {
		this.mediaNewsId = mediaNewsId;
	}


	/**
	 * 获取图片url
	 *
	 * @return url - 图片url
	 */
	public String getUrl() {
		return url;
	}


	/**
	 * 设置图片url
	 *
	 * @param url 图片url
	 */
	public void setUrl( String url ) {
		this.url = url;
	}


	/**
	 * 获取图片顺序
	 *
	 * @return num - 图片顺序
	 */
	public Integer getNum() {
		return num;
	}


	/**
	 * 设置图片顺序
	 *
	 * @param num 图片顺序
	 */
	public void setNum( Integer num ) {
		this.num = num;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", mediaNewsId=").append(mediaNewsId);
		sb.append(", url=").append(url);
		sb.append(", num=").append(num);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
