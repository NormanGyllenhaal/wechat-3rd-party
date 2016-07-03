package site.lovecode.wechat.entity;

import site.lovecode.wechat.common.mybatis.Identity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "wx_user_official_account")
public class UserOfficialAccount implements Identity, Serializable {
    @Id
    private Long id;

    /**
     * 系统用户id
     */
    private Long userId;

    /**
     * 微信公众号基本信息表id,关联微信公众号基本信息表
     */
    private Long officialAccountId;

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
     * 获取系统用户id
     *
     * @return userId - 系统用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置系统用户id
     *
     * @param userId 系统用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取微信公众号基本信息表id,关联微信公众号基本信息表
     *
     * @return officialAccountId - 微信公众号基本信息表id,关联微信公众号基本信息表
     */
    public Long getOfficialAccountId() {
        return officialAccountId;
    }

    /**
     * 设置微信公众号基本信息表id,关联微信公众号基本信息表
     *
     * @param officialAccountId 微信公众号基本信息表id,关联微信公众号基本信息表
     */
    public void setOfficialAccountId(Long officialAccountId) {
        this.officialAccountId = officialAccountId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", officialAccountId=").append(officialAccountId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}