package site.lovecode.controller;

import me.chanjar.weixin.common.exception.WxErrorException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import site.lovecode.service.TempMessageService;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/5/3.
 */
@Controller
public class TempMessageController {

    @Resource
    private TempMessageService tempMessageService;

    @RequestMapping("/sendTempMessage.html")
    public void sendTempMessage() throws WxErrorException {
           tempMessageService.sendTempMessage();
    }
}
