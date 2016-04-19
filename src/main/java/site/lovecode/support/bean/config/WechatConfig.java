package site.lovecode.support.bean.config;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/4/13.
 */
public class WechatConfig extends WxMpInMemoryConfigStorage implements Serializable {

    /**
     * refreshToken
     */
    private String refreshToken;

    /**
     * 账号绑定类型
     */
    private Integer accountType;

    /**
     * 微信公众账号基本信息id
     */
    private Long officialAccountId;

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Long getOfficialAccountId() {
        return officialAccountId;
    }

    public void setOfficialAccountId(Long officialAccountId) {
        this.officialAccountId = officialAccountId;
    }
}
