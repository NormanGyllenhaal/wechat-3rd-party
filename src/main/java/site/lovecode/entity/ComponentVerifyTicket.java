package site.lovecode.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wx_component_verify_ticket")
public class ComponentVerifyTicket implements Serializable {
    @Id
    private Long id;

    @Column(name = "component_verify_ticket")
    private String componentVerifyTicket;

    @Column(name = "create_time")
    private Date createTime;

    private String appid;

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
     * @return component_verify_ticket
     */
    public String getComponentVerifyTicket() {
        return componentVerifyTicket;
    }

    /**
     * @param componentVerifyTicket
     */
    public void setComponentVerifyTicket(String componentVerifyTicket) {
        this.componentVerifyTicket = componentVerifyTicket;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", componentVerifyTicket=").append(componentVerifyTicket);
        sb.append(", createTime=").append(createTime);
        sb.append(", appid=").append(appid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}