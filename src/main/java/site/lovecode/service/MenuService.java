package site.lovecode.service;

import me.chanjar.weixin.common.exception.WxErrorException;

/**
 * Created by Administrator on 2016/4/19.
 */
public interface MenuService {

    void createMenu() throws WxErrorException;


    void getMeun() throws WxErrorException;
}
