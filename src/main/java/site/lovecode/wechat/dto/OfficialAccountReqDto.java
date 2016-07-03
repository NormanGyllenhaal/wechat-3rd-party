package site.lovecode.wechat.dto;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/4/18.
 */
public class OfficialAccountReqDto implements Serializable {


	/**
	 * TODO（用一句话描述这个变量的含义）
	 */

	private static final long serialVersionUID = 1L;

	private Integer serviceTypeInfo;

	private Integer verifyTypeInfo;

	private String nickName;

	private String userName;

	private String appid;

	private String appSecret;

	private String token;

	private String encodingAesKey;

	private String wechatId;

	private String messageUrl;


	public Integer getServiceTypeInfo() {
		return serviceTypeInfo;
	}


	public void setServiceTypeInfo( Integer serviceTypeInfo ) {
		this.serviceTypeInfo = serviceTypeInfo;
	}


	public Integer getVerifyTypeInfo() {
		return verifyTypeInfo;
	}


	public void setVerifyTypeInfo( Integer verifyTypeInfo ) {
		this.verifyTypeInfo = verifyTypeInfo;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName( String nickName ) {
		this.nickName = nickName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName( String userName ) {
		this.userName = userName;
	}


	public String getAppid() {
		return appid;
	}


	public void setAppid( String appid ) {
		this.appid = appid;
	}


	public String getAppSecret() {
		return appSecret;
	}


	public void setAppSecret( String appSecret ) {
		this.appSecret = appSecret;
	}


	public String getToken() {
		return token;
	}


	public void setToken( String token ) {
		this.token = token;
	}


	public String getEncodingAesKey() {
		return encodingAesKey;
	}


	public void setEncodingAesKey( String encodingAesKey ) {
		this.encodingAesKey = encodingAesKey;
	}


	public String getWechatId() {
		return wechatId;
	}


	public void setWechatId( String wechatId ) {
		this.wechatId = wechatId;
	}


	public String getMessageUrl() {
		return messageUrl;
	}


	public void setMessageUrl( String messageUrl ) {
		this.messageUrl = messageUrl;
	}


	@Override
	public String toString() {
		return "OfficialAccountReq{" + "serviceTypeInfo="
				+ serviceTypeInfo + ", verifyTypeInfo=" + verifyTypeInfo + ", nickName='" + nickName + '\''
				+ ", userName='" + userName + '\'' + ", appid='" + appid + '\'' + ", appSecret='" + appSecret + '\''
				+ ", token='" + token + '\'' + ", encodingAesKey='" + encodingAesKey + '\'' + ", wechatId='" + wechatId
				+ '\'' + ", messageUrl='" + messageUrl + '\'' + '}';
	}
}
