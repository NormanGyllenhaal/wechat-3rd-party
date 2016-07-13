/**
 * PersonalUserModuleImpl.java cn.vko.peixun.module.communication.module
 * Copyright (c) 2016, .
 */


package site.lovecode.wechat.module.impl;


import me.chanjar.weixin.common.exception.WxErrorException;
import org.apache.struts.util.ModuleException;
import site.lovecode.wechat.dto.PersonalUserDto;
import site.lovecode.wechat.dto.PersonalUserTagsDto;
import site.lovecode.wechat.dto.TagsDto;
import site.lovecode.wechat.entity.PersonalUser;
import site.lovecode.wechat.entity.Tags;
import site.lovecode.wechat.module.IPersonalUserModule;
import site.lovecode.wechat.service.IPersonalUserService;
import site.lovecode.wechat.service.ITagsService;
import site.lovecode.wechat.support.common.Response;
import site.lovecode.wechat.support.enums.EnumConstants;
import site.lovecode.wechat.util.Page;

import javax.annotation.Resource;
import java.util.List;


/**
 * 微信粉丝管理业务员层
 * <p>
 *
 * @author   yangpeng
 * @date	 2016年5月10日 
 * @version  1.0.0	 
 */
public class PersonalUserModuleImpl extends AbstractModule implements IPersonalUserModule {


	@Resource
	private IPersonalUserService personalUserServiceImpl;


	@Resource
	private ITagsService tagsServiceImpl;


	@Override
	public Response<List<PersonalUser>> refreshPersonlUser(Long orgId ) throws ModuleException {
		try {
			return success(personalUserServiceImpl.refreshPersonlUser(orgId));
		} catch ( WxErrorException e ) {
			e.printStackTrace();
			throw new ModuleException(
					String.valueOf(e.getError().getErrorCode()), e.getError().getErrorMsg(), e.getCause());
		}
	}






	/**
	 * 
	 * 获取指定公众号下的所用用户
	 * <p>
	 * 
	 *
	 * @param orgId  公众号id
	 * @return 用户信息
	 */
	@Override
	public Response<List<PersonalUser>> getPersonUserList( Long orgId ) {
		return success(personalUserServiceImpl.getPersonUserList(orgId));
	}


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
	@Override
	public Response<Page<PersonalUserDto>> getPersonUserByPage(Page<PersonalUserDto> page, Long orgId ) {
		return success(personalUserServiceImpl.getPersonUserByPage(page, orgId));
	}


	/**
	 * 
	 * 根据用户id获取用户信息
	 * <p>
	 * 
	 *
	 * @param personalUserId 用户id
	 * @return 
	 */
	@Override
	public Response<PersonalUserDto> getPersonalUser( Long personalUserId ) {
		return success(personalUserServiceImpl.getPersonalUser(personalUserId));
	}


	/**
	 * 
	 * 获取公众号所有标签
	 * <p>
	 * 
	 *
	 * @param orgId
	 * @return 
	 */
	@Override
	public Response<TagsDto> getTags(Long orgId ) {
		return success(getTagsDto(orgId));
	}


