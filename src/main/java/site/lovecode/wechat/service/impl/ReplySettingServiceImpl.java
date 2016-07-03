package site.lovecode.wechat.service.impl;


import me.chanjar.weixin.common.exception.WxErrorException;
import org.springframework.stereotype.Service;
import site.lovecode.wechat.client.WechatClient;
import site.lovecode.wechat.client.WechatFactory;
import site.lovecode.wechat.entity.*;
import site.lovecode.wechat.mapper.*;
import site.lovecode.wechat.service.IReplySettingService;
import site.lovecode.wechat.support.bean.AutoReplyInfoBean;
import site.lovecode.wechat.support.enums.*;
import site.lovecode.wechat.util.IdWorker;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2016/4/22.
 */
@Service
public class ReplySettingServiceImpl implements IReplySettingService {

	@Resource
	private WechatFactory wechatFactory;

	@Resource
	private ReplySettingMapper replySettingMapper;

	@Resource
	private KeywordReplySettingMapper keywordReplySettingMapper;

	@Resource
	private KeywordReplySettingKeywordMapper keywordReplySettingKeywordMapper;

	@Resource
	private KeywordReplySettingReplyMapper keywordReplySettingReplyMapper;

	@Resource
	private KeywordReplySettingNewMapper keywordReplySettingNewMapper;


	@Override
	public void getAutoReplySetting( Long oaid ) throws WxErrorException {
		WechatClient wechatClient = wechatFactory.getInstance(oaid);
		AutoReplyInfoBean autoReplyInfoBean = wechatClient.getCurrentAutoreplyInfo();
		// 接口调用成功后，首先删除之前保存的信息
		deleteOldSetting(oaid);

		// 保存添加粉丝自动回复设置
		saveAddFriendReplySetting(autoReplyInfoBean, oaid);

		// 保存消息回复自动设置
		saveReplaySetting(autoReplyInfoBean, oaid);

		// 关键词自动回复设置
		saveKeywordReplySetting(autoReplyInfoBean, oaid);

	}


