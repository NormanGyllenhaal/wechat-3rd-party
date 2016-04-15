package site.lovecode.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import site.lovecode.common.mybatis.Identity;

@Table(name = "wx_authorizer_info")
public class AuthorizerInfo implements Identity, Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 微信公众账号基本信息表id，关联微信公众号基本信息表
     */
    private Long officialAccountId;

    /**
     * 授权方appid
     */
    private String authorizerAppid;

    /**
     * 授权方头像
     */
    private String headImg;

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

    /**
     * 授权状态,0为已授权,1为已取消授权
     */
    private Integer authorizationStatus;

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

    /**
     * 获取授权状态,0为已授权,1为已取消授权
     *
     * @return authorizationStatus - 授权状态,0为已授权,1为已取消授权
     */
    public Integer getAuthorizationStatus() {
        return authorizationStatus;
    }

    /**
     * 设置授权状态,0为已授权,1为已取消授权
     *
     * @param authorizationStatus 授权状态,0为已授权,1为已取消授权
     */
    public void setAuthorizationStatus(Integer authorizationStatus) {
        this.authorizationStatus = authorizationStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", officialAccountId=").append(officialAccountId);
        sb.append(", authorizerAppid=").append(authorizerAppid);
        sb.append(", headImg=").append(headImg);
        sb.append(", alias=").append(alias);
        sb.append(", qrcodeUrl=").append(qrcodeUrl);
        sb.append(", createTime=").append(createTime);
        sb.append(", authorizationStatus=").append(authorizationStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}