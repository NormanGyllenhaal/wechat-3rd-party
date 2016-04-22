package site.lovecode.service;

import me.chanjar.weixin.common.exception.WxErrorException;

/**
 * Created by Administrator on 2016/4/22.
 */
public interface ReplySettingService {

    void getAutoReplySetting(Long oaid) throws WxErrorException;
}
