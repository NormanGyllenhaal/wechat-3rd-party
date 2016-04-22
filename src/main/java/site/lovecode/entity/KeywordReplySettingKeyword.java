package site.lovecode.entity;

import java.io.Serializable;
import javax.persistence.*;
import site.lovecode.common.mybatis.Identity;

@Table(name = "wx_keyword_reply_setting_keyword")
public class KeywordReplySettingKeyword implements Identity, Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 微信关键词自动回复设置id
     */
    private Long keywordReplySettingId;

    /**
     * 匹配消息类型，支持文本（text）、图片（img）、语音（voice）、视频（video，图文消息（news）
     */
    private Integer type;

    /**
     * 匹配模式，contain代表消息中含有该关键词即可，equal表示消息内容必须和关键词严格相同
     */
    private Integer matchMode;

    /**
     * 对于文本类型，content是文本内容，对于图文、图片、语音、视频类型，content是mediaID
     */
    private String content;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取微信关键词自动回复设置id
     *
     * @return keywordReplySettingId - 微信关键词自动回复设置id
     */
    public Long getKeywordReplySettingId() {
        return keywordReplySettingId;
    }

    /**
     * 设置微信关键词自动回复设置id
     *
     * @param keywordReplySettingId 微信关键词自动回复设置id
     */
    public void setKeywordReplySettingId(Long keywordReplySettingId) {
        this.keywordReplySettingId = keywordReplySettingId;
    }

    /**
     * 获取匹配消息类型，支持文本（text）、图片（img）、语音（voice）、视频（video，图文消息（news）
     *
     * @return type - 匹配消息类型，支持文本（text）、图片（img）、语音（voice）、视频（video，图文消息（news）
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置匹配消息类型，支持文本（text）、图片（img）、语音（voice）、视频（video，图文消息（news）
     *
     * @param type 匹配消息类型，支持文本（text）、图片（img）、语音（voice）、视频（video，图文消息（news）
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取匹配模式，contain代表消息中含有该关键词即可，equal表示消息内容必须和关键词严格相同
     *
     * @return matchMode - 匹配模式，contain代表消息中含有该关键词即可，equal表示消息内容必须和关键词严格相同
     */
    public Integer getMatchMode() {
        return matchMode;
    }

    /**
     * 设置匹配模式，contain代表消息中含有该关键词即可，equal表示消息内容必须和关键词严格相同
     *
     * @param matchMode 匹配模式，contain代表消息中含有该关键词即可，equal表示消息内容必须和关键词严格相同
     */
    public void setMatchMode(Integer matchMode) {
        this.matchMode = matchMode;
    }

    /**
     * 获取对于文本类型，content是文本内容，对于图文、图片、语音、视频类型，content是mediaID
     *
     * @return content - 对于文本类型，content是文本内容，对于图文、图片、语音、视频类型，content是mediaID
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置对于文本类型，content是文本内容，对于图文、图片、语音、视频类型，content是mediaID
     *
     * @param content 对于文本类型，content是文本内容，对于图文、图片、语音、视频类型，content是mediaID
     */
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", keywordReplySettingId=").append(keywordReplySettingId);
        sb.append(", type=").append(type);
        sb.append(", matchMode=").append(matchMode);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}