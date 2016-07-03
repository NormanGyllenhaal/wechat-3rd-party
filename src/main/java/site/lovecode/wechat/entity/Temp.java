package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table( name = "WX_TEMP" )
public class Temp implements Identity, Serializable {

	/**
	 * 主键
	 */
	@Id
	private Long id;

	/**
	 * 模板id
	 */
	private String templateId;

	/**
	 * 模板标题
	 */
	private String title;

	/**
	 * 模板所属行业的一级行业
	 */
	private String primaryIndustry;

	/**
	 * 模板所属行业的二级行业
	 */
	private String deputyIndustry;

	/**
	 * 模板内容
	        
	 */
	private String content;

	/**
	 * 模板示例
	 */
	private String example;

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
	 * 获取模板id
	 *
	 * @return templateId - 模板id
	 */
	public String getTemplateId() {
		return templateId;
	}


	/**
	 * 设置模板id
	 *
	 * @param templateId 模板id
	 */
	public void setTemplateId( String templateId ) {
		this.templateId = templateId;
	}


	/**
	 * 获取模板标题
	 *
	 * @return title - 模板标题
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * 设置模板标题
	 *
	 * @param title 模板标题
	 */
	public void setTitle( String title ) {
		this.title = title;
	}


	/**
	 * 获取模板所属行业的一级行业
	 *
	 * @return primaryIndustry - 模板所属行业的一级行业
	 */
	public String getPrimaryIndustry() {
		return primaryIndustry;
	}


	/**
	 * 设置模板所属行业的一级行业
	 *
	 * @param primaryIndustry 模板所属行业的一级行业
	 */
	public void setPrimaryIndustry( String primaryIndustry ) {
		this.primaryIndustry = primaryIndustry;
	}


	/**
	 * 获取模板所属行业的二级行业
	 *
	 * @return deputyIndustry - 模板所属行业的二级行业
	 */
	public String getDeputyIndustry() {
		return deputyIndustry;
	}


	/**
	 * 设置模板所属行业的二级行业
	 *
	 * @param deputyIndustry 模板所属行业的二级行业
	 */
	public void setDeputyIndustry( String deputyIndustry ) {
		this.deputyIndustry = deputyIndustry;
	}


	/**
	 * 获取模板内容
	        
	 *
	 * @return content - 模板内容
	        
	 */
	public String getContent() {
		return content;
	}


	/**
	 * 设置模板内容
	        
	 *
	 * @param content 模板内容
	        
	 */
	public void setContent( String content ) {
		this.content = content;
	}


	/**
	 * 获取模板示例
	 *
	 * @return example - 模板示例
	 */
	public String getExample() {
		return example;
	}


	/**
	 * 设置模板示例
	 *
	 * @param example 模板示例
	 */
	public void setExample( String example ) {
		this.example = example;
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
		sb.append(", templateId=").append(templateId);
		sb.append(", title=").append(title);
		sb.append(", primaryIndustry=").append(primaryIndustry);
		sb.append(", deputyIndustry=").append(deputyIndustry);
		sb.append(", content=").append(content);
		sb.append(", example=").append(example);
		sb.append(", createTime=").append(createTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
