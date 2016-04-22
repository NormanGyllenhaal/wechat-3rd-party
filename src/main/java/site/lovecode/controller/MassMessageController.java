package site.lovecode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/4/20.
 */
@Controller
public class MassMessageController {

    @RequestMapping("massMessage.html")
    public String massMessage(){
        return "massMessage";
    }



    @RequestMapping("sendMassMessage.html")
    public String sendMassMessage(Model model,String text,Long oaid){
        return "massMessage";
    }
}
