package site.lovecode.service.impl;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import site.lovecode.client.WechatFactory;
import site.lovecode.service.MenuService;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/4/19.
 */
@Service
public class MenuServiceImpl implements MenuService {

    private Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Resource
    private WechatFactory wechatFactory;


    @Override
    public void createMenu() throws WxErrorException {
        WxMpService wxMpService = wechatFactory.getWxMpService();
        WxMpUserList wxUserList = wxMpService.userList(null);
        logger.info(wxUserList.getOpenIds().toString());
        WxMpUser user = wxMpService.userInfo(wxUserList.getOpenIds().get(0), "zh_CN");
        logger.info(user.toString());
    }


}
