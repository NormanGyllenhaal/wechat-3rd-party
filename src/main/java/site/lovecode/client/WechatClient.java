package site.lovecode.client;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import site.lovecode.support.bean.json.UserInfoListResp;
import site.lovecode.support.bean.json.UserInfoResp;

import java.util.List;

/**
 * Created by Administrator on 2016/4/20.
 */
public interface WechatClient extends WxMpService {

    List<UserInfoResp> getUserList(List<String> openidList) throws WxErrorException;
}
