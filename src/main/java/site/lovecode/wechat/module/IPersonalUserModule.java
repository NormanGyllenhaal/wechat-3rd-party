/**
 * IPersonalUserModule.java cn.vko.peixun.core.module.communication Copyright
 * (c) 2016, .
 */


package site.lovecode.wechat.module;


import org.apache.struts.util.ModuleException;
import site.lovecode.wechat.dto.PersonalUserDto;
import site.lovecode.wechat.dto.PersonalUserTagsDto;
import site.lovecode.wechat.dto.TagsDto;
import site.lovecode.wechat.entity.PersonalUser;
import site.lovecode.wechat.support.common.Response;
import site.lovecode.wechat.util.Page;

import java.util.List;


/**
 * 粉丝管理业务逻辑层
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月10日 
 * @version  1.0.0	 
 */
public interface IPersonalUserModule {


	public Response<List<PersonalUser>> refreshPersonlUser(Long orgId) throws ModuleException;


	/**
	 * 
	 * 获取指定公众号下的所用用户
	 * <p>
	 * 
	 *
	 * @param orgId  公众号id
	 * @return 用户信息
	 */
	public Response<List<PersonalUser>> getPersonUserList(Long orgId);


	/**
	 * 
	 * 分页获取所用用户
	 * <p>
	 * 
	 *
	 * @param page 分页对象
	 * @param orgId 公众号id
	 * @return 
	 */
	public Response<Page<PersonalUserDto>> getPersonUserByPage(Page<PersonalUserDto> page, Long orgId);




	/**
	 * 获取用户分页列表和标签
	 * @param orgId
	 * @param page
	 * @return
	 */
	public Response<PersonalUserTagsDto> getUserTags(Long orgId, Page<PersonalUserDto> page);


	/**
	 * 
	 * 修改一个用户的标签
	 * <p>
	 * 
	 *
	 * @param orgId
	 * @param personalUserId
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	public Response<PersonalUserDto> modifyUserTags(Long orgId, Long personalUserId, List<Integer> tagIdList) throws ModuleException;


	/**
	 * 
	 * 批量添加用户到黑名单中
	 * <p>
	 * TODO(这里可以描述这个方法的执行逻辑，方便看客一目了然的了解代码含义，支持HTML格式化– 可选)
	 *
	 * @param page
	 * @param orgId
	 * @param personalUserIdList
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	public Response<PersonalUserTagsDto> batchAddBlackList(
			Page<PersonalUserDto> page, Long orgId, List<Long> personalUserIdList);


	/**
	 * 批量移除用户黑名单
	 * 
	 * <p>
	 * TODO(这里可以描述这个方法的执行逻辑，方便看客一目了然的了解代码含义，支持HTML格式化– 可选)
	 *
	 * @param page
	 * @param orgId
	 * @param personalUserIdList
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	public Response<PersonalUserTagsDto> batchRemoveBlackList(
			Page<PersonalUserDto> page, Long orgId, List<Long> personalUserIdList);


	/**
	 * 
	 * 获取公众号所有标签
	 * <p>
	 * 
	 *
	 * @param orgId
	 * @return 
	 */
	public Response<TagsDto> getTags(Long orgId);


	/**
	 * 
	 * 根据用户id获取用户信息
	 * <p>
	 * 
	 *
	 * @param personalUserId 用户id
	 * @return 
	 */
	public Response<PersonalUserDto> getPersonalUser(Long personalUserId);


	/**
	 * 
	 * 创建标签
	 * <p>
	 * 
	 *
	 * @param orgId 公众号id
	 * @param tagsName 标签名称
	 * @return
	 * @throws ModuleException 异常
	 */
	public Response<TagsDto> createTags(Long orgId, String tagsName) throws ModuleException;


	/**
	 * 
	 * 根据用户昵称获取用户分页列表
	 * <p>
	 * 
	 *
	 * @param page 分页对象
	 * @param orgId 公众号id
	 * @param nickName 昵称
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	public Response<Page<PersonalUserDto>> getPersonUserByNickName(
			Page<PersonalUserDto> page, Long orgId, String nickName);


	/**
	 * 
	 * 根据标签获取用户分页列表
	 * <p>
	 * 
	 *
	 * @param page 分页对象
	 * @param orgId 公众号id
	 * @param tagId 标签
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	public Response<Page<PersonalUserDto>> getPersonalUseryByTag(Page<PersonalUserDto> page, Long orgId, Integer tagId);


	/**
	 * 
	 * 批量添加用户标签信息
	 * <p>
	 * 
	 *
	 * @param page 分页对象
	 * @param orgId 公众号id
	 * @param personalUserIdList 用户id列表
	 * @param tagIdList  用户标签列表
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	public Response<Page<PersonalUserDto>> batchAddUserTags(
			Page<PersonalUserDto> page, Long orgId, List<Long> personalUserIdList, List<Integer> tagIdList) throws ModuleException;


	/**
	 * 
	 * 修改用户备注名
	 * <p>
	 * 
	 *
	 * @param remark
	 * @param personalUserId
	 * @param orgId
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	public Response<PersonalUserDto> modifyRemark(String remark, Long personalUserId, Long orgId) throws ModuleException;


	/**
	 * 
	 * 修改标签
	 * <p>
	 * 
	 *
	 * @param orgId 公众号id
	 * @param tagName 标签
	 * @param id 标签id
	 * @return
	 * @throws ModuleException 
	 */
	public Response<TagsDto> modifyTags(Long orgId, String tagName, Long id) throws ModuleException;


	/**
	 * 
	 * 删除标签
	 * <p>
	 * 
	 *
	 * @param orgId 公众号id
	 * @param id 标签id
	 * @return
	 * @throws ModuleException TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	Response<TagsDto> deleteTags(Long orgId, Long id) throws ModuleException;
}
