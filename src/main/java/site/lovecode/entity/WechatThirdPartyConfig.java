package site.lovecode.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import site.lovecode.common.mybatis.Identity;

@Table(name = "wx_wechat_third_party_config")
public class WechatThirdPartyConfig implements Identity, Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 微信第三方component_appid
     */
    private String componentAppid;

    /**
     * 微信第三方component_appsecret
     */
    private String componentAppsecret;

    /**
     * 微信第三方token信息
     */
    private String token;

    /**
     * 微信第三方加解密key
     */
    private String encodeingAesKey;

    /**
     * 授权事件接收url
     */
    private String authorizationUrl;

    /**
     * 授权事件跳转url
     */
    private String redirectUrl;

    /**
     * 第三方component_access_token
     */
    private String componentAccessToken;

    /**
     * 公众号消息与事件接收URL
     */
    private String messgesUrl;

    /**
     * 微信第三方component_verfiy_ticket
     */
    private String componentVerifyTicket;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

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
     * 获取微信第三方component_appid
     *
     * @return componentAppid - 微信第三方component_appid
     */
    public String getComponentAppid() {
        return componentAppid;
    }

    /**
     * 设置微信第三方component_appid
     *
     * @param componentAppid 微信第三方component_appid
     */
    public void setComponentAppid(String componentAppid) {
        this.componentAppid = componentAppid;
    }

    /**
     * 获取微信第三方component_appsecret
     *
     * @return componentAppsecret - 微信第三方component_appsecret
     */
    public String getComponentAppsecret() {
        return componentAppsecret;
    }

    /**
     * 设置微信第三方component_appsecret
     *
     * @param componentAppsecret 微信第三方component_appsecret
     */
    public void setComponentAppsecret(String componentAppsecret) {
        this.componentAppsecret = componentAppsecret;
    }

    /**
     * 获取微信第三方token信息
     *
     * @return token - 微信第三方token信息
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置微信第三方token信息
     *
     * @param token 微信第三方token信息
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 获取微信第三方加解密key
     *
     * @return encodeingAesKey - 微信第三方加解密key
     */
    public String getEncodeingAesKey() {
        return encodeingAesKey;
    }

    /**
     * 设置微信第三方加解密key
     *
     * @param encodeingAesKey 微信第三方加解密key
     */
    public void setEncodeingAesKey(String encodeingAesKey) {
        this.encodeingAesKey = encodeingAesKey;
    }

    /**
     * 获取授权事件接收url
     *
     * @return authorizationUrl - 授权事件接收url
     */
    public String getAuthorizationUrl() {
        return authorizationUrl;
    }

    /**
     * 设置授权事件接收url
     *
     * @param authorizationUrl 授权事件接收url
     */
    public void setAuthorizationUrl(String authorizationUrl) {
        this.authorizationUrl = authorizationUrl;
    }

    /**
     * 获取授权事件跳转url
     *
     * @return redirectUrl - 授权事件跳转url
     */
    public String getRedirectUrl() {
        return redirectUrl;
    }

    /**
     * 设置授权事件跳转url
     *
     * @param redirectUrl 授权事件跳转url
     */
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    /**
     * 获取第三方component_access_token
     *
     * @return componentAccessToken - 第三方component_access_token
     */
    public String getComponentAccessToken() {
        return componentAccessToken;
    }

    /**
     * 设置第三方component_access_token
     *
     * @param componentAccessToken 第三方component_access_token
     */
    public void setComponentAccessToken(String componentAccessToken) {
        this.componentAccessToken = componentAccessToken;
    }

    /**
     * 获取公众号消息与事件接收URL
     *
     * @return messgesUrl - 公众号消息与事件接收URL
     */
    public String getMessgesUrl() {
        return messgesUrl;
    }

    /**
     * 设置公众号消息与事件接收URL
     *
     * @param messgesUrl 公众号消息与事件接收URL
     */
    public void setMessgesUrl(String messgesUrl) {
        this.messgesUrl = messgesUrl;
    }

    /**
     * 获取微信第三方component_verfiy_ticket
     *
     * @return componentVerifyTicket - 微信第三方component_verfiy_ticket
     */
    public String getComponentVerifyTicket() {
        return componentVerifyTicket;
    }

    /**
     * 设置微信第三方component_verfiy_ticket
     *
     * @param componentVerifyTicket 微信第三方component_verfiy_ticket
     */
    public void setComponentVerifyTicket(String componentVerifyTicket) {
        this.componentVerifyTicket = componentVerifyTicket;
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
     * 获取更新时间
     *
     * @return updateTime - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", componentAppid=").append(componentAppid);
        sb.append(", componentAppsecret=").append(componentAppsecret);
        sb.append(", token=").append(token);
        sb.append(", encodeingAesKey=").append(encodeingAesKey);
        sb.append(", authorizationUrl=").append(authorizationUrl);
        sb.append(", redirectUrl=").append(redirectUrl);
        sb.append(", componentAccessToken=").append(componentAccessToken);
        sb.append(", messgesUrl=").append(messgesUrl);
        sb.append(", componentVerifyTicket=").append(componentVerifyTicket);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}