/**
 * UserDataServiceImpl.java site.lovecode.wechat.service.impl
 * Copyright (c) 2016, norman.
 */


package site.lovecode.wechat.service.impl;


import org.springframework.stereotype.Service;
import site.lovecode.wechat.dto.PersonalUserGroupDto;
import site.lovecode.wechat.dto.PersonalUserGroupJoinDto;
import site.lovecode.wechat.entity.UserData;
import site.lovecode.wechat.mapper.OrgOfficialAccountMapper;
import site.lovecode.wechat.mapper.PersonalUserMapper;
import site.lovecode.wechat.mapper.UserDataMapper;
import site.lovecode.wechat.service.IUserDataService;
import site.lovecode.wechat.util.Page;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;


/**
 * 用户数据业务逻辑实现类
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月20日 
 * @version  1.0.0	 
 */
@Service
public class UserDataServiceImpl implements IUserDataService {

	@Resource
	private UserDataMapper userDataMapper;

	@Resource
	private PersonalUserMapper personalUserMapper;

	@Resource
	private OrgOfficialAccountMapper orgOfficialAccountMapper;


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
	@Override
	public Page<UserData> getUserDataPageByTerm(
			Page<UserData> page, Date beginDate, Date endDate, Integer userSource, Long orgId ) {
		userDataMapper.selectByItem(page, beginDate, endDate, userSource, getOaid(orgId));
		return page;
	}


	/**
	 * 获取用户属性分析数据
	 * @param orgId 机构id
	 * @return
	 */
	@Override
	public PersonalUserGroupJoinDto getUserProperty(Long orgId ) {
		return personalUserMapper.selectGroupBy(getOaid(orgId));
	}


	/**
	 * 根据用户省份获取用户人数统计
	 * @param orgId
	 * @param province
	 * @return
	 */
	@Override
	public List<PersonalUserGroupDto> getUserCountByProvince(Long orgId, String province) {
		return personalUserMapper.selectUserCountByProvince(getOaid(orgId),province);
	}


	@Override
	public List<UserData> getUserDataList(Date beginDate, Date endDate, Integer userSource, Long orgId) {
		return userDataMapper.selectByItem(null,beginDate,endDate,userSource,getOaid(orgId));
	}


	Long getOaid( Long orgId ) {
		return orgOfficialAccountMapper.getOfficialAccountIdByOrgId(orgId);
	}


}
