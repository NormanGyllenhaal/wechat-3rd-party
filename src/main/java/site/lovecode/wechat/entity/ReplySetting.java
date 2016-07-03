package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table( name = "WX_REPLY_SETTING" )
public class ReplySetting implements Identity, Serializable {

	/**
	 * 主键
	 */
	@Id
	private Long id;

	/**
	 * 微信公众号基本信息id
	 */
	private Long officialAccountId;

	/**
	 * 回复是否开启，0代表未开启，1代表开启
	 */
	private Integer replyOpen;

	/**
	 * 动作类型，1代表关注回复，2代表消息自动回复
	 */
	private Integer replyType;

	/**
	 * 自动回复的类型。关注后自动回复和消息自动回复的类型仅支持文本（text）、图片（img）、语音（voice）、视频（video），关键词自动回复则还多了图文消息（news） 
	 */
	private Integer type;

	/**
	 * 对于文本类型，content是文本内容，对于图文、图片、语音、视频类型，content是mediaID
	 */
	private String content;

	/**
	 * 设置平台方，1,代表在微信后台设置，2代表在我方后台设置
	 */
	private Integer plat;

	/**
	 * 创建时间
	 */
	private Date createTime;

	private static final long serialVersionUID = 1L;


	/**
	 * 获取主键
	 *
	 * @return id - 主键
	 */
	@Override
	public Long getId() {
		return id;
	}


	/**
	 * 设置主键
	 *
	 * @param id 主键
	 */
	@Override
	public void setId( Long id ) {
		this.id = id;
	}


	/**
	 * 获取微信公众号基本信息id
	 *
	 * @return officialAccountId - 微信公众号基本信息id
	 */
	public Long getOfficialAccountId() {
		return officialAccountId;
	}


	/**
	 * 设置微信公众号基本信息id
	 *
	 * @param officialAccountId 微信公众号基本信息id
	 */
	public void setOfficialAccountId( Long officialAccountId ) {
		this.officialAccountId = officialAccountId;
	}


	/**
	 * 获取回复是否开启，0代表未开启，1代表开启
	 *
	 * @return replyOpen - 回复是否开启，0代表未开启，1代表开启
	 */
	public Integer getReplyOpen() {
		return replyOpen;
	}


	/**
	 * 设置回复是否开启，0代表未开启，1代表开启
	 *
	 * @param replyOpen 回复是否开启，0代表未开启，1代表开启
	 */
	public void setReplyOpen( Integer replyOpen ) {
		this.replyOpen = replyOpen;
	}


	/**
	 * 获取动作类型，1代表关注回复，2代表消息自动回复
	 *
	 * @return replyType - 动作类型，1代表关注回复，2代表消息自动回复
	 */
	public Integer getReplyType() {
		return replyType;
	}


	/**
	 * 设置动作类型，1代表关注回复，2代表消息自动回复
	 *
	 * @param replyType 动作类型，1代表关注回复，2代表消息自动回复
	 */
	public void setReplyType( Integer replyType ) {
		this.replyType = replyType;
	}


	/**
	 * 获取自动回复的类型。关注后自动回复和消息自动回复的类型仅支持文本（text）、图片（img）、语音（voice）、视频（video），关键词自动回复则还多了图文消息（news） 
	 *
	 * @return type - 自动回复的类型。关注后自动回复和消息自动回复的类型仅支持文本（text）、图片（img）、语音（voice）、视频（video），关键词自动回复则还多了图文消息（news） 
	 */
	public Integer getType() {
		return type;
	}


	/**
	 * 设置自动回复的类型。关注后自动回复和消息自动回复的类型仅支持文本（text）、图片（img）、语音（voice）、视频（video），关键词自动回复则还多了图文消息（news） 
	 *
	 * @param type 自动回复的类型。关注后自动回复和消息自动回复的类型仅支持文本（text）、图片（img）、语音（voice）、视频（video），关键词自动回复则还多了图文消息（news） 
	 */
	public void setType( Integer type ) {
		this.type = type;
	}


	/**
	 * 获取对于文本类型，content是文本内容，对于图文、图片、语音、视频类型，content是mediaID
	 *
	 * @return content - 对于文本类型，content是文本内容，对于图文、图片、语音、视频类型，content是mediaID
	 */
	public String getContent() {
		return content;
	}


	/**
	 * 设置对于文本类型，content是文本内容，对于图文、图片、语音、视频类型，content是mediaID
	 *
	 * @param content 对于文本类型，content是文本内容，对于图文、图片、语音、视频类型，content是mediaID
	 */
	public void setContent( String content ) {
		this.content = content;
	}


	/**
	 * 获取设置平台方，1,代表在微信后台设置，2代表在我方后台设置
	 *
	 * @return plat - 设置平台方，1,代表在微信后台设置，2代表在我方后台设置
	 */
	public Integer getPlat() {
		return plat;
	}


	/**
	 * 设置设置平台方，1,代表在微信后台设置，2代表在我方后台设置
	 *
	 * @param plat 设置平台方，1,代表在微信后台设置，2代表在我方后台设置
	 */
	public void setPlat( Integer plat ) {
		this.plat = plat;
	}


	/**
	 * 获取创建时间
	 *
	 * @return createTime - 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}


	/**
	 * 设置创建时间
	 *
	 * @param createTime 创建时间
	 */
	public void setCreateTime( Date createTime ) {
		this.createTime = createTime;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", officialAccountId=").append(officialAccountId);
		sb.append(", replyOpen=").append(replyOpen);
		sb.append(", replyType=").append(replyType);
		sb.append(", type=").append(type);
		sb.append(", content=").append(content);
		sb.append(", plat=").append(plat);
		sb.append(", createTime=").append(createTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
