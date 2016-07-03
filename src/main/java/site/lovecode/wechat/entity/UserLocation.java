package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table( name = "WX_USER_LOCATION" )
public class UserLocation implements Identity, Serializable {

	/**
	 * 主键
	 */
	@Id
	private Long id;

	/**
	 * 收到消息一方的用户id，关联微信个人用户表或微信公众账号基本信息表
	 */
	private Long toUserId;

	/**
	 * 消息发送方的用户id
	 */
	private Long fromUserId;

	/**
	 * 接收方微信号
	 */
	private String toUserName;

	/**
	 * 发送方微信号openid
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
	 * 地理位置维度
	 */
	private String latitude;

	/**
	 * 地理位置经度
	 */
	private String longitude;

	/**
	 * 地理位置精度
	 */
	private String locationPrecision;

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
	 * 获取收到消息一方的用户id，关联微信个人用户表或微信公众账号基本信息表
	 *
	 * @return toUserId - 收到消息一方的用户id，关联微信个人用户表或微信公众账号基本信息表
	 */
	public Long getToUserId() {
		return toUserId;
	}


	/**
	 * 设置收到消息一方的用户id，关联微信个人用户表或微信公众账号基本信息表
	 *
	 * @param toUserId 收到消息一方的用户id，关联微信个人用户表或微信公众账号基本信息表
	 */
	public void setToUserId( Long toUserId ) {
		this.toUserId = toUserId;
	}


	/**
	 * 获取消息发送方的用户id
	 *
	 * @return fromUserId - 消息发送方的用户id
	 */
	public Long getFromUserId() {
		return fromUserId;
	}


	/**
	 * 设置消息发送方的用户id
	 *
	 * @param fromUserId 消息发送方的用户id
	 */
	public void setFromUserId( Long fromUserId ) {
		this.fromUserId = fromUserId;
	}


	/**
	 * 获取接收方微信号
	 *
	 * @return toUserName - 接收方微信号
	 */
	public String getToUserName() {
		return toUserName;
	}


	/**
	 * 设置接收方微信号
	 *
	 * @param toUserName 接收方微信号
	 */
	public void setToUserName( String toUserName ) {
		this.toUserName = toUserName;
	}


	/**
	 * 获取发送方微信号openid
	 *
	 * @return fromUserName - 发送方微信号openid
	 */
	public String getFromUserName() {
		return fromUserName;
	}


	/**
	 * 设置发送方微信号openid
	 *
	 * @param fromUserName 发送方微信号openid
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
	 * 获取地理位置维度
	 *
	 * @return latitude - 地理位置维度
	 */
	public String getLatitude() {
		return latitude;
	}


	/**
	 * 设置地理位置维度
	 *
	 * @param latitude 地理位置维度
	 */
	public void setLatitude( String latitude ) {
		this.latitude = latitude;
	}


	/**
	 * 获取地理位置经度
	 *
	 * @return longitude - 地理位置经度
	 */
	public String getLongitude() {
		return longitude;
	}


	/**
	 * 设置地理位置经度
	 *
	 * @param longitude 地理位置经度
	 */
	public void setLongitude( String longitude ) {
		this.longitude = longitude;
	}


	/**
	 * 获取地理位置精度
	 *
	 * @return locationPrecision - 地理位置精度
	 */
	public String getLocationPrecision() {
		return locationPrecision;
	}


	/**
	 * 设置地理位置精度
	 *
	 * @param locationPrecision 地理位置精度
	 */
	public void setLocationPrecision( String locationPrecision ) {
		this.locationPrecision = locationPrecision;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", toUserId=").append(toUserId);
		sb.append(", fromUserId=").append(fromUserId);
		sb.append(", toUserName=").append(toUserName);
		sb.append(", fromUserName=").append(fromUserName);
		sb.append(", createTime=").append(createTime);
		sb.append(", msgType=").append(msgType);
		sb.append(", event=").append(event);
		sb.append(", latitude=").append(latitude);
		sb.append(", longitude=").append(longitude);
		sb.append(", locationPrecision=").append(locationPrecision);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
