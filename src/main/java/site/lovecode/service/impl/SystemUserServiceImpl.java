package site.lovecode.service.impl;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Service;
import site.lovecode.entity.SystemUser;
import site.lovecode.mapper.SystemUserMapper;
import site.lovecode.service.SystemUserService;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/4/15.
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Resource
    public SystemUserMapper systemUserMapper;

    @Override
    public boolean checkUsernameAndPassword(String username,String password) {
        SystemUser systemUser = systemUserMapper.selectOne(new SystemUser(){
            {
                setUserName(username);
            }
        });
        if(systemUser!=null){
            if(systemUser.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
