package site.lovecode.wechat.service.impl;


import com.alibaba.fastjson.JSON;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpMaterialCountResult;
import me.chanjar.weixin.mp.bean.result.WxMpMaterialFileBatchGetResult;
import me.chanjar.weixin.mp.bean.result.WxMpMaterialFileBatchGetResult.WxMaterialFileBatchGetNewsItem;
import me.chanjar.weixin.mp.bean.result.WxMpMaterialNewsBatchGetResult;
import me.chanjar.weixin.mp.bean.result.WxMpMaterialNewsBatchGetResult.WxMaterialNewsBatchGetNewsItem;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import site.lovecode.wechat.client.WechatClient;
import site.lovecode.wechat.client.WechatFactory;
import site.lovecode.wechat.client.WechatThirdPartyClient;
import site.lovecode.wechat.client.impl.WechatThirdPartyClientImpl;
import site.lovecode.wechat.dto.AuthorizerInfoDto;
import site.lovecode.wechat.dto.FuncInfoDto;
import site.lovecode.wechat.entity.*;
import site.lovecode.wechat.jedis.RedisCache;
import site.lovecode.wechat.mapper.*;
import site.lovecode.wechat.service.IReplySettingService;
import site.lovecode.wechat.service.IWechatService;
import site.lovecode.wechat.service.IWechatThridPartyService;
import site.lovecode.wechat.support.bean.*;
import site.lovecode.wechat.support.config.WechatConfig;
import site.lovecode.wechat.support.enums.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by Administrator on 2016/4/8.
 */
@Service
public class WechatThirdPartyServiceImpl  implements IWechatThridPartyService {

	private Logger logger = LoggerFactory.getLogger(WechatThirdPartyServiceImpl.class);


	@Resource
	private ComponentVerifyTicketMapper componentVerifyTicketMapper;


	@Resource
	private WechatThirdPartyConfigMapper wechatThirdPartyConfigMapper;


	@Resource
	private AuthorizerInfoMapper authorizerInfoMapper;

	@Resource
	private WechatThirdPartyClient wechatThirdPartyClient;

	@Resource
	private FuncInfoMapper funcInfoMapper;

	@Resource
	private BusinessInfoMapper businessInfoMapper;

	@Resource
	private OfficialAccountMapper officialAccountMapper;

	@Resource
	private AuthorizerAccessTokenMapper authorizerAccessTokenMapper;


	@Resource
	private ThreadPoolTaskExecutor taskExecutor;

	@Resource
	private WechatFactory wechatFactory;


	@Resource
	private PersonalUserMapper personalUserMapper;


	@Resource
	private IWechatService wechatService;


	@Resource
	private PersonalUserTagsMapper personalUserTagsMapper;

	@Resource
	private TagsMapper tagsMapper;

	@Resource
	private RedisCache redisCache;

	@Resource
	private MediaMapper mediaMapper;

	@Resource
	private MediaNewsMapper mediaNewsMapper;

	@Resource
	private MenuMapper menuMapper;

	@Resource
	private MenuSettingMapper menuSettingMapper;

	@Resource
	private IReplySettingService replySettingServiceImpl;


	/**
	 * 保存ComponentVerifyTicket
	 *
	 * @param xmlDecryptingBean
	 */
	@Override
	public void saveComponentVerifyTicket( XmlDecryptingBean xmlDecryptingBean ) throws WxErrorException {
		// 更新内存中的componentVerfiyTicket
		WechatThirdPartyClientImpl.wechatThirdPartyConfig.setComponentVerifyTicket(xmlDecryptingBean
				.getComponentVerifyTicket());
		// 检查componentAccessToken是否为空
		if ( StringUtils.isEmpty(WechatThirdPartyClientImpl.wechatThirdPartyConfig.getComponentAccessToken()) ) {
			WechatThirdPartyClientImpl.wechatThirdPartyConfig.setComponentAccessToken(wechatThirdPartyClient
					.refreshComponentAccessToken().getComponentAccessToken());
		}
		// 保存到数据库
		componentVerifyTicketMapper.insert(new ComponentVerifyTicket() {

			private static final long serialVersionUID = 1L;

			{
				setComponentVerifyTicket(xmlDecryptingBean.getComponentVerifyTicket());
				setCreateTime(new Timestamp(Long.parseLong(xmlDecryptingBean.getCreateTime()) * 1000));
				setComponentAppid(xmlDecryptingBean.getAppId());
				setDeadline(new Timestamp(System.currentTimeMillis() + (60 * 60 * 1000)));
			}
		});
	}


