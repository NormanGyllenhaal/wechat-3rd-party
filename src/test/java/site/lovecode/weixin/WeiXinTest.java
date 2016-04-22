package site.lovecode.weixin;


import com.alibaba.fastjson.JSON;
import com.thoughtworks.xstream.XStream;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.*;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import site.lovecode.support.bean.*;
import site.lovecode.support.bean.json.AutoReplyInfoBean;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


/**
 * Created by Administrator on 2016/3/29.
 */
public class WeiXinTest {

    private Logger logger = LoggerFactory.getLogger(WeiXinTest.class);

    private String appid = "wxa0803d1acc6a603a";
    private String appsecret = "706702fb42c55f793ddb6b206ec4f348";

    //private ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath*:applicationContext-*.xml");



   // WechatThirdPartyClient wechatThirdPartyClient = (WechatThirdPartyClient) ctx.getBean("wechatThirdPartyClientImpl");

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



    //@Test
    public void testXml(){
        String sb = "<xml><AppId><![CDATA[wxe817ddf41e533ba1]]></AppId>    <Encrypt><![CDATA[EWFAZvJAzoAcNXu3aOJzok1jA9pLLeye1T64vMTFv3oIdxj065oeFCO0YHmONX9fRgp+ndd9lMISCKmr6noVobahnSUMGKvCLWYslA/2pNnfWKJCqzH1ym7x+T6emw5GlAfX8Suu8BEgotO4JDuG06VBCPQsuVEurn+5l1muOzKJuvcxlQVOY+NGxsJkKN2DMGcSOb+adn4Y/pyQ8tduZ+GoWLvWetiuHi5jCrIIabQQcNCHJkr6lxl+4I/Fwa+Lm2GXce5ZJnGnDF0gLGVObL/QSqEIY6B7SjjBe1MISC2oFciPXMCGwEF7QcAi4OViNE++7VU0AJy9cXxPqCgbrILuIurdIP7iU4Ma6QY+PoMFHX/JY5TZ50YQZqDntHgP4k6f4QTUqPnziVHXJ7TedkL6kHJJxI6sXYsQh2zKd/YzOs/ctATEedWYBc253vPD7LXUoKNrUcgoSnCQuYMLsQ==]]></Encrypt></xml>";
        /*XStream xStream = XStreamInitializer.getInstance();
        xStream.processAnnotations(new Class[]{TicketEncryptingBean.class});
        TicketEncryptingBean ticketEncryptingBean = (TicketEncryptingBean) xStream.fromXML(sb);*/

        XmlEncryptingBean xmlEncryptingBean = (XmlEncryptingBean)  new XStream(){
            {
                processAnnotations(XmlEncryptingBean.class);
            }
        }.fromXML(sb.toString());
        logger.info(xmlEncryptingBean.toString());
        String format = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";
        String fromXML = String.format(format, xmlEncryptingBean.getEncrypt());
        String result = "<xml><AppId><![CDATA[wxe817ddf41e533ba1]]></AppId>\n" +
                "<CreateTime>1459498313</CreateTime>\n" +
                "<InfoType><![CDATA[component_verify_ticket]]></InfoType>\n" +
                "<ComponentVerifyTicket><![CDATA[ticket@@@4YgrQ1GcLm96FiKa3ub75hSnze8A3pCgulgJ4W2VnbC94oh3VoET-vXdEp6MdpKbp1n5_F1cDKILuUz7PrRkLg]]></ComponentVerifyTicket>\n" +
                "</xml>\n";

        XStream xStream2 = new XStream();
        xStream2.processAnnotations(new Class[]{XmlDecryptingBean.class});
        logger.info("解密后明文: " + result);
        XmlDecryptingBean xmlDecryptingBean = (XmlDecryptingBean) xStream2.fromXML(result);
        logger.info("----------javaBean"+ xmlDecryptingBean.toString());
    }


    //@Test
    public void testWechatThirdPart(){

    }

