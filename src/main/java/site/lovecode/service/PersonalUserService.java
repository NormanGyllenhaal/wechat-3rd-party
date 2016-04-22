package site.lovecode.service;

import me.chanjar.weixin.common.exception.WxErrorException;
import site.lovecode.entity.PersonalUser;

import java.util.List;

/**
 * Created by Administrator on 2016/4/20.
 */
public interface PersonalUserService {


    public List<PersonalUser> refreshPersonlUser(Long oaid) throws WxErrorException;
}
