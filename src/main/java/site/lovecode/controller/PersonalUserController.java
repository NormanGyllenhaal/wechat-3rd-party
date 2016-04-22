package site.lovecode.controller;

import me.chanjar.weixin.common.exception.WxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import site.lovecode.entity.PersonalUser;
import site.lovecode.service.PersonalUserService;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by Administrator on 2016/4/20.
 */
@Controller
public class PersonalUserController {

    private Logger logger = LoggerFactory.getLogger(PersonalUserController.class);

    @Resource
    private PersonalUserService personalUserService;


    @RequestMapping("refreshUserList.html")
    public String userList(Long oaid,Model model) throws WxErrorException {
        logger.info(oaid.toString());
        List<PersonalUser> personalUserList = personalUserService.refreshPersonlUser(oaid);
        model.addAttribute("list",personalUserList);
        return "userList";
    }


}
