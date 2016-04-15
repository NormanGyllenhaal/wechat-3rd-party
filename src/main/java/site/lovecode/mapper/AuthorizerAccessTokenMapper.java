package site.lovecode.mapper;

import site.lovecode.common.mybatis.CommonMapper;
import site.lovecode.entity.AuthorizerAccessToken;

public interface AuthorizerAccessTokenMapper extends CommonMapper<AuthorizerAccessToken> {

    Integer updateToken(AuthorizerAccessToken authorizerAccessToken);
}