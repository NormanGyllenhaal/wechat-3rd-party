package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table( name = "WX_COMPONENT_VERIFY_TICKET" )
public class ComponentVerifyTicket implements Identity, Serializable {

	/**
	 * 主键
	 */
	@Id
	private Long id;

	/**
	 * 微信第三方componentAppid
	 */
	private String componentAppid;

	/**
	 * 微信第三方component_verify_ticket
	 */
	private String componentVerifyTicket;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 失效时间
	 */
	private Date deadline;

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
	 * 获取微信第三方componentAppid
	 *
	 * @return componentAppid - 微信第三方componentAppid
	 */
	public String getComponentAppid() {
		return componentAppid;
	}


	/**
	 * 设置微信第三方componentAppid
	 *
	 * @param componentAppid 微信第三方componentAppid
	 */
	public void setComponentAppid( String componentAppid ) {
		this.componentAppid = componentAppid;
	}


	/**
	 * 获取微信第三方component_verify_ticket
	 *
	 * @return componentVerifyTicket - 微信第三方component_verify_ticket
	 */
	public String getComponentVerifyTicket() {
		return componentVerifyTicket;
	}


	/**
	 * 设置微信第三方component_verify_ticket
	 *
	 * @param componentVerifyTicket 微信第三方component_verify_ticket
	 */
	public void setComponentVerifyTicket( String componentVerifyTicket ) {
		this.componentVerifyTicket = componentVerifyTicket;
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


	/**
	 * 获取失效时间
	 *
	 * @return deadline - 失效时间
	 */
	public Date getDeadline() {
		return deadline;
	}


	/**
	 * 设置失效时间
	 *
	 * @param deadline 失效时间
	 */
	public void setDeadline( Date deadline ) {
		this.deadline = deadline;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", componentAppid=").append(componentAppid);
		sb.append(", componentVerifyTicket=").append(componentVerifyTicket);
		sb.append(", createTime=").append(createTime);
		sb.append(", deadline=").append(deadline);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
