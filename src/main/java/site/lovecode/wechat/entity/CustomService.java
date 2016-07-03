package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table( name = "WX_CUSTOM_SERVICE" )
public class CustomService implements Identity, Serializable {

	@Id
	private Long id;

	/**
	 * 微信公众号基本信息表id
	 */
	private Long officialAccountId;

	/**
	 * 完整客服账号，格式为：账号前缀@公众号微信号
	 */
	private String kfAccount;

	/**
	 * 客服昵称
	 */
	private String kfNick;

	/**
	 * 客服工号
	 */
	private Integer kfId;

	/**
	 * 客服昵称，最长6个汉字或12个英文字符
	 */
	private String nickname;

	/**
	 * 客服头像
	 */
	private String kfHeadimgurl;

	/**
	 * 客服账号登录密码，格式为密码明文的32位加密MD5值。该密码仅用于在公众平台官网的多客服功能中使用，若不使用多客服功能，则不必设置密码
	 */
	private String password;

	/**
	 * 创建时间
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
	 * 获取微信公众号基本信息表id
	 *
	 * @return officialAccountId - 微信公众号基本信息表id
	 */
	public Long getOfficialAccountId() {
		return officialAccountId;
	}


	/**
	 * 设置微信公众号基本信息表id
	 *
	 * @param officialAccountId 微信公众号基本信息表id
	 */
	public void setOfficialAccountId( Long officialAccountId ) {
		this.officialAccountId = officialAccountId;
	}


	/**
	 * 获取完整客服账号，格式为：账号前缀@公众号微信号
	 *
	 * @return kfAccount - 完整客服账号，格式为：账号前缀@公众号微信号
	 */
	public String getKfAccount() {
		return kfAccount;
	}


	/**
	 * 设置完整客服账号，格式为：账号前缀@公众号微信号
	 *
	 * @param kfAccount 完整客服账号，格式为：账号前缀@公众号微信号
	 */
	public void setKfAccount( String kfAccount ) {
		this.kfAccount = kfAccount;
	}


	/**
	 * 获取客服昵称
	 *
	 * @return kfNick - 客服昵称
	 */
	public String getKfNick() {
		return kfNick;
	}


	/**
	 * 设置客服昵称
	 *
	 * @param kfNick 客服昵称
	 */
	public void setKfNick( String kfNick ) {
		this.kfNick = kfNick;
	}


	/**
	 * 获取客服工号
	 *
	 * @return kfId - 客服工号
	 */
	public Integer getKfId() {
		return kfId;
	}


	/**
	 * 设置客服工号
	 *
	 * @param kfId 客服工号
	 */
	public void setKfId( Integer kfId ) {
		this.kfId = kfId;
	}


	/**
	 * 获取客服昵称，最长6个汉字或12个英文字符
	 *
	 * @return nickname - 客服昵称，最长6个汉字或12个英文字符
	 */
	public String getNickname() {
		return nickname;
	}


	/**
	 * 设置客服昵称，最长6个汉字或12个英文字符
	 *
	 * @param nickname 客服昵称，最长6个汉字或12个英文字符
	 */
	public void setNickname( String nickname ) {
		this.nickname = nickname;
	}


	/**
	 * 获取客服头像
	 *
	 * @return kfHeadimgurl - 客服头像
	 */
	public String getKfHeadimgurl() {
		return kfHeadimgurl;
	}


	/**
	 * 设置客服头像
	 *
	 * @param kfHeadimgurl 客服头像
	 */
	public void setKfHeadimgurl( String kfHeadimgurl ) {
		this.kfHeadimgurl = kfHeadimgurl;
	}


	/**
	 * 获取客服账号登录密码，格式为密码明文的32位加密MD5值。该密码仅用于在公众平台官网的多客服功能中使用，若不使用多客服功能，则不必设置密码
	 *
	 * @return password - 客服账号登录密码，格式为密码明文的32位加密MD5值。该密码仅用于在公众平台官网的多客服功能中使用，若不使用多客服功能，则不必设置密码
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * 设置客服账号登录密码，格式为密码明文的32位加密MD5值。该密码仅用于在公众平台官网的多客服功能中使用，若不使用多客服功能，则不必设置密码
	 *
	 * @param password 客服账号登录密码，格式为密码明文的32位加密MD5值。该密码仅用于在公众平台官网的多客服功能中使用，若不使用多客服功能，则不必设置密码
	 */
	public void setPassword( String password ) {
		this.password = password;
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
		sb.append(", kfAccount=").append(kfAccount);
		sb.append(", kfNick=").append(kfNick);
		sb.append(", kfId=").append(kfId);
		sb.append(", nickname=").append(nickname);
		sb.append(", kfHeadimgurl=").append(kfHeadimgurl);
		sb.append(", password=").append(password);
		sb.append(", createTime=").append(createTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