    //@Test
    public void getUrl(){
        String json = "{\"authorization_info\":{\"authorizer_appid\":\"wx6f2613cb148826e0\",\"authorizer_access_token\":\"FJOdUh6Ztqnqs0-ywYh8AtMLAC2ujQv-CAenXz6L4Wjz-vuksu2IVcsRuMaQ08vRZzOdyinfHOJ8PSFtMdSOHR8VgL6yVEeJiFBvoMt6Jw74bpo9wbX948iTzHesKWsjLWTjAFDTEB\",\"expires_in\":7200,\"authorizer_refresh_token\":\"refreshtoken@@@vFiO1FOFiFvCHFJlNgsZDUoN62CG-_aChmBDIOZng18\",\"func_info\":[{\"funcscope_category\":{\"id\":1}},{\"funcscope_category\":{\"id\":15}},{\"funcscope_category\":{\"id\":4}},{\"funcscope_category\":{\"id\":7}},{\"funcscope_category\":{\"id\":2}},{\"funcscope_category\":{\"id\":3}},{\"funcscope_category\":{\"id\":11}},{\"funcscope_category\":{\"id\":6}}]}}";
        QueryAuthBean queryAuthBean = JSON.parseObject(json, QueryAuthBean.class);
        logger.info(queryAuthBean.getAuthOrizationInfo().getFuncInfoList().toString());
    }





    //@Test
    public void testDao(){
      /*  FuncInfoMapper mapper = (FuncInfoMapper) ctx.getBean("funcInfoMapper");
        mapper.insert(new FuncInfo(){
            {
                //setAuthorizerInfoId(1L);
                setFuncName(1);
            }
        });*/
    }


    //@Test
    public void testHandle(){
        WxMpXmlMessage message3 = new WxMpXmlMessage();
        message3.setContent("123");
        WxMpService wxMpService = new WxMpServiceImpl();
        WxMpMessageRouter router = new WxMpMessageRouter(wxMpService);
        router.rule().content("123").handler(new WxMpMessageHandler(){

            @Override
            public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {
                return WxMpXmlOutMessage.TEXT()
                        .content("content")
                        .fromUser("from")
                        .toUser("to")
                        .build();
            }
        }).end();
        WxMpXmlOutMessage out = router.route(message3);
        logger.info(out.toString());
    }

