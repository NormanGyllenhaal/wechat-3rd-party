package site.lovecode.controller;

import me.chanjar.weixin.common.exception.WxErrorException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import site.lovecode.service.ReplySettingService;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/4/25.
 */
@Controller
public class ReplySettingController {

    @Resource
    private ReplySettingService replySettingService;

    @RequestMapping("/saveReplySetting.html")
    public String saveReplySetting(Long oaid) throws WxErrorException {
        replySettingService.getAutoReplySetting(oaid);
        return "accountList";
    }
}
