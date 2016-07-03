package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table( name = "WX_ORG_OFFICIAL_ACCOUNT" )
public class OrgOfficialAccount implements Identity, Serializable {

	@Id
	private Long id;

	/**
	 * 系统用户id
	 */
	private Long orgId;

	/**
	 * 微信公众号基本信息表id,关联微信公众号基本信息表
	 */
	private Long officialAccountId;

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
	 * 获取系统用户id
	 *
	 * @return orgId - 系统用户id
	 */
	public Long getOrgId() {
		return orgId;
	}


	/**
	 * 设置系统用户id
	 *
	 * @param orgId 系统用户id
	 */
	public void setOrgId( Long orgId ) {
		this.orgId = orgId;
	}


	/**
	 * 获取微信公众号基本信息表id,关联微信公众号基本信息表
	 *
	 * @return officialAccountId - 微信公众号基本信息表id,关联微信公众号基本信息表
	 */
	public Long getOfficialAccountId() {
		return officialAccountId;
	}


	/**
	 * 设置微信公众号基本信息表id,关联微信公众号基本信息表
	 *
	 * @param officialAccountId 微信公众号基本信息表id,关联微信公众号基本信息表
	 */
	public void setOfficialAccountId( Long officialAccountId ) {
		this.officialAccountId = officialAccountId;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", orgId=").append(orgId);
		sb.append(", officialAccountId=").append(officialAccountId);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
