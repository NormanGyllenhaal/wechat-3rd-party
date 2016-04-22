package site.lovecode.entity;

import java.io.Serializable;
import javax.persistence.*;
import site.lovecode.common.mybatis.Identity;

@Table(name = "wx_keyword_reply_setting_news")
public class KeywordReplySettingNew implements Identity, Serializable {
    @Id
    private Long id;

    /**
     * 微信关键词自动回复设置回复信息id,关联微信关键词自动回复设置回复信息表
     */
    private Long keywordReplySettingReplyId;

    /**
     * 图文消息的标题
     */
    private String title;

    /**
     * 作者
     */
    private String author;

    /**
     * 摘要
     */
    private String digest;

    /**
     * 是否显示封面，0为不显示，1为显示
     */
    private Integer showCover;

    /**
     * 封面图片的URL
     */
    private String coverUrl;

    /**
     * 正文的URL
     */
    private String contentUrl;

    /**
     * 原文的URL，若置空则无查看原文入口
     */
    private String sourceUrl;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取微信关键词自动回复设置回复信息id,关联微信关键词自动回复设置回复信息表
     *
     * @return keywordReplySettingReplyId - 微信关键词自动回复设置回复信息id,关联微信关键词自动回复设置回复信息表
     */
    public Long getKeywordReplySettingReplyId() {
        return keywordReplySettingReplyId;
    }

    /**
     * 设置微信关键词自动回复设置回复信息id,关联微信关键词自动回复设置回复信息表
     *
     * @param keywordReplySettingReplyId 微信关键词自动回复设置回复信息id,关联微信关键词自动回复设置回复信息表
     */
    public void setKeywordReplySettingReplyId(Long keywordReplySettingReplyId) {
        this.keywordReplySettingReplyId = keywordReplySettingReplyId;
    }

    /**
     * 获取图文消息的标题
     *
     * @return title - 图文消息的标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置图文消息的标题
     *
     * @param title 图文消息的标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取作者
     *
     * @return author - 作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置作者
     *
     * @param author 作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取摘要
     *
     * @return digest - 摘要
     */
    public String getDigest() {
        return digest;
    }

    /**
     * 设置摘要
     *
     * @param digest 摘要
     */
    public void setDigest(String digest) {
        this.digest = digest;
    }

    /**
     * 获取是否显示封面，0为不显示，1为显示
     *
     * @return showCover - 是否显示封面，0为不显示，1为显示
     */
    public Integer getShowCover() {
        return showCover;
    }

    /**
     * 设置是否显示封面，0为不显示，1为显示
     *
     * @param showCover 是否显示封面，0为不显示，1为显示
     */
    public void setShowCover(Integer showCover) {
        this.showCover = showCover;
    }

    /**
     * 获取封面图片的URL
     *
     * @return coverUrl - 封面图片的URL
     */
    public String getCoverUrl() {
        return coverUrl;
    }

    /**
     * 设置封面图片的URL
     *
     * @param coverUrl 封面图片的URL
     */
    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    /**
     * 获取正文的URL
     *
     * @return contentUrl - 正文的URL
     */
    public String getContentUrl() {
        return contentUrl;
    }

    /**
     * 设置正文的URL
     *
     * @param contentUrl 正文的URL
     */
    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    /**
     * 获取原文的URL，若置空则无查看原文入口
     *
     * @return sourceUrl - 原文的URL，若置空则无查看原文入口
     */
    public String getSourceUrl() {
        return sourceUrl;
    }

    /**
     * 设置原文的URL，若置空则无查看原文入口
     *
     * @param sourceUrl 原文的URL，若置空则无查看原文入口
     */
    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", keywordReplySettingReplyId=").append(keywordReplySettingReplyId);
        sb.append(", title=").append(title);
        sb.append(", author=").append(author);
        sb.append(", digest=").append(digest);
        sb.append(", showCover=").append(showCover);
        sb.append(", coverUrl=").append(coverUrl);
        sb.append(", contentUrl=").append(contentUrl);
        sb.append(", sourceUrl=").append(sourceUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}