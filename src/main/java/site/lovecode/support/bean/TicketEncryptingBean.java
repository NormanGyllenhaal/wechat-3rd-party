package site.lovecode.support.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import me.chanjar.weixin.common.util.xml.XStreamCDataConverter;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/4/1.
 */
@XStreamAlias("xml")
public class TicketEncryptingBean implements Serializable {

    @XStreamAlias("AppId")
    @XStreamConverter(value=XStreamCDataConverter.class)
    private String appId;

    @XStreamAlias("Encrypt")
    @XStreamConverter(value=XStreamCDataConverter.class)
    private String encrypt;

    public String getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }


    @Override
    public String toString() {
        return "TicketEncryptingBean{" +
                "appId='" + appId + '\'' +
                ", encrypt='" + encrypt + '\'' +
                '}';
    }
}
