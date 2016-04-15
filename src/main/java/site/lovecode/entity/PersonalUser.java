package site.lovecode.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import site.lovecode.common.mybatis.Identity;

@Table(name = "wx_personal_user")
public class PersonalUser implements Identity, Serializable {
    @Id
    private Long id;

    /**
     * 用户所属的公众号id，关联公众号基本信息表
     */
    private Long officialAccountId;

    /**
     * 用户的标识，对当前公众号唯一
     */
    private String openid;

    /**
     * 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息，只有openid和UnionID（在该公众号绑定到了微信开放平台账号时才有）。
     */
    private Integer subscribe;

    /**
     * 用户的昵称
     */
    private String nickName;

    /**
     * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    private Integer sex;

    /**
     * 用户所在城市
     */
    private String city;

    /**
     * 用户所在国家
     */
    private String country;

    /**
     * 用户所在省份
     */
    private String province;

    /**
     * 用户的语言，简体中文为zh_CN
     */
    private String language;

    /**
     * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
     */
    private String headimgurl;

    /**
     * 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
     */
    private Date subscribeTime;

    /**
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     */
    private String unionid;

    /**
     * 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
     */
    private String remark;

    /**
     * 用户所在的分组ID
     */
    private String groupid;

    /**
     * 消息创建时间
     */
    private Date createTime;

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
     * 获取用户所属的公众号id，关联公众号基本信息表
     *
     * @return officialAccountId - 用户所属的公众号id，关联公众号基本信息表
     */
    public Long getOfficialAccountId() {
        return officialAccountId;
    }

    /**
     * 设置用户所属的公众号id，关联公众号基本信息表
     *
     * @param officialAccountId 用户所属的公众号id，关联公众号基本信息表
     */
    public void setOfficialAccountId(Long officialAccountId) {
        this.officialAccountId = officialAccountId;
    }

    /**
     * 获取用户的标识，对当前公众号唯一
     *
     * @return openid - 用户的标识，对当前公众号唯一
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置用户的标识，对当前公众号唯一
     *
     * @param openid 用户的标识，对当前公众号唯一
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息，只有openid和UnionID（在该公众号绑定到了微信开放平台账号时才有）。
     *
     * @return subscribe - 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息，只有openid和UnionID（在该公众号绑定到了微信开放平台账号时才有）。
     */
    public Integer getSubscribe() {
        return subscribe;
    }

    /**
     * 设置用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息，只有openid和UnionID（在该公众号绑定到了微信开放平台账号时才有）。
     *
     * @param subscribe 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息，只有openid和UnionID（在该公众号绑定到了微信开放平台账号时才有）。
     */
    public void setSubscribe(Integer subscribe) {
        this.subscribe = subscribe;
    }

    /**
     * 获取用户的昵称
     *
     * @return nickName - 用户的昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置用户的昵称
     *
     * @param nickName 用户的昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     *
     * @return sex - 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     *
     * @param sex 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取用户所在城市
     *
     * @return city - 用户所在城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置用户所在城市
     *
     * @param city 用户所在城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取用户所在国家
     *
     * @return country - 用户所在国家
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置用户所在国家
     *
     * @param country 用户所在国家
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取用户所在省份
     *
     * @return province - 用户所在省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置用户所在省份
     *
     * @param province 用户所在省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取用户的语言，简体中文为zh_CN
     *
     * @return language - 用户的语言，简体中文为zh_CN
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 设置用户的语言，简体中文为zh_CN
     *
     * @param language 用户的语言，简体中文为zh_CN
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 获取用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
     *
     * @return headimgurl - 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
     */
    public String getHeadimgurl() {
        return headimgurl;
    }

    /**
     * 设置用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
     *
     * @param headimgurl 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
     */
    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    /**
     * 获取用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
     *
     * @return subscribeTime - 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
     */
    public Date getSubscribeTime() {
        return subscribeTime;
    }

    /**
     * 设置用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
     *
     * @param subscribeTime 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
     */
    public void setSubscribeTime(Date subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    /**
     * 获取只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     *
     * @return unionid - 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     */
    public String getUnionid() {
        return unionid;
    }

    /**
     * 设置只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     *
     * @param unionid 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    /**
     * 获取公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
     *
     * @return remark - 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
     *
     * @param remark 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取用户所在的分组ID
     *
     * @return groupid - 用户所在的分组ID
     */
    public String getGroupid() {
        return groupid;
    }

    /**
     * 设置用户所在的分组ID
     *
     * @param groupid 用户所在的分组ID
     */
    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    /**
     * 获取消息创建时间
     *
     * @return createTime - 消息创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置消息创建时间
     *
     * @param createTime 消息创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", officialAccountId=").append(officialAccountId);
        sb.append(", openid=").append(openid);
        sb.append(", subscribe=").append(subscribe);
        sb.append(", nickName=").append(nickName);
        sb.append(", sex=").append(sex);
        sb.append(", city=").append(city);
        sb.append(", country=").append(country);
        sb.append(", province=").append(province);
        sb.append(", language=").append(language);
        sb.append(", headimgurl=").append(headimgurl);
        sb.append(", subscribeTime=").append(subscribeTime);
        sb.append(", unionid=").append(unionid);
        sb.append(", remark=").append(remark);
        sb.append(", groupid=").append(groupid);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}