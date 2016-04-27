package site.lovecode.support.bean.vo;

import site.lovecode.entity.KeywordReplySettingNew;
import site.lovecode.entity.KeywordReplySettingReply;

import java.util.List;

/**
 * Created by Administrator on 2016/4/26.
 */
public class KeywordReplySettingReplyVo extends KeywordReplySettingReply {

    private List<KeywordReplySettingNew> keywordReplySettingNewList;

    public List<KeywordReplySettingNew> getKeywordReplySettingNewList() {
        return keywordReplySettingNewList;
    }

    public void setKeywordReplySettingNewList(List<KeywordReplySettingNew> keywordReplySettingNewList) {
        this.keywordReplySettingNewList = keywordReplySettingNewList;
    }
}
