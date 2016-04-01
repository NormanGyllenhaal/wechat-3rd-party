package site.lovecode.weixin;


import com.alibaba.fastjson.JSON;
import com.thoughtworks.xstream.XStream;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxMenu;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.util.xml.XStreamInitializer;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import site.lovecode.client.WechatClient;
import site.lovecode.client.WechatThirdPartyClient;
import site.lovecode.entity.User;
import site.lovecode.mapper.UserMapper;
import site.lovecode.support.bean.TicketDecryptingBean;
import site.lovecode.support.bean.TicketEncryptingBean;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


/**
 * Created by Administrator on 2016/3/29.
 */
public class WeiXinTest {

    private Logger logger = LoggerFactory.getLogger(WeiXinTest.class);

    private String appid = "wxa0803d1acc6a603a";
    private String appsecret = "706702fb42c55f793ddb6b206ec4f348";

    private ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath*:applicationContext-*.xml");


    WechatClient wechatClient = (WechatClient) ctx.getBean("wechatClientImpl");

    WechatThirdPartyClient wechatThirdPartyClient = (WechatThirdPartyClient) ctx.getBean("wechatThirdPartyClientImpl");

    //@Test
    public void getAccessToken() throws Exception {
        HttpURLConnection httpconn = null;
        StringBuilder sb = new StringBuilder();
        sb.append("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=");
        sb.append(appid);
        sb.append("&secret=").append(appsecret);
        try {
            URL url = new URL(sb.toString());
            httpconn = (HttpURLConnection) url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    httpconn.getInputStream()));
            String str = null;
            sb.delete(0, sb.length());
            while ((str = rd.readLine()) != null) {
                sb.append(str);
            }
            System.out.print(sb.toString());
            rd.close();
        } catch (Exception e) {
            throw new Exception("获取access token微信接口调用异常", e);
        } finally {
            if (httpconn != null) {
                httpconn.disconnect();
                httpconn = null;
            }

        }
    }


    /**
     *
     */
    //@Test
    public void testWxService() {
        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId("wxa0803d1acc6a603a"); // 设置微信公众号的appid
        config.setSecret("706702fb42c55f793ddb6b206ec4f348"); // 设置微信公众号的app corpSecret
        config.setToken("..."); // 设置微信公众号的token
        config.setAesKey("..."); // 设置微信公众号的EncodingAESKey
        WxMpService wxService = new WxMpServiceImpl();
        wxService.setWxMpConfigStorage(config);
        try {
            logger.info(wxService.getAccessToken());
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }


    /**
     * 测试增加菜单
     */
    //@Test
    public void testSetMenu() {
        String url = wechatClient.getWxMpService().oauth2buildAuthorizationUrl(WxConsts.OAUTH2_SCOPE_USER_INFO, null);
        logger.info(url);
        String json = "{\"menu\":{\"button\":[{\"type\":\"click\",\"name\":\"新的测试\",\"key\":\"非的付费的沙发放四大发送到发送到发疯的冯绍峰水电费水电费\",\"sub_button\":[]},{\"type\":\"click\",\"name\":\"想得美啊\",\"key\":\"V1001_TODAY_SINGER\",\"sub_button\":[]},{\"name\":\"二级菜单\",\"sub_button\":[{\"type\":\"view\",\"name\":\"测试授权\",\"url\":\""+url+"\",\"sub_button\":[]},{\"type\":\"view\",\"name\":\"视频\",\"url\":\"http://v.qq.com/\",\"sub_button\":[]},{\"type\":\"click\",\"name\":\"赞一下我们\",\"key\":\"V1001_GOOD\",\"sub_button\":[]}]}]}}";
        Boolean result = wechatClient.setMenu(WxMenu.fromJson(json));
        logger.info(result.toString());
    }


    /**
     * 获取菜单
     */
    //@Test
    public void testGetMen() {
        WechatClient wechatClient = (WechatClient) ctx.getBean("wechatClientImpl");

    }


    /**
     * 主动发送消息
     */
    //@Test
    public void setMessage() {
        try {
            wechatClient.setMessage("oGRG5t8PNCWlZDT4jFBt7hXUmZnM");
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }

    //@Test
    public void testXml(){
        String sb = "<xml><AppId><![CDATA[wxe817ddf41e533ba1]]></AppId>    <Encrypt><![CDATA[EWFAZvJAzoAcNXu3aOJzok1jA9pLLeye1T64vMTFv3oIdxj065oeFCO0YHmONX9fRgp+ndd9lMISCKmr6noVobahnSUMGKvCLWYslA/2pNnfWKJCqzH1ym7x+T6emw5GlAfX8Suu8BEgotO4JDuG06VBCPQsuVEurn+5l1muOzKJuvcxlQVOY+NGxsJkKN2DMGcSOb+adn4Y/pyQ8tduZ+GoWLvWetiuHi5jCrIIabQQcNCHJkr6lxl+4I/Fwa+Lm2GXce5ZJnGnDF0gLGVObL/QSqEIY6B7SjjBe1MISC2oFciPXMCGwEF7QcAi4OViNE++7VU0AJy9cXxPqCgbrILuIurdIP7iU4Ma6QY+PoMFHX/JY5TZ50YQZqDntHgP4k6f4QTUqPnziVHXJ7TedkL6kHJJxI6sXYsQh2zKd/YzOs/ctATEedWYBc253vPD7LXUoKNrUcgoSnCQuYMLsQ==]]></Encrypt></xml>";
        XStream xStream = XStreamInitializer.getInstance();
        xStream.processAnnotations(new Class[]{TicketEncryptingBean.class});
        TicketEncryptingBean ticketEncryptingBean = (TicketEncryptingBean) xStream.fromXML(sb);

        String format = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";
        String fromXML = String.format(format, ticketEncryptingBean.getEncrypt());
        String result = "<xml><AppId><![CDATA[wxe817ddf41e533ba1]]></AppId>\n" +
                "<CreateTime>1459498313</CreateTime>\n" +
                "<InfoType><![CDATA[component_verify_ticket]]></InfoType>\n" +
                "<ComponentVerifyTicket><![CDATA[ticket@@@4YgrQ1GcLm96FiKa3ub75hSnze8A3pCgulgJ4W2VnbC94oh3VoET-vXdEp6MdpKbp1n5_F1cDKILuUz7PrRkLg]]></ComponentVerifyTicket>\n" +
                "</xml>\n";

        XStream xStream2 = new XStream();
        xStream2.processAnnotations(new Class[]{TicketDecryptingBean.class});
        logger.info("解密后明文: " + result);
        TicketDecryptingBean ticketDecryptingBean = (TicketDecryptingBean) xStream2.fromXML(result);
        logger.info("----------javaBean"+ticketDecryptingBean.toString());
    }


    @Test
    public void testWechatThirdPart(){
        try {
            logger.info(wechatThirdPartyClient.getComponentAccessToken().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
