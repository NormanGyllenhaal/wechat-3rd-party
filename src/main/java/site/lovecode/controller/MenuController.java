package site.lovecode.controller;

import me.chanjar.weixin.common.exception.WxErrorException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import site.lovecode.service.MenuService;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/4/19.
 */
@Controller
public class MenuController {

    @Resource
    private MenuService menuService;


    @RequestMapping("/createMenu.html")
    public String createMenu(){
        try {
            menuService.createMenu();
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return "menu";
    }
}
