package site.lovecode.wechat.module.impl;


import org.springframework.stereotype.Service;
import site.lovecode.wechat.dto.PersonalUserGroupDto;
import site.lovecode.wechat.dto.PersonalUserGroupJoinDto;
import site.lovecode.wechat.entity.UserData;
import site.lovecode.wechat.module.IUserDataModule;
import site.lovecode.wechat.service.IUserDataService;
import site.lovecode.wechat.support.common.Response;
import site.lovecode.wechat.util.Page;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;


/**
 * 
 * 用户数据服务层
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月20日
 * @version  1.0.0
 */
@Service
public class UserDataModuleImpl extends AbstractModule implements IUserDataModule {


	@Resource
	private IUserDataService userDataServiceImpl;


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
	public Response<Page<UserData>> getUserDataPage(
			Page<UserData> page, Date beginDate, Date endDate, Integer userSource, Long orgId ) {
		return success(userDataServiceImpl.getUserDataPageByTerm(page, beginDate, endDate, userSource, orgId));

	}


	/**
	 * 获取用户属性分析数据
	 * @param orgId 机构id
	 * @return
	 */
	@Override
	public Response<PersonalUserGroupJoinDto> getUserProperty(Long orgId ) {
		return success(userDataServiceImpl.getUserProperty(orgId));
	}


	/**
	 * 根据省份获取用户人数统计数据
	 * @param orgId
	 * @param province
     * @return
     */
	@Override
	public Response<List<PersonalUserGroupDto>> getUserByProvince(Long orgId, String province){
		return success(userDataServiceImpl.getUserCountByProvince(orgId,province));
	}


	/**
	 * 获取用户数据列表
	 * @param beginDate
	 * @param endDate
	 * @param userSource
	 * @param orgId
     * @return
     */
	public Response<List<UserData>> getUserDataList(Date beginDate, Date endDate, Integer userSource, Long orgId){
		return success(userDataServiceImpl.getUserDataList(beginDate,endDate,userSource,orgId));
	}


}
