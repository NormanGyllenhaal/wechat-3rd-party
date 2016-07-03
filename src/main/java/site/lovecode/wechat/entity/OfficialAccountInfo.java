package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table( name = "WX_OFFICIAL_ACCOUNT_INFO" )
public class OfficialAccountInfo implements Identity, Serializable {

	/**
	 * 主键
	 */
	@Id
	private Long id;

	/**
	 * 微信公众账号基本信息表id，关联微信公众号基本信息表
	 */
	private Long officialAccountId;

	/**
	 * 微信的公众号appid
	 */
	private String appid;

	/**
	 * 微信公众号appSecret
	 */
	private String appSecret;

	/**
	 * 微信公众号的token
	 */
	private String token;

	/**
	 * 微信公众号encodingAesKey
	 */
	private String encodingAesKey;

	/**
	 * 微信号id
	 */
	private String wechatId;

	/**
	 * 公众号消息接收地址
	 */
	private String messageUrl;

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
	 * 获取微信公众账号基本信息表id，关联微信公众号基本信息表
	 *
	 * @return officialAccountId - 微信公众账号基本信息表id，关联微信公众号基本信息表
	 */
	public Long getOfficialAccountId() {
		return officialAccountId;
	}


	/**
	 * 设置微信公众账号基本信息表id，关联微信公众号基本信息表
	 *
	 * @param officialAccountId 微信公众账号基本信息表id，关联微信公众号基本信息表
	 */
	public void setOfficialAccountId( Long officialAccountId ) {
		this.officialAccountId = officialAccountId;
	}


	/**
	 * 获取微信的公众号appid
	 *
	 * @return appid - 微信的公众号appid
	 */
	public String getAppid() {
		return appid;
	}


	/**
	 * 设置微信的公众号appid
	 *
	 * @param appid 微信的公众号appid
	 */
	public void setAppid( String appid ) {
		this.appid = appid;
	}


	/**
	 * 获取微信公众号appSecret
	 *
	 * @return appSecret - 微信公众号appSecret
	 */
	public String getAppSecret() {
		return appSecret;
	}


	/**
	 * 设置微信公众号appSecret
	 *
	 * @param appSecret 微信公众号appSecret
	 */
	public void setAppSecret( String appSecret ) {
		this.appSecret = appSecret;
	}


	/**
	 * 获取微信公众号的token
	 *
	 * @return token - 微信公众号的token
	 */
	public String getToken() {
		return token;
	}


	/**
	 * 设置微信公众号的token
	 *
	 * @param token 微信公众号的token
	 */
	public void setToken( String token ) {
		this.token = token;
	}


	/**
	 * 获取微信公众号encodingAesKey
	 *
	 * @return encodingAesKey - 微信公众号encodingAesKey
	 */
	public String getEncodingAesKey() {
		return encodingAesKey;
	}


	/**
	 * 设置微信公众号encodingAesKey
	 *
	 * @param encodingAesKey 微信公众号encodingAesKey
	 */
	public void setEncodingAesKey( String encodingAesKey ) {
		this.encodingAesKey = encodingAesKey;
	}


	/**
	 * 获取微信号id
	 *
	 * @return wechatId - 微信号id
	 */
	public String getWechatId() {
		return wechatId;
	}


	/**
	 * 设置微信号id
	 *
	 * @param wechatId 微信号id
	 */
	public void setWechatId( String wechatId ) {
		this.wechatId = wechatId;
	}


	/**
	 * 获取公众号消息接收地址
	 *
	 * @return messageUrl - 公众号消息接收地址
	 */
	public String getMessageUrl() {
		return messageUrl;
	}


	/**
	 * 设置公众号消息接收地址
	 *
	 * @param messageUrl 公众号消息接收地址
	 */
	public void setMessageUrl( String messageUrl ) {
		this.messageUrl = messageUrl;
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
		sb.append(", appid=").append(appid);
		sb.append(", appSecret=").append(appSecret);
		sb.append(", token=").append(token);
		sb.append(", encodingAesKey=").append(encodingAesKey);
		sb.append(", wechatId=").append(wechatId);
		sb.append(", messageUrl=").append(messageUrl);
		sb.append(", createTime=").append(createTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
