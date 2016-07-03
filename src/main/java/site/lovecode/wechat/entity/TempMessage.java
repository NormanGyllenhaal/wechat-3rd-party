package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table( name = "WX_TEMP_MESSAGE" )
public class TempMessage implements Identity, Serializable {

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
	 * 接收用户的openid
	 */
	private String touser;

	/**
	 * 消息链接
	 */
	private String url;

	/**
	 * 发送数据体
	 */
	private String data;

	/**
	 * 消息发送时间
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
	 * 获取接收用户的openid
	 *
	 * @return touser - 接收用户的openid
	 */
	public String getTouser() {
		return touser;
	}


	/**
	 * 设置接收用户的openid
	 *
	 * @param touser 接收用户的openid
	 */
	public void setTouser( String touser ) {
		this.touser = touser;
	}


	/**
	 * 获取消息链接
	 *
	 * @return url - 消息链接
	 */
	public String getUrl() {
		return url;
	}


	/**
	 * 设置消息链接
	 *
	 * @param url 消息链接
	 */
	public void setUrl( String url ) {
		this.url = url;
	}


	/**
	 * 获取发送数据体
	 *
	 * @return data - 发送数据体
	 */
	public String getData() {
		return data;
	}


	/**
	 * 设置发送数据体
	 *
	 * @param data 发送数据体
	 */
	public void setData( String data ) {
		this.data = data;
	}


	/**
	 * 获取消息发送时间
	 *
	 * @return createTime - 消息发送时间
	 */
	public Date getCreateTime() {
		return createTime;
	}


	/**
	 * 设置消息发送时间
	 *
	 * @param createTime 消息发送时间
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
		sb.append(", touser=").append(touser);
		sb.append(", url=").append(url);
		sb.append(", data=").append(data);
		sb.append(", createTime=").append(createTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
