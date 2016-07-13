/**
 * IUserDataModule.java cn.vko.peixun.core.module.communication Copyright (c)
 * 2016, .
 */


package site.lovecode.wechat.module;


import site.lovecode.wechat.dto.PersonalUserGroupDto;
import site.lovecode.wechat.dto.PersonalUserGroupJoinDto;
import site.lovecode.wechat.entity.UserData;
import site.lovecode.wechat.support.common.Response;
import site.lovecode.wechat.util.Page;

import java.sql.Date;
import java.util.List;


/**
 * 用户数据服务层
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月20日
 * @version  1.0.0
 */


public interface IUserDataModule {


	/**
	 * 
	 * 分页获取用户分析数据
	 * <p>
	 * 
	 *
	 * @param page 分页对象
	 * @param beginDate 开始时间
	 * @param endDate 结束时间
	 * @param userSource 关注方式
	 * @param orgId 机构id 
	 * @return 分页对象
	 */
	Response<Page<UserData>> getUserDataPage(
			Page<UserData> page, Date beginDate, Date endDate, Integer userSource, Long orgId);


	/**
	 * 获取用户属性分析数据
	 * @param orgId 机构id
	 * @return
	 */
	 Response<PersonalUserGroupJoinDto> getUserProperty(Long orgId);



	/**
	 * 根据省份获取用户人数统计数据
	 * @param orgId
	 * @param province
	 * @return
	 */
	 Response<List<PersonalUserGroupDto>> getUserByProvince(Long orgId, String province);



	/**
	 * 获取用户数据列表
	 * @param beginDate
	 * @param endDate
	 * @param userSource
	 * @param orgId
	 * @return
	 */
	 Response<List<UserData>> getUserDataList(Date beginDate, Date endDate, Integer userSource, Long orgId);

}