	/**
	 * 
	 * 设置被添加自动回复
	 * <p>
	 * 
	 *
	 * @param oaid
	 * @param type
	 * @param content TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@Override
	public void setAddFriendReplySetting( Long oaid, Integer type, String content ) {
		replySettingMapper.insertSelective(new ReplySetting() {

			private static final long serialVersionUID = 1L;

			{
				setOfficialAccountId(oaid);
				setReplyOpen(ReplyOpenEnum.open.key());
				setReplyType(ReplyTypeEnum.ADDFRIENDREPLYOPEN.key());
				setType(type);
				setContent(content);
				setPlat(PlatEnum.my.key());
			}
		});
	}


	/**
	 * 
	 * 设置消息自动回复
	 * <p>
	 * 
	 *
	 * @param oaid
	 * @param type
	 * @param content TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@Override
	public void setAutoReplySetting( Long oaid, Integer type, String content ) {
		replySettingMapper.insertSelective(new ReplySetting() {

			private static final long serialVersionUID = 1L;

			{
				setOfficialAccountId(oaid);
				setReplyOpen(ReplyOpenEnum.open.key());
				setReplyType(ReplyTypeEnum.AUTOREPLYOPEN.key());
				setType(type);
				setContent(content);
				setPlat(PlatEnum.my.key());
			}
		});

	}


	/**
	 * 
	 * 保存添加粉丝自动回复设置
	 * <p>
	 * 
	 *
	 * @param autoReplyInfoBean
	 * @param oaid TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	private void saveAddFriendReplySetting( AutoReplyInfoBean autoReplyInfoBean, Long oaid ) {
		if ( autoReplyInfoBean.getAddFriendAutoreplyInfo() != null ) {
			replySettingMapper.insert(new ReplySetting() {

				private static final long serialVersionUID = 1L;

				{
					setOfficialAccountId(oaid);
					setReplyOpen(autoReplyInfoBean.getIsAddFriendReplyOpen());
					setReplyType(ReplyTypeEnum.ADDFRIENDREPLYOPEN.key());
					setType(MessageTypeEnum.getValue(autoReplyInfoBean.getAddFriendAutoreplyInfo().getType()));
					setContent(autoReplyInfoBean.getAddFriendAutoreplyInfo().getContent());
					setPlat(PlatEnum.weixin.key());
				}
			});
		} else {
			replySettingMapper.insert(new ReplySetting() {

				private static final long serialVersionUID = 1L;

				{
					setOfficialAccountId(oaid);
					setReplyOpen(autoReplyInfoBean.getIsAddFriendReplyOpen());
					setReplyType(ReplyTypeEnum.ADDFRIENDREPLYOPEN.key());
					setPlat(PlatEnum.weixin.key());
				}
			});
		}
	}


	/**
	 * 
	 * 保存消息自动回复设置
	 * <p>
	 * 
	 *
	 * @param autoReplyInfoBean
	 * @param oaid TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	private void saveReplaySetting( AutoReplyInfoBean autoReplyInfoBean, Long oaid ) {
		if ( autoReplyInfoBean.getMessageDefaultAutoreplyInfo() != null ) {
			replySettingMapper.insert(new ReplySetting() {


				private static final long serialVersionUID = 1L;

				{
					setOfficialAccountId(oaid);
					setReplyOpen(autoReplyInfoBean.getIsAutoreplyOpen());
					setReplyType(ReplyTypeEnum.AUTOREPLYOPEN.key());
					setType(MessageTypeEnum.getValue(autoReplyInfoBean.getMessageDefaultAutoreplyInfo().getType()));
					setContent(autoReplyInfoBean.getMessageDefaultAutoreplyInfo().getContent());
					setPlat(PlatEnum.weixin.key());
				}
			});
		} else {
			replySettingMapper.insert(new ReplySetting() {

				private static final long serialVersionUID = 1L;

				{
					setOfficialAccountId(oaid);
					setReplyOpen(autoReplyInfoBean.getIsAutoreplyOpen());
					setReplyType(ReplyTypeEnum.AUTOREPLYOPEN.key());
					setPlat(PlatEnum.weixin.key());
				}
			});
		}
	}


	/**
	 * 
	 *  保存关键词自动回复设置
	 * <p>
	 *
	 * @param autoReplyInfoBean
	 * @param oaid TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	private void saveKeywordReplySetting( AutoReplyInfoBean autoReplyInfoBean, Long oaid ) {

		if ( autoReplyInfoBean.getKeywordAutoreplyInfo() != null ) {
			autoReplyInfoBean
					.getKeywordAutoreplyInfo()
					.getList()
					.forEach(
						listBean -> {

							KeywordReplySetting keywordReplySetting = new KeywordReplySetting() {

								private static final long serialVersionUID = 1L;

								{
									setOfficialAccountId(oaid);
									setRuleName(listBean.getRuleName());
									setReplyMod(ReplyModeEnum.valueOf(listBean.getReplyMode()).key());
									setCreateTime(new Timestamp((listBean.getCreateTime() * 1000)));
									setPlat(PlatEnum.weixin.key());
									setReplyOpen(autoReplyInfoBean.getIsAutoreplyOpen());
								}
							};
							keywordReplySettingMapper.insert(keywordReplySetting);
							List<KeywordReplySettingKeyword> keywordReplySettingKeywordList = listBean
									.getKeywordListInfo().stream()
									.map(keywordListInfoBean -> new KeywordReplySettingKeyword() {

										private static final long serialVersionUID = 1L;

										{
											setKeywordReplySettingId(keywordReplySetting.getId());
											setType(MessageTypeEnum.valueOf(keywordListInfoBean.getType()).getKey());
											setMatchMode(MatchModeEnum.valueOf(keywordListInfoBean.getMatchMode())
													.key());
											setContent(keywordListInfoBean.getContent());
										}
									}).collect(Collectors.toList());
							keywordReplySettingKeywordMapper.batchInsert(keywordReplySettingKeywordList);
							listBean.getReplyListInfo().forEach(
								replyListInfoBean -> {
									KeywordReplySettingReply keywordReplySettingReply = new KeywordReplySettingReply() {

										private static final long serialVersionUID = 1L;

										{
											setKeywordReplySettingId(keywordReplySetting.getId());
											setType(MessageTypeEnum.valueOf(replyListInfoBean.getType()).getKey());
											setContent(replyListInfoBean.getContent());
										}
									};
									keywordReplySettingReplyMapper.insert(keywordReplySettingReply);
									if ( replyListInfoBean.getNewsInfo() != null
											&& replyListInfoBean.getNewsInfo().getList().size() != 0 ) {
										List<KeywordReplySettingNew> keywordReplySettingNewList = replyListInfoBean
												.getNewsInfo().getList().stream()
												.map(news -> new KeywordReplySettingNew() {

													private static final long serialVersionUID = 1L;

													{
														setId(IdWorker.getId());
														setKeywordReplySettingReplyId(keywordReplySettingReply.getId());
														setTitle(news.getTitle());
														setAuthor(news.getAuthor());
														setDigest(news.getDigest());
														setShowCover(news.getShowCover());
														setCoverUrl(news.getCoverUrl());
														setContentUrl(news.getContentUrl());
														setSourceUrl(news.getContentUrl());
													}
												}).collect(Collectors.toList());
										keywordReplySettingNewMapper.batchInsert(keywordReplySettingNewList);
									}
								});
						});
		}

	}


	/**
	 * 
	 * 删除所有公众号自动回复设置
	 * <p>
	 * 
	 *
	 * @param oaid TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	private void deleteOldSetting( Long oaid ) {
		replySettingMapper.delete(new ReplySetting() {

			private static final long serialVersionUID = 1L;

			{
				setOfficialAccountId(oaid);
				setPlat(PlatEnum.weixin.key());
			}
		});
		List<KeywordReplySetting> keywordReplySettingList = keywordReplySettingMapper.select(new KeywordReplySetting() {


			private static final long serialVersionUID = 1L;

			{
				setOfficialAccountId(oaid);
				setPlat(PlatEnum.weixin.key());
			}
		});
		if ( keywordReplySettingList != null && keywordReplySettingList.size() > 0 ) {
			keywordReplySettingMapper.delete(new KeywordReplySetting() {

				private static final long serialVersionUID = 1L;

				{
					setOfficialAccountId(oaid);
					setPlat(PlatEnum.weixin.key());
				}
			});
			keywordReplySettingList.forEach(keywordReplySetting -> {
				keywordReplySettingKeywordMapper.delete(new KeywordReplySettingKeyword() {

					private static final long serialVersionUID = 1L;

					{
						setKeywordReplySettingId(keywordReplySetting.getId());
					}
				});
				List<KeywordReplySettingReply> keywordReplySettingReplies = keywordReplySettingReplyMapper
						.select(new KeywordReplySettingReply() {

							private static final long serialVersionUID = 1L;

							{
								setKeywordReplySettingId(keywordReplySetting.getId());
							}
						});
				keywordReplySettingReplyMapper.delete(new KeywordReplySettingReply() {

					private static final long serialVersionUID = 1L;

					{
						setKeywordReplySettingId(keywordReplySetting.getId());
					}
				});
				keywordReplySettingReplies.forEach(keywordReplySettingReply -> {
					keywordReplySettingNewMapper.delete(new KeywordReplySettingNew() {

						private static final long serialVersionUID = 1L;

						{
							setKeywordReplySettingReplyId(keywordReplySettingReply.getId());
						}
					});
				});
			});

		}
	}


}
