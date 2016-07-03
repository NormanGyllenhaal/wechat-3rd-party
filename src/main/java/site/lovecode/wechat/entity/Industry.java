package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table( name = "WX_INDUSTRY" )
public class Industry implements Identity, Serializable {

	/**
	 * 主键
	 */
	@Id
	private Long id;

	/**
	 * 微信公众号基本id
	 */
	private Long officialAccountId;

	/**
	 * 公众号行业id
	 */
	private Integer industryId;

	/**
	 * 公众号行业主行描述
	 */
	private String fristClass;

	/**
	 * 公众号的行业类别，第一行业或第二行业
	 */
	private Integer type;

	/**
	 * 副行描述
	 */
	private String secondClass;

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
	 * 获取微信公众号基本id
	 *
	 * @return officialAccountId - 微信公众号基本id
	 */
	public Long getOfficialAccountId() {
		return officialAccountId;
	}


	/**
	 * 设置微信公众号基本id
	 *
	 * @param officialAccountId 微信公众号基本id
	 */
	public void setOfficialAccountId( Long officialAccountId ) {
		this.officialAccountId = officialAccountId;
	}


	/**
	 * 获取公众号行业id
	 *
	 * @return industryId - 公众号行业id
	 */
	public Integer getIndustryId() {
		return industryId;
	}


	/**
	 * 设置公众号行业id
	 *
	 * @param industryId 公众号行业id
	 */
	public void setIndustryId( Integer industryId ) {
		this.industryId = industryId;
	}


	/**
	 * 获取公众号行业主行描述
	 *
	 * @return fristClass - 公众号行业主行描述
	 */
	public String getFristClass() {
		return fristClass;
	}


	/**
	 * 设置公众号行业主行描述
	 *
	 * @param fristClass 公众号行业主行描述
	 */
	public void setFristClass( String fristClass ) {
		this.fristClass = fristClass;
	}


	/**
	 * 获取公众号的行业类别，第一行业或第二行业
	 *
	 * @return type - 公众号的行业类别，第一行业或第二行业
	 */
	public Integer getType() {
		return type;
	}


	/**
	 * 设置公众号的行业类别，第一行业或第二行业
	 *
	 * @param type 公众号的行业类别，第一行业或第二行业
	 */
	public void setType( Integer type ) {
		this.type = type;
	}


	/**
	 * 获取副行描述
	 *
	 * @return secondClass - 副行描述
	 */
	public String getSecondClass() {
		return secondClass;
	}


	/**
	 * 设置副行描述
	 *
	 * @param secondClass 副行描述
	 */
	public void setSecondClass( String secondClass ) {
		this.secondClass = secondClass;
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
		sb.append(", industryId=").append(industryId);
		sb.append(", fristClass=").append(fristClass);
		sb.append(", type=").append(type);
		sb.append(", secondClass=").append(secondClass);
		sb.append(", createTime=").append(createTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
