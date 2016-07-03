package site.lovecode.wechat.mapper;


import site.lovecode.wechat.common.mybatis.CommonMapper;
import site.lovecode.wechat.entity.AuthorizerAccessToken;

public interface AuthorizerAccessTokenMapper extends CommonMapper<AuthorizerAccessToken> {

	Integer updateToken(AuthorizerAccessToken authorizerAccessToken);
}
