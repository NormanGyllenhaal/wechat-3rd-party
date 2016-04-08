package site.lovecode.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import site.lovecode.common.mybatis.Identity;

@Table(name = "wx_component_access_token")
public class ComponentAccessToken implements Identity, Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * componentAppid
     */
    private String componentAppid;

    /**
     * 微信第三方component_access_token
     */
    private String componentAccessToken;

    /**
     * 有效时间
     */
    private Integer expiresIn;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 失效时间
     */
    private Date failureTime;

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
     * 获取componentAppid
     *
     * @return componentAppid - componentAppid
     */
    public String getComponentAppid() {
        return componentAppid;
    }

    /**
     * 设置componentAppid
     *
     * @param componentAppid componentAppid
     */
    public void setComponentAppid(String componentAppid) {
        this.componentAppid = componentAppid;
    }

    /**
     * 获取微信第三方component_access_token
     *
     * @return componentAccessToken - 微信第三方component_access_token
     */
    public String getComponentAccessToken() {
        return componentAccessToken;
    }

    /**
     * 设置微信第三方component_access_token
     *
     * @param componentAccessToken 微信第三方component_access_token
     */
    public void setComponentAccessToken(String componentAccessToken) {
        this.componentAccessToken = componentAccessToken;
    }

    /**
     * 获取有效时间
     *
     * @return expiresIn - 有效时间
     */
    public Integer getExpiresIn() {
        return expiresIn;
    }

    /**
     * 设置有效时间
     *
     * @param expiresIn 有效时间
     */
    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
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
     * 获取失效时间
     *
     * @return failureTime - 失效时间
     */
    public Date getFailureTime() {
        return failureTime;
    }

    /**
     * 设置失效时间
     *
     * @param failureTime 失效时间
     */
    public void setFailureTime(Date failureTime) {
        this.failureTime = failureTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", componentAppid=").append(componentAppid);
        sb.append(", componentAccessToken=").append(componentAccessToken);
        sb.append(", expiresIn=").append(expiresIn);
        sb.append(", createTime=").append(createTime);
        sb.append(", failureTime=").append(failureTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}