package site.lovecode.wechat.service.impl;


import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutNewsMessage;
import me.chanjar.weixin.mp.bean.outxmlbuilder.NewsBuilder;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import site.lovecode.wechat.client.WechatClient;
import site.lovecode.wechat.client.WechatFactory;
import site.lovecode.wechat.client.WechatThirdPartyClient;
import site.lovecode.wechat.client.impl.WechatThirdPartyClientImpl;
import site.lovecode.wechat.dto.KeywordReplySettingDto;
import site.lovecode.wechat.dto.KeywordReplySettingReplyDto;
import site.lovecode.wechat.dto.OfficialAccountDto;
import site.lovecode.wechat.entity.*;
import site.lovecode.wechat.jedis.RedisCache;
import site.lovecode.wechat.mapper.*;
import site.lovecode.wechat.service.IWechatService;
import site.lovecode.wechat.support.config.WechatConfig;
import site.lovecode.wechat.support.enums.*;
import site.lovecode.wechat.support.singleton.MessageRouterSingleton;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2016/4/13.
 */
@Service
public class WechatServiceImpl implements InitializingBean, IWechatService {

	private final Logger logger = LoggerFactory.getLogger(WechatServiceImpl.class);

	@Resource
	private RedisCache redisCache;


	@Resource
	private OfficialAccountMapper officialAccountMapper;

	@Resource
	private ComponentVerifyTicketMapper componentVerifyTicketMapper;


	@Resource
	private WechatThirdPartyConfigMapper wechatThirdPartyConfigMapper;

	@Resource
	private WechatThirdPartyClient wechatThirdPartyClient;


	@Resource
	private ReplySettingMapper replySettingMapper;

	@Resource
	private KeywordReplySettingMapper keywordReplySettingMapper;


