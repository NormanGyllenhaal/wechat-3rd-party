package site.lovecode.mapper;

import org.apache.ibatis.annotations.Param;
import site.lovecode.common.mybatis.MyMapper;
import site.lovecode.entity.AuthorizerInfo;

public interface AuthorizerInfoMapper extends MyMapper<AuthorizerInfo> {

     Integer updateAuthorizationStatus(@Param("authorizationStatus")Integer authorizationStatus,@Param("authorizerAppid")String authorizerAppid);
}