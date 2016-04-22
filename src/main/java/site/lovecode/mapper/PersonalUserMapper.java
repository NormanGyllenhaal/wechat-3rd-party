package site.lovecode.mapper;

import site.lovecode.common.mybatis.CommonMapper;
import site.lovecode.entity.PersonalUser;

public interface PersonalUserMapper extends CommonMapper<PersonalUser> {

    void deleteByOfficialAccountIdAndSubscribe(Long officialAccountId);
}