	@Resource
	private WechatFactory wechatFactory;


	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("----加载公众号第三方配置----");
		loadWechatThirdPartyConfig();
		logger.info("加载所有公众号配置信息");
		loadWechatConfig();
		logger.info("加载公众号消息处理器");
		loadReplySetting();

	}


	public void loadWechatThirdPartyConfig() throws WxErrorException {
		WechatThirdPartyClientImpl.wechatThirdPartyConfig = wechatThirdPartyConfigMapper.selectByPrimaryKey(1L);
		// 获取已经存储的ticket
		ComponentVerifyTicket componentVerifyTicket = componentVerifyTicketMapper
				.selectOrderByCreateTime(WechatThirdPartyClientImpl.wechatThirdPartyConfig.getComponentAppid());
		if ( Optional.ofNullable(componentVerifyTicket).isPresent()
				&& componentVerifyTicket.getDeadline().getTime() > System.currentTimeMillis() ) {
			WechatThirdPartyClientImpl.wechatThirdPartyConfig.setComponentVerifyTicket(componentVerifyTicket
					.getComponentVerifyTicket());
			WechatThirdPartyClientImpl.wechatThirdPartyConfig.setComponentAccessToken(wechatThirdPartyClient
					.refreshComponentAccessToken().getComponentAccessToken());
		}
		logger.info(WechatThirdPartyClientImpl.wechatThirdPartyConfig.toString());
	}


	public void loadWechatConfig() {
		Map<Long, WechatConfig> wechatConfigMap = Stream
				.of(
					officialAccountMapper.selectJoinAuthorizerAccessToken(null),
					officialAccountMapper.selectJoinInfoAndAccessToken())
				.flatMap(officialAccountVo -> officialAccountVo.stream()).collect(Collectors.toList()).stream()
				.collect(Collectors.toMap(OfficialAccount::getId, vo -> getWechatConfig(vo)));
		logger.info("公众号信息" + wechatConfigMap.size());
		wechatConfigMap.forEach(( aLong, wechatConfig ) -> {
			redisCache.setValue(aLong, wechatConfig);
			redisCache.setValue(wechatConfig.getUserName(), aLong.toString());
		});
		logger.info(wechatConfigMap.toString());
	}


	private void loadReplySetting() {
		List<OfficialAccount> officialAccountList = officialAccountMapper.selectAll();
		officialAccountList.forEach(officialAccount -> generateMessageRouter(
			officialAccount.getId(), officialAccount.getUserName()));
	}


	/**
	 * 更新或生成消息处理器
	 * @param oaid
	 * @param userName
	 */
	@Override
	public void generateMessageRouter( Long oaid, String userName ) {
		logger.info("----生成消息处理器------");
		WechatClient wechatClient = wechatFactory.getInstance(oaid);
		WxMpMessageRouter wxMpMessageRouter = new WxMpMessageRouter(wechatClient);
		// 1.加载添加自动回复规则
		// 如果被添加自动回复规则为空或者没有被启用，且存在在我第三方设置的自动回复规则时，那么在我第三方开启设置的被添加自动回复规则生效
		// 如果被添加自动回复规则启用且存在规则，那么我方设置的规则不启用
		List<ReplySetting> replySettingList = replySettingMapper.select(new ReplySetting() {

			/**
			 * TODO（用一句话描述这个变量的含义）
			 */
			private static final long serialVersionUID = 1L;

			{
				setOfficialAccountId(oaid);
				setReplyType(ReplyTypeEnum.ADDFRIENDREPLYOPEN.key());
			}
		});
		if ( isOpenMySetting(replySettingList) ) {
			ReplySetting replySetting = replySettingList.stream().filter(rs -> rs.getPlat().equals(PlatEnum.my.key()))
					.collect(Collectors.toList()).get(0);
			wxMpMessageRouter
					.rule()
					.async(false)
					.event(WxConsts.EVT_SUBSCRIBE)
					.handler(
						( wxMessage, context, wxMpService, sessionManager ) -> getWxMpXmlOutMessage(
							wxMessage, replySetting.getType(), replySetting.getContent(), null)).end();
		}
		// 2.加载关键词自动回复,只加载我方配置的关键词规则
		// 如果自动回复规则开启,那么如果存在微信端设置的关键词自动回复规则，那么不启用微信端设置的关键词自动回复规则，启用在我方开启设置的关键词自动回复规则
		// 如果自动回复规则关闭，那么如果存在关键词自动回复规则，我方设置的关键词回复规则将启用
		List<KeywordReplySettingDto> keywordReplySettingVoList = keywordReplySettingMapper.selectJoin(
			oaid, ReplyOpenEnum.open.key(), PlatEnum.my.key());
		if ( keywordReplySettingVoList != null && keywordReplySettingVoList.size() > 0 ) {
			keywordReplySettingVoList.forEach(keywordReplySettingVo -> {
				if ( Optional.ofNullable(keywordReplySettingVo).isPresent()
						&& Optional.ofNullable(keywordReplySettingVo.getKeywordReplySettingKeywordList()).isPresent()
						&& keywordReplySettingVo.getKeywordReplySettingKeywordList().size() > 0 ) {
					keywordReplySettingVo.getKeywordReplySettingKeywordList().forEach(
						keywordReplySettingKeyword -> {
							KeywordReplySettingReplyDto keywordReplySettingReplyVo = keywordReplySettingVo
									.getKeywordReplySettingReplyVoList().get(0);
							addRule(keywordReplySettingReplyVo, wxMpMessageRouter, keywordReplySettingKeyword);
						});
				}
			});
		}
		// 3.加载自动回复规则
		// 如果自动回复规则微信端已经开启，并且自动回复规则存在，那么使用微信端设置的自动回复规则,，我方不加载。
		// 如果自动回复规则关闭，在我方存在自动回复规则并且开启的情况下，使用我方的自动回复规则
		List<ReplySetting> replySettings = replySettingMapper.select(new ReplySetting() {

			private static final long serialVersionUID = 1L;

			{
				setOfficialAccountId(oaid);
				setReplyType(ReplyTypeEnum.AUTOREPLYOPEN.key());
			}
		});
		if ( isOpenMySetting(replySettings) ) {
			ReplySetting replySetting = replySettings.stream().filter(rs -> rs.getPlat().equals(PlatEnum.my.key()))
					.collect(Collectors.toList()).get(0);
			wxMpMessageRouter
					.rule()
					.async(false)
					.handler(
						( wxMessage, context, wxMpService, sessionManager ) -> getWxMpXmlOutMessage(
							wxMessage, replySetting.getType(), replySetting.getContent(), null)).end();
		}
		MessageRouterSingleton.getInstance().putWxMpMessageRouter(userName, wxMpMessageRouter);
	}


	/**
	 * 添加规则
	 * @param keywordReplySettingReplyVo
	 * @param wxMpMessageRouter
	 * @param keywordReplySettingKeyword
	 */
	private void addRule(
			KeywordReplySettingReplyDto keywordReplySettingReplyVo, WxMpMessageRouter wxMpMessageRouter,
			KeywordReplySettingKeyword keywordReplySettingKeyword ) {
		if ( keywordReplySettingKeyword.getMatchMode().equals(MatchModeEnum.contain.key()) ) {
			wxMpMessageRouter
					.rule()
					.async(false)
					.msgType(MessageTypeEnum.valueOf(keywordReplySettingKeyword.getType()).name())
					.matcher(message -> message.getContent().contains(keywordReplySettingKeyword.getContent()))
					.handler(
						( wxMessage, context, wxMpService, sessionManager ) -> getWxMpXmlOutMessage(
							wxMessage, keywordReplySettingReplyVo.getType(), keywordReplySettingReplyVo.getContent(),
							keywordReplySettingReplyVo.getKeywordReplySettingNewList())).end();
		} else if ( keywordReplySettingKeyword.getMatchMode().equals(MatchModeEnum.equal.key()) ) {
			wxMpMessageRouter
					.rule()
					.async(false)
					.msgType(MessageTypeEnum.valueOf(keywordReplySettingKeyword.getType()).name())
					.content(keywordReplySettingKeyword.getContent())
					.handler(
						( wxMessage, context, wxMpService, sessionManager ) -> getWxMpXmlOutMessage(
							wxMessage, keywordReplySettingReplyVo.getType(), keywordReplySettingReplyVo.getContent(),
							keywordReplySettingReplyVo.getKeywordReplySettingNewList())).end();
		}
	}


	/**
	 * 判断是否打开我方回复配置
	 * @param replySettingList
	 * @return
	 */
	private Boolean isOpenMySetting( List<ReplySetting> replySettingList ) {
		Boolean result = false;
		if ( replySettingList != null && replySettingList.size() > 0 ) {
			List<ReplySetting> replySettingsWeixin = replySettingList.stream()
					.filter(rs -> rs.getPlat().equals(PlatEnum.weixin.key())).collect(Collectors.toList());
			if ( replySettingsWeixin != null && replySettingsWeixin.size() > 0 ) {
				ReplySetting replySetting = replySettingsWeixin.get(0);
				if ( replySetting == null
						|| replySetting.getReplyOpen().equals(ReplyOpenEnum.close.key())
						|| StringUtils.isEmpty(replySetting.getContent()) ) {
					List<ReplySetting> collect = replySettingList.stream()
							.filter(rs -> rs.getPlat().equals(PlatEnum.my.key())).collect(Collectors.toList());
					if ( collect != null && collect.size() > 0 ) {
						if ( collect.get(0).getReplyOpen().equals(ReplyOpenEnum.open.key()) ) {
							result = true;
						}
					}
				}
			}
		}
		return result;
	}


	/**
	 * 生成回复消息
	 * @param wxMpXmlMessage
	 * @param type
	 * @param content
	 * @param keywordReplySettingNewList
	 * @return
	 */
	private WxMpXmlOutMessage getWxMpXmlOutMessage(
			WxMpXmlMessage wxMpXmlMessage, Integer type, String content,
			List<KeywordReplySettingNew> keywordReplySettingNewList ) {
		MessageTypeEnum messageTypeEnum = MessageTypeEnum.valueOf(type);
		switch ( messageTypeEnum ) {
			case text :
				return WxMpXmlOutMessage.TEXT().content(content).fromUser(wxMpXmlMessage.getToUserName())
						.toUser(wxMpXmlMessage.getFromUserName()).build();
			case img :
				return WxMpXmlOutMessage.IMAGE().mediaId(content).fromUser(wxMpXmlMessage.getToUserName())
						.toUser(wxMpXmlMessage.getFromUserName()).build();
			case video :
				return WxMpXmlOutMessage.VIDEO().mediaId(content).fromUser(wxMpXmlMessage.getToUserName())
						.toUser(wxMpXmlMessage.getFromUserName()).build();
			case voice :
				return WxMpXmlOutMessage.VOICE().mediaId(content).fromUser(wxMpXmlMessage.getToUserName())
						.toUser(wxMpXmlMessage.getFromUserName()).build();
			case news :
				NewsBuilder newsBuilder = WxMpXmlOutMessage.NEWS();
				keywordReplySettingNewList.forEach(keywordReplySettingNew -> newsBuilder
						.addArticle(new WxMpXmlOutNewsMessage.Item() {

							{
								setDescription(keywordReplySettingNew.getDigest());
								setPicUrl(keywordReplySettingNew.getCoverUrl());
								setUrl(keywordReplySettingNew.getContentUrl());
								setTitle(keywordReplySettingNew.getTitle());
							}
						}));
				return newsBuilder.fromUser(wxMpXmlMessage.getToUserName()).toUser(wxMpXmlMessage.getFromUserName())
						.build();
			default:
				return null;
		}
	}


	/**
	 * 
	 * 加载公众号配置信息到redis中
	 * <p>
	 * 
	 *
	 * @param officialAccountId 公众号id
	 */
	@Override
	public void addWechatConfigInRedis( Long officialAccountId ) {
		List<OfficialAccountDto> authorizerInfo = officialAccountMapper
				.selectJoinAuthorizerAccessToken(officialAccountId);
		WechatConfig wechatConfig = getWechatConfig(authorizerInfo.get(0));
		redisCache.setValue(officialAccountId, wechatConfig);
	}


	/**
	 * 获取公众号配置信息
	 * (non-Javadoc)
	 */
	@Override
	public WechatConfig getWechatConfig( OfficialAccountDto vo ) {
		return new WechatConfig() {

			private static final long serialVersionUID = 1L;
			{
				setAppId(vo.getAppid());
				setAccountType(vo.getAccountType());
				setOfficialAccountId(vo.getId());
				setUserName(vo.getUserName());
				if ( vo.getAccountType().equals(OfficialAccountTypeEnum.AUTHORIZATION.key()) ) {
					setRefreshToken(vo.getAuthorizerAccessToken().getAuthorizerRefreshToken());
					setAccessToken(vo.getAuthorizerAccessToken().getAuthorizerAccessToken());
					setExpiresTime(vo.getAuthorizerAccessToken().getExpiresIn());
				} else if ( vo.getAccountType().equals(OfficialAccountTypeEnum.UNAUTHORIZATION.key()) ) {
					setSecret(vo.getOfficialAccountInfo().getAppSecret());
					setRefreshToken(vo.getOfficialAccountInfo().getToken());
					setAesKey(vo.getOfficialAccountInfo().getEncodingAesKey());
					if ( vo.getOfficialAccountAccessToken() != null ) {
						if ( vo.getOfficialAccountAccessToken().getAccessToken() != null ) {
							setAccessToken(vo.getOfficialAccountAccessToken().getAccessToken());
						}
						if ( vo.getOfficialAccountAccessToken().getExpiresIn() != null ) {
							setExpiresTime(vo.getOfficialAccountAccessToken().getExpiresIn());
						}
					}
				}
			}
		};
	}


}
