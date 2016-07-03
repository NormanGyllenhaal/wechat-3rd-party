package site.lovecode.wechat.service;

import me.chanjar.weixin.common.exception.WxErrorException;

/**
 * Created by Administrator on 2016/5/3.
 */
public interface TempMessageService {


	void sendTempMessage() throws WxErrorException;
}
