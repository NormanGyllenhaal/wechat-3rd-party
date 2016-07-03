package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table( name = "WX_AUTHENTICATION_MESSAGE" )
public class AuthenticationMessage implements Identity, Serializable {

	@Id
	private Long id;

	/**
	 * 微信公众号基本信息id
	 */
	private Long officialAccountId;

	/**
	 * 开发者微信号
	 */
	private String toUserName;

	/**
	 * 系统账号
	 */
	private String fromUserName;

	/**
	 * 消息创建时间
	 */
	private Date createTime;

	/**
	 * 消息类型
	 */
	private Integer msgType;

	/**
	 * 事件类型 
	 */
	private Integer event;

	/**
	 * 认证过期时间
	 */
	private Date expiredTime;

	/**
	 * 失败发生时间 
	 */
	private Date failTime;

	/**
	 * 认证失败的原因
	 */
	private String failReason;

	/**
	 * 消息是否已经通知
	 */
	private Integer advised;

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
	 * 获取开发者微信号
	 *
	 * @return toUserName - 开发者微信号
	 */
	public String getToUserName() {
		return toUserName;
	}


	/**
	 * 设置开发者微信号
	 *
	 * @param toUserName 开发者微信号
	 */
	public void setToUserName( String toUserName ) {
		this.toUserName = toUserName;
	}


	/**
	 * 获取系统账号
	 *
	 * @return fromUserName - 系统账号
	 */
	public String getFromUserName() {
		return fromUserName;
	}


	/**
	 * 设置系统账号
	 *
	 * @param fromUserName 系统账号
	 */
	public void setFromUserName( String fromUserName ) {
		this.fromUserName = fromUserName;
	}


	/**
	 * 获取消息创建时间
	 *
	 * @return createTime - 消息创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}


	/**
	 * 设置消息创建时间
	 *
	 * @param createTime 消息创建时间
	 */
	public void setCreateTime( Date createTime ) {
		this.createTime = createTime;
	}


	/**
	 * 获取消息类型
	 *
	 * @return msgType - 消息类型
	 */
	public Integer getMsgType() {
		return msgType;
	}


	/**
	 * 设置消息类型
	 *
	 * @param msgType 消息类型
	 */
	public void setMsgType( Integer msgType ) {
		this.msgType = msgType;
	}


	/**
	 * 获取事件类型 
	 *
	 * @return event - 事件类型 
	 */
	public Integer getEvent() {
		return event;
	}


	/**
	 * 设置事件类型 
	 *
	 * @param event 事件类型 
	 */
	public void setEvent( Integer event ) {
		this.event = event;
	}


	/**
	 * 获取认证过期时间
	 *
	 * @return expiredTime - 认证过期时间
	 */
	public Date getExpiredTime() {
		return expiredTime;
	}


	/**
	 * 设置认证过期时间
	 *
	 * @param expiredTime 认证过期时间
	 */
	public void setExpiredTime( Date expiredTime ) {
		this.expiredTime = expiredTime;
	}


	/**
	 * 获取失败发生时间 
	 *
	 * @return failTime - 失败发生时间 
	 */
	public Date getFailTime() {
		return failTime;
	}


	/**
	 * 设置失败发生时间 
	 *
	 * @param failTime 失败发生时间 
	 */
	public void setFailTime( Date failTime ) {
		this.failTime = failTime;
	}


	/**
	 * 获取认证失败的原因
	 *
	 * @return failReason - 认证失败的原因
	 */
	public String getFailReason() {
		return failReason;
	}


	/**
	 * 设置认证失败的原因
	 *
	 * @param failReason 认证失败的原因
	 */
	public void setFailReason( String failReason ) {
		this.failReason = failReason;
	}


	/**
	 * 获取消息是否已经通知
	 *
	 * @return advised - 消息是否已经通知
	 */
	public Integer getAdvised() {
		return advised;
	}


	/**
	 * 设置消息是否已经通知
	 *
	 * @param advised 消息是否已经通知
	 */
	public void setAdvised( Integer advised ) {
		this.advised = advised;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", officialAccountId=").append(officialAccountId);
		sb.append(", toUserName=").append(toUserName);
		sb.append(", fromUserName=").append(fromUserName);
		sb.append(", createTime=").append(createTime);
		sb.append(", msgType=").append(msgType);
		sb.append(", event=").append(event);
		sb.append(", expiredTime=").append(expiredTime);
		sb.append(", failTime=").append(failTime);
		sb.append(", failReason=").append(failReason);
		sb.append(", advised=").append(advised);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
