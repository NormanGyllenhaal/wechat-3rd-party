/**
 * ArticleHourDto.java site.lovecode.wechat.dto Copyright (c)
 * 2016,norman.
 */


package site.lovecode.wechat.dto;


import site.lovecode.wechat.entity.ArticleHour;

import java.util.HashMap;
import java.util.Map;


/**
 * 图文小时报
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月24日
 * @version  1.0.0
 */


public class ArticleHourGroupDto extends ArticleHour {


	/**
	 * TODO（用一句话描述这个变量的含义）
	 */

	private static final long serialVersionUID = 1L;

	private Integer intPageFromSessionReadUser;

	private Integer intPageFromSessionReadCount;

	private Integer intPageFromFeedReadUser;

	private Integer intPageFromFeedReadCount;

	/**
	 * 历史消息页阅读人数
	 */

	private Integer intPageFromHistMsgReadUser;

	/**
	 * 历史消息页阅读次数
	 */

	private Integer intPageFromHistMsgReadCount;

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


	public Integer getIntPageFromSessionReadUser() {
		return intPageFromSessionReadUser;
	}


	public void setIntPageFromSessionReadUser( Integer intPageFromSessionReadUser ) {
		this.intPageFromSessionReadUser = intPageFromSessionReadUser;
	}


	public Integer getIntPageFromSessionReadCount() {
		return intPageFromSessionReadCount;
	}


	public void setIntPageFromSessionReadCount( Integer intPageFromSessionReadCount ) {
		this.intPageFromSessionReadCount = intPageFromSessionReadCount;
	}


	public Integer getIntPageFromFeedReadUser() {
		return intPageFromFeedReadUser;
	}


	public void setIntPageFromFeedReadUser( Integer intPageFromFeedReadUser ) {
		this.intPageFromFeedReadUser = intPageFromFeedReadUser;
	}


	public Integer getIntPageFromFeedReadCount() {
		return intPageFromFeedReadCount;
	}


	public void setIntPageFromFeedReadCount( Integer intPageFromFeedReadCount ) {
		this.intPageFromFeedReadCount = intPageFromFeedReadCount;
	}


	public Integer getIntPageFromHistMsgReadUser() {
		return intPageFromHistMsgReadUser;
	}

	public void setIntPageFromHistMsgReadUser(Integer intPageFromHistMsgReadUser) {
		this.intPageFromHistMsgReadUser = intPageFromHistMsgReadUser;
	}

	public Integer getIntPageFromHistMsgReadCount() {
		return intPageFromHistMsgReadCount;
	}

	public void setIntPageFromHistMsgReadCount(Integer intPageFromHistMsgReadCount) {
		this.intPageFromHistMsgReadCount = intPageFromHistMsgReadCount;
	}

	public Integer getIntPageFromFriendsReadUser() {
		return intPageFromFriendsReadUser;
	}

	public void setIntPageFromFriendsReadUser(Integer intPageFromFriendsReadUser) {
		this.intPageFromFriendsReadUser = intPageFromFriendsReadUser;
	}

	public Integer getIntPageFromFriendReadCount() {
		return intPageFromFriendReadCount;
	}

	public void setIntPageFromFriendReadCount(Integer intPageFromFriendReadCount) {
		this.intPageFromFriendReadCount = intPageFromFriendReadCount;
	}

	public Integer getIntPageFromOtherReadUser() {
		return intPageFromOtherReadUser;
	}

	public void setIntPageFromOtherReadUser(Integer intPageFromOtherReadUser) {
		this.intPageFromOtherReadUser = intPageFromOtherReadUser;
	}

	public Integer getIntPageFromOtherReadCount() {
		return intPageFromOtherReadCount;
	}

	public void setIntPageFromOtherReadCount(Integer intPageFromOtherReadCount) {
		this.intPageFromOtherReadCount = intPageFromOtherReadCount;
	}

	public Map<String, Object> toMap() {
		return new HashMap<String, Object>() {
			{
				put("时间", getRefDate());
				put("图文页阅读人数", getIntPageReadUser());
				put("图文页月的次数", getIntPageReadCount());
				put("从公众号会话打开人数",intPageFromSessionReadUser);
				put("从公众号会话打开次数",intPageFromFeedReadCount);
				put("从朋友圈打开人数",intPageFromFeedReadUser);
				put("从朋友圈打开次数",intPageFromFeedReadCount);
				put("分享转发人数",getShareUser());
				put("分享转发次数",getShareCount());
				put("微信收藏人数",getAddToFavUser());
				put("微信收藏次数",getAddToFavCount());
			}
		};
	}

}
