package site.lovecode.wechat.mapper;


import org.apache.ibatis.annotations.Param;
import site.lovecode.wechat.common.mybatis.CommonMapper;
import site.lovecode.wechat.entity.OfficialAccountAccessToken;

public interface OfficialAccountAccessTokenMapper extends CommonMapper<OfficialAccountAccessToken> {


	Integer updateByOfficialAccount(
			@Param("accessToken") String accessToken, @Param("expiresIn") Long expiresIn,
			@Param("officialAccountId") Long officialAccountId);
}
