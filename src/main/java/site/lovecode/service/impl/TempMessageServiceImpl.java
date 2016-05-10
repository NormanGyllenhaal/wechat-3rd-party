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
        WxMpTemplateMessage wxMpTemplateMessage =  new WxMpTemplateMessage();
        wxMpTemplateMessage.setToUser(openid);
        wxMpTemplateMessage.setTemplateId("W6Y6ZVhkJJc2lxbcYt6mI57UYwWHfgl9VD9Dqa8NBac");
        wxMpTemplateMessage.setUrl("http://weixin.qq.com/download");
        wxMpTemplateMessage.getDatas().add(new WxMpTemplateData("first", "1"));
        wxMpTemplateMessage.getDatas().add(new WxMpTemplateData("keyword1", "2"));
        wxMpTemplateMessage.getDatas().add(new WxMpTemplateData("keyword2", "3"));
        wxMpTemplateMessage.getDatas().add(new WxMpTemplateData("keyword3", "4"));
        wxMpTemplateMessage.getDatas().add(new WxMpTemplateData("keyword4", "5"));
        wxMpTemplateMessage.getDatas().add(new WxMpTemplateData("remark", "恭喜你购买成功"));
        String json = wxMpTemplateMessage.toJson();
        wechatClient.templateSend(wxMpTemplateMessage);

    }
}
