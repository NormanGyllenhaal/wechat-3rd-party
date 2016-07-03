package site.lovecode.wechat.mapper;


import org.apache.ibatis.annotations.Param;
import site.lovecode.wechat.common.mybatis.CommonMapper;
import site.lovecode.wechat.entity.AuthorizerInfo;

public interface AuthorizerInfoMapper extends CommonMapper<AuthorizerInfo> {

	Integer updateAuthorizationStatus(
			@Param("authorizationStatus") Integer authorizationStatus,
			@Param("authorizerAppid") String authorizerAppid);
}
