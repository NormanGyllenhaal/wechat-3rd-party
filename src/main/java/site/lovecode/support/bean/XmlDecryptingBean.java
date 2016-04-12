package site.lovecode.support.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import me.chanjar.weixin.common.util.xml.XStreamCDataConverter;

/**
 * Created by Administrator on 2016/4/1.
 */
@XStreamAlias("xml")
public class XmlDecryptingBean {

    @XStreamAlias("AppId")
    @XStreamConverter(value=XStreamCDataConverter.class)
    private String appId;

    @XStreamAlias("CreateTime")
    @XStreamConverter(value=XStreamCDataConverter.class)
    private String createTime;

    @XStreamAlias("InfoType")
    @XStreamConverter(value=XStreamCDataConverter.class)
    private String infoType;

    @XStreamAlias("ComponentVerifyTicket")
    @XStreamConverter(value=XStreamCDataConverter.class)
    private String componentVerifyTicket;

    @XStreamAlias("AuthorizerAppid")
    @XStreamConverter(value=XStreamCDataConverter.class)
    private String authorizerAppid;

    @XStreamAlias("AuthorizationCode")
    @XStreamConverter(value=XStreamCDataConverter.class)
    private String authorizationCode;

    @XStreamAlias("AuthorizationCodeExpiredTime")
    @XStreamConverter(value=XStreamCDataConverter.class)
    private String authorizationCodeExpiredTime;


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getComponentVerifyTicket() {
        return componentVerifyTicket;
    }

    public void setComponentVerifyTicket(String componentVerifyTicket) {
        this.componentVerifyTicket = componentVerifyTicket;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public String getAuthorizerAppid() {
        return authorizerAppid;
    }

    public void setAuthorizerAppid(String authorizerAppid) {
        this.authorizerAppid = authorizerAppid;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getAuthorizationCodeExpiredTime() {
        return authorizationCodeExpiredTime;
    }

    public void setAuthorizationCodeExpiredTime(String authorizationCodeExpiredTime) {
        this.authorizationCodeExpiredTime = authorizationCodeExpiredTime;
    }

    @Override
    public String toString() {
        return "XmlDecryptingBean{" +
                "appId='" + appId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", infoType='" + infoType + '\'' +
                ", componentVerifyTicket='" + componentVerifyTicket + '\'' +
                ", authorizerAppid='" + authorizerAppid + '\'' +
                ", authorizationCode='" + authorizationCode + '\'' +
                ", authorizationCodeExpiredTime='" + authorizationCodeExpiredTime + '\'' +
                '}';
    }
}
