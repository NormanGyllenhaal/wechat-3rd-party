package site.lovecode.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import site.lovecode.common.mybatis.Identity;

@Table(name = "wx_keyword_reply_setting")
public class KeywordReplySetting implements Identity, Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 微信公众号基本信息id，关联微信公众号基本信息表
     */
    private Long officialAccountId;

    /**
     * 回复模式，reply_all代表全部回复，random_one代表随机回复其中一条
     */
    private Integer replyMod;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 规则名称
     */
    private byte[] ruleName;

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
     * 获取微信公众号基本信息id，关联微信公众号基本信息表
     *
     * @return officialAccountId - 微信公众号基本信息id，关联微信公众号基本信息表
     */
    public Long getOfficialAccountId() {
        return officialAccountId;
    }

    /**
     * 设置微信公众号基本信息id，关联微信公众号基本信息表
     *
     * @param officialAccountId 微信公众号基本信息id，关联微信公众号基本信息表
     */
    public void setOfficialAccountId(Long officialAccountId) {
        this.officialAccountId = officialAccountId;
    }

    /**
     * 获取回复模式，reply_all代表全部回复，random_one代表随机回复其中一条
     *
     * @return replyMod - 回复模式，reply_all代表全部回复，random_one代表随机回复其中一条
     */
    public Integer getReplyMod() {
        return replyMod;
    }

    /**
     * 设置回复模式，reply_all代表全部回复，random_one代表随机回复其中一条
     *
     * @param replyMod 回复模式，reply_all代表全部回复，random_one代表随机回复其中一条
     */
    public void setReplyMod(Integer replyMod) {
        this.replyMod = replyMod;
    }

    /**
     * 获取创建时间
     *
     * @return createTime - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取规则名称
     *
     * @return ruleName - 规则名称
     */
    public byte[] getRuleName() {
        return ruleName;
    }

    /**
     * 设置规则名称
     *
     * @param ruleName 规则名称
     */
    public void setRuleName(byte[] ruleName) {
        this.ruleName = ruleName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", officialAccountId=").append(officialAccountId);
        sb.append(", replyMod=").append(replyMod);
        sb.append(", createTime=").append(createTime);
        sb.append(", ruleName=").append(ruleName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}