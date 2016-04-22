package site.lovecode.service.impl;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import site.lovecode.client.WechatClient;
import site.lovecode.client.WechatFactory;
import site.lovecode.entity.PersonalUser;
import site.lovecode.mapper.PersonalUserMapper;
import site.lovecode.service.PersonalUserService;
import site.lovecode.service.WechatService;
import site.lovecode.support.bean.json.UserInfoListResp;
import site.lovecode.support.bean.json.UserInfoResp;
import site.lovecode.util.IdWorker;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2016/4/20.
 */
@Service
public class PersonalUserServiceImpl implements PersonalUserService {

    private Logger logger  = LoggerFactory.getLogger(this.getClass());

    @Resource
    private WechatFactory wechatFactory;



    @Resource
    private PersonalUserMapper personalUserMapper;

    @Override
    public List<PersonalUser> refreshPersonlUser(Long oaid) throws WxErrorException {
        WechatClient wechatClient =  wechatFactory.getWechatClient();
        WxMpUserList wxMpUserList = wechatClient.userList(null);
        List<UserInfoResp> userList = wechatClient.getUserList(wxMpUserList.getOpenIds());
        List<PersonalUser> personalUserList =userList.stream().map(userInfoResp -> new PersonalUser(){
            {
                setOfficialAccountId(oaid);
                setOpenid(userInfoResp.getOpenid());
                setSubscribe(userInfoResp.getSubscribe());
                setNickName(userInfoResp.getNickname());
                setSex(userInfoResp.getSex());
                setCity(userInfoResp.getCity());
                setCountry(userInfoResp.getCountry());
                setProvince(userInfoResp.getProvince());
                setLanguage(userInfoResp.getLanguage());
                setHeadimgurl(userInfoResp.getHeadimgurl());
                setSubscribeTime(new Timestamp(userInfoResp.getSubscribeTime()*1000));
                setUnionid(userInfoResp.getUnionid());
                setRemark(userInfoResp.getRemark());
                setGroupid(userInfoResp.getGrounpid());
            }
        }).collect(Collectors.toList());
        personalUserMapper.deleteByOfficialAccountIdAndSubscribe(oaid);
        //personalUserMapper.batchInsert(personalUserList);
        return personalUserList;
    }
}
