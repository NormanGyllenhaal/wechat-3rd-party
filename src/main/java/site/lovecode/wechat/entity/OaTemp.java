package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table( name = "WX_OA_TEMP" )
public class OaTemp implements Identity, Serializable {

	@Id
	private Long id;

	/**
	 * 微信公众号基本信息id
	 */
	private Long officialAccountId;

	/**
	 * 公众号模板id
	 */
	private String templateId;

	/**
	 * 模板优先级
	 */
	private Integer level;

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
	 * 获取公众号模板id
	 *
	 * @return templateId - 公众号模板id
	 */
	public String getTemplateId() {
		return templateId;
	}


	/**
	 * 设置公众号模板id
	 *
	 * @param templateId 公众号模板id
	 */
	public void setTemplateId( String templateId ) {
		this.templateId = templateId;
	}


	/**
	 * 获取模板优先级
	 *
	 * @return level - 模板优先级
	 */
	public Integer getLevel() {
		return level;
	}


	/**
	 * 设置模板优先级
	 *
	 * @param level 模板优先级
	 */
	public void setLevel( Integer level ) {
		this.level = level;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", officialAccountId=").append(officialAccountId);
		sb.append(", templateId=").append(templateId);
		sb.append(", level=").append(level);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
