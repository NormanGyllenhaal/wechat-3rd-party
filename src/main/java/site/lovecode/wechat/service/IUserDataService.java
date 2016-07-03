/**
 * IUserDataService.java site.lovecode.wechat.service Copyright
 * (c) 2016, norman.
 */


package site.lovecode.wechat.service;


import site.lovecode.wechat.dto.PersonalUserGroupDto;
import site.lovecode.wechat.dto.PersonalUserGroupJoinDto;
import site.lovecode.wechat.entity.UserData;
import site.lovecode.wechat.util.Page;

import java.sql.Date;
import java.util.List;


/**
 * 用户数据逻辑业务接口
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月20日
 * @version  1.0.0
 */
public interface IUserDataService {


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
	Page<UserData> getUserDataPageByTerm(
			Page<UserData> page, Date beginDate, Date endDate, Integer userSource, Long orgId);


	/**
	 * 获取用户属性分析数据
	 * @param orgId 机构id
	 * @return
	 */
	 PersonalUserGroupJoinDto getUserProperty(Long orgId);


	/**
	 * 根据用户省份获取用户人数统计
	 * @param orgId
	 * @param province
	 * @return
     */
	List<PersonalUserGroupDto> getUserCountByProvince(Long orgId, String province);


    /**
	 * 根据条件获取用户数据列表
	 * @param beginDate
	 * @param endDate
	 * @param userSource
	 * @param orgId
     * @return
     */
	List<UserData> getUserDataList(Date beginDate, Date endDate, Integer userSource, Long orgId);

}
