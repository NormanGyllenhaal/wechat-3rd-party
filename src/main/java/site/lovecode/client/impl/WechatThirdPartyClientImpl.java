package site.lovecode.client.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import site.lovecode.client.WechatThirdPartyClient;
import site.lovecode.support.bean.ComponentAccessTokenBean;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by Administrator on 2016/4/1.
 */
@Service
public class WechatThirdPartyClientImpl implements WechatThirdPartyClient {


    private Logger logger  = LoggerFactory.getLogger(WechatThirdPartyClientImpl.class);



    public String post(String url,String postData) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        if (postData != null) {
            StringEntity entity = new StringEntity(postData, Consts.UTF_8);
            httpPost.setEntity(entity);
        }
        CloseableHttpResponse response = httpclient.execute(httpPost);
        String resultContent = new BasicResponseHandler().handleResponse(response);
        JSONObject jsonObject = JSON.parseObject(resultContent);
        logger.info(jsonObject.toJSONString());
        return resultContent;
    }


    public ComponentAccessTokenBean getComponentAccessToken() throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("component_appid","wxe817ddf41e533ba1");
        jsonObject.put("component_appsecret","37c4eb033c32e692b09c2c29dc6095aa");
        jsonObject.put("component_verify_ticket","ticket@@@4YgrQ1GcLm96FiKa3ub75hSnze8A3pCgulgJ4W2VnbC94oh3VoET-vXdEp6MdpKbp1n5_F1cDKILuUz7PrRkLg");
        String url = "https://api.weixin.qq.com/cgi-bin/component/api_component_token";
        return JSON.parseObject(post(url,jsonObject.toJSONString()),ComponentAccessTokenBean.class);
    }

    public String getPreAuthCode(){
        return null;
    }



}
