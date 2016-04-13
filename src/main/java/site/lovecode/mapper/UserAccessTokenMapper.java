package site.lovecode.mapper;

import site.lovecode.common.mybatis.MyMapper;
import site.lovecode.entity.UserAccessToken;
import tk.mybatis.mapper.common.Mapper;

public interface UserAccessTokenMapper extends MyMapper<UserAccessToken> {

    Integer updateToken(UserAccessToken userAccessToken);
}