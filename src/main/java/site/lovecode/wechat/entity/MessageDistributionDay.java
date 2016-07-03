package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table( name = "WX_MESSAGE_DISTRIBUTION_DAY" )
public class MessageDistributionDay implements Identity, Serializable {

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
	 * 数据的日期
	 */
	private Date refDate;

	/**
	 * 当日发送消息量分布的区间，0代表 “0”，1代表“1-5”，2代表“6-10”，3代表“10次以上”
	 */
	private Integer countInterval;

	/**
	 * 上行发送了（向公众号发送了）消息的用户数
	 */
	private Integer msgUser;

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
	 * 获取数据的日期
	 *
	 * @return refDate - 数据的日期
	 */
	public Date getRefDate() {
		return refDate;
	}


	/**
	 * 设置数据的日期
	 *
	 * @param refDate 数据的日期
	 */
	public void setRefDate( Date refDate ) {
		this.refDate = refDate;
	}


	/**
	 * 获取当日发送消息量分布的区间，0代表 “0”，1代表“1-5”，2代表“6-10”，3代表“10次以上”
	 *
	 * @return countInterval - 当日发送消息量分布的区间，0代表 “0”，1代表“1-5”，2代表“6-10”，3代表“10次以上”
	 */
	public Integer getCountInterval() {
		return countInterval;
	}


	/**
	 * 设置当日发送消息量分布的区间，0代表 “0”，1代表“1-5”，2代表“6-10”，3代表“10次以上”
	 *
	 * @param countInterval 当日发送消息量分布的区间，0代表 “0”，1代表“1-5”，2代表“6-10”，3代表“10次以上”
	 */
	public void setCountInterval( Integer countInterval ) {
		this.countInterval = countInterval;
	}


	/**
	 * 获取上行发送了（向公众号发送了）消息的用户数
	 *
	 * @return msgUser - 上行发送了（向公众号发送了）消息的用户数
	 */
	public Integer getMsgUser() {
		return msgUser;
	}


	/**
	 * 设置上行发送了（向公众号发送了）消息的用户数
	 *
	 * @param msgUser 上行发送了（向公众号发送了）消息的用户数
	 */
	public void setMsgUser( Integer msgUser ) {
		this.msgUser = msgUser;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", officialAccountId=").append(officialAccountId);
		sb.append(", refDate=").append(refDate);
		sb.append(", countInterval=").append(countInterval);
		sb.append(", msgUser=").append(msgUser);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
