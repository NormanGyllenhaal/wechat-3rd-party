package site.lovecode.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import site.lovecode.common.mybatis.Identity;

@Table(name = "wx_media")
public class Media implements Identity, Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 微信公众号基本信息id,关联微信公众号基本信息表
     */
    private Long officialAccountId;

    /**
     * 媒体文件的唯一标识
            
     */
    private String mediaId;

    /**
     * 媒体文件的类型
     */
    private Integer type;

    /**
     * 媒体文件上传时间
     */
    private Date createdAt;

    /**
     * 素材存储本地路径
     */
    private String path;

    /**
     * 素材类型,永久或临时
     */
    private Integer mediaType;

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
     * 获取微信公众号基本信息id,关联微信公众号基本信息表
     *
     * @return officialAccountId - 微信公众号基本信息id,关联微信公众号基本信息表
     */
    public Long getOfficialAccountId() {
        return officialAccountId;
    }

    /**
     * 设置微信公众号基本信息id,关联微信公众号基本信息表
     *
     * @param officialAccountId 微信公众号基本信息id,关联微信公众号基本信息表
     */
    public void setOfficialAccountId(Long officialAccountId) {
        this.officialAccountId = officialAccountId;
    }

    /**
     * 获取媒体文件的唯一标识
            
     *
     * @return mediaId - 媒体文件的唯一标识
            
     */
    public String getMediaId() {
        return mediaId;
    }

    /**
     * 设置媒体文件的唯一标识
            
     *
     * @param mediaId 媒体文件的唯一标识
            
     */
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    /**
     * 获取媒体文件的类型
     *
     * @return type - 媒体文件的类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置媒体文件的类型
     *
     * @param type 媒体文件的类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取媒体文件上传时间
     *
     * @return createdAt - 媒体文件上传时间
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 设置媒体文件上传时间
     *
     * @param createdAt 媒体文件上传时间
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 获取素材存储本地路径
     *
     * @return path - 素材存储本地路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置素材存储本地路径
     *
     * @param path 素材存储本地路径
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取素材类型,永久或临时
     *
     * @return mediaType - 素材类型,永久或临时
     */
    public Integer getMediaType() {
        return mediaType;
    }

    /**
     * 设置素材类型,永久或临时
     *
     * @param mediaType 素材类型,永久或临时
     */
    public void setMediaType(Integer mediaType) {
        this.mediaType = mediaType;
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
        sb.append(", officialAccountId=").append(officialAccountId);
        sb.append(", mediaId=").append(mediaId);
        sb.append(", type=").append(type);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", path=").append(path);
        sb.append(", mediaType=").append(mediaType);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}