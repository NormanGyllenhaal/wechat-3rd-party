package site.lovecode.service.impl;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.WxMpTemplateMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import org.springframework.stereotype.Service;
import site.lovecode.client.WechatClient;
import site.lovecode.client.WechatFactory;
import site.lovecode.service.TempMessageService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/5/3.
 */
@Service
public class TempMessageServiceImpl implements TempMessageService {

    @Resource
    private WechatFactory wechatFactory;

    @Override
    public void sendTempMessage() throws WxErrorException {
        WechatClient wechatClient = wechatFactory.getWechatClient();
        WxMpUserList wxMpUserList = wechatClient.userList(null);
        List<String> openIds = wxMpUserList.getOpenIds();
        String openid = openIds.get(0);
        WxMpTemplateMessage wxMpTemplateMessage = new WxMpTemplateMessage() {
            {
                setToUser(openid);
                setTemplateId("ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY");
                setUrl("http://weixin.qq.com/download");
                getDatas().add(new WxMpTemplateData("first", "恭喜你购买成功"));
                getDatas().add(new WxMpTemplateData("keynote1", "恭喜你购买成功"));
                getDatas().add(new WxMpTemplateData("keynote2", "恭喜你购买成功"));
                getDatas().add(new WxMpTemplateData("keynote3", "恭喜你购买成功"));
                getDatas().add(new WxMpTemplateData("remark", "恭喜你购买成功"));
            }
        };
        String json = wxMpTemplateMessage.toJson();
        String j = "   {\n" +
                "           \"touser\":\""+openid+"\",\n" +
                "           \"template_id\":\"ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY\",\n" +
                "           \"url\":\"http://weixin.qq.com/download\",            \n" +
                "           \"data\":{\n" +
                "                   \"first\": {\n" +
                "                       \"value\":\"恭喜你购买成功！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keynote1\":{\n" +
                "                       \"value\":\"巧克力\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keynote2\": {\n" +
                "                       \"value\":\"39.8元\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keynote3\": {\n" +
                "                       \"value\":\"2014年9月22日\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"remark\":{\n" +
                "                       \"value\":\"欢迎再次购买！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   }\n" +
                "           }\n" +
                "       }";
        wechatClient.sendTemplateMessage(j);

    }
}
