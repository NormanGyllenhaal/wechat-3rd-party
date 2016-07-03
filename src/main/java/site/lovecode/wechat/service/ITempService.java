package site.lovecode.wechat.service;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.WxMpTemplateMessage;

/**
 * Created by Administrator on 2016/6/22.
 */
public interface ITempService {


    void sendTempMessage(Long orgId, WxMpTemplateMessage wxMpTemplateMessage) throws WxErrorException;


}
