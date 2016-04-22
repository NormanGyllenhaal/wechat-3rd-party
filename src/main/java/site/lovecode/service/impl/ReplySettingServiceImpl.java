package site.lovecode.service.impl;

import me.chanjar.weixin.common.exception.WxErrorException;
import org.springframework.stereotype.Service;
import site.lovecode.client.WechatClient;
import site.lovecode.client.WechatFactory;
import site.lovecode.service.ReplySettingService;
import site.lovecode.support.bean.json.AutoReplyInfoBean;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/4/22.
 */
@Service
public class ReplySettingServiceImpl implements ReplySettingService{

    @Resource
    private WechatFactory wechatFactory;

    @Override
    public void getAutoReplySetting(Long oaid) throws WxErrorException {
         WechatClient wechatClient = wechatFactory.getWechatClient();
         AutoReplyInfoBean autoReplyInfoBean = wechatClient.getCurrentAutoreplyInfo();


    }
}
