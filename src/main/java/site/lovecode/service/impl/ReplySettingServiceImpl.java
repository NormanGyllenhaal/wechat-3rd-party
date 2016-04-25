package site.lovecode.service.impl;

import me.chanjar.weixin.common.exception.WxErrorException;
import org.springframework.stereotype.Service;
import site.lovecode.client.WechatClient;
import site.lovecode.client.WechatFactory;
import site.lovecode.entity.*;
import site.lovecode.mapper.*;
import site.lovecode.service.ReplySettingService;
import site.lovecode.support.bean.enums.*;
import site.lovecode.support.bean.json.AutoReplyInfoBean;
import site.lovecode.util.IdWorker;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2016/4/22.
 */
@Service
public class ReplySettingServiceImpl implements ReplySettingService{

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
    public void getAutoReplySetting(Long oaid) throws WxErrorException {
         WechatClient wechatClient = wechatFactory.getWechatClient();
         AutoReplyInfoBean autoReplyInfoBean = wechatClient.getCurrentAutoreplyInfo();
         //接口调用成功后，首先删除之前保存的信息
         deleteOldSetting(oaid);


        if(autoReplyInfoBean.getAddFriendAutoreplyInfo()!=null){
            replySettingMapper.insert(new ReplySetting(){
                {
                    setOfficialAccountId(oaid);
                    setReplyOpen(autoReplyInfoBean.getIsAddFriendReplyOpen());
                    setReplyType(ReplyTypeEnum.ADDFRIENDREPLYOPEN.key());
                    setType(MessageTypeEnum.getValue(autoReplyInfoBean.getAddFriendAutoreplyInfo().getType()));
                    setContent(autoReplyInfoBean.getAddFriendAutoreplyInfo().getContent());
                    setPlat(PlatEnum.weixin.key());
                }
            });
        }

        if(autoReplyInfoBean.getMessageDefaultAutoreplyInfo()!=null){
            replySettingMapper.insert(new ReplySetting(){
                {
                    setOfficialAccountId(oaid);
                    setReplyOpen(autoReplyInfoBean.getIsAutoreplyOpen());
                    setReplyType(ReplyTypeEnum.AUTOREPLYOPEN.key());
                    setType(MessageTypeEnum.getValue(autoReplyInfoBean.getMessageDefaultAutoreplyInfo().getType()));
                    setContent(autoReplyInfoBean.getMessageDefaultAutoreplyInfo().getContent());
                    setPlat(PlatEnum.weixin.key());
                }
            });
        }

        if(autoReplyInfoBean.getKeywordAutoreplyInfo()!=null){
            autoReplyInfoBean.getKeywordAutoreplyInfo().getList().forEach(listBean -> {

                KeywordReplySetting keywordReplySetting = new KeywordReplySetting() {
                    {
                        setOfficialAccountId(oaid);
                        setRuleName(listBean.getRuleName());
                        setReplyMod(ReplyModeEnum.valueOf(listBean.getReplyMode()).key());
                        setCreateTime(new Timestamp((listBean.getCreateTime() * 1000)));
                        setPlat(PlatEnum.weixin.key());
                    }
                };
                keywordReplySettingMapper.insert(keywordReplySetting);
                List<KeywordReplySettingKeyword> keywordReplySettingKeywordList = listBean.getKeywordListInfo().stream().map(keywordListInfoBean -> new KeywordReplySettingKeyword() {
                    {
                        setId(IdWorker.getId());
                        setKeywordReplySettingId(keywordReplySetting.getId());
                        setType(MessageTypeEnum.valueOf(keywordListInfoBean.getType()).getKey());
                        setMatchMode(MatchModeEnum.valueOf(keywordListInfoBean.getMatchMode()).key());
                        setContent(keywordListInfoBean.getContent());
                    }
                }).collect(Collectors.toList());
                keywordReplySettingKeywordMapper.batchInsert(keywordReplySettingKeywordList);
                listBean.getReplyListInfo().forEach(replyListInfoBean -> {
                    KeywordReplySettingReply keywordReplySettingReply = new KeywordReplySettingReply() {
                        {
                            setKeywordReplySettingId(keywordReplySetting.getId());
                            setType(MessageTypeEnum.valueOf(replyListInfoBean.getType()).getKey());
                            setContent(replyListInfoBean.getContent());
                        }
                    };
                    keywordReplySettingReplyMapper.insert(keywordReplySettingReply);
                    if(replyListInfoBean.getNewsInfo()!=null&&replyListInfoBean.getNewsInfo().getList().size()!=0){
                        List<KeywordReplySettingNew> keywordReplySettingNewList = replyListInfoBean.getNewsInfo().getList().stream().map(news -> new KeywordReplySettingNew() {
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

    public void deleteOldSetting(Long oaid){
        replySettingMapper.delete(new ReplySetting() {
            {
                setOfficialAccountId(oaid);
                setPlat(PlatEnum.weixin.key());
            }
        });
        List<KeywordReplySetting> keywordReplySettingList = keywordReplySettingMapper.select(new KeywordReplySetting() {
            {
                setOfficialAccountId(oaid);
                setPlat(PlatEnum.weixin.key());
            }
        });
        if(keywordReplySettingList!=null&&keywordReplySettingList.size()>0){
            keywordReplySettingMapper.delete(new KeywordReplySetting(){
                {
                    setOfficialAccountId(oaid);
                    setPlat(PlatEnum.weixin.key());
                }
            });
            keywordReplySettingList.forEach(keywordReplySetting -> {
                keywordReplySettingKeywordMapper.delete(new KeywordReplySettingKeyword(){
                    {
                        setKeywordReplySettingId(keywordReplySetting.getId());
                    }
                });
                List<KeywordReplySettingReply> keywordReplySettingReplies = keywordReplySettingReplyMapper.select(new KeywordReplySettingReply() {
                    {
                        setKeywordReplySettingId(keywordReplySetting.getId());
                    }
                });
                keywordReplySettingReplyMapper.delete(new KeywordReplySettingReply(){
                    {
                        setKeywordReplySettingId(keywordReplySetting.getId());
                    }
                });
                keywordReplySettingReplies.forEach(keywordReplySettingReply -> {
                    keywordReplySettingNewMapper.delete(new KeywordReplySettingNew(){
                        {
                            setKeywordReplySettingReplyId(keywordReplySettingReply.getId());
                        }
                    });
                });
            });

        }
    }
}
