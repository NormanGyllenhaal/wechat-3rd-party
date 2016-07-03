package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table( name = "WX_TAGS" )
public class Tags implements Identity, Serializable {

	@Id
	private Long id;

	/**
	 * 公众号id
	 */
	private Long officialAccountId;

	/**
	 * 标签id
	 */
	private Integer tagId;

	/**
	 * 标签名称
	 */
	private String tagName;

	/**
	 * 标签下粉丝数
	 */
	private Integer count;

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
	 * 获取公众号id
	 *
	 * @return officialAccountId - 公众号id
	 */
	public Long getOfficialAccountId() {
		return officialAccountId;
	}


	/**
	 * 设置公众号id
	 *
	 * @param officialAccountId 公众号id
	 */
	public void setOfficialAccountId( Long officialAccountId ) {
		this.officialAccountId = officialAccountId;
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


	/**
	 * 获取标签下粉丝数
	 *
	 * @return count - 标签下粉丝数
	 */
	public Integer getCount() {
		return count;
	}


	/**
	 * 设置标签下粉丝数
	 *
	 * @param count 标签下粉丝数
	 */
	public void setCount( Integer count ) {
		this.count = count;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", officialAccountId=").append(officialAccountId);
		sb.append(", tagId=").append(tagId);
		sb.append(", tagName=").append(tagName);
		sb.append(", count=").append(count);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
