package site.lovecode.wechat.dto;


import site.lovecode.wechat.entity.KeywordReplySettingNew;
import site.lovecode.wechat.entity.KeywordReplySettingReply;

import java.util.List;

/**
 * Created by Administrator on 2016/4/26.
 */
public class KeywordReplySettingReplyDto extends KeywordReplySettingReply {

	/**
	 * TODO（用一句话描述这个变量的含义）
	 */

	private static final long serialVersionUID = 1L;

	private List<KeywordReplySettingNew> keywordReplySettingNewList;


	public List<KeywordReplySettingNew> getKeywordReplySettingNewList() {
		return keywordReplySettingNewList;
	}


	public void setKeywordReplySettingNewList( List<KeywordReplySettingNew> keywordReplySettingNewList ) {
		this.keywordReplySettingNewList = keywordReplySettingNewList;
	}
}
