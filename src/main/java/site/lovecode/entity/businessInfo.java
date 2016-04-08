package site.lovecode.entity;

import java.io.Serializable;
import javax.persistence.*;
import site.lovecode.common.mybatis.Identity;

@Table(name = "wx_business_info")
public class businessInfo implements Identity, Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 公众账号基本信息id
     */
    private Long authorizerInfoId;

    /**
     * 商业功能名称
     */
    private Integer businessInfoName;

    /**
     * 商业功能开通状态
     */
    private Integer businessInfoStatus;

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
     * 获取公众账号基本信息id
     *
     * @return authorizerInfoId - 公众账号基本信息id
     */
    public Long getAuthorizerInfoId() {
        return authorizerInfoId;
    }

    /**
     * 设置公众账号基本信息id
     *
     * @param authorizerInfoId 公众账号基本信息id
     */
    public void setAuthorizerInfoId(Long authorizerInfoId) {
        this.authorizerInfoId = authorizerInfoId;
    }

    /**
     * 获取商业功能名称
     *
     * @return businessInfoName - 商业功能名称
     */
    public Integer getBusinessInfoName() {
        return businessInfoName;
    }

    /**
     * 设置商业功能名称
     *
     * @param businessInfoName 商业功能名称
     */
    public void setBusinessInfoName(Integer businessInfoName) {
        this.businessInfoName = businessInfoName;
    }

    /**
     * 获取商业功能开通状态
     *
     * @return businessInfoStatus - 商业功能开通状态
     */
    public Integer getBusinessInfoStatus() {
        return businessInfoStatus;
    }

    /**
     * 设置商业功能开通状态
     *
     * @param businessInfoStatus 商业功能开通状态
     */
    public void setBusinessInfoStatus(Integer businessInfoStatus) {
        this.businessInfoStatus = businessInfoStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", authorizerInfoId=").append(authorizerInfoId);
        sb.append(", businessInfoName=").append(businessInfoName);
        sb.append(", businessInfoStatus=").append(businessInfoStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}