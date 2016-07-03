package site.lovecode.wechat.mapper;


import org.apache.ibatis.annotations.Param;
import site.lovecode.wechat.common.mybatis.CommonMapper;
import site.lovecode.wechat.dto.OfficialAccountAuthorizerInfoDto;
import site.lovecode.wechat.dto.OfficialAccountDto;
import site.lovecode.wechat.entity.OfficialAccount;

import java.util.List;

public interface OfficialAccountMapper extends CommonMapper<OfficialAccount> {


	List<OfficialAccountDto> selectJoinAuthorizerAccessToken(@Param("id") Long id);


	List<OfficialAccountDto> selectJoinInfoAndAccessToken();


	List<OfficialAccountAuthorizerInfoDto> selectJoinAuthorizerInfo(
			@Param("accountType") Integer accountType, @Param("verifyTypeInfo") Integer verifyTypeInfo,
			@Param("authorizationStatus") Integer authorizationStatus);
}
