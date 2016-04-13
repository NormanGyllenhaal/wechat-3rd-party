package site.lovecode.support.bean.config;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;

/**
 * Created by Administrator on 2016/4/13.
 */
public class WechatConfig extends WxMpInMemoryConfigStorage {

    private String refreshToken;

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

}
