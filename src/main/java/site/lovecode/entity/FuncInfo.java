package site.lovecode.entity;

import java.io.Serializable;
import javax.persistence.*;
import site.lovecode.common.mybatis.Identity;

@Table(name = "wx_func_info")
public class FuncInfo implements Identity, Serializable {
    /**
     * zhujian
     */
    @Id
    private Long id;

    /**
     * 微信公众账号基本信息表id，关联微信公众号基本信息表
     */
    private Long officialAccountId;

    /**
     * 权限的名称id
     */
    private Integer funcName;

    private static final long serialVersionUID = 1L;

    /**
     * 获取zhujian
     *
     * @return id - zhujian
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置zhujian
     *
     * @param id zhujian
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取微信公众账号基本信息表id，关联微信公众号基本信息表
     *
     * @return officialAccountId - 微信公众账号基本信息表id，关联微信公众号基本信息表
     */
    public Long getOfficialAccountId() {
        return officialAccountId;
    }

    /**
     * 设置微信公众账号基本信息表id，关联微信公众号基本信息表
     *
     * @param officialAccountId 微信公众账号基本信息表id，关联微信公众号基本信息表
     */
    public void setOfficialAccountId(Long officialAccountId) {
        this.officialAccountId = officialAccountId;
    }

    /**
     * 获取权限的名称id
     *
     * @return funcName - 权限的名称id
     */
    public Integer getFuncName() {
        return funcName;
    }

    /**
     * 设置权限的名称id
     *
     * @param funcName 权限的名称id
     */
    public void setFuncName(Integer funcName) {
        this.funcName = funcName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", officialAccountId=").append(officialAccountId);
        sb.append(", funcName=").append(funcName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}