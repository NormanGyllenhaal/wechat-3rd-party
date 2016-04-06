package site.lovecode.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "wx_wechat_third_party_config")
public class WechatThirdPartyConfig implements Serializable {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 微信第三方平台appid
     */
    @Column(name = "component_appid")
    private String componentAppid;

    /**
     *  微信的appSecret
     */
    @Column(name = "component_appsecret")
    private String componentAppsecret;

    /**
     * 公众号信息效验token
     */
    private String token;

    /**
     * endcodingAesKey
     */
    @Column(name = "encoding_aes_key")
    private String encodingAesKey;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取微信第三方平台appid
     *
     * @return component_appid - 微信第三方平台appid
     */
    public String getComponentAppid() {
        return componentAppid;
    }

    /**
     * 设置微信第三方平台appid
     *
     * @param componentAppid 微信第三方平台appid
     */
    public void setComponentAppid(String componentAppid) {
        this.componentAppid = componentAppid;
    }

    /**
     * 获取 微信的appSecret
     *
     * @return component_appsecret -  微信的appSecret
     */
    public String getComponentAppsecret() {
        return componentAppsecret;
    }

    /**
     * 设置 微信的appSecret
     *
     * @param componentAppsecret  微信的appSecret
     */
    public void setComponentAppsecret(String componentAppsecret) {
        this.componentAppsecret = componentAppsecret;
    }

    /**
     * 获取公众号信息效验token
     *
     * @return token - 公众号信息效验token
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置公众号信息效验token
     *
     * @param token 公众号信息效验token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 获取endcodingAesKey
     *
     * @return encoding_aes_key - endcodingAesKey
     */
    public String getEncodingAesKey() {
        return encodingAesKey;
    }

    /**
     * 设置endcodingAesKey
     *
     * @param encodingAesKey endcodingAesKey
     */
    public void setEncodingAesKey(String encodingAesKey) {
        this.encodingAesKey = encodingAesKey;
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
        sb.append(", encodingAesKey=").append(encodingAesKey);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}