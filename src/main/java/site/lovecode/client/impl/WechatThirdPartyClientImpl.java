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

import java.io.IOException;

/**
 * Created by Administrator on 2016/4/1.
 */
public class WechatThirdPartyClientImpl {


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


    public String getComponentAccessToken(){
        JSONObject jsonObject = new JSONObject();
        return null;
    }



}
