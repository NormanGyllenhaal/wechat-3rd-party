package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table( name = "WX_MESSAGE" )
public class Message implements Identity, Serializable {

	/**
	 * 消息id
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
	 * 消息id，64位整型
	 */
	private Long msgId;

	/**
	 * 消息内容
	 */
	private String content;

	/**
	 * 图片链接
	 */
	private String picUrl;

	/**
	 * 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	private String mediaId;

	/**
	 * 语音格式，如amr，speex等
	 */
	private String format;

	/**
	 * 语音识别结果
	 */
	private String recongnition;

	/**
	 * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
	 */
	private String thumbMediaId;

	/**
	 * 地理位置维度
	 */
	private String locationX;

	/**
	 * 地理位置经度
	 */
	private String locationY;

	/**
	 * 地图缩放大小
	 */
	private Integer scale;

	/**
	 * 地理位置信息
	 */
	private String locationLabel;

	/**
	 * 消息标题
	 */
	private String title;

	/**
	 * 消息描述
	 */
	private String description;

	/**
	 * 消息链接
	 */
	private String url;

	/**
	 * 二维码的ticket，可用来换取二维码图片
	 */
	private String ticket;

	/**
	 * 音乐链接
	 */
	private String musicUrl;

	/**
	 * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
	 */
	private String hqMusicUrl;

	/**
	 * 文章数量
	 */
	private Integer articleCount;

	private static final long serialVersionUID = 1L;


	/**
	 * 获取消息id
	 *
	 * @return id - 消息id
	 */
	@Override
	public Long getId() {
		return id;
	}


	/**
	 * 设置消息id
	 *
	 * @param id 消息id
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
	 * 获取消息id，64位整型
	 *
	 * @return msgId - 消息id，64位整型
	 */
	public Long getMsgId() {
		return msgId;
	}


	/**
	 * 设置消息id，64位整型
	 *
	 * @param msgId 消息id，64位整型
	 */
	public void setMsgId( Long msgId ) {
		this.msgId = msgId;
	}


	/**
	 * 获取消息内容
	 *
	 * @return content - 消息内容
	 */
	public String getContent() {
		return content;
	}


	/**
	 * 设置消息内容
	 *
	 * @param content 消息内容
	 */
	public void setContent( String content ) {
		this.content = content;
	}


	/**
	 * 获取图片链接
	 *
	 * @return picUrl - 图片链接
	 */
	public String getPicUrl() {
		return picUrl;
	}


	/**
	 * 设置图片链接
	 *
	 * @param picUrl 图片链接
	 */
	public void setPicUrl( String picUrl ) {
		this.picUrl = picUrl;
	}


	/**
	 * 获取图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 *
	 * @return mediaId - 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	public String getMediaId() {
		return mediaId;
	}


	/**
	 * 设置图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 *
	 * @param mediaId 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	public void setMediaId( String mediaId ) {
		this.mediaId = mediaId;
	}


	/**
	 * 获取语音格式，如amr，speex等
	 *
	 * @return format - 语音格式，如amr，speex等
	 */
	public String getFormat() {
		return format;
	}


	/**
	 * 设置语音格式，如amr，speex等
	 *
	 * @param format 语音格式，如amr，speex等
	 */
	public void setFormat( String format ) {
		this.format = format;
	}


	/**
	 * 获取语音识别结果
	 *
	 * @return recongnition - 语音识别结果
	 */
	public String getRecongnition() {
		return recongnition;
	}


	/**
	 * 设置语音识别结果
	 *
	 * @param recongnition 语音识别结果
	 */
	public void setRecongnition( String recongnition ) {
		this.recongnition = recongnition;
	}


	/**
	 * 获取视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
	 *
	 * @return thumbMediaId - 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
	 */
	public String getThumbMediaId() {
		return thumbMediaId;
	}


	/**
	 * 设置视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
	 *
	 * @param thumbMediaId 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
	 */
	public void setThumbMediaId( String thumbMediaId ) {
		this.thumbMediaId = thumbMediaId;
	}


	/**
	 * 获取地理位置维度
	 *
	 * @return locationX - 地理位置维度
	 */
	public String getLocationX() {
		return locationX;
	}


	/**
	 * 设置地理位置维度
	 *
	 * @param locationX 地理位置维度
	 */
	public void setLocationX( String locationX ) {
		this.locationX = locationX;
	}


