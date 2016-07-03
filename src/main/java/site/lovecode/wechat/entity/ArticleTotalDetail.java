package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;
import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Table( name = "WX_ARTICLE_TOTAL_DETAIL" )
public class ArticleTotalDetail implements Identity, Serializable {

	/**
	 * 主键
	 */
	@Id
	private Long id;

	/**
	 * 微信图文群发总数据id
	 */
	private Long articleTotalId;

	/**
	 * 微信公众账号基本信息id
	 */
	private Long officialAccountId;


	/**
	 * 数据统计日期
	 */

	private Date statDate;


	private Integer targetUser;

	/**
	 * 图文页（点击群发图文卡片进入的页面）的阅读人数
	 */

	private Integer intPageReadUser;

	/**
	 * 图文页的阅读次数
	 */

	private Integer intPageReadCount;

	/**
	 * 原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0
	 */

	private Integer oriPageReadUser;

	/**
	 * 原文页的阅读次数
	 */

	private Integer oriPageReadCount;

	/**
	 * 分享的人数
	 */

	private Integer shareUser;

	/**
	 * 分享的次数
	 */

	private Integer shareCount;

	/**
	 * 收藏的人数
	 */

	private Integer addToFavUser;

	/**
	 * 收藏的次数
	 */

	private Integer addToFavCount;

	/**
	 * 公众号会话阅读人数
	 */

	private Integer intPageFromSessionReadUser;

	/**
	 *  公众号会话阅读次数
	 */

	private Integer intPageFromSessionReadCount;

	/**
	 * 历史消息页阅读人数
	 */

	private Integer intPageFromHistMsgReadUser;

	/**
	 * 历史消息页阅读次数
	 */

	private Integer intPageFromHistMsgReadCount;

	/**
	 *  朋友圈阅读人数
	 */

	private Integer intPageFromFeedReadUser;


	/**
	 * 好友转发阅读次数
	 */

	private Integer intPageFromFeedReadCount;

	/**
	 * 朋友圈阅读次数
	 */

	private Integer intPageFromFriendsReadUser;

	/**
	 * 好友转发阅读次数
	 */

	private Integer intPageFromFriendReadCount;

	/**
	 * 其他场景阅读人数
	 */

	private Integer intPageFromOtherReadUser;

	/**
	 * 其他场景阅读次数
	 */

	private Integer intPageFromOtherReadCount;

	/**
	 * 公众号会话转发朋友圈人数
	 */

	private Integer feedShareFromSessionUser;

	/**
	 * 公众号会话转发朋友圈次数
	 */

	private Integer feedShareFromSessionCnt;

	/**
	 * 朋友圈转发朋友圈人数
	 */

	private Integer feedShareFromFeedUser;

	/**
	 * 朋友圈转发朋友圈次数
	 */

	private Integer feedShareFromFeedCnt;

	/**
	 * 其他场景转发朋友圈人数
	 */

	private Integer feedShareFromOtherUser;

	/**
	 * 其他场景转发朋友圈次数
	 */

	private Integer feedShareFromOtherCnt;


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
	 * 获取微信图文群发总数据id
	 *
	 * @return articleTotalId - 微信图文群发总数据id
	 */
	public Long getArticleTotalId() {
		return articleTotalId;
	}


