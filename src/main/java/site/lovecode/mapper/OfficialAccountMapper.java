package site.lovecode.mapper;

import site.lovecode.common.mybatis.CommonMapper;
import site.lovecode.entity.OfficialAccount;
import site.lovecode.support.bean.vo.OfficialAccountVo;

import java.util.List;

public interface OfficialAccountMapper extends CommonMapper<OfficialAccount> {

    List<OfficialAccountVo> selectJoinAuthorizerInfo();

    List<OfficialAccountVo> selectJoinInfoAndAccessToken();
}