    /**
	 * 获取用户分页列表和标签
	 * @param orgId
	 * @param page
	 * @return
     */
	public Response<PersonalUserTagsDto> getUserTags(Long orgId, Page<PersonalUserDto> page){
		return success(new PersonalUserTagsDto(personalUserServiceImpl.getPersonUserByPage(page, orgId),getTagsDto(orgId)));
	}

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
	@Override
	public Response<PersonalUserDto> modifyUserTags( Long orgId, Long personalUserId, List<Integer> tagIdList ) throws ModuleException {
		try {
			return success(personalUserServiceImpl.addPersonalUserTags(personalUserId, tagIdList, orgId));
		} catch ( Exception e ) {
			e.printStackTrace();
			throw new ModuleException("修改用户标签异常");
		}
	}


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
	@Override
	public Response<PersonalUserTagsDto> batchAddBlackList(
			Page<PersonalUserDto> page, Long orgId, List<Long> personalUserIdList ) {
		return success(new PersonalUserTagsDto(personalUserServiceImpl.batchChangeStatus(
			page, personalUserIdList, orgId, EnumConstants.PersonalUserOfStatus.blackList.key()), getTagDto(
			tagsServiceImpl.getTagsList(orgId), personalUserServiceImpl.getPersonUserCount(orgId))));
	}


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
	@Override
	public Response<PersonalUserTagsDto> batchRemoveBlackList(
			Page<PersonalUserDto> page, Long orgId, List<Long> personalUserIdList ) {
		return success(new PersonalUserTagsDto(personalUserServiceImpl.batchChangeStatus(
			page, personalUserIdList, orgId, EnumConstants.PersonalUserOfStatus.normal.key()), getTagDto(
			tagsServiceImpl.getTagsList(orgId), personalUserServiceImpl.getPersonUserCount(orgId))));
	}


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
	@Override
	public Response<TagsDto> createTags( Long orgId, String tagsName ) throws ModuleException {
		TagsDto tagsDto;
		try {
			tagsDto = getTagDto(
				tagsServiceImpl.createTags(orgId, tagsName), personalUserServiceImpl.getPersonUserCount(orgId));
		} catch ( WxErrorException e ) {
			e.printStackTrace();
			throw new ModuleException(
					String.valueOf(e.getError().getErrorCode()), e.getError().getErrorMsg(), e.getCause());
		}
		return success(tagsDto);
	}


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
	@Override
	public Response<Page<PersonalUserDto>> getPersonUserByNickName(
			Page<PersonalUserDto> page, Long orgId, String nickName ) {
		return success(personalUserServiceImpl.getPersonUserByNickName(page, orgId, nickName));
	}


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
	@Override
	public Response<Page<PersonalUserDto>> getPersonalUseryByTag( Page<PersonalUserDto> page, Long orgId, Integer tagId ) {
		return success(personalUserServiceImpl.getPersonUserByTags(page, orgId, tagId));
	}


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
	@Override
	public Response<PersonalUserDto> modifyRemark( String remark, Long personalUserId, Long orgId ) throws ModuleException {
		try {
			return success(personalUserServiceImpl.modifyRemark(remark, personalUserId, orgId));
		} catch ( WxErrorException e ) {
			e.printStackTrace();
			throw new ModuleException(
					String.valueOf(e.getError().getErrorCode()), e.getError().getErrorMsg(), e.getCause());
		}
	}


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
	@Override
	public Response<Page<PersonalUserDto>> batchAddUserTags(
			Page<PersonalUserDto> page, Long orgId, List<Long> personalUserIdList, List<Integer> tagIdList ) throws ModuleException {
		try {
			return success(personalUserServiceImpl.batchAddUserTags(page, orgId, personalUserIdList, tagIdList));
		} catch ( WxErrorException e ) {
			e.printStackTrace();
			throw new ModuleException(String.valueOf(e.getError().getErrorCode()), e.getMessage(), e.getCause());
		}
	}


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
	@Override
	public Response<TagsDto> modifyTags( Long orgId, String tagName, Long id ) throws ModuleException {
		try {
			List<Tags> tags = tagsServiceImpl.modifyTags(orgId, tagName, id);
			return success(getTagDto(tags, personalUserServiceImpl.getPersonUserCount(orgId)));
		} catch ( WxErrorException e ) {
			e.printStackTrace();
			throw new ModuleException(
					String.valueOf(e.getError().getErrorCode()), e.getError().getErrorMsg(), e.getCause());
		}
	}


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
	@Override
	public Response<TagsDto> deleteTags( Long orgId, Long id ) throws ModuleException {
		try {
			return success(getTagDto(
				tagsServiceImpl.deleteTag(orgId, id), personalUserServiceImpl.getPersonUserCount(orgId)));
		} catch ( WxErrorException e ) {
			e.printStackTrace();
			throw new ModuleException(
					String.valueOf(e.getError().getErrorCode()), e.getError().getErrorMsg(), e.getCause());
		}
	}


	private TagsDto getTagDto( List<Tags> tagsList, Integer userCount ) {
		TagsDto tagsDto = new TagsDto();
		tagsDto.setTagsList(tagsList);
		tagsDto.setUserCount(userCount);
		return tagsDto;
	}


	private TagsDto getTagsDto(Long orgId){
		TagsDto tagsDto = new TagsDto();
		tagsDto.setTagsList(tagsServiceImpl.getTagsList(orgId));
		tagsDto.setUserCount(personalUserServiceImpl.getPersonUserCount(orgId));
		return  tagsDto;
	}


}
