package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table( name = "WX_PRE_AUTH_CODE" )
public class PreAuthCode implements Identity, Serializable {

	/**
	 * 主键
	 */
	@Id
	private Long id;

	/**
	 * 微信预授权码
	 */
	private String preAuthCode;

	private Date createTime;

	/**
	 * 有效期
	 */
	private Integer expiresIn;

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
	 * 获取微信预授权码
	 *
	 * @return preAuthCode - 微信预授权码
	 */
	public String getPreAuthCode() {
		return preAuthCode;
	}


	/**
	 * 设置微信预授权码
	 *
	 * @param preAuthCode 微信预授权码
	 */
	public void setPreAuthCode( String preAuthCode ) {
		this.preAuthCode = preAuthCode;
	}


	/**
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}


	/**
	 * @param createTime
	 */
	public void setCreateTime( Date createTime ) {
		this.createTime = createTime;
	}


	/**
	 * 获取有效期
	 *
	 * @return expiresIn - 有效期
	 */
	public Integer getExpiresIn() {
		return expiresIn;
	}


	/**
	 * 设置有效期
	 *
	 * @param expiresIn 有效期
	 */
	public void setExpiresIn( Integer expiresIn ) {
		this.expiresIn = expiresIn;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", preAuthCode=").append(preAuthCode);
		sb.append(", createTime=").append(createTime);
		sb.append(", expiresIn=").append(expiresIn);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
