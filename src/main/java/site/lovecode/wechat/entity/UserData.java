package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;
import site.lovecode.wechat.util.DateUtil;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Table( name = "WX_USER_DATA" )
public class UserData implements Identity, Serializable {

	@Id
	private Long id;

	/**
	 * 微信公众号基本信息id，关联公众号基本信息表
	 */
	private Long officialAccountId;

	/**
	 * 数据的日期
	 */
	private Date refDate;

	/**
	 * 用户的渠道，数值代表的含义如下：
	        0代表其他（包括带参数二维码） 3代表扫二维码 17代表名片分享 35代表搜号码（即微信添加朋友页的搜索） 39代表查询微信公众帐号 43代表图文页右上角菜单
	 */
	private Integer userSource;

	/**
	 * 新增的用户数量
	 */
	private Integer newUser;

	/**
	 * 取消关注的用户数量，new_user减去cancel_user即为净增用户数量
	 */
	private Integer cancel;

	/**
	 * 总用户量
	 */
	private Integer cumulateUser;

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
	 * 获取微信公众号基本信息id，关联公众号基本信息表
	 *
	 * @return officialAccountId - 微信公众号基本信息id，关联公众号基本信息表
	 */
	public Long getOfficialAccountId() {
		return officialAccountId;
	}


	/**
	 * 设置微信公众号基本信息id，关联公众号基本信息表
	 *
	 * @param officialAccountId 微信公众号基本信息id，关联公众号基本信息表
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
	 * 获取用户的渠道，数值代表的含义如下：
	        0代表其他（包括带参数二维码） 3代表扫二维码 17代表名片分享 35代表搜号码（即微信添加朋友页的搜索） 39代表查询微信公众帐号 43代表图文页右上角菜单
	 *
	 * @return userSource - 用户的渠道，数值代表的含义如下：
	        0代表其他（包括带参数二维码） 3代表扫二维码 17代表名片分享 35代表搜号码（即微信添加朋友页的搜索） 39代表查询微信公众帐号 43代表图文页右上角菜单
	 */
	public Integer getUserSource() {
		return userSource;
	}


	/**
	 * 设置用户的渠道，数值代表的含义如下：
	        0代表其他（包括带参数二维码） 3代表扫二维码 17代表名片分享 35代表搜号码（即微信添加朋友页的搜索） 39代表查询微信公众帐号 43代表图文页右上角菜单
	 *
	 * @param userSource 用户的渠道，数值代表的含义如下：
	        0代表其他（包括带参数二维码） 3代表扫二维码 17代表名片分享 35代表搜号码（即微信添加朋友页的搜索） 39代表查询微信公众帐号 43代表图文页右上角菜单
	 */
	public void setUserSource( Integer userSource ) {
		this.userSource = userSource;
	}


	/**
	 * 获取新增的用户数量
	 *
	 * @return newUser - 新增的用户数量
	 */
	public Integer getNewUser() {
		return newUser;
	}


	/**
	 * 设置新增的用户数量
	 *
	 * @param newUser 新增的用户数量
	 */
	public void setNewUser( Integer newUser ) {
		this.newUser = newUser;
	}


	/**
	 * 获取取消关注的用户数量，new_user减去cancel_user即为净增用户数量
	 *
	 * @return cancel - 取消关注的用户数量，new_user减去cancel_user即为净增用户数量
	 */
	public Integer getCancel() {
		return cancel;
	}


	/**
	 * 设置取消关注的用户数量，new_user减去cancel_user即为净增用户数量
	 *
	 * @param cancel 取消关注的用户数量，new_user减去cancel_user即为净增用户数量
	 */
	public void setCancel( Integer cancel ) {
		this.cancel = cancel;
	}


	/**
	 * 获取总用户量
	 *
	 * @return cumulateUser - 总用户量
	 */
	public Integer getCumulateUser() {
		return cumulateUser;
	}


	/**
	 * 设置总用户量
	 *
	 * @param cumulateUser 总用户量
	 */
	public void setCumulateUser( Integer cumulateUser ) {
		this.cumulateUser = cumulateUser;
	}



	public Map<String,Object>  toMap(){
		return new HashMap<String, Object>() {
			{
				put("时间", DateUtil.formatDate(refDate));
				put("新关注人数",newUser);
				put("取消关注人数",cancel);
				put("净增关注人数",newUser-cancel);
				put("累计关注人数",cumulateUser);
			}
		};
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
		sb.append(", userSource=").append(userSource);
		sb.append(", newUser=").append(newUser);
		sb.append(", cancel=").append(cancel);
		sb.append(", cumulateUser=").append(cumulateUser);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
