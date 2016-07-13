/**
 * PersonalUserController.java cn.vko.peixun.web.communicaion.controller
 * Copyright (c) 2016, .
 */


package site.lovecode.wechat.controller;


import org.apache.commons.lang.StringUtils;
import org.apache.struts.util.ModuleException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import site.lovecode.wechat.dto.PersonalUserIdReqDto;
import site.lovecode.wechat.dto.PersonalUserTagBatchReqDto;
import site.lovecode.wechat.dto.PersonalUserTagReqDto;
import site.lovecode.wechat.entity.PersonalUser;
import site.lovecode.wechat.module.IPersonalUserModule;

import javax.annotation.Resource;
import java.util.List;


/**
 * 用户粉丝管理
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月10日 
 * @version  1.0.0	 
 */
@Controller
@RequestMapping( "/communication/user" )
public class PersonalUserController extends BaseController {

	@Resource
	private IPersonalUserModule personalUserModuleImpl;


	/**
	 * 
	 * 获取微信粉丝列表和标签用户数
	 * <p>
	 *
	 * @param orgId
	 * @return 
	 */
	@RequestMapping( "/personalUserList" )
	public String getPersonalUserList( Long orgId) {
		return "communication/user/fan_management";
	}



	@RequestMapping("/getPersonalUserAjax")
	@ResponseBody
	public String getPersonalUserAjax(){
		return callback(personalUserModuleImpl.getUserTags(getOrgId(),getPage()).getBody(),"yyyy-MM-dd");
	}


	/**
	 * 
	 * 刷新指定公众账号数据库中的所有用户
	 * <p>
	 * 
	 *
	 * @param orgId
	 * @param model
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@RequestMapping( "/refershUserList" )
	public String refreshUserList( Long orgId, Model model ) throws ModuleException {
		List<PersonalUser> userList = personalUserModuleImpl.refreshPersonlUser(orgId).getBody();
		model.addAttribute("list", userList);
		return "communication/user_list";
	}


	/**
	 * 
	 * 根据用户id获取用户详细信息
	 * <p>
	 * 
	 *
	 * @param personalUserId 用户id
	 * @return 
	 */
	@RequestMapping( "/getUserById" )
	@ResponseBody
	public String getPersonalUser( Long personalUserId ) {
		return callbackSuccess(personalUserModuleImpl.getPersonalUser(personalUserId).getBody());
	}


	/**
	 * 
	 * 按照用户昵称查找用户列表
	 * <p>
	 * 
	 *
	 * @param nickName
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@RequestMapping( "/getUserByNickName" )
	@ResponseBody
	public String getUserByNickName( String nickName ) {
		return callbackSuccess(personalUserModuleImpl.getPersonUserByNickName(
				getPage(), getOrgId(), nickName).getBody());
	}


	/**
	 * 
	 * 按照用户标签查找用户列表
	 * <p>
	 *
	 *
	 * @param tagId
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@RequestMapping( "/getUserByTags" )
	@ResponseBody
	public String getUserByTags( Integer tagId ) {
		return callbackSuccess(personalUserModuleImpl.getPersonalUseryByTag(getPage(), getOrgId(), tagId).getBody());
	}


	/**
	 * 
	 * 将用户添加到黑名单中
	 * <p>
	 * 
	 *
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@RequestMapping( "/addToBlackList" )
	@ResponseBody
	public String batchAddToBlackList( PersonalUserIdReqDto dto ) {
		return callbackSuccess(personalUserModuleImpl.batchAddBlackList(
			getPage(), getOrgId(), dto.getPersonalUserIdList()).getBody());
	}


	/**
	 * 
	 * 批量将用户移除黑名单
	 * <p>
	 * 
	 *
	 * @param dto
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@RequestMapping( "/removeBlackList" )
	@ResponseBody
	public String batchRemoveBlackList( PersonalUserIdReqDto dto ) {
		return callbackSuccess(personalUserModuleImpl.batchRemoveBlackList(
			getPage(), getOrgId(), dto.getPersonalUserIdList()).getBody());
	}


	/**
	 * 
	 * 批量为用户打标签
	 * <p>
	 * 
	 *
	 * @return 
	 */
	@RequestMapping( "/batchAddTags" )
	@ResponseBody
	public String batchAddTags( PersonalUserTagBatchReqDto dto ) {
		return callbackSuccess(personalUserModuleImpl.batchAddUserTags(
			getPage(), getOrgId(), dto.getPersonalUserIdList(), dto.getTagIdList()).getBody());
	}


	/**
	 * 
	 * 修改一个用户的标签
	 * <p>
	 * 
	 *
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@RequestMapping( "/modifyUserTags" )
	@ResponseBody
	public String modifyUserTags( PersonalUserTagReqDto reqDto ) {
		return callbackSuccess(personalUserModuleImpl.modifyUserTags(
			getOrgId(), reqDto.getPersonalUserId(), reqDto.getTagIdList()).getBody());
	}


	/**
	 * 
	 * 创建标签
	 * <p>
	 * 
	 *
	 * @return 
	 */
	@RequestMapping( "/createTags" )
	@ResponseBody
	public String createTags( Long orgId, String tagsName ) throws ModuleException {
		if ( StringUtils.isNotEmpty(tagsName) ) {
			return callbackSuccess(personalUserModuleImpl.createTags(orgId, tagsName).getBody());
		} else {
			return callbackFail("标签不可以为空");
		}

	}


	/**
	 * 
	 * 删除公众号标签
	 * <p>
	 * 
	 *
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@RequestMapping( "/deleteTags" )
	@ResponseBody
	public String deleteTags( Long id ) throws ModuleException {
		return callbackSuccess(personalUserModuleImpl.deleteTags(getOrgId(), id).getBody());
	}


	/**
	 * 
	 * 修改公众号标签
	 * <p>
	 *
	 *
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@RequestMapping( "/modifyTags" )
	@ResponseBody
	public String modifyTags( String tagName, Long id ) throws ModuleException {
		Long orgId = getOrgId();
		return callbackSuccess(personalUserModuleImpl.modifyTags(orgId, tagName, id).getBody());
	}


	/**
	 * 
	 * 修改用户备注名称
	 * <p>
	 *
	 * @param remark 备注名
	 * @param personalUserId  用户userId
	 * @return 
	 */
	@RequestMapping( "/modifyRemark" )
	@ResponseBody
	public String modifyRemark( String remark, Long personalUserId, Long orgId ) {
		return callbackSuccess(personalUserModuleImpl.modifyRemark(remark, personalUserId, orgId));
	}

}
