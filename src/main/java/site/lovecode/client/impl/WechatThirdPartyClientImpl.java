package site.lovecode.client.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import site.lovecode.client.WechatThirdPartyClient;
import site.lovecode.entity.ComponentVerifyTicket;
import site.lovecode.entity.WechatThirdPartyConfig;
import site.lovecode.mapper.ComponentVerifyTicketMapper;
import site.lovecode.mapper.WechatThirdPartyConfigMapper;
import site.lovecode.support.bean.ComponentAccessTokenBean;
import site.lovecode.support.bean.PreAuthCodeBean;
import site.lovecode.support.bean.TicketDecryptingBean;
import site.lovecode.util.HttpUtil;


import javax.annotation.Resource;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/4/1.
 */
@Service
public class WechatThirdPartyClientImpl  implements InitializingBean,WechatThirdPartyClient {


    private Logger logger = LoggerFactory.getLogger(WechatThirdPartyClientImpl.class);


    private static String componentVerifyTicket;


    public static  WechatThirdPartyConfig wechatThirdPartyConfig;

    @Resource
    private WechatThirdPartyConfigMapper wechatThirdPartyConfigMapper;

    @Resource
    private ComponentVerifyTicketMapper componentVerifyTicketMapper;


    /**
     * 获取ComponentVerifyTicket
     */
    public String getComponentVerifyTicket(){
        if(componentVerifyTicket==null){
            componentVerifyTicket = componentVerifyTicketMapper.selectOrderByCreateTime(wechatThirdPartyConfig.getComponentAppid());
        }
        return componentVerifyTicket;
    }


    /**
     * 获取component_access_token
     *
     * @return
     * @throws IOException
     */
    public ComponentAccessTokenBean getComponentAccessToken() throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("component_appid",wechatThirdPartyConfig.getComponentAppid() );
        jsonObject.put("component_appsecret", wechatThirdPartyConfig.getComponentAppsecret());
        jsonObject.put("component_verify_ticket", getComponentVerifyTicket());
        String url = "https://api.weixin.qq.com/cgi-bin/component/api_component_token";
        return JSON.parseObject(HttpUtil.doPostSSL(url, jsonObject.toJSONString()), ComponentAccessTokenBean.class);
    }


    /**
     * 获取预授权码
     *
     * @param componentAccessToken
     * @return
     * @throws IOException
     */
    public PreAuthCodeBean getPreAuthCode(String componentAccessToken) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("component_appid",wechatThirdPartyConfig.getComponentAppid());
        String url = "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token=" + componentAccessToken;
        return JSON.parseObject(HttpUtil.doPostSSL(url, jsonObject.toJSONString()),PreAuthCodeBean.class);
    }


    /**
     * 获取授权页面地址
     *
     * @param perAuthCode
     * @param redirectUri
     * @return
     */
    public String getAuthOrizationUrl(String perAuthCode, String redirectUri) {
        String url = "https://mp.weixin.qq.com/cgi-bin/componentloginpage?";
        StringBuilder sb = new StringBuilder();
        sb.append(url).append("component_appid=" + wechatThirdPartyConfig.getComponentAppid()).append("&pre_auth_code=" + perAuthCode).append("&redirect_uri=" + redirectUri);
        return sb.toString();
    }




    /**
     * 使用授权码换取公众号的接口调用凭据和授权信息
     *
     * @param authorizationCode
     * @param componentAccessToken
     * @return
     * @throws IOException
     */
    public String queryAuth(String authorizationCode, String componentAccessToken) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token=" + componentAccessToken;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("component_appid", wechatThirdPartyConfig.getComponentAppid());
        jsonObject.put("authorization_code", authorizationCode);
        return HttpUtil.doPostSSL(url, jsonObject.toJSONString());
    }


    /**
     * 获取授权方公账号信息
     * @param componentAccessToken
     * @param authorizerAppid
     * @return
     */
    public String getQuthorizerInfo(String componentAccessToken,String authorizerAppid){
        String url = "https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info?component_access_token="+componentAccessToken;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("component_appid",wechatThirdPartyConfig.getComponentAppid());
        jsonObject.put("authorizer_appid",authorizerAppid);
        return HttpUtil.doPostSSL(url,jsonObject.toJSONString());
    }

    /**
     * 保存ComponentVerifyTicket
     * @param ticketDecryptingBean
     */
    @Override
    public void saveComponentVerifyTicket(TicketDecryptingBean ticketDecryptingBean) {
        componentVerifyTicket = ticketDecryptingBean.getComponentVerifyTicket();
        ComponentVerifyTicket componentVerifyTicket = new ComponentVerifyTicket();
        componentVerifyTicket.setComponentVerifyTicket(ticketDecryptingBean.getComponentVerifyTicket());
        componentVerifyTicket.setAppid(ticketDecryptingBean.getAppId());
        componentVerifyTicket.setCreateTime(new Timestamp(Long.parseLong(ticketDecryptingBean.getCreateTime())*1000));
        componentVerifyTicketMapper.insert(componentVerifyTicket);
    }


    /**
     * 初始化加载公众号配置细信息
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception{
        logger.info("----加载公众号第三方配置----");
        wechatThirdPartyConfig = wechatThirdPartyConfigMapper.selectByPrimaryKey(1);
        logger.info(wechatThirdPartyConfig.toString());
    }


}
