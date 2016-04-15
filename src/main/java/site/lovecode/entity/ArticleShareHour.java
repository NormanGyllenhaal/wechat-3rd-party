package site.lovecode.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import site.lovecode.common.mybatis.Identity;

@Table(name = "wx_article_share_hour")
public class ArticleShareHour implements Identity, Serializable {
    @Id
    private Long id;

    /**
     * 微信公众号基本信息id
     */
    private Long officialAccountId;

    /**
     * 数据的日期
     */
    private Date refDate;

    /**
     * 数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
     */
    private Integer refHour;

    /**
     * 分享的场景
            1代表好友转发 2代表朋友圈 3代表腾讯微博 255代表其他
     */
    private Integer shareScene;

    /**
     * 分享的次数
     */
    private Integer shareCount;

    /**
     * 分享的人数
     */
    private Integer shareUser;

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
     * 获取微信公众号基本信息id
     *
     * @return officialAccountId - 微信公众号基本信息id
     */
    public Long getOfficialAccountId() {
        return officialAccountId;
    }

    /**
     * 设置微信公众号基本信息id
     *
     * @param officialAccountId 微信公众号基本信息id
     */
    public void setOfficialAccountId(Long officialAccountId) {
        this.officialAccountId = officialAccountId;
    }

    /**
     * 获取数据的日期
     *
     * @return refDate - 数据的日期
     */
    public Date getRefDate() {
        return refDate;
    }

    /**
     * 设置数据的日期
     *
     * @param refDate 数据的日期
     */
    public void setRefDate(Date refDate) {
        this.refDate = refDate;
    }

    /**
     * 获取数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
     *
     * @return refHour - 数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
     */
    public Integer getRefHour() {
        return refHour;
    }

    /**
     * 设置数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
     *
     * @param refHour 数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
     */
    public void setRefHour(Integer refHour) {
        this.refHour = refHour;
    }

    /**
     * 获取分享的场景
            1代表好友转发 2代表朋友圈 3代表腾讯微博 255代表其他
     *
     * @return shareScene - 分享的场景
            1代表好友转发 2代表朋友圈 3代表腾讯微博 255代表其他
     */
    public Integer getShareScene() {
        return shareScene;
    }

    /**
     * 设置分享的场景
            1代表好友转发 2代表朋友圈 3代表腾讯微博 255代表其他
     *
     * @param shareScene 分享的场景
            1代表好友转发 2代表朋友圈 3代表腾讯微博 255代表其他
     */
    public void setShareScene(Integer shareScene) {
        this.shareScene = shareScene;
    }

    /**
     * 获取分享的次数
     *
     * @return shareCount - 分享的次数
     */
    public Integer getShareCount() {
        return shareCount;
    }

    /**
     * 设置分享的次数
     *
     * @param shareCount 分享的次数
     */
    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    /**
     * 获取分享的人数
     *
     * @return shareUser - 分享的人数
     */
    public Integer getShareUser() {
        return shareUser;
    }

    /**
     * 设置分享的人数
     *
     * @param shareUser 分享的人数
     */
    public void setShareUser(Integer shareUser) {
        this.shareUser = shareUser;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", officialAccountId=").append(officialAccountId);
        sb.append(", refDate=").append(refDate);
        sb.append(", refHour=").append(refHour);
        sb.append(", shareScene=").append(shareScene);
        sb.append(", shareCount=").append(shareCount);
        sb.append(", shareUser=").append(shareUser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}