	/**
	 * 获取地理位置经度
	 *
	 * @return locationY - 地理位置经度
	 */
	public String getLocationY() {
		return locationY;
	}


	/**
	 * 设置地理位置经度
	 *
	 * @param locationY 地理位置经度
	 */
	public void setLocationY( String locationY ) {
		this.locationY = locationY;
	}


	/**
	 * 获取地图缩放大小
	 *
	 * @return scale - 地图缩放大小
	 */
	public Integer getScale() {
		return scale;
	}


	/**
	 * 设置地图缩放大小
	 *
	 * @param scale 地图缩放大小
	 */
	public void setScale( Integer scale ) {
		this.scale = scale;
	}


	/**
	 * 获取地理位置信息
	 *
	 * @return locationLabel - 地理位置信息
	 */
	public String getLocationLabel() {
		return locationLabel;
	}


	/**
	 * 设置地理位置信息
	 *
	 * @param locationLabel 地理位置信息
	 */
	public void setLocationLabel( String locationLabel ) {
		this.locationLabel = locationLabel;
	}


	/**
	 * 获取消息标题
	 *
	 * @return title - 消息标题
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * 设置消息标题
	 *
	 * @param title 消息标题
	 */
	public void setTitle( String title ) {
		this.title = title;
	}


	/**
	 * 获取消息描述
	 *
	 * @return description - 消息描述
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * 设置消息描述
	 *
	 * @param description 消息描述
	 */
	public void setDescription( String description ) {
		this.description = description;
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
	 * 获取二维码的ticket，可用来换取二维码图片
	 *
	 * @return ticket - 二维码的ticket，可用来换取二维码图片
	 */
	public String getTicket() {
		return ticket;
	}


	/**
	 * 设置二维码的ticket，可用来换取二维码图片
	 *
	 * @param ticket 二维码的ticket，可用来换取二维码图片
	 */
	public void setTicket( String ticket ) {
		this.ticket = ticket;
	}


	/**
	 * 获取音乐链接
	 *
	 * @return musicUrl - 音乐链接
	 */
	public String getMusicUrl() {
		return musicUrl;
	}


	/**
	 * 设置音乐链接
	 *
	 * @param musicUrl 音乐链接
	 */
	public void setMusicUrl( String musicUrl ) {
		this.musicUrl = musicUrl;
	}


	/**
	 * 获取高质量音乐链接，WIFI环境优先使用该链接播放音乐
	 *
	 * @return hqMusicUrl - 高质量音乐链接，WIFI环境优先使用该链接播放音乐
	 */
	public String getHqMusicUrl() {
		return hqMusicUrl;
	}


	/**
	 * 设置高质量音乐链接，WIFI环境优先使用该链接播放音乐
	 *
	 * @param hqMusicUrl 高质量音乐链接，WIFI环境优先使用该链接播放音乐
	 */
	public void setHqMusicUrl( String hqMusicUrl ) {
		this.hqMusicUrl = hqMusicUrl;
	}


	/**
	 * 获取文章数量
	 *
	 * @return articleCount - 文章数量
	 */
	public Integer getArticleCount() {
		return articleCount;
	}


	/**
	 * 设置文章数量
	 *
	 * @param articleCount 文章数量
	 */
	public void setArticleCount( Integer articleCount ) {
		this.articleCount = articleCount;
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
		sb.append(", msgId=").append(msgId);
		sb.append(", content=").append(content);
		sb.append(", picUrl=").append(picUrl);
		sb.append(", mediaId=").append(mediaId);
		sb.append(", format=").append(format);
		sb.append(", recongnition=").append(recongnition);
		sb.append(", thumbMediaId=").append(thumbMediaId);
		sb.append(", locationX=").append(locationX);
		sb.append(", locationY=").append(locationY);
		sb.append(", scale=").append(scale);
		sb.append(", locationLabel=").append(locationLabel);
		sb.append(", title=").append(title);
		sb.append(", description=").append(description);
		sb.append(", url=").append(url);
		sb.append(", ticket=").append(ticket);
		sb.append(", musicUrl=").append(musicUrl);
		sb.append(", hqMusicUrl=").append(hqMusicUrl);
		sb.append(", articleCount=").append(articleCount);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
