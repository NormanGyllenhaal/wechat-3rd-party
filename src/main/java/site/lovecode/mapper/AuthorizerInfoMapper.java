package site.lovecode.mapper;

import org.apache.ibatis.annotations.Param;
import site.lovecode.common.mybatis.CommonMapper;
import site.lovecode.entity.AuthorizerInfo;
import site.lovecode.support.bean.enums.AuthorizationStatusEnum;

public interface AuthorizerInfoMapper extends CommonMapper<AuthorizerInfo> {

    Integer updateAuthorizationStatus(@Param("authorizationStatus")Integer authorizationStatus , @Param("authorizerAppid")String authorizerAppid);
}