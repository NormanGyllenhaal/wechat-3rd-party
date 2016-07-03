package site.lovecode.wechat.mapper;


import org.apache.ibatis.annotations.Param;
import site.lovecode.wechat.common.mybatis.CommonMapper;
import site.lovecode.wechat.entity.UserData;
import site.lovecode.wechat.util.Page;

import java.sql.Date;
import java.util.List;

public interface UserDataMapper extends CommonMapper<UserData> {


	List<UserData> selectByItem(
			@Param("page") Page<UserData> page, @Param("beginDate") Date beginDate,
			@Param("endDate") Date endDate, @Param("userSource") Integer userSource,
			@Param("officialAccountId") Long officialAccountId);
}
