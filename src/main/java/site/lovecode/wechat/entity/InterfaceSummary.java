package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table( name = "WX_INTERFACE_SUMMARY" )
public class InterfaceSummary implements Identity, Serializable {

	@Id
	private Long id;

	/**
	 * 微信公众账号基本信息id
	 */
	private Long officialAccountId;

	/**
	 * 数据的日期
	 */
	private Date refDate;

	/**
	 * 通过服务器配置地址获得消息后，被动回复用户消息的次数
	 */
	private Integer callbackCount;

	/**
	 * 上述动作的失败次数
	 */
	private Integer failCount;

	/**
	 * 总耗时，除以callback_count即为平均耗时
	 */
	private Integer totalTimeCost;

	/**
	 * 最大耗时
	 */
	private Integer maxTimeCost;

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
	 * 获取微信公众账号基本信息id
	 *
	 * @return officialAccountId - 微信公众账号基本信息id
	 */
	public Long getOfficialAccountId() {
		return officialAccountId;
	}


	/**
	 * 设置微信公众账号基本信息id
	 *
	 * @param officialAccountId 微信公众账号基本信息id
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
	 * 获取通过服务器配置地址获得消息后，被动回复用户消息的次数
	 *
	 * @return callbackCount - 通过服务器配置地址获得消息后，被动回复用户消息的次数
	 */
	public Integer getCallbackCount() {
		return callbackCount;
	}


	/**
	 * 设置通过服务器配置地址获得消息后，被动回复用户消息的次数
	 *
	 * @param callbackCount 通过服务器配置地址获得消息后，被动回复用户消息的次数
	 */
	public void setCallbackCount( Integer callbackCount ) {
		this.callbackCount = callbackCount;
	}


	/**
	 * 获取上述动作的失败次数
	 *
	 * @return failCount - 上述动作的失败次数
	 */
	public Integer getFailCount() {
		return failCount;
	}


	/**
	 * 设置上述动作的失败次数
	 *
	 * @param failCount 上述动作的失败次数
	 */
	public void setFailCount( Integer failCount ) {
		this.failCount = failCount;
	}


	/**
	 * 获取总耗时，除以callback_count即为平均耗时
	 *
	 * @return totalTimeCost - 总耗时，除以callback_count即为平均耗时
	 */
	public Integer getTotalTimeCost() {
		return totalTimeCost;
	}


	/**
	 * 设置总耗时，除以callback_count即为平均耗时
	 *
	 * @param totalTimeCost 总耗时，除以callback_count即为平均耗时
	 */
	public void setTotalTimeCost( Integer totalTimeCost ) {
		this.totalTimeCost = totalTimeCost;
	}


	/**
	 * 获取最大耗时
	 *
	 * @return maxTimeCost - 最大耗时
	 */
	public Integer getMaxTimeCost() {
		return maxTimeCost;
	}


	/**
	 * 设置最大耗时
	 *
	 * @param maxTimeCost 最大耗时
	 */
	public void setMaxTimeCost( Integer maxTimeCost ) {
		this.maxTimeCost = maxTimeCost;
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
		sb.append(", callbackCount=").append(callbackCount);
		sb.append(", failCount=").append(failCount);
		sb.append(", totalTimeCost=").append(totalTimeCost);
		sb.append(", maxTimeCost=").append(maxTimeCost);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
