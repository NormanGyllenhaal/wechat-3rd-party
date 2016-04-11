package site.lovecode.entity;

import java.io.Serializable;
import javax.persistence.*;
import site.lovecode.common.mybatis.Identity;

@Table(name = "wx_user_info")
public class UserInfo implements Identity, Serializable {
    @Id
    private Long id;

    private String compoentAppid;

    private String appid;

    private String openid;

    private String subscribe;

    private String nickname;

    private Integer sex;

    private String language;

    private String city;

    private String province;

    private String headimgurl;

    private String subscribeTime;

    private String unionid;

    private String remark;

    private String grounpid;

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
     * @return compoentAppid
     */
    public String getCompoentAppid() {
        return compoentAppid;
    }

    /**
     * @param compoentAppid
     */
    public void setCompoentAppid(String compoentAppid) {
        this.compoentAppid = compoentAppid;
    }

    /**
     * @return appid
     */
    public String getAppid() {
        return appid;
    }

    /**
     * @param appid
     */
    public void setAppid(String appid) {
        this.appid = appid;
    }

    /**
     * @return openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * @param openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * @return subscribe
     */
    public String getSubscribe() {
        return subscribe;
    }

    /**
     * @param subscribe
     */
    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }

    /**
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return headimgurl
     */
    public String getHeadimgurl() {
        return headimgurl;
    }

    /**
     * @param headimgurl
     */
    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    /**
     * @return subscribeTime
     */
    public String getSubscribeTime() {
        return subscribeTime;
    }

    /**
     * @param subscribeTime
     */
    public void setSubscribeTime(String subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    /**
     * @return unionid
     */
    public String getUnionid() {
        return unionid;
    }

    /**
     * @param unionid
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return grounpid
     */
    public String getGrounpid() {
        return grounpid;
    }

    /**
     * @param grounpid
     */
    public void setGrounpid(String grounpid) {
        this.grounpid = grounpid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", compoentAppid=").append(compoentAppid);
        sb.append(", appid=").append(appid);
        sb.append(", openid=").append(openid);
        sb.append(", subscribe=").append(subscribe);
        sb.append(", nickname=").append(nickname);
        sb.append(", sex=").append(sex);
        sb.append(", language=").append(language);
        sb.append(", city=").append(city);
        sb.append(", province=").append(province);
        sb.append(", headimgurl=").append(headimgurl);
        sb.append(", subscribeTime=").append(subscribeTime);
        sb.append(", unionid=").append(unionid);
        sb.append(", remark=").append(remark);
        sb.append(", grounpid=").append(grounpid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}