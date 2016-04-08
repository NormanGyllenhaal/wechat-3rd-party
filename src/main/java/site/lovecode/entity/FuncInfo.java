package site.lovecode.entity;

import java.io.Serializable;
import javax.persistence.*;
import site.lovecode.common.mybatis.Identity;

@Table(name = "wx_func_info")
public class FuncInfo implements  Serializable,Identity {
    /**
     * zhujian
     */
    @Id
    private Long id;

    /**
     * 微信授权方公众账号基本信息id,关联微信公众号基本信息表
     */
    private Long authorizerInfoId;

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
     * 获取微信授权方公众账号基本信息id,关联微信公众号基本信息表
     *
     * @return authorizerInfoId - 微信授权方公众账号基本信息id,关联微信公众号基本信息表
     */
    public Long getAuthorizerInfoId() {
        return authorizerInfoId;
    }

    /**
     * 设置微信授权方公众账号基本信息id,关联微信公众号基本信息表
     *
     * @param authorizerInfoId 微信授权方公众账号基本信息id,关联微信公众号基本信息表
     */
    public void setAuthorizerInfoId(Long authorizerInfoId) {
        this.authorizerInfoId = authorizerInfoId;
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
        sb.append(", authorizerInfoId=").append(authorizerInfoId);
        sb.append(", funcName=").append(funcName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}