	/**
	 * 授权成功执行的操作
	 * 1.保存公众号基本信息
	 * 2.保存公众号详细信息
	 * 3.保存公众号access_token
	 * 4.保存公众号权限信息
	 * 5.保存公众号商业信息
	 * 如果是首次授权异步执行的操作
	 * 1.批量拉取用户信息
	 * 2.获取用户自动回复配置，并初始化微信消息接收器
	 * 3.批量拉取用户永久素材
	 * 4.获取自定义菜单配置并保存
	 * 
	 *
	 * @throws IOException
	 */
	@Override
	public AuthorizerInfoDto saveInfo(String authCode ) throws Exception {
		// 获取用户accessToken和refreshToken
		QueryAuthBean queryAuthBean = wechatThirdPartyClient.queryAuth(authCode);
		// 获取公众号用户的基本信息
		AuthorizerInfoBean authorizerInfoBean = wechatThirdPartyClient.getAuthorizerInfo(queryAuthBean
				.getAuthOrizationInfo().getAuthorizerAppid());
		// 查询公众号基本信息表
		OfficialAccount officialAccount = officialAccountMapper.selectOne(new OfficialAccount() {

			private static final long serialVersionUID = 1L;

			{
				setAppid(authorizerInfoBean.getAuthorizeationInfo().getAuthorizerAppid());
			}
		});
		// 如果存在记录更新，不存在直接插入
		Boolean flag = true;
		if ( officialAccount != null ) {
			officialAccount.setAccountType(OfficialAccountTypeEnum.AUTHORIZATION.key());
			officialAccount.setServiceTypeInfo(authorizerInfoBean.getAuthorizerInfo().getServiceTypeInfo().getId());
			officialAccount.setVerifyTypeInfo(authorizerInfoBean.getAuthorizerInfo().getVerifyTypeInfo().getId());
			officialAccountMapper.updateByPrimaryKeySelective(officialAccount);
			flag = false;
		} else {
			officialAccount = saveOfficialAccount(authorizerInfoBean);
		}
		// 保存授权公众号信息
		AuthorizerInfo authorizerInfo = replaceAuthorizerInfo(officialAccount, authorizerInfoBean);
		// 保存公众号的access_token信息
		replaceAuthorizerAccessToken(officialAccount, queryAuthBean);
		// 保存公众号的权限信息
		List<FuncInfoDto> funcInfoDtoList = saveFuncInfo(officialAccount, queryAuthBean);
		// 保存公众号的商业信息
		saveBusinessInfo(officialAccount, authorizerInfoBean);

		WechatClient wechatClient = wechatFactory.getInstance(officialAccount.getId());
		final Long oaid = officialAccount.getId();
		final String userName = officialAccount.getUserName();
		// 添加或更新新公众号配置到redis中
		wechatService.addWechatConfigInRedis(oaid);
		if ( flag ) {
			taskExecutor.execute(( ) -> {
				try {
					savePersonalUserFirst(wechatClient, oaid);
					saveTagsFirst(wechatClient, oaid);
				} catch ( Exception e ) {
					e.printStackTrace();
				}
			});
			// 异步执行获取自动回复配置，生成消息处理器
			executeGenerateMessageRouter(oaid, userName);
			// 异步执行获取用户素材
			executeGetMedia(wechatClient, oaid);
			taskExecutor.execute(( ) -> {
				try {
					getMenuSetting(wechatClient, oaid);
				} catch ( Exception e ) {
					e.printStackTrace();
				}
			});

		}

		return new AuthorizerInfoDto(authorizerInfo, officialAccount, funcInfoDtoList);
	}


