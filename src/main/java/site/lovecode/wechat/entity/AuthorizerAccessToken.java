package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table( name = "WX_AUTHORIZER_ACCESS_TOKEN" )
public class AuthorizerAccessToken implements Identity, Serializable {


	/**
	 * 创建 AuthorizerAccessToken对象.
	 *
	 */

	public AuthorizerAccessToken() {
		super();
	}


	/**
	 * 创建 AuthorizerAccessToken对象.
	 *
	 * @param officialAccountId
	 * @param authorizerAppid
	 * @param authorizerAccessToken
	 * @param expiresIn
	 * @param authorizerRefreshToken
	 * @param createTime
	 */

	public AuthorizerAccessToken(
			Long officialAccountId,
			String authorizerAppid,
			String authorizerAccessToken,
			Long expiresIn,
			String authorizerRefreshToken,
			Date createTime ) {
		super();
		this.officialAccountId = officialAccountId;
		this.authorizerAppid = authorizerAppid;
		this.authorizerAccessToken = authorizerAccessToken;
		this.expiresIn = expiresIn;
		this.authorizerRefreshToken = authorizerRefreshToken;
		this.createTime = createTime;
	}


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
	 * 授权方appid
	 */
	private String authorizerAppid;

	/**
	 * 授权方令牌
	 */
	private String authorizerAccessToken;

	/**
	 * 截止时间
	 */
	private Long expiresIn;

	/**
	 * 接口调用凭据刷新令牌
	 */
	private String authorizerRefreshToken;

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
	 * 获取授权方appid
	 *
	 * @return authorizerAppid - 授权方appid
	 */
	public String getAuthorizerAppid() {
		return authorizerAppid;
	}


	/**
	 * 设置授权方appid
	 *
	 * @param authorizerAppid 授权方appid
	 */
	public void setAuthorizerAppid( String authorizerAppid ) {
		this.authorizerAppid = authorizerAppid;
	}


	/**
	 * 获取授权方令牌
	 *
	 * @return authorizerAccessToken - 授权方令牌
	 */
	public String getAuthorizerAccessToken() {
		return authorizerAccessToken;
	}


	/**
	 * 设置授权方令牌
	 *
	 * @param authorizerAccessToken 授权方令牌
	 */
	public void setAuthorizerAccessToken( String authorizerAccessToken ) {
		this.authorizerAccessToken = authorizerAccessToken;
	}


	/**
	 * 获取截止时间
	 *
	 * @return expiresIn - 截止时间
	 */
	public Long getExpiresIn() {
		return expiresIn;
	}


	/**
	 * 设置截止时间
	 *
	 * @param expiresIn 截止时间
	 */
	public void setExpiresIn( Long expiresIn ) {
		this.expiresIn = expiresIn;
	}


	/**
	 * 获取接口调用凭据刷新令牌
	 *
	 * @return authorizerRefreshToken - 接口调用凭据刷新令牌
	 */
	public String getAuthorizerRefreshToken() {
		return authorizerRefreshToken;
	}


	/**
	 * 设置接口调用凭据刷新令牌
	 *
	 * @param authorizerRefreshToken 接口调用凭据刷新令牌
	 */
	public void setAuthorizerRefreshToken( String authorizerRefreshToken ) {
		this.authorizerRefreshToken = authorizerRefreshToken;
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
		sb.append(", authorizerAppid=").append(authorizerAppid);
		sb.append(", authorizerAccessToken=").append(authorizerAccessToken);
		sb.append(", expiresIn=").append(expiresIn);
		sb.append(", authorizerRefreshToken=").append(authorizerRefreshToken);
		sb.append(", createTime=").append(createTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
