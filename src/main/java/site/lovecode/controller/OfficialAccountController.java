package site.lovecode.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import site.lovecode.mapper.OfficialAccountMapper;
import site.lovecode.service.OfficialAccountService;
import site.lovecode.support.bean.request.OfficialAccountReq;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/4/15.
 */
@Controller
public class OfficialAccountController {

    private Logger logger = LoggerFactory.getLogger(OfficialAccountController.class);

    @Resource
    private OfficialAccountService officialAccountService;

    @RequestMapping("/binding.html")
    public String binding(){
       return "binding";
    }

    @RequestMapping("/toBinding.html")
    public String toBinding(OfficialAccountReq officialAccountReq){
        logger.info(officialAccountReq.toString());
        officialAccountService.saveOfficialAccount(officialAccountReq);
        return "userinfo";
    }
}
