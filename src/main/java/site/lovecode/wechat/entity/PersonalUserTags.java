package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table( name = "WX_PERSONAL_USER_TAGS" )
public class PersonalUserTags implements Identity, Serializable {

	/**
	 * 主键
	 */
	@Id
	private Long id;

	/**
	 * 用户id
	 */
	private Long personalUserId;

	/**
	 * 标签id
	 */
	private Integer tagId;

	/**
	 * 标签名称
	 */
	private String tagName;

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
	 * 获取用户id
	 *
	 * @return personalUserId - 用户id
	 */
	public Long getPersonalUserId() {
		return personalUserId;
	}


	/**
	 * 设置用户id
	 *
	 * @param personalUserId 用户id
	 */
	public void setPersonalUserId( Long personalUserId ) {
		this.personalUserId = personalUserId;
	}


	/**
	 * 获取标签id
	 *
	 * @return tagId - 标签id
	 */
	public Integer getTagId() {
		return tagId;
	}


	/**
	 * 设置标签id
	 *
	 * @param tagId 标签id
	 */
	public void setTagId( Integer tagId ) {
		this.tagId = tagId;
	}


	/**
	 * 获取标签名称
	 *
	 * @return tagName - 标签名称
	 */
	public String getTagName() {
		return tagName;
	}


	/**
	 * 设置标签名称
	 *
	 * @param tagName 标签名称
	 */
	public void setTagName( String tagName ) {
		this.tagName = tagName;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", personalUserId=").append(personalUserId);
		sb.append(", tagId=").append(tagId);
		sb.append(", tagName=").append(tagName);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
