package site.lovecode.wechat.dto;

import site.lovecode.wechat.entity.KeywordReplySetting;
import site.lovecode.wechat.entity.KeywordReplySettingKeyword;
import java.util.List;



/**
 * Created by Administrator on 2016/4/26.
 */
public class KeywordReplySettingDto extends KeywordReplySetting {

	/**
	 * TODO（用一句话描述这个变量的含义）
	 */

	private static final long serialVersionUID = 1L;

	private List<KeywordReplySettingKeyword> keywordReplySettingKeywordList;

	private List<KeywordReplySettingReplyDto> keywordReplySettingReplyVoList;


	public List<KeywordReplySettingKeyword> getKeywordReplySettingKeywordList() {
		return keywordReplySettingKeywordList;
	}


	public void setKeywordReplySettingKeywordList( List<KeywordReplySettingKeyword> keywordReplySettingKeywordList ) {
		this.keywordReplySettingKeywordList = keywordReplySettingKeywordList;
	}


	public List<KeywordReplySettingReplyDto> getKeywordReplySettingReplyVoList() {
		return keywordReplySettingReplyVoList;
	}


	public void setKeywordReplySettingReplyVoList( List<KeywordReplySettingReplyDto> keywordReplySettingReplyVoList ) {
		this.keywordReplySettingReplyVoList = keywordReplySettingReplyVoList;
	}
}
