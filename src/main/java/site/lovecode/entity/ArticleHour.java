package site.lovecode.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import site.lovecode.common.mybatis.Identity;

@Table(name = "wx_article_hour")
public class ArticleHour implements Identity, Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 微信公众账号基本信息id
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
     * 这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）和index（消息次序索引）组成， 例如12003_3， 其中12003是msgid，即一次群发的消息的id； 3为index，假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个
     */
    private String msgid;

    /**
     * 图文消息的标题
     */
    private String title;

    /**
     * 图文页（点击群发图文卡片进入的页面）的阅读人数
     */
    private Integer intPageReadUser;

    /**
     * 图文页的阅读次数
     */
    private Integer intPageReadCount;

    /**
     * 原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0
     */
    private Integer oriPageReadUser;

    /**
     * 原文页的阅读次数
     */
    private Integer oriPageReadCount;

    /**
     * 分享的人数
     */
    private Integer shareUser;

    /**
     * 分享的次数
            
     */
    private Integer shareCount;

    /**
     * 收藏的人数
     */
    private Integer addToFavUser;

    /**
     * 收藏的次数
     */
    private Integer addToFavCount;

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
     * 获取微信公众账号基本信息id
     *
     * @return officialAccountId - 微信公众账号基本信息id
     */
    public Long getOfficialAccountId() {
        return officialAccountId;
    }

    /**
     * 设置微信公众账号基本信息id
     *
     * @param officialAccountId 微信公众账号基本信息id
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
     * 获取这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）和index（消息次序索引）组成， 例如12003_3， 其中12003是msgid，即一次群发的消息的id； 3为index，假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个
     *
     * @return msgid - 这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）和index（消息次序索引）组成， 例如12003_3， 其中12003是msgid，即一次群发的消息的id； 3为index，假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个
     */
    public String getMsgid() {
        return msgid;
    }

    /**
     * 设置这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）和index（消息次序索引）组成， 例如12003_3， 其中12003是msgid，即一次群发的消息的id； 3为index，假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个
     *
     * @param msgid 这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）和index（消息次序索引）组成， 例如12003_3， 其中12003是msgid，即一次群发的消息的id； 3为index，假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个
     */
    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    /**
     * 获取图文消息的标题
     *
     * @return title - 图文消息的标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置图文消息的标题
     *
     * @param title 图文消息的标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取图文页（点击群发图文卡片进入的页面）的阅读人数
     *
     * @return intPageReadUser - 图文页（点击群发图文卡片进入的页面）的阅读人数
     */
    public Integer getIntPageReadUser() {
        return intPageReadUser;
    }

    /**
     * 设置图文页（点击群发图文卡片进入的页面）的阅读人数
     *
     * @param intPageReadUser 图文页（点击群发图文卡片进入的页面）的阅读人数
     */
    public void setIntPageReadUser(Integer intPageReadUser) {
        this.intPageReadUser = intPageReadUser;
    }

    /**
     * 获取图文页的阅读次数
     *
     * @return intPageReadCount - 图文页的阅读次数
     */
    public Integer getIntPageReadCount() {
        return intPageReadCount;
    }

    /**
     * 设置图文页的阅读次数
     *
     * @param intPageReadCount 图文页的阅读次数
     */
    public void setIntPageReadCount(Integer intPageReadCount) {
        this.intPageReadCount = intPageReadCount;
    }

    /**
     * 获取原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0
     *
     * @return oriPageReadUser - 原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0
     */
    public Integer getOriPageReadUser() {
        return oriPageReadUser;
    }

    /**
     * 设置原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0
     *
     * @param oriPageReadUser 原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0
     */
    public void setOriPageReadUser(Integer oriPageReadUser) {
        this.oriPageReadUser = oriPageReadUser;
    }

    /**
     * 获取原文页的阅读次数
     *
     * @return oriPageReadCount - 原文页的阅读次数
     */
    public Integer getOriPageReadCount() {
        return oriPageReadCount;
    }

    /**
     * 设置原文页的阅读次数
     *
     * @param oriPageReadCount 原文页的阅读次数
     */
    public void setOriPageReadCount(Integer oriPageReadCount) {
        this.oriPageReadCount = oriPageReadCount;
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
     * 获取收藏的人数
     *
     * @return addToFavUser - 收藏的人数
     */
    public Integer getAddToFavUser() {
        return addToFavUser;
    }

    /**
     * 设置收藏的人数
     *
     * @param addToFavUser 收藏的人数
     */
    public void setAddToFavUser(Integer addToFavUser) {
        this.addToFavUser = addToFavUser;
    }

    /**
     * 获取收藏的次数
     *
     * @return addToFavCount - 收藏的次数
     */
    public Integer getAddToFavCount() {
        return addToFavCount;
    }

    /**
     * 设置收藏的次数
     *
     * @param addToFavCount 收藏的次数
     */
    public void setAddToFavCount(Integer addToFavCount) {
        this.addToFavCount = addToFavCount;
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
        sb.append(", msgid=").append(msgid);
        sb.append(", title=").append(title);
        sb.append(", intPageReadUser=").append(intPageReadUser);
        sb.append(", intPageReadCount=").append(intPageReadCount);
        sb.append(", oriPageReadUser=").append(oriPageReadUser);
        sb.append(", oriPageReadCount=").append(oriPageReadCount);
        sb.append(", shareUser=").append(shareUser);
        sb.append(", shareCount=").append(shareCount);
        sb.append(", addToFavUser=").append(addToFavUser);
        sb.append(", addToFavCount=").append(addToFavCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}