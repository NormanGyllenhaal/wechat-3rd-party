package site.lovecode.mapper;


import org.apache.ibatis.annotations.Param;
import site.lovecode.common.mybatis.CommonMapper;
import site.lovecode.entity.OfficialAccountAccessToken;


public interface OfficialAccountAccessTokenMapper extends CommonMapper<OfficialAccountAccessToken> {


	Integer updateByOfficialAccount(
			@Param("accessToken") String accessToken, @Param("expiresIn") Long expiresIn,
			@Param("officialAccountId") Long officialAccountId);
}
