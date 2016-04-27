package site.lovecode.support.bean.vo;

import site.lovecode.entity.KeywordReplySetting;
import site.lovecode.entity.KeywordReplySettingKeyword;

import java.util.List;

/**
 * Created by Administrator on 2016/4/26.
 */
public class KeywordReplySettingVo extends KeywordReplySetting{

    private List<KeywordReplySettingKeyword> keywordReplySettingKeywordList;

    private List<KeywordReplySettingReplyVo> keywordReplySettingReplyVoList;

    public List<KeywordReplySettingKeyword> getKeywordReplySettingKeywordList() {
        return keywordReplySettingKeywordList;
    }

    public void setKeywordReplySettingKeywordList(List<KeywordReplySettingKeyword> keywordReplySettingKeywordList) {
        this.keywordReplySettingKeywordList = keywordReplySettingKeywordList;
    }

    public List<KeywordReplySettingReplyVo> getKeywordReplySettingReplyVoList() {
        return keywordReplySettingReplyVoList;
    }

    public void setKeywordReplySettingReplyVoList(List<KeywordReplySettingReplyVo> keywordReplySettingReplyVoList) {
        this.keywordReplySettingReplyVoList = keywordReplySettingReplyVoList;
    }
}
