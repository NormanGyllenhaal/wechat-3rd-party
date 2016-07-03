package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table( name = "WX_KEYWORD_REPLY_SETTING_REPLY" )
public class KeywordReplySettingReply implements Identity, Serializable {

	@Id
	private Long id;

	/**
	 * 微信关键词自动回复设置id
	 */
	private Long keywordReplySettingId;

	/**
	 * 匹配消息类型，支持文本（text）、图片（img）、语音（voice）、视频（video，图文消息（news）
	 */
	private Integer type;

	private String content;

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
	 * 获取微信关键词自动回复设置id
	 *
	 * @return keywordReplySettingId - 微信关键词自动回复设置id
	 */
	public Long getKeywordReplySettingId() {
		return keywordReplySettingId;
	}


	/**
	 * 设置微信关键词自动回复设置id
	 *
	 * @param keywordReplySettingId 微信关键词自动回复设置id
	 */
	public void setKeywordReplySettingId( Long keywordReplySettingId ) {
		this.keywordReplySettingId = keywordReplySettingId;
	}


	/**
	 * 获取匹配消息类型，支持文本（text）、图片（img）、语音（voice）、视频（video，图文消息（news）
	 *
	 * @return type - 匹配消息类型，支持文本（text）、图片（img）、语音（voice）、视频（video，图文消息（news）
	 */
	public Integer getType() {
		return type;
	}


	/**
	 * 设置匹配消息类型，支持文本（text）、图片（img）、语音（voice）、视频（video，图文消息（news）
	 *
	 * @param type 匹配消息类型，支持文本（text）、图片（img）、语音（voice）、视频（video，图文消息（news）
	 */
	public void setType( Integer type ) {
		this.type = type;
	}


	/**
	 * @return content
	 */
	public String getContent() {
		return content;
	}


	/**
	 * @param content
	 */
	public void setContent( String content ) {
		this.content = content;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", keywordReplySettingId=").append(keywordReplySettingId);
		sb.append(", type=").append(type);
		sb.append(", content=").append(content);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
