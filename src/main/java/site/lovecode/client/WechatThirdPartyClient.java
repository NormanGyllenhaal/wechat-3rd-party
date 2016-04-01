package site.lovecode.client;

import site.lovecode.support.bean.ComponentAccessTokenBean;

import java.io.IOException;

/**
 * Created by Administrator on 2016/4/1.
 */
public interface WechatThirdPartyClient {

    public ComponentAccessTokenBean getComponentAccessToken() throws IOException;
}