	/**
	 * 
	 * 刷新用户数据
	 * <p>
	 * 
	 *
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@Override
	public void refreshData( Long oaid ) throws Exception {

		WechatClient wechatClient = wechatFactory.getInstance(oaid);
		WechatConfig wechatConfig = JSON.parseObject(redisCache.getValue(oaid), WechatConfig.class);
		// 异步执行获取用户操作
		taskExecutor.execute(( ) -> {
			try {
				savePersonalUser(wechatClient, oaid);
				saveTags(wechatClient, oaid);
			} catch ( Exception e ) {
				e.printStackTrace();
			}
		});
		// 异步执行获取自动回复配置，生成消息处理器
		executeGenerateMessageRouter(oaid, wechatConfig.getUserName());
		// 异步执行获取用户素材
		taskExecutor.execute(( ) -> {
			try {
				delOldMedia(oaid);
				getMedia(wechatClient, oaid);
			} catch ( Exception e ) {
				e.printStackTrace();

			}
		});
		// 异步执行更新自定义菜单
		taskExecutor.execute(( ) -> {
			deleteMenu(oaid);
			try {
				getMenuSetting(wechatClient, oaid);
			} catch ( Exception e ) {
				e.printStackTrace();

			}
		});

	}


	/**
	 * 生成用户的授权页面
	 *
	 * @return
	 * @throws IOException
	 */
	@Override
	public String getCompoentLoginUrl() throws IOException, WxErrorException {
		return wechatThirdPartyClient.getAuthOrizationUrl(wechatThirdPartyClient.getPreAuthCode().getPreAuthCode());
	}


	/**
	 * 用户取消授权，变更授权状态为取消
	 */
	@Override
	public void changeAuthorizationStatus( String authorizerAppid ) {
		logger.info("修改状态");
		authorizerInfoMapper.updateAuthorizationStatus(AuthorizationStatusEnum.UNAUTHORIZED.key(), authorizerAppid);
	}




