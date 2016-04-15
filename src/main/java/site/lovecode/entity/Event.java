package site.lovecode.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import site.lovecode.common.mybatis.Identity;

@Table(name = "wx_event")
public class Event implements Identity, Serializable {
    @Id
    private Long id;

    /**
     * 收到消息一方的用户id，关联微信个人用户表或微信公众账号基本信息表
     */
    private Long toUserId;

    /**
     * 消息发送方的用户id
     */
    private Long fromUserId;

    /**
     * 接收方微信号
     */
    private String toUserName;

    /**
     * 发送方微信号openid
     */
    private String fromUserName;

    /**
     * 消息创建时间
     */
    private Date createTime;

    /**
     * 消息类型
     */
    private Integer msgType;

    /**
     * 二维码的ticket，可用来换取二维码图片
     */
    private String ticket;

    /**
     * 事件KEY值，qrscene_为前缀，后面为二维码的参数值
     */
    private String eventKey;

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
     * 获取收到消息一方的用户id，关联微信个人用户表或微信公众账号基本信息表
     *
     * @return toUserId - 收到消息一方的用户id，关联微信个人用户表或微信公众账号基本信息表
     */
    public Long getToUserId() {
        return toUserId;
    }

    /**
     * 设置收到消息一方的用户id，关联微信个人用户表或微信公众账号基本信息表
     *
     * @param toUserId 收到消息一方的用户id，关联微信个人用户表或微信公众账号基本信息表
     */
    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    /**
     * 获取消息发送方的用户id
     *
     * @return fromUserId - 消息发送方的用户id
     */
    public Long getFromUserId() {
        return fromUserId;
    }

    /**
     * 设置消息发送方的用户id
     *
     * @param fromUserId 消息发送方的用户id
     */
    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    /**
     * 获取接收方微信号
     *
     * @return toUserName - 接收方微信号
     */
    public String getToUserName() {
        return toUserName;
    }

    /**
     * 设置接收方微信号
     *
     * @param toUserName 接收方微信号
     */
    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    /**
     * 获取发送方微信号openid
     *
     * @return fromUserName - 发送方微信号openid
     */
    public String getFromUserName() {
        return fromUserName;
    }

    /**
     * 设置发送方微信号openid
     *
     * @param fromUserName 发送方微信号openid
     */
    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
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

    /**
     * 获取消息类型
     *
     * @return msgType - 消息类型
     */
    public Integer getMsgType() {
        return msgType;
    }

    /**
     * 设置消息类型
     *
     * @param msgType 消息类型
     */
    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    /**
     * 获取二维码的ticket，可用来换取二维码图片
     *
     * @return ticket - 二维码的ticket，可用来换取二维码图片
     */
    public String getTicket() {
        return ticket;
    }

    /**
     * 设置二维码的ticket，可用来换取二维码图片
     *
     * @param ticket 二维码的ticket，可用来换取二维码图片
     */
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    /**
     * 获取事件KEY值，qrscene_为前缀，后面为二维码的参数值
     *
     * @return eventKey - 事件KEY值，qrscene_为前缀，后面为二维码的参数值
     */
    public String getEventKey() {
        return eventKey;
    }

    /**
     * 设置事件KEY值，qrscene_为前缀，后面为二维码的参数值
     *
     * @param eventKey 事件KEY值，qrscene_为前缀，后面为二维码的参数值
     */
    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", toUserId=").append(toUserId);
        sb.append(", fromUserId=").append(fromUserId);
        sb.append(", toUserName=").append(toUserName);
        sb.append(", fromUserName=").append(fromUserName);
        sb.append(", createTime=").append(createTime);
        sb.append(", msgType=").append(msgType);
        sb.append(", ticket=").append(ticket);
        sb.append(", eventKey=").append(eventKey);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}