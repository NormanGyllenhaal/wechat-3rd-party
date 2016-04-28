package site.lovecode.service.impl;

import me.chanjar.weixin.common.bean.WxMenu;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import site.lovecode.client.WechatClient;
import site.lovecode.client.WechatFactory;
import site.lovecode.service.MenuService;
import site.lovecode.support.bean.json.SelfMenuInfoBean;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/4/19.
 */
@Service
public class MenuServiceImpl implements MenuService {

    private Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Resource
    private WechatFactory wechatFactory;


    /**
     * 创建菜单
     * @throws WxErrorException
     */
    @Override
    public void createMenu() throws WxErrorException {
        WechatClient wechatClient = wechatFactory.getWechatClient();
        SelfMenuInfoBean selfMenu = wechatClient.getSelfMenu();
    }


    /**
     * 获取菜单
     * @throws WxErrorException
     */
    public void getMeun() throws WxErrorException {
        WechatClient wechatClient = wechatFactory.getWechatClient();
        WxMenu wxMenu = wechatClient.menuGet();
        logger.info(wxMenu.toString());
    }




}