	/**
	 * 
	 * 保存公众号信息
	 * <p>
	 * TODO(这里可以描述这个方法的执行逻辑，方便看客一目了然的了解代码含义，支持HTML格式化– 可选)
	 *
	 * @param authorizerInfoBean
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	private OfficialAccount saveOfficialAccount( AuthorizerInfoBean authorizerInfoBean ) {
		OfficialAccount officialAccount = new OfficialAccount();
		officialAccount.setAppid(authorizerInfoBean.getAuthorizeationInfo().getAuthorizerAppid());
		officialAccount.setAccountType(OfficialAccountTypeEnum.AUTHORIZATION.key());
		officialAccount.setServiceTypeInfo(authorizerInfoBean.getAuthorizerInfo().getServiceTypeInfo().getId());
		officialAccount.setVerifyTypeInfo(authorizerInfoBean.getAuthorizerInfo().getVerifyTypeInfo().getId());
		officialAccount.setUserName(authorizerInfoBean.getAuthorizerInfo().getUserName());
		officialAccount.setNickName(authorizerInfoBean.getAuthorizerInfo().getNickName());
		// 插入授权方公众号信息
		officialAccountMapper.insert(officialAccount);
		return officialAccount;
	}


	/**
	 * 
	 * 保存授权公众号信息
	 * <p>
	 * 
	 *
	 * @param finalOfficialAccount
	 * @param authorizerInfoBean TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	private AuthorizerInfo replaceAuthorizerInfo(
			OfficialAccount finalOfficialAccount, AuthorizerInfoBean authorizerInfoBean ) {
		AuthorizerInfo authorizer = new AuthorizerInfo();
		authorizer.setOfficialAccountId(finalOfficialAccount.getId());
		authorizer.setAuthorizerAppid(authorizerInfoBean.getAuthorizeationInfo().getAuthorizerAppid());
		authorizer.setAlias(authorizerInfoBean.getAuthorizerInfo().getAlizs());
		authorizer.setHeadImg(authorizerInfoBean.getAuthorizerInfo().getHeadImg());
		authorizer.setQrcodeUrl(authorizerInfoBean.getAuthorizerInfo().getQrcodeUrl());
		authorizer.setAuthorizationStatus(AuthorizationStatusEnum.AUTHORIZED.key());
		authorizerInfoMapper.replace(authorizer);
		return authorizer;
	}


	/**
	 * 
	 * 保存授权公众号token信息
	 * <p>
	 * 
	 *
	 * @param finalOfficialAccount
	 * @param queryAuthBean TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	private void replaceAuthorizerAccessToken( OfficialAccount finalOfficialAccount, QueryAuthBean queryAuthBean ) {
		authorizerAccessTokenMapper.replace(new AuthorizerAccessToken(
				finalOfficialAccount.getId(), queryAuthBean.getAuthOrizationInfo().getAuthorizerAppid(), queryAuthBean
						.getAuthOrizationInfo().getAuthorizerAccessToken(), (queryAuthBean.getAuthOrizationInfo()
						.getExpriesIn() * 1000) + System.currentTimeMillis(), queryAuthBean.getAuthOrizationInfo()
						.getAuthorizerRefreshToken(), new Timestamp(System.currentTimeMillis())));
	}


	/**
	 * 
	 * 保存公众号权限
	 * <p>
	 * 
	 *
	 * @param finalOfficialAccount
	 * @param queryAuthBean
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	private List<FuncInfoDto> saveFuncInfo( OfficialAccount finalOfficialAccount, QueryAuthBean queryAuthBean ) {
		Integer num = funcInfoMapper.delete(new FuncInfo() {

			private static final long serialVersionUID = 1L;
			{
				setOfficialAccountId(finalOfficialAccount.getId());
			}
		});
		logger.info("删除旧的权限信息：" + num);
		List<FuncInfo> funcInfoList = queryAuthBean.getAuthOrizationInfo().getFuncInfoList().stream()
				.map(funcInfoObject -> new FuncInfo() {

					private static final long serialVersionUID = 1L;

					{
						setFuncName(funcInfoObject.getFuncscopeCategory().getId());
						setOfficialAccountId(finalOfficialAccount.getId());
					}
				}).collect(Collectors.toList());
		funcInfoMapper.batchInsert(funcInfoList);
		//Map<Integer, FuncInfo> funcInfoMap = list2MapByKey(funcInfoList, "funcName");
		Map<Integer, FuncInfo> funcInfoMap = null;
		List<FuncInfoDto> funcInfoListDtoList = new ArrayList<>();
		for ( FuncInfoEnum funcInfoEnum : EnumSet.allOf(FuncInfoEnum.class) ) {
			FuncInfoDto dto = new FuncInfoDto();
			dto.setFuncName(funcInfoEnum.getKey());
			dto.setFuncDesc(funcInfoEnum.getDesc());
			if ( funcInfoMap.get(funcInfoEnum.getKey()) != null ) {
				dto.setStatus(FuncInfoStatusEnum.open.key());
			} else {
				dto.setStatus(FuncInfoStatusEnum.close.key());
			}
			funcInfoListDtoList.add(dto);
		}

		return funcInfoListDtoList;
	}


	/**
	 * 
	 * 保存商业信息
	 * <p>
	 * 
	 *
	 * @param finalOfficialAccount
	 * @param authorizerInfoBean TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	private void saveBusinessInfo( OfficialAccount finalOfficialAccount, AuthorizerInfoBean authorizerInfoBean ) {
		Integer businessInfoNum = businessInfoMapper.delete(new BusinessInfo() {

			/**
			 * TODO（用一句话描述这个变量的含义）
			 */

			private static final long serialVersionUID = 1L;