    @Test
    public void testJson(){
        String str = "{\n" +
                "    \"is_add_friend_reply_open\": 1,\n" +
                "    \"is_autoreply_open\": 1,\n" +
                "    \"add_friend_autoreply_info\": {\n" +
                "        \"type\": \"text\",\n" +
                "        \"content\": \"Thanks for your attention!\"\n" +
                "    },\n" +
                "    \"message_default_autoreply_info\": {\n" +
                "        \"type\": \"text\",\n" +
                "        \"content\": \"Hello, this is autoreply!\"\n" +
                "    },\n" +
                "    \"keyword_autoreply_info\": {\n" +
                "        \"list\": [\n" +
                "            {\n" +
                "                \"rule_name\": \"autoreply-news\",\n" +
                "                \"create_time\": 1423028166,\n" +
                "                \"reply_mode\": \"reply_all\",\n" +
                "                \"keyword_list_info\": [\n" +
                "                    {\n" +
                "                        \"type\": \"text\",\n" +
                "                        \"match_mode\": \"contain\",\n" +
                "                        \"content\": \"news测试\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"reply_list_info\": [\n" +
                "                    {\n" +
                "                        \"type\": \"news\",\n" +
                "                        \"news_info\": {\n" +
                "                            \"list\": [\n" +
                "                                {\n" +
                "                                    \"title\": \"it's news\",\n" +
                "                                    \"author\": \"jim\",\n" +
                "                                    \"digest\": \"it's digest\",\n" +
                "                                    \"show_cover\": 1,\n" +
                "                                    \"cover_url\": \"http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfKbE8sWdt2DDcL0dMfQWJWTVn1N8DxI0gcRmrtqBOuwQH\\n  euPKmFLK0ZQ/0\",\n" +
                "                                    \"content_url\": \"http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=203929886&idx=1&sn=628f964cf0c6d84c026881b6959aea8b#rd\",\n" +
                "                                    \"source_url\": \"http://www.url.com\"\n" +
                "                                }\n" +
                "                            ]\n" +
                "                        }\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"type\": \"news\",\n" +
                "                        \"content\": \"KQb_w_Tiz-nSdVLoTV35Psmty8hGBulGhEdbb9SKs-o\",\n" +
                "                        \"news_info\": {\n" +
                "                            \"list\": [\n" +
                "                                {\n" +
                "                                    \"title\": \"MULTI_NEWS\",\n" +
                "                                    \"author\": \"JIMZHENG\",\n" +
                "                                    \"digest\": \"text\",\n" +
                "                                    \"show_cover\": 0,\n" +
                "                                    \"cover_url\": \"http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfK0HKuBIa1A1cypS0uY1wickv70iaY1gf3I1DTszuJoS3lAVLv\\nhTcm9sDA/0\",\n" +
                "                                    \"content_url\": \"http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=204013432&idx=1&sn=80ce6d9abcb832237bf86c87e50fda15#rd\",\n" +
                "                                    \"source_url\": \"\"\n" +
                "                                },\n" +
                "                                {\n" +
                "                                    \"title\": \"MULTI_NEWS4\",\n" +
                "                                    \"author\": \"JIMZHENG\",\n" +
                "                                    \"digest\": \"MULTI_NEWSMULTI_NEWSMULTI_NEWSMULTI_NEWSMULTI_NEWSMULT\",\n" +
                "                                    \"show_cover\": 1,\n" +
                "                                    \"cover_url\": \"http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfKbE8sWdt2DDcL0dMfQWJWTVn1N8DxI0gcRmrtqBOuwQ\\nHeuPKmFLK0ZQ/0\",\n" +
                "                                    \"content_url\": \"http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=204013432&idx=5&sn=b4ef73a915e7c2265e437096582774af#rd\",\n" +
                "                                    \"source_url\": \"\"\n" +
                "                                }\n" +
                "                            ]\n" +
                "                        }\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"rule_name\": \"autoreply-voice\",\n" +
                "                \"create_time\": 1423027971,\n" +
                "                \"reply_mode\": \"random_one\",\n" +
                "                \"keyword_list_info\": [\n" +
                "                    {\n" +
                "                        \"type\": \"text\",\n" +
                "                        \"match_mode\": \"contain\",\n" +
                "                        \"content\": \"voice测试\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"reply_list_info\": [\n" +
                "                    {\n" +
                "                        \"type\": \"voice\",\n" +
                "                        \"content\": \"NESsxgHEvAcg3egJTtYj4uG1PTL6iPhratdWKDLAXYErhN6oEEfMdVyblWtBY5vp\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"rule_name\": \"autoreply-text\",\n" +
                "                \"create_time\": 1423027926,\n" +
                "                \"reply_mode\": \"random_one\",\n" +
                "                \"keyword_list_info\": [\n" +
                "                    {\n" +
                "                        \"type\": \"text\",\n" +
                "                        \"match_mode\": \"contain\",\n" +
                "                        \"content\": \"text测试\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"reply_list_info\": [\n" +
                "                    {\n" +
                "                        \"type\": \"text\",\n" +
                "                        \"content\": \"hello!text!\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"rule_name\": \"autoreply-video\",\n" +
                "                \"create_time\": 1423027801,\n" +
                "                \"reply_mode\": \"random_one\",\n" +
                "                \"keyword_list_info\": [\n" +
                "                    {\n" +
                "                        \"type\": \"text\",\n" +
                "                        \"match_mode\": \"equal\",\n" +
                "                        \"content\": \"video测试\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"reply_list_info\": [\n" +
                "                    {\n" +
                "                        \"type\": \"video\",\n" +
                "                        \"content\": \"http://61.182.133.153/vweixinp.tc.qq.com/1007_114bcede9a2244eeb5ab7f76d951df5f.f10.mp4?vkey=7183E5C952B16C3AB1991BA8138673DE1037CB82A29801A504B64A77F691BF9DF7AD054A9B7FE683&sha=0&save=1\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";


    }


    /*@Test
    public void testBatch(){
        BusinessInfoMapper businessInfoMapper = (BusinessInfoMapper)ctx.getBean("businessInfoMapper");
        List<BusinessInfo> businessInfoList = Stream.of(new BusinessInfo(123L, BusinessInfoEnum.OPEN_CARD.key(),1),new BusinessInfo(123L, BusinessInfoEnum.OPEN_CARD.key(),1)).collect(Collectors.toList());
        businessInfoMapper.batchInsert(businessInfoList);
     }*/


}
