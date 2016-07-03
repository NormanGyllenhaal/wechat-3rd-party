package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table( name = "WX_MASS_MESSAGE" )
public class MassMessage implements Identity, Serializable {

	/**
	 * 主键
	 */
	@Id
	private Long id;

	/**
	 * 微信公众号基本信息id
	 */
	private Long officialAccountId;

	/**
	 * 微信群组id
	 */
	private String groupId;

	/**
	 * 用于群发的消息的media_id
	 */
	private String mediaId;

	/**
	 * 群发的消息类型，
	 */
	private Integer msgType;

	/**
	 * 填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个
	 */
	private String touser;

	/**
	 * 消息的标题
	 */
	private String title;

	/**
	 * 消息的描述
	 */
	private String description;

	/**
	 * 视频缩略图的媒体ID
	 */
	private String thumbMediaId;

	/**
	 * 用于设定是否向全部用户发送
	 */
	private Integer isToAll;

	/**
	 * 消息的数据ID，，该字段只有在群发图文消息时，才会出现。可以用于在图文分析数据接口中，获取到对应的图文消息的数据，是图文分析数据接口中的msgid字段中的前半部分，详见图文分析数据接口中的msgid字段的介绍。
	 */
	private String msgDataId;

	/**
	 * 消息发送任务的ID
	 */
	private String msgId;

	private String content;

	/**
	 * group_id下粉丝数；或者openid_list中的粉丝数
	 */
	private Integer totalCount;

	/**
	 * 过滤（过滤是指特定地区、性别的过滤、用户设置拒收的过滤，用户接收已超4条的过滤）后，准备发送的粉丝数，原则上，FilterCount = SentCount + ErrorCount
	 */
	private Integer filterCount;

	/**
	 * 群发消息的结果
	 */
	private Integer status;

	/**
	 * 发送失败的粉丝数
	 */
	private Integer errorCount;

	/**
	 * 发送成功的粉丝数
	 */
	private Integer sendCount;

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
	 * 获取微信群组id
	 *
	 * @return groupId - 微信群组id
	 */
	public String getGroupId() {
		return groupId;
	}


	/**
	 * 设置微信群组id
	 *
	 * @param groupId 微信群组id
	 */
	public void setGroupId( String groupId ) {
		this.groupId = groupId;
	}


	/**
	 * 获取用于群发的消息的media_id
	 *
	 * @return mediaId - 用于群发的消息的media_id
	 */
	public String getMediaId() {
		return mediaId;
	}


	/**
	 * 设置用于群发的消息的media_id
	 *
	 * @param mediaId 用于群发的消息的media_id
	 */
	public void setMediaId( String mediaId ) {
		this.mediaId = mediaId;
	}


	/**
	 * 获取群发的消息类型，
	 *
	 * @return msgType - 群发的消息类型，
	 */
	public Integer getMsgType() {
		return msgType;
	}


	/**
	 * 设置群发的消息类型，
	 *
	 * @param msgType 群发的消息类型，
	 */
	public void setMsgType( Integer msgType ) {
		this.msgType = msgType;
	}


	/**
	 * 获取填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个
	 *
	 * @return touser - 填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个
	 */
	public String getTouser() {
		return touser;
	}


	/**
	 * 设置填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个
	 *
	 * @param touser 填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个
	 */
	public void setTouser( String touser ) {
		this.touser = touser;
	}


	/**
	 * 获取消息的标题
	 *
	 * @return title - 消息的标题
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * 设置消息的标题
	 *
	 * @param title 消息的标题
	 */
	public void setTitle( String title ) {
		this.title = title;
	}


	/**
	 * 获取消息的描述
	 *
	 * @return description - 消息的描述
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * 设置消息的描述
	 *
	 * @param description 消息的描述
	 */
	public void setDescription( String description ) {
		this.description = description;
	}


	/**
	 * 获取视频缩略图的媒体ID
	 *
	 * @return thumbMediaId - 视频缩略图的媒体ID
	 */
	public String getThumbMediaId() {
		return thumbMediaId;
	}


	/**
	 * 设置视频缩略图的媒体ID
	 *
	 * @param thumbMediaId 视频缩略图的媒体ID
	 */
	public void setThumbMediaId( String thumbMediaId ) {
		this.thumbMediaId = thumbMediaId;
	}


	/**
	 * 获取用于设定是否向全部用户发送
	 *
	 * @return isToAll - 用于设定是否向全部用户发送
	 */
	public Integer getIsToAll() {
		return isToAll;
	}


	/**
	 * 设置用于设定是否向全部用户发送
	 *
	 * @param isToAll 用于设定是否向全部用户发送
	 */
	public void setIsToAll( Integer isToAll ) {
		this.isToAll = isToAll;
	}


	/**
	 * 获取消息的数据ID，，该字段只有在群发图文消息时，才会出现。可以用于在图文分析数据接口中，获取到对应的图文消息的数据，是图文分析数据接口中的msgid字段中的前半部分，详见图文分析数据接口中的msgid字段的介绍。
	 *
	 * @return msgDataId - 消息的数据ID，，该字段只有在群发图文消息时，才会出现。可以用于在图文分析数据接口中，获取到对应的图文消息的数据，是图文分析数据接口中的msgid字段中的前半部分，详见图文分析数据接口中的msgid字段的介绍。
	 */
	public String getMsgDataId() {
		return msgDataId;
	}


