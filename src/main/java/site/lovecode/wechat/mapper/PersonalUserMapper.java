package site.lovecode.wechat.mapper;


import org.apache.ibatis.annotations.Param;
import site.lovecode.wechat.common.mybatis.CommonMapper;
import site.lovecode.wechat.dto.PersonalUserDto;
import site.lovecode.wechat.dto.PersonalUserGroupDto;
import site.lovecode.wechat.dto.PersonalUserGroupJoinDto;
import site.lovecode.wechat.dto.PersonalUserTermDto;
import site.lovecode.wechat.entity.PersonalUser;
import site.lovecode.wechat.util.Page;

import java.util.List;

public interface PersonalUserMapper extends CommonMapper<PersonalUser> {


	/**
	 * 
	 * 删除指定条件的用户
	 * <p>
	 * 
	 *
	 * @param oaid
	 * @return 
	 */
	Integer deleteByOfficialAccountIdAndSubscribe(Long oaid);


	/**
	 * 
	 * 按条件查询用户数据
	 * <p>
	 *
	 *
	 * @param page 分页对象
	 * @return 
	 */
	List<PersonalUserDto> selectJoinTags(
			@Param("page") Page<PersonalUserDto> page, @Param("term") PersonalUserTermDto term);


	/**
	 * 
	 * 根据用户标签查询用户的信息和标签信息
	 * <p>
	 * 
	 *
	 * @param page
	 * @param term
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	List<PersonalUserDto> selectJoinByTags(
			@Param("page") Page<PersonalUserDto> page, @Param("term") PersonalUserTermDto term);


	/**
	 * 
	 * 根据主键查询openid
	 * <p>
	 * 
	 *
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	List<String> selectInId(@Param("idList") List<Long> idList);


	/**
	 * 
	 * 查询用户属性统计数据
	 * <p>
	 * 
	 *
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	PersonalUserGroupJoinDto selectGroupBy(@Param("oaid") Long oaid);


	/**
	 * 根据省份查用户城市分布人数
	 * @param oaid
	 * @param province
	 * @return
     */
	List<PersonalUserGroupDto> selectUserCountByProvince(@Param("oaid") Long oaid, @Param("province") String province);
}
