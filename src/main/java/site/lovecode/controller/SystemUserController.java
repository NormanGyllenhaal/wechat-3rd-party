package site.lovecode.controller;

import me.chanjar.weixin.common.exception.WxErrorException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import site.lovecode.service.SystemUserService;
import site.lovecode.service.WechatThridPartyService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2016/4/15.
 */
@Controller
public class SystemUserController  {

    @Resource
    private SystemUserService systemUserService;

    @Resource
    private WechatThridPartyService wechatThridPartyService;


    @RequestMapping("/login.html")
    public ModelAndView login(Model model){
         return new ModelAndView("login");
    }

    @RequestMapping("/check.html")
    public String checkPassword(String username, String password, Model model, RedirectAttributes attr, HttpSession httpSession) throws WxErrorException {
        if(systemUserService.checkUsernameAndPassword(username,password)){
            try {
                model.addAttribute("url", wechatThridPartyService.getCompoentLoginUrl());
                httpSession.setAttribute("username",username);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "index";
        }else{
            attr.addAttribute("msg","用户名或密码错误");
            return "redirect:/login.html";
        }
    }



}