	/**
	 * 设置消息的数据ID，，该字段只有在群发图文消息时，才会出现。可以用于在图文分析数据接口中，获取到对应的图文消息的数据，是图文分析数据接口中的msgid字段中的前半部分，详见图文分析数据接口中的msgid字段的介绍。
	 *
	 * @param msgDataId 消息的数据ID，，该字段只有在群发图文消息时，才会出现。可以用于在图文分析数据接口中，获取到对应的图文消息的数据，是图文分析数据接口中的msgid字段中的前半部分，详见图文分析数据接口中的msgid字段的介绍。
	 */
	public void setMsgDataId( String msgDataId ) {
		this.msgDataId = msgDataId;
	}


	/**
	 * 获取消息发送任务的ID
	 *
	 * @return msgId - 消息发送任务的ID
	 */
	public String getMsgId() {
		return msgId;
	}


	/**
	 * 设置消息发送任务的ID
	 *
	 * @param msgId 消息发送任务的ID
	 */
	public void setMsgId( String msgId ) {
		this.msgId = msgId;
	}


	/**
	 * @return content
	 */
	public String getContent() {
		return content;
	}


	/**
	 * @param content
	 */
	public void setContent( String content ) {
		this.content = content;
	}


	/**
	 * 获取group_id下粉丝数；或者openid_list中的粉丝数
	 *
	 * @return totalCount - group_id下粉丝数；或者openid_list中的粉丝数
	 */
	public Integer getTotalCount() {
		return totalCount;
	}


	/**
	 * 设置group_id下粉丝数；或者openid_list中的粉丝数
	 *
	 * @param totalCount group_id下粉丝数；或者openid_list中的粉丝数
	 */
	public void setTotalCount( Integer totalCount ) {
		this.totalCount = totalCount;
	}


	/**
	 * 获取过滤（过滤是指特定地区、性别的过滤、用户设置拒收的过滤，用户接收已超4条的过滤）后，准备发送的粉丝数，原则上，FilterCount = SentCount + ErrorCount
	 *
	 * @return filterCount - 过滤（过滤是指特定地区、性别的过滤、用户设置拒收的过滤，用户接收已超4条的过滤）后，准备发送的粉丝数，原则上，FilterCount = SentCount + ErrorCount
	 */
	public Integer getFilterCount() {
		return filterCount;
	}


	/**
	 * 设置过滤（过滤是指特定地区、性别的过滤、用户设置拒收的过滤，用户接收已超4条的过滤）后，准备发送的粉丝数，原则上，FilterCount = SentCount + ErrorCount
	 *
	 * @param filterCount 过滤（过滤是指特定地区、性别的过滤、用户设置拒收的过滤，用户接收已超4条的过滤）后，准备发送的粉丝数，原则上，FilterCount = SentCount + ErrorCount
	 */
	public void setFilterCount( Integer filterCount ) {
		this.filterCount = filterCount;
	}


	/**
	 * 获取群发消息的结果
	 *
	 * @return status - 群发消息的结果
	 */
	public Integer getStatus() {
		return status;
	}


	/**
	 * 设置群发消息的结果
	 *
	 * @param status 群发消息的结果
	 */
	public void setStatus( Integer status ) {
		this.status = status;
	}


	/**
	 * 获取发送失败的粉丝数
	 *
	 * @return errorCount - 发送失败的粉丝数
	 */
	public Integer getErrorCount() {
		return errorCount;
	}


	/**
	 * 设置发送失败的粉丝数
	 *
	 * @param errorCount 发送失败的粉丝数
	 */
	public void setErrorCount( Integer errorCount ) {
		this.errorCount = errorCount;
	}


	/**
	 * 获取发送成功的粉丝数
	 *
	 * @return sendCount - 发送成功的粉丝数
	 */
	public Integer getSendCount() {
		return sendCount;
	}


	/**
	 * 设置发送成功的粉丝数
	 *
	 * @param sendCount 发送成功的粉丝数
	 */
	public void setSendCount( Integer sendCount ) {
		this.sendCount = sendCount;
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
		sb.append(", officialAccountId=").append(officialAccountId);
		sb.append(", groupId=").append(groupId);
		sb.append(", mediaId=").append(mediaId);
		sb.append(", msgType=").append(msgType);
		sb.append(", touser=").append(touser);
		sb.append(", title=").append(title);
		sb.append(", description=").append(description);
		sb.append(", thumbMediaId=").append(thumbMediaId);
		sb.append(", isToAll=").append(isToAll);
		sb.append(", msgDataId=").append(msgDataId);
		sb.append(", msgId=").append(msgId);
		sb.append(", content=").append(content);
		sb.append(", totalCount=").append(totalCount);
		sb.append(", filterCount=").append(filterCount);
		sb.append(", status=").append(status);
		sb.append(", errorCount=").append(errorCount);
		sb.append(", sendCount=").append(sendCount);
		sb.append(", createTime=").append(createTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
