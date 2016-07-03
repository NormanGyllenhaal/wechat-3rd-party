package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;
import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table( name = "WX_ARTICLE_SHARE_DAY" )
public class ArticleShareDay implements Identity, Serializable {

	@Id
	private Long id;

	/**
	 * 微信公众号基本信息id
	 */
	private Long officialAccountId;

	/**
	 * 数据的日期
	 */
	@JSONField( name = "ref_date" )
	private Date refDate;

	/**
	 * 分享的场景
	        1代表好友转发 2代表朋友圈 3代表腾讯微博 255代表其他
	 */
	@JSONField( name = "share_scene" )
	private Integer shareScene;

	/**
	 * 分享的次数
	 */
	@JSONField( name = "share_count" )
	private Integer shareCount;

	/**
	 * 分享的人数
	 */
	@JSONField( name = "share_user" )
	private Integer shareUser;

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
	 * 获取分享的场景
	        1代表好友转发 2代表朋友圈 3代表腾讯微博 255代表其他
	 *
	 * @return shareScene - 分享的场景
	        1代表好友转发 2代表朋友圈 3代表腾讯微博 255代表其他
	 */
	public Integer getShareScene() {
		return shareScene;
	}


	/**
	 * 设置分享的场景
	        1代表好友转发 2代表朋友圈 3代表腾讯微博 255代表其他
	 *
	 * @param shareScene 分享的场景
	        1代表好友转发 2代表朋友圈 3代表腾讯微博 255代表其他
	 */
	public void setShareScene( Integer shareScene ) {
		this.shareScene = shareScene;
	}


	/**
	 * 获取分享的次数
	 *
	 * @return shareCount - 分享的次数
	 */
	public Integer getShareCount() {
		return shareCount;
	}


	/**
	 * 设置分享的次数
	 *
	 * @param shareCount 分享的次数
	 */
	public void setShareCount( Integer shareCount ) {
		this.shareCount = shareCount;
	}


	/**
	 * 获取分享的人数
	 *
	 * @return shareUser - 分享的人数
	 */
	public Integer getShareUser() {
		return shareUser;
	}


	/**
	 * 设置分享的人数
	 *
	 * @param shareUser 分享的人数
	 */
	public void setShareUser( Integer shareUser ) {
		this.shareUser = shareUser;
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
		sb.append(", shareScene=").append(shareScene);
		sb.append(", shareCount=").append(shareCount);
		sb.append(", shareUser=").append(shareUser);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
