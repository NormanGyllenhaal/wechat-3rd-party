package site.lovecode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2016/4/15.
 */
@Controller
public class OfficialAccountController {

    @RequestMapping("/binding.html")
    public ModelAndView binging(){
       return new ModelAndView("binding");
    }
}
