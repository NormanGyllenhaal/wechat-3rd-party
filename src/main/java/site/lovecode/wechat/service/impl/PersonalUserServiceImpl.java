package site.lovecode.wechat.service.impl;


import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import site.lovecode.wechat.client.WechatClient;
import site.lovecode.wechat.client.WechatFactory;
import site.lovecode.wechat.dto.PersonalUserDto;
import site.lovecode.wechat.dto.PersonalUserTermDto;
import site.lovecode.wechat.entity.PersonalUser;
import site.lovecode.wechat.entity.PersonalUserTags;
import site.lovecode.wechat.mapper.OrgOfficialAccountMapper;
import site.lovecode.wechat.mapper.PersonalUserMapper;
import site.lovecode.wechat.mapper.PersonalUserTagsMapper;
import site.lovecode.wechat.service.IPersonalUserService;
import site.lovecode.wechat.support.bean.UserInfoResp;
import site.lovecode.wechat.support.enums.EnumConstants;
import site.lovecode.wechat.util.IdWorker;
import site.lovecode.wechat.util.Page;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2016/4/20.
 */
@Service
public class PersonalUserServiceImpl implements IPersonalUserService {

	private final Logger logger = LoggerFactory.getLogger(PersonalUserServiceImpl.class);

	@Resource
	private WechatFactory wechatFactory;


	@Resource
	private PersonalUserMapper personalUserMapper;


	@Resource
	private PersonalUserTagsMapper personalUserTagsMapper;


	@Resource
	private OrgOfficialAccountMapper orgOfficialAccountMapper;


