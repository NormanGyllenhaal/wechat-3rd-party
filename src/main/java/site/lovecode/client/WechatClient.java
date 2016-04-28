package site.lovecode.client;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import site.lovecode.support.bean.json.*;

import java.util.List;

/**
 * Created by Administrator on 2016/4/20.
 */
public interface WechatClient extends WxMpService {

    /**
     * 批量获取用户基本信息
     * @param openidList
     * @return
     * @throws WxErrorException
     */
    List<UserInfoResp> getUserList(List<String> openidList) throws WxErrorException;

    /**
     * 获取用户自动回复配置
     * @return
     * @throws WxErrorException
     */
    AutoReplyInfoBean getCurrentAutoreplyInfo() throws WxErrorException;

    /**
     * 创建菜单
     * @param menuBean
     * @throws WxErrorException
     */
    void createMeun(MenuBean menuBean) throws WxErrorException;


    /**
     * 获取用户微信后台的菜单配置
     * @return
     * @throws WxErrorException
     */
    SelfMenuInfoBean getSelfMenu() throws  WxErrorException;





}