			{
				setOfficialAccountId(finalOfficialAccount.getId());
			}
		});
		logger.info("删除旧的商业信息：" + businessInfoNum);
		List<BusinessInfo> businessInfoList = Stream.of(
			new BusinessInfo(finalOfficialAccount.getId(), BusinessInfoEnum.OPEN_CARD.key(), authorizerInfoBean
					.getAuthorizerInfo().getBusinessInfoBean().getOpenCard()),
			new BusinessInfo(finalOfficialAccount.getId(), BusinessInfoEnum.OPEN_PAY.key(), authorizerInfoBean
					.getAuthorizerInfo().getBusinessInfoBean().getOpenPay()),
			new BusinessInfo(finalOfficialAccount.getId(), BusinessInfoEnum.OPEN_SCAN.key(), authorizerInfoBean
					.getAuthorizerInfo().getBusinessInfoBean().getOpenScan()),
			new BusinessInfo(finalOfficialAccount.getId(), BusinessInfoEnum.OPEN_SHAKE.key(), authorizerInfoBean
					.getAuthorizerInfo().getBusinessInfoBean().getOpenShake()),
			new BusinessInfo(finalOfficialAccount.getId(), BusinessInfoEnum.OPEN_STORE.key(), authorizerInfoBean
					.getAuthorizerInfo().getBusinessInfoBean().getOpenStore())).collect(Collectors.toList());
		businessInfoMapper.batchInsert(businessInfoList);
	}


	/**
	 * 
	 * 保存用户信息
	 * <p>
	 * 
	 *
	 * @param wechatClient
	 * @param oaid
	 * @throws WxErrorException TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	private void savePersonalUser( WechatClient wechatClient, Long oaid ) throws WxErrorException {
		WxMpUserList wxMpUserList = wechatClient.userList(null);
		List<UserInfoResp> userList = wechatClient.getUserList(wxMpUserList.getOpenIds());
		//
		List<PersonalUser> personalUserList = personalUserMapper.select(new PersonalUser() {

			private static final long serialVersionUID = 1L;

			{
				setOfficialAccountId(oaid);
			}
		});
		Map<String, Long> openIdMap = personalUserList.stream().collect(
			Collectors.toMap(PersonalUser::getOpenid, PersonalUser::getId));

		List<PersonalUserTags> tagsList = new ArrayList<>();
		userList.forEach(userInfoResp -> {

			PersonalUser personalUser = new PersonalUser() {

				private static final long serialVersionUID = 1L;
				{
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
					setStatus(EnumConstants.PersonalUserOfStatus.normal.key());
				}
			};
			Long id = openIdMap.get(userInfoResp.getOpenid());
			if ( Optional.ofNullable(id).isPresent() ) {
				personalUser.setId(id);
				personalUserMapper.updateByPrimaryKey(personalUser);
			} else {
				personalUserMapper.insertSelective(personalUser);
			}
			List<PersonalUserTags> collect = userInfoResp.getTagIdList().stream().map(tagId -> new PersonalUserTags() {

				private static final long serialVersionUID = 1L;
				{
					setPersonalUserId(personalUser.getId());
					setTagId(tagId);
				}
			}).collect(Collectors.toList());
			// 删除之前的标签信息
			personalUserTagsMapper.delete(new PersonalUserTags() {

				private static final long serialVersionUID = 1L;

				{
					setPersonalUserId(personalUser.getId());
				}
			});
			tagsList.addAll(collect);
		});

		// 批量插入用户标签
		personalUserTagsMapper.batchInsert(tagsList);
	}


	/**
	 * 
	 * 首次保存用户信息
	 * <p>
	 * 
	 *
	 * @param wechatClient
	 * @param oaid
	 * @throws WxErrorException TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	private void savePersonalUserFirst( WechatClient wechatClient, Long oaid ) throws WxErrorException {
		WxMpUserList wxMpUserList = wechatClient.userList(null);
		List<UserInfoResp> userList = wechatClient.getUserList(wxMpUserList.getOpenIds());
		List<PersonalUserTags> tagsList = new ArrayList<>();
		userList.forEach(userInfoResp -> {
			PersonalUser personalUser = new PersonalUser() {

				private static final long serialVersionUID = 1L;
				{
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
					setStatus(EnumConstants.PersonalUserOfStatus.normal.key());
				}
			};
			personalUserMapper.insertSelective(personalUser);
			List<PersonalUserTags> collect = userInfoResp.getTagIdList().stream().map(tagId -> new PersonalUserTags() {

				private static final long serialVersionUID = 1L;
				{
					setPersonalUserId(personalUser.getId());
					setTagId(tagId);
				}
			}).collect(Collectors.toList());

			tagsList.addAll(collect);
		});
		// 批量插入用户标签
		personalUserTagsMapper.batchInsert(tagsList);
	}


	/**
	 * 
	 * 保存公众号标签
	 * <p>
	 * 
	 *
	 * @param wechatClient
	 * @param oaid 
	 * @throws WxErrorException 
	 */
	private void saveTags( WechatClient wechatClient, Long oaid ) throws WxErrorException {
		TagsBean tagsBean = wechatClient.getAllTags();

		List<Tags> list = tagsMapper.select(new Tags() {

			private static final long serialVersionUID = 1L;

			{
				setOfficialAccountId(oaid);
			}
		});
		List<Tags> tagsList = tagsBean.getTags().stream().map(tags -> new Tags() {

			private static final long serialVersionUID = 1L;

			{
				setOfficialAccountId(oaid);
				setTagId(tags.getId());
				setTagName(tags.getName());
				setCount(tags.getCount());
			}
		}).collect(Collectors.toList());
		if ( list != null && list.size() > 0 ) {
			Map<Integer, Long> tagIdMap = list.stream().collect(Collectors.toMap(Tags::getTagId, Tags::getId));
			List<Tags> insertTagsList = new ArrayList<Tags>();
			List<Tags> updateTagsList = new ArrayList<Tags>();
			tagsList.forEach(tags -> {
				Long id = tagIdMap.get(tags.getTagId());
				if ( Optional.ofNullable(id).isPresent() ) {
					tags.setId(oaid);
					updateTagsList.add(tags);
				} else {
					insertTagsList.add(tags);
				}
			});
			tagsMapper.batchInsert(insertTagsList);
			tagsMapper.batchUpdateSelective(updateTagsList);
		} else {
			tagsMapper.batchInsert(tagsList);
		}
	}


	/**
	 * 
	 * 首次保存用户标签信息
	 * <p>
	 * 
	 *
	 * @param wechatClient
	 * @param oaid
	 * @throws WxErrorException TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	private void saveTagsFirst( WechatClient wechatClient, Long oaid ) throws WxErrorException {
		TagsBean tagsBean = wechatClient.getAllTags();
		List<Tags> tagsList = tagsBean.getTags().stream().map(tags -> new Tags() {

			private static final long serialVersionUID = 1L;

			{
				setOfficialAccountId(oaid);
				setTagId(tags.getId());
				setTagName(tags.getName());
				setCount(tags.getCount());
			}
		}).collect(Collectors.toList());
		tagsMapper.batchInsert(tagsList);
	}


	/**
	 * 
	 * 异步执行创建消息处理器
	 * <p>
	 * 
	 *
	 * @param oaid
	 * @param userName TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	private void executeGenerateMessageRouter( Long oaid, String userName ) {
		taskExecutor.execute(( ) -> {
			try {
				replySettingServiceImpl.getAutoReplySetting(oaid);
				wechatService.generateMessageRouter(oaid, userName);
			} catch ( Exception e ) {
				e.printStackTrace();
			}
		});
	}


	/**
	 * 
	 * 异步执行获取素材操作
	 * <p>
	 * 
	 *
	 * @param wechatClient
	 * @param oaid TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	private void executeGetMedia( WechatClient wechatClient, Long oaid ) {
		taskExecutor.execute(( ) -> {
			try {
				getMedia(wechatClient, oaid);
			} catch ( Exception e ) {
				e.printStackTrace();

			}
		});
	}


	private void getMedia( WechatClient wechatClient, Long oaid ) throws WxErrorException {
		WxMpMaterialCountResult materialCount = wechatClient.materialCount();
		List<Media> list = new ArrayList<>();
		if ( materialCount != null ) {
			if ( materialCount.getImageCount() > 0 ) {
				List<WxMaterialFileBatchGetNewsItem> mediaList = getMedisList(
					wechatClient, materialCount.getImageCount(), WxConsts.MATERIAL_IMAGE);
				List<Media> media = toMediaList(mediaList, oaid, EnumConstants.MediaTypeOfEnum.img.key());
				list.addAll(media);

			}
			if ( materialCount.getVoiceCount() > 0 ) {
				list.addAll(toMediaList(
					getMedisList(wechatClient, materialCount.getVoiceCount(), WxConsts.MATERIAL_VOICE), oaid,
					EnumConstants.MediaTypeOfEnum.voice.key()));
			}
			if ( materialCount.getVideoCount() > 0 ) {
				list.addAll(toMediaList(
					getMedisList(wechatClient, materialCount.getVideoCount(), WxConsts.MATERIAL_VIDEO), oaid,
					EnumConstants.MediaTypeOfEnum.video.key()));
			}
			if ( materialCount.getNewsCount() > 0 ) {
				List<WxMaterialNewsBatchGetNewsItem> newsList = getNewsList(wechatClient, materialCount.getNewsCount());
				saveMediaNewsList(newsList, oaid);
			}
		}
		if ( list.size() > 0 ) {
			mediaMapper.batchInsert(list);
		}

	}


	private List<Media> toMediaList( List<WxMaterialFileBatchGetNewsItem> mediaList, Long oaid, Integer type ) {
		List<Media> collect = mediaList.stream().map(item -> new Media() {

			private static final long serialVersionUID = 1L;

			{
				setOfficialAccountId(oaid);
				setMediaId(item.getMediaId());
				setType(type);
				setName(item.getName());
				setUrl(item.getUrl());
				setUpdateTime(item.getUpdateTime());
				setMediaType(EnumConstants.MediaMediaTypeOfEnum.forever.key());
			}
		}).collect(Collectors.toList());
		return collect;
	}


	private void saveMediaNewsList( List<WxMaterialNewsBatchGetNewsItem> newList, Long oaid ) {
		List<MediaNews> list = new ArrayList<MediaNews>();
		newList.forEach(item -> {
			Media media = new Media() {

				private static final long serialVersionUID = 1L;

				{
					setOfficialAccountId(oaid);
					setType(EnumConstants.MediaTypeOfEnum.news.key());
					setMediaId(item.getMediaId());
					setMediaType(EnumConstants.MediaMediaTypeOfEnum.forever.key());
					setUpdateTime(item.getUpdateTime());
				}
			};
			mediaMapper.insertSelective(media);
			List<MediaNews> collect = item.getContent().getArticles().stream().map(article -> new MediaNews() {

				private static final long serialVersionUID = 1L;

				{
					setMyMediaId(media.getId());
					setTitle(article.getTitle());
					setThumbMediaId(article.getThumbMediaId());
					setShowCoverPic(1);
					setAuthor(article.getAuthor());
					setDigest(article.getDigest());
					setContent(article.getContent());
					setUrl(article.getUrl());
					setContentSourceUrl(article.getContentSourceUrl());
				}
			}).collect(Collectors.toList());
			list.addAll(collect);
		});
		if ( list.size() > 0 ) {
			mediaNewsMapper.batchInsert(list);
		}
	}


	private List<WxMaterialFileBatchGetNewsItem> getMedisList( WechatClient wechatClient, Integer count, String type )
		throws WxErrorException {
		List<WxMaterialFileBatchGetNewsItem> mediaList = new ArrayList<>();
		if ( count > 20 ) {
			Integer num = count % 20;
			Integer iteratorNum = (count - num) / 20;
			for ( int i = 0 ; i < iteratorNum ; i++ ) {
				addMediaList(mediaList, wechatClient, iteratorNum * 20, type);
			}
			addMediaList(mediaList, wechatClient, num, type);
		} else {
			addMediaList(mediaList, wechatClient, 0, type);
		}
		return mediaList;
	}


	private List<WxMaterialNewsBatchGetNewsItem> getNewsList( WechatClient wechatClient, Integer count )
		throws WxErrorException {
		List<WxMaterialNewsBatchGetNewsItem> newList = new ArrayList<>();
		if ( count > 20 ) {
			Integer num = count % 20;
			Integer iteratorNum = (count - num) / 20;
			for ( int i = 0 ; i < iteratorNum ; i++ ) {
				addNewList(newList, wechatClient, iteratorNum * 20);
			}
			addNewList(newList, wechatClient, num);
		} else {
			addNewList(newList, wechatClient, 0);
		}
		return newList;
	}


	private void addMediaList(
			List<WxMaterialFileBatchGetNewsItem> mediaList, WechatClient wechatClient, Integer offset, String type )
		throws WxErrorException {
		WxMpMaterialFileBatchGetResult materialFileBatchGetResult = wechatClient.materialFileBatchGet(type, offset, 20);
		List<WxMaterialFileBatchGetNewsItem> items = materialFileBatchGetResult.getItems();
		mediaList.addAll(items);
	}


	private void addNewList( List<WxMaterialNewsBatchGetNewsItem> mediaList, WechatClient wechatClient, Integer offset )
		throws WxErrorException {
		WxMpMaterialNewsBatchGetResult materialNewsBatchGet = wechatClient.materialNewsBatchGet(offset, 20);
		List<WxMaterialNewsBatchGetNewsItem> items = materialNewsBatchGet.getItems();
		mediaList.addAll(items);
	}


	private void delOldMedia( Long oaid ) {
		List<Media> mediaList = mediaMapper.select(new Media() {

			private static final long serialVersionUID = 1L;

			{
				setOfficialAccountId(oaid);
				setMediaType(EnumConstants.MediaMediaTypeOfEnum.forever.key());
			}
		});
		mediaMapper.delete(new Media() {

			private static final long serialVersionUID = 1L;

			{
				setOfficialAccountId(oaid);
				setMediaType(EnumConstants.MediaMediaTypeOfEnum.forever.key());
			}

		});
		List<MediaNews> mediaNewsList = mediaList.stream().map(media -> new MediaNews() {

			private static final long serialVersionUID = 1L;

			{
				setMyMediaId(media.getId());
			}
		}).collect(Collectors.toList());
		mediaNewsMapper.batchDelete(mediaNewsList);
	}


	private void deleteMenu( Long oaid ) {
		menuSettingMapper.delete(new MenuSetting() {

			private static final long serialVersionUID = 1L;

			{
				setOfficialAccountId(oaid);
			}
		});
		menuMapper.delete(new Menu() {

			private static final long serialVersionUID = 1L;

			{
				setOfficialAccountId(oaid);
			}
		});
	}


	private void getMenuSetting( WechatClient wechatClient, Long oaid ) throws WxErrorException {
		SelfMenuInfoBean selfMenu = wechatClient.getSelfMenu();
		if ( selfMenu != null ) {
			menuSettingMapper.insertSelective(new MenuSetting() {

				private static final long serialVersionUID = 1L;

				{
					setOfficialAccountId(oaid);
					setIsMenuOpen(selfMenu.getIsMenuOpen());
				}
			});
			List<Menu> menuList = new ArrayList<Menu>();
			selfMenu
					.getSelfmenuInfo()
					.getButton()
					.forEach(
						buttonBean -> {

							Menu menu = new Menu() {

								private static final long serialVersionUID = 1L;

								{
									setType(MenuOfTypeEnum.valueOf(buttonBean.getType()).key());
									setName(buttonBean.getName());
									if ( MenuOfTypeEnum.view.desc().equals(buttonBean.getType()) ) {
										setUrl(buttonBean.getUrl());
									} else {
										setValue(buttonBean.getValue());
									}
									setOfficialAccountId(oaid);
									setLevel(MenuOfLevelEnum.one.key());
								}
							};
							menuMapper.insertSelective(menu);
							if ( buttonBean.getSubButton() != null
									&& buttonBean.getSubButton().getList() != null
									&& buttonBean.getSubButton().getList().size() > 0 ) {
								List<Menu> collect = buttonBean.getSubButton().getList().stream()
										.map(button -> new Menu() {

											private static final long serialVersionUID = 1L;

											{
												setType(MenuOfTypeEnum.valueOf(buttonBean.getType()).key());
												setName(buttonBean.getName());
												if ( MenuOfTypeEnum.view.desc().equals(buttonBean.getType()) ) {
													setUrl(buttonBean.getUrl());
												} else {
													setValue(buttonBean.getValue());
												}
												setOfficialAccountId(oaid);
												setLevel(MenuOfLevelEnum.two.key());
												setParentId(menu.getId());
											}
										}).collect(Collectors.toList());
								menuList.addAll(collect);

							}

						});
			menuMapper.batchInsertSelective(menuList);
		}

	}

}
