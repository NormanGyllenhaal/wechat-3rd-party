package site.lovecode.support.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Administrator on 2016/4/1.
 */
public class ComponentAccessTokenBean {

    @JSONField(name="component_access_token")
    private String componentAccessToken;

    @JSONField(name="expires_in")
    private String expiresIn;


    public String getComponentAccessToken() {
        return componentAccessToken;
    }

    public void setComponentAccessToken(String componentAccessToken) {
        this.componentAccessToken = componentAccessToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        return "ComponentAccessTokenBean{" +
                "componentAccessToken='" + componentAccessToken + '\'' +
                ", expiresIn='" + expiresIn + '\'' +
                '}';
    }
}
