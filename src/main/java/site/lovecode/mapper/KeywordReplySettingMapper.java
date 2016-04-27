package site.lovecode.mapper;

import org.apache.ibatis.annotations.Param;
import site.lovecode.common.mybatis.CommonMapper;
import site.lovecode.entity.KeywordReplySetting;
import site.lovecode.support.bean.vo.KeywordReplySettingVo;

import java.util.List;

public interface KeywordReplySettingMapper extends CommonMapper<KeywordReplySetting> {

    List<KeywordReplySettingVo> selectJoin(@Param("officialAccountId") Long officialAccountId, @Param("replyOpen") Integer replyOpen, @Param("plat") Integer plat);
}