	/**
	 * 设置微信图文群发总数据id
	 *
	 * @param articleTotalId 微信图文群发总数据id
	 */
	public void setArticleTotalId( Long articleTotalId ) {
		this.articleTotalId = articleTotalId;
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
	 * 获取数据统计日期
	 *
	 * @return statDate - 数据统计日期
	 */

	public Date getStatDate() {
		return statDate;
	}


	/**
	 * 设置数据统计日期
	 *
	 * @param statDate 数据统计日期
	 */
	@JSONField( name = "stat_date" )
	public void setStatDate( Date statDate ) {
		this.statDate = statDate;
	}


	/**
	 * @return targetUser
	 */
	public Integer getTargetUser() {
		return targetUser;
	}


	/**
	 * @param targetUser
	 */
	@JSONField( name = "target_user" )
	public void setTargetUser( Integer targetUser ) {
		this.targetUser = targetUser;
	}


	/**
	 * 获取图文页（点击群发图文卡片进入的页面）的阅读人数
	 *
	 * @return intPageReadUser - 图文页（点击群发图文卡片进入的页面）的阅读人数
	 */
	public Integer getIntPageReadUser() {
		return intPageReadUser;
	}


	/**
	 * 设置图文页（点击群发图文卡片进入的页面）的阅读人数
	 *
	 * @param intPageReadUser 图文页（点击群发图文卡片进入的页面）的阅读人数
	 */
	@JSONField( name = "int_page_read_user" )
	public void setIntPageReadUser( Integer intPageReadUser ) {
		this.intPageReadUser = intPageReadUser;
	}


	/**
	 * 获取图文页的阅读次数
	 *
	 * @return intPageReadCount - 图文页的阅读次数
	 */
	public Integer getIntPageReadCount() {
		return intPageReadCount;
	}


	/**
	 * 设置图文页的阅读次数
	 *
	 * @param intPageReadCount 图文页的阅读次数
	 */
	@JSONField( name = "int_page_read_count" )
	public void setIntPageReadCount( Integer intPageReadCount ) {
		this.intPageReadCount = intPageReadCount;
	}


	/**
	 * 获取原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0
	 *
	 * @return oriPageReadUser - 原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0
	 */
	public Integer getOriPageReadUser() {
		return oriPageReadUser;
	}


	/**
	 * 设置原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0
	 *
	 * @param oriPageReadUser 原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0
	 */
	@JSONField( name = "ori_page_read_user" )
	public void setOriPageReadUser( Integer oriPageReadUser ) {
		this.oriPageReadUser = oriPageReadUser;
	}


	/**
	 * 获取原文页的阅读次数
	 *
	 * @return oriPageReadCount - 原文页的阅读次数
	 */
	public Integer getOriPageReadCount() {
		return oriPageReadCount;
	}


	/**
	 * 设置原文页的阅读次数
	 *
	 * @param oriPageReadCount 原文页的阅读次数
	 */
	@JSONField( name = "ori_page_read_count" )
	public void setOriPageReadCount( Integer oriPageReadCount ) {
		this.oriPageReadCount = oriPageReadCount;
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
	@JSONField( name = "share_user" )
	public void setShareUser( Integer shareUser ) {
		this.shareUser = shareUser;
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
	@JSONField( name = "share_count" )
	public void setShareCount( Integer shareCount ) {
		this.shareCount = shareCount;
	}


	/**
	 * 获取收藏的人数
	 *
	 * @return addToFavUser - 收藏的人数
	 */
	public Integer getAddToFavUser() {
		return addToFavUser;
	}


	/**
	 * 设置收藏的人数
	 *
	 * @param addToFavUser 收藏的人数
	 */
	@JSONField( name = "add_to_fav_user" )
	public void setAddToFavUser( Integer addToFavUser ) {
		this.addToFavUser = addToFavUser;
	}


	/**
	 * 获取收藏的次数
	 *
	 * @return addToFavCount - 收藏的次数
	 */
	public Integer getAddToFavCount() {
		return addToFavCount;
	}


	/**
	 * 设置收藏的次数
	 *
	 * @param addToFavCount 收藏的次数
	 */
	@JSONField( name = "add_to_fav_count" )
	public void setAddToFavCount( Integer addToFavCount ) {
		this.addToFavCount = addToFavCount;
	}


	/**
	 * 获取公众号会话阅读人数
	 *
	 * @return intPageFromSessionReadUser - 公众号会话阅读人数
	 */
	public Integer getIntPageFromSessionReadUser() {
		return intPageFromSessionReadUser;
	}


	/**
	 * 设置公众号会话阅读人数
	 *
	 * @param intPageFromSessionReadUser 公众号会话阅读人数
	 */
	@JSONField( name = "int_page_from_session_read_user" )
	public void setIntPageFromSessionReadUser( Integer intPageFromSessionReadUser ) {
		this.intPageFromSessionReadUser = intPageFromSessionReadUser;
	}


	/**
	 * 获取 公众号会话阅读次数
	 *
	 * @return intPageFromSessionReadCount -  公众号会话阅读次数
	 */
	public Integer getIntPageFromSessionReadCount() {
		return intPageFromSessionReadCount;
	}


	/**
	 * 设置 公众号会话阅读次数
	 *
	 * @param intPageFromSessionReadCount  公众号会话阅读次数
	 */
	@JSONField( name = "int_page_from_session_read_count" )
	public void setIntPageFromSessionReadCount( Integer intPageFromSessionReadCount ) {
		this.intPageFromSessionReadCount = intPageFromSessionReadCount;
	}


	/**
	 * 获取历史消息页阅读人数
	 *
	 * @return intPageFromHistMsgReadUser - 历史消息页阅读人数
	 */
	public Integer getIntPageFromHistMsgReadUser() {
		return intPageFromHistMsgReadUser;
	}


	/**
	 * 设置历史消息页阅读人数
	 *
	 * @param intPageFromHistMsgReadUser 历史消息页阅读人数
	 */
	@JSONField( name = "int_page_from_hist_msg_read_user" )
	public void setIntPageFromHistMsgReadUser( Integer intPageFromHistMsgReadUser ) {
		this.intPageFromHistMsgReadUser = intPageFromHistMsgReadUser;
	}


	/**
	 * 获取历史消息页阅读次数
	 *
	 * @return intPageFromHistMsgReadCount - 历史消息页阅读次数
	 */
	public Integer getIntPageFromHistMsgReadCount() {
		return intPageFromHistMsgReadCount;
	}


	/**
	 * 设置历史消息页阅读次数
	 *
	 * @param intPageFromHistMsgReadCount 历史消息页阅读次数
	 */
	@JSONField( name = "int_page_from_hist_msg_read_count" )
	public void setIntPageFromHistMsgReadCount( Integer intPageFromHistMsgReadCount ) {
		this.intPageFromHistMsgReadCount = intPageFromHistMsgReadCount;
	}


	/**
	 * 获取 朋友圈阅读人数
	 *
	 * @return intPageFromFeedReadUser -  朋友圈阅读人数
	 */
	public Integer getIntPageFromFeedReadUser() {
		return intPageFromFeedReadUser;
	}


	/**
	 * 设置 朋友圈阅读人数
	 *
	 * @param intPageFromFeedReadUser  朋友圈阅读人数
	 */
	@JSONField( name = "int_page_from_feed_read_user" )
	public void setIntPageFromFeedReadUser( Integer intPageFromFeedReadUser ) {
		this.intPageFromFeedReadUser = intPageFromFeedReadUser;
	}


	/**
	 * 获取好友转发阅读次数
	 *
	 * @return intPageFromFeedReadCount - 好友转发阅读次数
	 */
	public Integer getIntPageFromFeedReadCount() {
		return intPageFromFeedReadCount;
	}


	/**
	 * 设置好友转发阅读次数
	 *
	 * @param intPageFromFeedReadCount 好友转发阅读次数
	 */
	@JSONField( name = "int_page_from_feed_read_count" )
	public void setIntPageFromFeedReadCount( Integer intPageFromFeedReadCount ) {
		this.intPageFromFeedReadCount = intPageFromFeedReadCount;
	}


	/**
	 * 获取朋友圈阅读次数
	 *
	 * @return intPageFromFriendsReadUser - 朋友圈阅读次数
	 */
	public Integer getIntPageFromFriendsReadUser() {
		return intPageFromFriendsReadUser;
	}


	/**
	 * 设置朋友圈阅读次数
	 *
	 * @param intPageFromFriendsReadUser 朋友圈阅读次数
	 */
	@JSONField( name = "int_page_from_friends_read_user" )
	public void setIntPageFromFriendsReadUser( Integer intPageFromFriendsReadUser ) {
		this.intPageFromFriendsReadUser = intPageFromFriendsReadUser;
	}


	/**
	 * 获取好友转发阅读次数
	 *
	 * @return intPageFromFriendReadCount - 好友转发阅读次数
	 */
	public Integer getIntPageFromFriendReadCount() {
		return intPageFromFriendReadCount;
	}


	/**
	 * 设置好友转发阅读次数
	 *
	 * @param intPageFromFriendReadCount 好友转发阅读次数
	 */
	@JSONField( name = "int_page_from_friends_read_count" )
	public void setIntPageFromFriendReadCount( Integer intPageFromFriendReadCount ) {
		this.intPageFromFriendReadCount = intPageFromFriendReadCount;
	}


	/**
	 * 获取其他场景阅读人数
	 *
	 * @return intPageFromOtherReadUser - 其他场景阅读人数
	 */
	public Integer getIntPageFromOtherReadUser() {
		return intPageFromOtherReadUser;
	}


	/**
	 * 设置其他场景阅读人数
	 *
	 * @param intPageFromOtherReadUser 其他场景阅读人数
	 */
	@JSONField( name = "int_page_from_other_read_user" )
	public void setIntPageFromOtherReadUser( Integer intPageFromOtherReadUser ) {
		this.intPageFromOtherReadUser = intPageFromOtherReadUser;
	}


	/**
	 * 获取其他场景阅读次数
	 *
	 * @return intPageFromOtherReadCount - 其他场景阅读次数
	 */
	public Integer getIntPageFromOtherReadCount() {
		return intPageFromOtherReadCount;
	}


	/**
	 * 设置其他场景阅读次数
	 *
	 * @param intPageFromOtherReadCount 其他场景阅读次数
	 */
	@JSONField( name = "int_page_from_other_read_count" )
	public void setIntPageFromOtherReadCount( Integer intPageFromOtherReadCount ) {
		this.intPageFromOtherReadCount = intPageFromOtherReadCount;
	}


	/**
	 * 获取公众号会话转发朋友圈人数
	 *
	 * @return feedShareFromSessionUser - 公众号会话转发朋友圈人数
	 */
	public Integer getFeedShareFromSessionUser() {
		return feedShareFromSessionUser;
	}


	/**
	 * 设置公众号会话转发朋友圈人数
	 *
	 * @param feedShareFromSessionUser 公众号会话转发朋友圈人数
	 */
	@JSONField( name = "feed_share_from_session_user" )
	public void setFeedShareFromSessionUser( Integer feedShareFromSessionUser ) {
		this.feedShareFromSessionUser = feedShareFromSessionUser;
	}


	/**
	 * 获取公众号会话转发朋友圈次数
	 *
	 * @return feedShareFromSessionCnt - 公众号会话转发朋友圈次数
	 */
	public Integer getFeedShareFromSessionCnt() {
		return feedShareFromSessionCnt;
	}


	/**
	 * 设置公众号会话转发朋友圈次数
	 *
	 * @param feedShareFromSessionCnt 公众号会话转发朋友圈次数
	 */
	@JSONField( name = "feed_share_from_session_cnt" )
	public void setFeedShareFromSessionCnt( Integer feedShareFromSessionCnt ) {
		this.feedShareFromSessionCnt = feedShareFromSessionCnt;
	}


	/**
	 * 获取朋友圈转发朋友圈人数
	 *
	 * @return feedShareFromFeedUser - 朋友圈转发朋友圈人数
	 */
	public Integer getFeedShareFromFeedUser() {
		return feedShareFromFeedUser;
	}


	/**
	 * 设置朋友圈转发朋友圈人数
	 *
	 * @param feedShareFromFeedUser 朋友圈转发朋友圈人数
	 */
	@JSONField( name = "feed_share_from_feed_user" )
	public void setFeedShareFromFeedUser( Integer feedShareFromFeedUser ) {
		this.feedShareFromFeedUser = feedShareFromFeedUser;
	}


	/**
	 * 获取朋友圈转发朋友圈次数
	 *
	 * @return feedShareFromFeedCnt - 朋友圈转发朋友圈次数
	 */
	public Integer getFeedShareFromFeedCnt() {
		return feedShareFromFeedCnt;
	}


	/**
	 * 设置朋友圈转发朋友圈次数
	 *
	 * @param feedShareFromFeedCnt 朋友圈转发朋友圈次数
	 */
	@JSONField( name = "feed_share_from_feed_cnt" )
	public void setFeedShareFromFeedCnt( Integer feedShareFromFeedCnt ) {
		this.feedShareFromFeedCnt = feedShareFromFeedCnt;
	}


	/**
	 * 获取其他场景转发朋友圈人数
	 *
	 * @return feedShareFromOtherUser - 其他场景转发朋友圈人数
	 */
	public Integer getFeedShareFromOtherUser() {
		return feedShareFromOtherUser;
	}


	/**
	 * 设置其他场景转发朋友圈人数
	 *
	 * @param feedShareFromOtherUser 其他场景转发朋友圈人数
	 */
	@JSONField( name = "feed_share_from_other_user" )
	public void setFeedShareFromOtherUser( Integer feedShareFromOtherUser ) {
		this.feedShareFromOtherUser = feedShareFromOtherUser;
	}


	/**
	 * 获取其他场景转发朋友圈次数
	 *
	 * @return feedShareFromOtherCnt - 其他场景转发朋友圈次数
	 */
	public Integer getFeedShareFromOtherCnt() {
		return feedShareFromOtherCnt;
	}


	/**
	 * 设置其他场景转发朋友圈次数
	 *
	 * @param feedShareFromOtherCnt 其他场景转发朋友圈次数
	 */
	@JSONField( name = "feed_share_from_other_cnt" )
	public void setFeedShareFromOtherCnt( Integer feedShareFromOtherCnt ) {
		this.feedShareFromOtherCnt = feedShareFromOtherCnt;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", articleTotalId=").append(articleTotalId);
		sb.append(", officialAccountId=").append(officialAccountId);
		sb.append(", statDate=").append(statDate);
		sb.append(", targetUser=").append(targetUser);
		sb.append(", intPageReadUser=").append(intPageReadUser);
		sb.append(", intPageReadCount=").append(intPageReadCount);
		sb.append(", oriPageReadUser=").append(oriPageReadUser);
		sb.append(", oriPageReadCount=").append(oriPageReadCount);
		sb.append(", shareUser=").append(shareUser);
		sb.append(", shareCount=").append(shareCount);
		sb.append(", addToFavUser=").append(addToFavUser);
		sb.append(", addToFavCount=").append(addToFavCount);
		sb.append(", intPageFromSessionReadUser=").append(intPageFromSessionReadUser);
		sb.append(", intPageFromSessionReadCount=").append(intPageFromSessionReadCount);
		sb.append(", intPageFromHistMsgReadUser=").append(intPageFromHistMsgReadUser);
		sb.append(", intPageFromHistMsgReadCount=").append(intPageFromHistMsgReadCount);
		sb.append(", intPageFromFeedReadUser=").append(intPageFromFeedReadUser);
		sb.append(", intPageFromFeedReadCount=").append(intPageFromFeedReadCount);
		sb.append(", intPageFromFriendsReadUser=").append(intPageFromFriendsReadUser);
		sb.append(", intPageFromFriendReadCount=").append(intPageFromFriendReadCount);
		sb.append(", intPageFromOtherReadUser=").append(intPageFromOtherReadUser);
		sb.append(", intPageFromOtherReadCount=").append(intPageFromOtherReadCount);
		sb.append(", feedShareFromSessionUser=").append(feedShareFromSessionUser);
		sb.append(", feedShareFromSessionCnt=").append(feedShareFromSessionCnt);
		sb.append(", feedShareFromFeedUser=").append(feedShareFromFeedUser);
		sb.append(", feedShareFromFeedCnt=").append(feedShareFromFeedCnt);
		sb.append(", feedShareFromOtherUser=").append(feedShareFromOtherUser);
		sb.append(", feedShareFromOtherCnt=").append(feedShareFromOtherCnt);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
