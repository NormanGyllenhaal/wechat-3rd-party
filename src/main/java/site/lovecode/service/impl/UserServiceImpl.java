package site.lovecode.service.impl;

import org.springframework.stereotype.Service;
import site.lovecode.entity.User;
import site.lovecode.mapper.UserMapper;
import site.lovecode.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/3/25.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getUser() {
        return userMapper.selectAll();
    }
}
