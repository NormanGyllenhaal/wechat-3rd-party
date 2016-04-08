package site.lovecode.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import site.lovecode.common.mybatis.Identity;

@Table(name = "wx_authorizre_info")
public class AuthorizerInfo implements Identity, Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 授权方appid
     */
    private String authorizerAppid;

    /**
     * 授权方昵称
     */
    private String nickName;

    /**
     * 授权方头像
     */
    private String headImg;

    /**
     * 授权方公众号类型
     */
    private Integer serviceTypeInfo;

    /**
     * 授权方认证类型，-1代表未认证，0代表微信认证，1代表新浪微博认证，2代表腾讯微博认证，3代表已资质认证通过但还未通过名称认证，4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
     */
    private Integer verifyTypeInfo;

    /**
     * 授权方公众号的原始ID
     */
    private String userName;

    /**
     * 授权方公众号所设置的微信号，可能为空
     */
    private String alias;

    /**
     * 二维码图片的URL，开发者最好自行也进行保存
     */
    private String qrcodeUrl;

    /**
     * 创建时间
     */
    private Date createTime;

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
     * 获取授权方appid
     *
     * @return authorizerAppid - 授权方appid
     */
    public String getAuthorizerAppid() {
        return authorizerAppid;
    }

    /**
     * 设置授权方appid
     *
     * @param authorizerAppid 授权方appid
     */
    public void setAuthorizerAppid(String authorizerAppid) {
        this.authorizerAppid = authorizerAppid;
    }

    /**
     * 获取授权方昵称
     *
     * @return nickName - 授权方昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置授权方昵称
     *
     * @param nickName 授权方昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取授权方头像
     *
     * @return headImg - 授权方头像
     */
    public String getHeadImg() {
        return headImg;
    }

    /**
     * 设置授权方头像
     *
     * @param headImg 授权方头像
     */
    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    /**
     * 获取授权方公众号类型
     *
     * @return serviceTypeInfo - 授权方公众号类型
     */
    public Integer getServiceTypeInfo() {
        return serviceTypeInfo;
    }

    /**
     * 设置授权方公众号类型
     *
     * @param serviceTypeInfo 授权方公众号类型
     */
    public void setServiceTypeInfo(Integer serviceTypeInfo) {
        this.serviceTypeInfo = serviceTypeInfo;
    }

    /**
     * 获取授权方认证类型，-1代表未认证，0代表微信认证，1代表新浪微博认证，2代表腾讯微博认证，3代表已资质认证通过但还未通过名称认证，4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
     *
     * @return verifyTypeInfo - 授权方认证类型，-1代表未认证，0代表微信认证，1代表新浪微博认证，2代表腾讯微博认证，3代表已资质认证通过但还未通过名称认证，4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
     */
    public Integer getVerifyTypeInfo() {
        return verifyTypeInfo;
    }

    /**
     * 设置授权方认证类型，-1代表未认证，0代表微信认证，1代表新浪微博认证，2代表腾讯微博认证，3代表已资质认证通过但还未通过名称认证，4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
     *
     * @param verifyTypeInfo 授权方认证类型，-1代表未认证，0代表微信认证，1代表新浪微博认证，2代表腾讯微博认证，3代表已资质认证通过但还未通过名称认证，4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
     */
    public void setVerifyTypeInfo(Integer verifyTypeInfo) {
        this.verifyTypeInfo = verifyTypeInfo;
    }

    /**
     * 获取授权方公众号的原始ID
     *
     * @return userName - 授权方公众号的原始ID
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置授权方公众号的原始ID
     *
     * @param userName 授权方公众号的原始ID
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取授权方公众号所设置的微信号，可能为空
     *
     * @return alias - 授权方公众号所设置的微信号，可能为空
     */
    public String getAlias() {
        return alias;
    }

    /**
     * 设置授权方公众号所设置的微信号，可能为空
     *
     * @param alias 授权方公众号所设置的微信号，可能为空
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * 获取二维码图片的URL，开发者最好自行也进行保存
     *
     * @return qrcodeUrl - 二维码图片的URL，开发者最好自行也进行保存
     */
    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    /**
     * 设置二维码图片的URL，开发者最好自行也进行保存
     *
     * @param qrcodeUrl 二维码图片的URL，开发者最好自行也进行保存
     */
    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", authorizerAppid=").append(authorizerAppid);
        sb.append(", nickName=").append(nickName);
        sb.append(", headImg=").append(headImg);
        sb.append(", serviceTypeInfo=").append(serviceTypeInfo);
        sb.append(", verifyTypeInfo=").append(verifyTypeInfo);
        sb.append(", userName=").append(userName);
        sb.append(", alias=").append(alias);
        sb.append(", qrcodeUrl=").append(qrcodeUrl);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}