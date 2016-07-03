package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table( name = "WX_INDUSTRY_TEMP" )
public class IndustryTemp implements Identity, Serializable {

	/**
	 * 主键
	 */
	@Id
	private Long id;

	/**
	 * 行业id
	 */
	private Integer industryId;

	/**
	 * 模板编号
	 */
	private String templeteNum;

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
	 * 获取行业id
	 *
	 * @return industryId - 行业id
	 */
	public Integer getIndustryId() {
		return industryId;
	}


	/**
	 * 设置行业id
	 *
	 * @param industryId 行业id
	 */
	public void setIndustryId( Integer industryId ) {
		this.industryId = industryId;
	}


	/**
	 * 获取模板编号
	 *
	 * @return templeteNum - 模板编号
	 */
	public String getTempleteNum() {
		return templeteNum;
	}


	/**
	 * 设置模板编号
	 *
	 * @param templeteNum 模板编号
	 */
	public void setTempleteNum( String templeteNum ) {
		this.templeteNum = templeteNum;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", industryId=").append(industryId);
		sb.append(", templeteNum=").append(templeteNum);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
