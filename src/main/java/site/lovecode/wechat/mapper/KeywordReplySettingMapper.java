package site.lovecode.wechat.mapper;


import org.apache.ibatis.annotations.Param;
import site.lovecode.wechat.common.mybatis.CommonMapper;
import site.lovecode.wechat.dto.KeywordReplySettingDto;
import site.lovecode.wechat.entity.KeywordReplySetting;

import java.util.List;

public interface KeywordReplySettingMapper extends CommonMapper<KeywordReplySetting> {

	List<KeywordReplySettingDto> selectJoin(
			@Param("officialAccountId") Long officialAccountId, @Param("replyOpen") Integer replyOpen,
			@Param("plat") Integer plat);
}
