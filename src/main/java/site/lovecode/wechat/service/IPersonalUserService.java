package site.lovecode.wechat.service;


import me.chanjar.weixin.common.exception.WxErrorException;
import site.lovecode.wechat.dto.PersonalUserDto;
import site.lovecode.wechat.entity.PersonalUser;
import site.lovecode.wechat.util.Page;

import java.util.List;

/**
 * Created by Administrator on 2016/4/20.
 */
public interface IPersonalUserService {


	/**
	 * 
	 * 强制刷新所用用户
	 * <p>
	 * 
	 *
	 * @param orgId
	 * @return
	 * @throws WxErrorException TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	public List<PersonalUser> refreshPersonlUser(Long orgId) throws WxErrorException;


	/**
	 * 
	 * 获取指定公众号下的所用用户
	 * <p>
	 * 
	 *
	 * @param orgId  公众号id
	 * @return 用户信息
	 */
	public List<PersonalUser> getPersonUserList(Long orgId);


	/**
	 * 
	 * 分页查询指定公众号所有用户和用户标签
	 * <p>R
	 * 
	 *
	 * @param orgId
	 * @return 
	 */
	public Page<PersonalUserDto> getPersonUserByPage(Page<PersonalUserDto> page, Long orgId);


	/**
	 * 
	 * 根据用户id获取用户
	 * <p>
	 * 
	 *
	 * @param personalUserId 用户id
	 * @return 
	 */
	public PersonalUserDto getPersonalUser(Long personalUserId);


	/**
	 * 
	 * 批量更改用户状态
	 * <p>
	 * 
	 *
	 * @param page
	 * @param personalUserIdList
	 * @param orgId
	 * @param status
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	public Page<PersonalUserDto> batchChangeStatus(
			Page<PersonalUserDto> page, List<Long> personalUserIdList, Long orgId, Integer status);


	/**
	 * 
	 * 获取公众号下用户数量
	 * <p>
	 * 
	 *
	 * @param orgId
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	public Integer getPersonUserCount(Long orgId);


	/**
	 * 
	 * 根据用户昵称查询用户列表
	 * <p>
	 * 
	 *
	 * @param page 分页对象
	 * @param orgId 公众号id
	 * @param nickName 昵称
	 * @return 
	 */
	public Page<PersonalUserDto> getPersonUserByNickName(Page<PersonalUserDto> page, Long orgId, String nickName);


	/**
	 * 
	 * 根据用户标签获取用户分页对象
	 * <p>
	 * 
	 *
	 * @param page 分页对象
	 * @param orgId 公众号id
	 * @param tagId 标签id
	 * @return 
	 */
	public Page<PersonalUserDto> getPersonUserByTags(Page<PersonalUserDto> page, Long orgId, Integer tagId);


	/**
	 * 
	 * 修改一个用户的标签
	 * <p>
	 * 
	 *
	 * @param personalUserId 用户id
	 * @param tagIdList 标签id
	 * @return 
	 */
	public PersonalUserDto addPersonalUserTags(Long personalUserId, List<Integer> tagIdList, Long orgId)
		throws Exception;


	/**
	 * 
	 * 批量为用户添加标签
	 * <p>
	 * 
	 *
	 * @param page 用户分页对象
	 * @param orgId 公众号id
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 * @throws WxErrorException 
	 */
	public Page<PersonalUserDto> batchAddUserTags(
			Page<PersonalUserDto> page, Long orgId, List<Long> personalUserIdList, List<Integer> tagIdList)
		throws WxErrorException;


	/**
	 * 
	 * 修改用户备注名称
	 * <p>
	 * 
	 *
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 * @throws WxErrorException 
	 */
	public PersonalUserDto modifyRemark(String remark, Long personalUserId, Long orgId) throws WxErrorException;


	/**
	 * 
	 * 修改用户绑定状态
	 * <p>
	 * 
	 *
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 * @throws WxErrorException 
	 */
	public PersonalUserDto modifyBind(Integer isBind, Long personalUserId) throws WxErrorException;
}