	@Override
	public List<PersonalUser> refreshPersonlUser( Long orgId ) throws WxErrorException {
		Long oaid = getOaid(orgId);
		WechatClient wechatClient = wechatFactory.getWechatClient();
		WxMpUserList wxMpUserList = wechatClient.userList(null);
		List<UserInfoResp> userList = wechatClient.getUserList(wxMpUserList.getOpenIds());
		List<PersonalUser> personalUserList = userList.stream().map(userInfoResp -> new PersonalUser() {

			private static final long serialVersionUID = 1L;

			{
				setId(IdWorker.getId());
				setOfficialAccountId(oaid);
				setOpenid(userInfoResp.getOpenid());
				setSubscribe(userInfoResp.getSubscribe());
				setNickName(userInfoResp.getNickname());
				setSex(userInfoResp.getSex());
				setCity(userInfoResp.getCity());
				setCountry(userInfoResp.getCountry());
				setProvince(userInfoResp.getProvince());
				setLanguage(userInfoResp.getLanguage());
				setHeadimgurl(userInfoResp.getHeadimgurl());
				setSubscribeTime(new Timestamp(userInfoResp.getSubscribeTime() * 1000));
				setUnionid(userInfoResp.getUnionid());
				setRemark(userInfoResp.getRemark());
				setGroupid(userInfoResp.getGrounpid());
			}
		}).collect(Collectors.toList());
		personalUserMapper.deleteByOfficialAccountIdAndSubscribe(oaid);
		personalUserMapper.batchInsert(personalUserList);
		logger.info(wechatClient.getCurrentAutoreplyInfo().toString());
		return personalUserList;
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
	public List<PersonalUser> getPersonUserList(Long orgId ) {
		PersonalUser personalUser = new PersonalUser();
		personalUser.setOfficialAccountId(getOaid(orgId));
		return personalUserMapper.select(personalUser);
	}


	/**
	 * 
	 * 分页查询指定公众号所有用户和用户标签
	 * <p>
	 * 
	 *
	 * @param orgId
	 * @return 
	 */
	@Override
	public Page<PersonalUserDto> getPersonUserByPage(Page<PersonalUserDto> page, Long orgId ) {
		PersonalUserTermDto term = new PersonalUserTermDto();
		Long oaid = getOaid(orgId);
		term.setOfficialAccountId(oaid);
		term.setStatus(EnumConstants.PersonalUserOfStatus.normal.key());
		personalUserMapper.selectJoinTags(page, term);
		Integer count = personalUserMapper.selectCount(new PersonalUser(){
			{
				setOfficialAccountId(oaid);
				setStatus(EnumConstants.PersonalUserOfStatus.normal.key());
			}
		});
		page.setCount(count);
		return page;
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
	public PersonalUserDto getPersonalUser( Long personalUserId ) {
		PersonalUserTermDto term = new PersonalUserTermDto();
		term.setPersonalUserId(personalUserId);
		List<PersonalUserDto> dtoList = personalUserMapper.selectJoinTags(null, term);
		return dtoList.get(0);
	}


	/**
	 * 
	 * 获取公众号下用户数量
	 * <p>
	 * 
	 *
	 * @param orgId
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@Override
	public Integer getPersonUserCount( Long orgId ) {
		PersonalUser personalUser = new PersonalUser();
		personalUser.setOfficialAccountId(getOaid(orgId));
		return personalUserMapper.selectCount(personalUser);
	}


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
	@Override
	public Page<PersonalUserDto> getPersonUserByNickName( Page<PersonalUserDto> page, Long orgId, String nickName ) {
		PersonalUserTermDto term = new PersonalUserTermDto();
		term.setOfficialAccountId(getOaid(orgId));
		term.setNickName(nickName);
		personalUserMapper.selectJoinTags(page, term);
		return page;
	}


	/**
	 * 
	 * 修改一个用户的标签
	 * <p>
	 * 
	 *
	 * @param personalUserId 用户id
	 * @param tagIdList 标签id
	 * @return 
	 * @throws Exception 
	 */
	@Override
	public PersonalUserDto addPersonalUserTags( Long personalUserId, List<Integer> tagIdList, Long orgId )
		throws Exception {
		PersonalUserDto personalUserDto = getPersonalUser(personalUserId);
		WechatClient wechatClient = wechatFactory.getInstance(getOaid(orgId));
		List<String> openIdList = new ArrayList<String>() {

			private static final long serialVersionUID = 1L;
			{
				add(personalUserDto.getOpenid());
			}
		};
		// 更新微信端数据
		// 取消老标签
		try {
			for ( PersonalUserTags tags : personalUserDto.getTagsList() ) {
				wechatClient.batchUntagging(openIdList, tags.getTagId());
			}
			for ( Integer tagId : tagIdList ) {
				wechatClient.batchTagging(openIdList, tagId);
			}
			// 删除掉老标签
			personalUserTagsMapper.delete(new PersonalUserTags() {

				private static final long serialVersionUID = 1L;

				{
					setPersonalUserId(personalUserId);
				}
			});
			// 批量插入用户标签
			List<PersonalUserTags> tagsList = new ArrayList<>();
			tagIdList.forEach(tagId -> {
				tagsList.add(new PersonalUserTags() {

					private static final long serialVersionUID = 1L;
					{
						setPersonalUserId(personalUserId);
						setTagId(tagId);
					}
				});
			});
			personalUserTagsMapper.batchInsert(tagsList);
		} catch ( WxErrorException e ) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return getPersonalUser(personalUserId);
	}


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
	@Override
	public Page<PersonalUserDto> batchChangeStatus(
			Page<PersonalUserDto> page, List<Long> personalUserIdList, Long orgId, Integer status ) {
		List<PersonalUser> list = new ArrayList<PersonalUser>() {

			private static final long serialVersionUID = 1L;

			{
				personalUserIdList.forEach(personalUserId -> {
					add(new PersonalUser() {

						private static final long serialVersionUID = 1L;

						{
							setId(personalUserId);
							setStatus(status);
						}
					});
				});

			}
		};
		personalUserMapper.batchUpdateSelective(list);
		return getPersonUserByPage(page, orgId);
	}


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
	@Override
	public Page<PersonalUserDto> getPersonUserByTags( Page<PersonalUserDto> page, Long orgId, Integer tagId ) {
		PersonalUserTermDto term = new PersonalUserTermDto();
		term.setOfficialAccountId(getOaid(orgId));
		term.setTagId(tagId);
		personalUserMapper.selectJoinByTags(page, term);
		return page;
	}


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
	@Override
	public Page<PersonalUserDto> batchAddUserTags(
			Page<PersonalUserDto> page, Long orgId, List<Long> personalUserIdList, List<Integer> tagIdList )
		throws WxErrorException {
		Long oaid = getOaid(orgId);
		WechatClient wechatClient = wechatFactory.getInstance(oaid);
		List<String> openIdList = personalUserMapper.selectInId(personalUserIdList);
		// 更新微信端数据
		for ( Integer tagId : tagIdList ) {
			wechatClient.batchTagging(openIdList, tagId);
		}
		// 批量插入用户标签
		List<PersonalUserTags> tagsList = new ArrayList<>();
		personalUserIdList.forEach(personalUserId -> {
			tagIdList.forEach(tagId -> {
				tagsList.add(new PersonalUserTags() {

					private static final long serialVersionUID = 1L;

					{
						setPersonalUserId(personalUserId);
						setTagId(tagId);
					}
				});
			});
		});
		personalUserTagsMapper.batchInsert(tagsList);
		return getPersonUserByPage(page, oaid);
	}


	/**
	 * 
	 * 修改用户备注名称
	 * <p>
	 * 
	 *
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 * @throws WxErrorException 
	 */
	@Override
	public PersonalUserDto modifyRemark( String remark, Long personalUserId, Long orgId ) throws WxErrorException {
		WechatClient wechatClient = wechatFactory.getInstance(getOaid(orgId));
		PersonalUser personalUser = personalUserMapper.selectByPrimaryKey(personalUserId);
		wechatClient.userUpdateRemark(personalUser.getOpenid(), remark);
		personalUserMapper.updateByPrimaryKey(new PersonalUser() {

			private static final long serialVersionUID = 1L;

			{
				setId(personalUserId);
				setRemark(remark);
			}
		});
		return getPersonalUser(personalUserId);

	}


	/**
	 * 
	 * 修改用户绑定状态
	 * <p>
	 * 
	 *
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 * @throws WxErrorException 
	 */
	@Override
	public PersonalUserDto modifyBind( Integer isBind, Long personalUserId ) throws WxErrorException {
		personalUserMapper.updateByPrimaryKey(new PersonalUser() {

			private static final long serialVersionUID = 1L;

			{
				setId(personalUserId);
				setIsBind(isBind);
			}
		});
		return getPersonalUser(personalUserId);
	}



	Long getOaid( Long orgId ) {
		return orgOfficialAccountMapper.getOfficialAccountIdByOrgId(orgId);
	}

}
