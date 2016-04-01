package site.lovecode.support.bean;

/**
 * Created by Administrator on 2016/4/1.
 */
public class WechatThirdPartyConfig {


    /**
     * 微信第三方平台的appId
     */
    private String appId;
    /**
     * 微信的appSecret
     */
    private String appSecret;
    /**
     * token
     *
     */
    private String token;

    /**
     * endcodingAesKey
     */
    private String encodingAesKey;


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEncodingAesKey() {
        return encodingAesKey;
    }

    public void setEncodingAesKey(String encodingAesKey) {
        this.encodingAesKey = encodingAesKey;
    }
}
