package site.lovecode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/4/18.
 */
@Controller
public class ErrorController {

    @RequestMapping("/404.html")
    public String pageNotFound(){
       return "404";
    }
}
