package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table( name = "WX_BUSINESS_INFO" )
public class BusinessInfo implements Identity, Serializable {


	/**
	 * 创建 BusinessInfo对象.
	 *
	 */

	public BusinessInfo() {
		super();
	}


	/**
	 * 创建 BusinessInfo对象.
	 *
	 * @param officialAccountId
	 * @param businessInfoName
	 * @param businessInfoStatus
	 */

	public BusinessInfo( Long officialAccountId, Integer businessInfoName, Integer businessInfoStatus ) {
		super();
		this.officialAccountId = officialAccountId;
		this.businessInfoName = businessInfoName;
		this.businessInfoStatus = businessInfoStatus;
	}

	/**
	 * 主键
	 */
	@Id
	private Long id;

	/**
	 * 微信公众账号基本信息表id，关联微信公众号基本信息表
	 */
	private Long officialAccountId;

	/**
	 * 商业功能名称
	 */
	private Integer businessInfoName;

	/**
	 * 商业功能开通状态
	 */
	private Integer businessInfoStatus;

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
	 * 获取微信公众账号基本信息表id，关联微信公众号基本信息表
	 *
	 * @return officialAccountId - 微信公众账号基本信息表id，关联微信公众号基本信息表
	 */
	public Long getOfficialAccountId() {
		return officialAccountId;
	}


	/**
	 * 设置微信公众账号基本信息表id，关联微信公众号基本信息表
	 *
	 * @param officialAccountId 微信公众账号基本信息表id，关联微信公众号基本信息表
	 */
	public void setOfficialAccountId( Long officialAccountId ) {
		this.officialAccountId = officialAccountId;
	}


	/**
	 * 获取商业功能名称
	 *
	 * @return businessInfoName - 商业功能名称
	 */
	public Integer getBusinessInfoName() {
		return businessInfoName;
	}


	/**
	 * 设置商业功能名称
	 *
	 * @param businessInfoName 商业功能名称
	 */
	public void setBusinessInfoName( Integer businessInfoName ) {
		this.businessInfoName = businessInfoName;
	}


	/**
	 * 获取商业功能开通状态
	 *
	 * @return businessInfoStatus - 商业功能开通状态
	 */
	public Integer getBusinessInfoStatus() {
		return businessInfoStatus;
	}


	/**
	 * 设置商业功能开通状态
	 *
	 * @param businessInfoStatus 商业功能开通状态
	 */
	public void setBusinessInfoStatus( Integer businessInfoStatus ) {
		this.businessInfoStatus = businessInfoStatus;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", officialAccountId=").append(officialAccountId);
		sb.append(", businessInfoName=").append(businessInfoName);
		sb.append(", businessInfoStatus=").append(businessInfoStatus);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
