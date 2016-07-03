package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table( name = "WX_OFFICIAL_ACCOUNT" )
public class OfficialAccount implements Identity, Serializable {

	@Id
	private Long id;

	/**
	 * 微信公众号appid
	 */
	private String appid;

	/**
	 * 公众账号的绑定方式,1为授权绑定,2为手动绑定
	        
	 */
	private Integer accountType;

	/**
	 * 公众号类型，0代表订阅号，1代表由历史老帐号升级后的订阅号，2代表服务号
	 */
	private Integer serviceTypeInfo;

	/**
	 * 授权方认证类型，-1代表未认证，0代表微信认证，1代表新浪微博认证，2代表腾讯微博认证，3代表已资质认证通过但还未通过名称认证，4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
	 */
	private Integer verifyTypeInfo;

	/**
	 * 公众号名称
	 */
	private String nickName;

	/**
	 * 公众号原始id
	 */
	private String userName;

	/**
	 * 记录创建时间
	 */
	private Date createTime;

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
	 * 获取微信公众号appid
	 *
	 * @return appid - 微信公众号appid
	 */
	public String getAppid() {
		return appid;
	}


	/**
	 * 设置微信公众号appid
	 *
	 * @param appid 微信公众号appid
	 */
	public void setAppid( String appid ) {
		this.appid = appid;
	}


	/**
	 * 获取公众账号的绑定方式,1为授权绑定,2为手动绑定
	        
	 *
	 * @return accountType - 公众账号的绑定方式,1为授权绑定,2为手动绑定
	        
	 */
	public Integer getAccountType() {
		return accountType;
	}


	/**
	 * 设置公众账号的绑定方式,1为授权绑定,2为手动绑定
	        
	 *
	 * @param accountType 公众账号的绑定方式,1为授权绑定,2为手动绑定
	        
	 */
	public void setAccountType( Integer accountType ) {
		this.accountType = accountType;
	}


	/**
	 * 获取公众号类型，0代表订阅号，1代表由历史老帐号升级后的订阅号，2代表服务号
	 *
	 * @return serviceTypeInfo - 公众号类型，0代表订阅号，1代表由历史老帐号升级后的订阅号，2代表服务号
	 */
	public Integer getServiceTypeInfo() {
		return serviceTypeInfo;
	}


	/**
	 * 设置公众号类型，0代表订阅号，1代表由历史老帐号升级后的订阅号，2代表服务号
	 *
	 * @param serviceTypeInfo 公众号类型，0代表订阅号，1代表由历史老帐号升级后的订阅号，2代表服务号
	 */
	public void setServiceTypeInfo( Integer serviceTypeInfo ) {
		this.serviceTypeInfo = serviceTypeInfo;
	}


	/**
	 * 获取授权方认证类型，-1代表未认证，0代表微信认证，1代表新浪微博认证，2代表腾讯微博认证，3代表已资质认证通过但还未通过名称认证，4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
	 *
	 * @return verifyTypeInfo - 授权方认证类型，-1代表未认证，0代表微信认证，1代表新浪微博认证，2代表腾讯微博认证，3代表已资质认证通过但还未通过名称认证，4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
	 */
	public Integer getVerifyTypeInfo() {
		return verifyTypeInfo;
	}


	/**
	 * 设置授权方认证类型，-1代表未认证，0代表微信认证，1代表新浪微博认证，2代表腾讯微博认证，3代表已资质认证通过但还未通过名称认证，4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
	 *
	 * @param verifyTypeInfo 授权方认证类型，-1代表未认证，0代表微信认证，1代表新浪微博认证，2代表腾讯微博认证，3代表已资质认证通过但还未通过名称认证，4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
	 */
	public void setVerifyTypeInfo( Integer verifyTypeInfo ) {
		this.verifyTypeInfo = verifyTypeInfo;
	}


	/**
	 * 获取公众号名称
	 *
	 * @return nickName - 公众号名称
	 */
	public String getNickName() {
		return nickName;
	}


	/**
	 * 设置公众号名称
	 *
	 * @param nickName 公众号名称
	 */
	public void setNickName( String nickName ) {
		this.nickName = nickName;
	}


	/**
	 * 获取公众号原始id
	 *
	 * @return userName - 公众号原始id
	 */
	public String getUserName() {
		return userName;
	}


	/**
	 * 设置公众号原始id
	 *
	 * @param userName 公众号原始id
	 */
	public void setUserName( String userName ) {
		this.userName = userName;
	}


	/**
	 * 获取记录创建时间
	 *
	 * @return createTime - 记录创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}


	/**
	 * 设置记录创建时间
	 *
	 * @param createTime 记录创建时间
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
		sb.append(", appid=").append(appid);
		sb.append(", accountType=").append(accountType);
		sb.append(", serviceTypeInfo=").append(serviceTypeInfo);
		sb.append(", verifyTypeInfo=").append(verifyTypeInfo);
		sb.append(", nickName=").append(nickName);
		sb.append(", userName=").append(userName);
		sb.append(", createTime=").append(createTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
