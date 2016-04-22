package site.lovecode.entity;

import java.io.Serializable;
import javax.persistence.*;
import site.lovecode.common.mybatis.Identity;

@Table(name = "wx_error_code")
public class ErrorCode implements Identity, Serializable {
    @Id
    private Long id;

    /**
     * 微信错误码
     */
    private String code;

    /**
     * 微信错误消息说明
     */
    private String msg;

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
     * 获取微信错误码
     *
     * @return code - 微信错误码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置微信错误码
     *
     * @param code 微信错误码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取微信错误消息说明
     *
     * @return msg - 微信错误消息说明
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置微信错误消息说明
     *
     * @param msg 微信错误消息说明
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", msg=").append(msg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}