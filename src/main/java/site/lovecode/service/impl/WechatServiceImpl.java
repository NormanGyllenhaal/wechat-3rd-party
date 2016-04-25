package site.lovecode.service.impl;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import site.lovecode.client.WechatClient;
import site.lovecode.client.WechatFactory;
import site.lovecode.client.WechatThirdPartyClient;
import site.lovecode.client.impl.WechatThirdPartyClientImpl;
import site.lovecode.entity.ComponentVerifyTicket;
import site.lovecode.entity.OfficialAccount;
import site.lovecode.jedis.RedisCache;
import site.lovecode.mapper.*;
import site.lovecode.service.WechatService;
import site.lovecode.support.bean.config.WechatConfig;
import site.lovecode.support.bean.enums.OfficialAccountTypeEnum;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2016/4/13.
 */
@Service
public class WechatServiceImpl implements InitializingBean, WechatService {

    private Logger logger = LoggerFactory.getLogger(WechatServiceImpl.class);

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
    private KeywordReplySettingKeywordMapper keywordReplySettingKeywordMapper;

    @Resource
    private KeywordReplySettingReplyMapper keywordReplySettingReplyMapper;

    @Resource
    private KeywordReplySettingNewMapper keywordReplySettingNewMapper;

    @Resource
    private WechatFactory wechatFactory;

    @Override
    public void afterPropertiesSet() throws Exception {
        loadWechatThirdPartyConfig();
        loadWechatConfig();

    }


    public void loadWechatThirdPartyConfig() throws WxErrorException {
        logger.info("----加载公众号第三方配置----");
        WechatThirdPartyClientImpl.wechatThirdPartyConfig = wechatThirdPartyConfigMapper.selectByPrimaryKey(1L);
        //获取已经存储的ticket
        ComponentVerifyTicket componentVerifyTicket = componentVerifyTicketMapper.selectOrderByCreateTime(WechatThirdPartyClientImpl.wechatThirdPartyConfig.getComponentAppid());
        if (Optional.ofNullable(componentVerifyTicket).isPresent() && componentVerifyTicket.getDeadline().getTime() > System.currentTimeMillis()) {
            WechatThirdPartyClientImpl.wechatThirdPartyConfig.setComponentVerifyTicket(componentVerifyTicket.getComponentVerifyTicket());
            WechatThirdPartyClientImpl.wechatThirdPartyConfig.setComponentAccessToken(wechatThirdPartyClient.refreshComponentAccessToken().getComponentAccessToken());
        }
        logger.info(WechatThirdPartyClientImpl.wechatThirdPartyConfig.toString());
    }



    public void loadWechatConfig(){
        logger.info("加载所有公众号配置信息");
        Map<Long, WechatConfig> wechatConfigMap = Stream.of(officialAccountMapper.selectJoinAuthorizerInfo(), officialAccountMapper.selectJoinInfoAndAccessToken()).flatMap(officialAccountVo -> officialAccountVo.stream()).collect(Collectors.toList()).stream().collect(Collectors.toMap(OfficialAccount::getId, vo -> new WechatConfig() {
            {
                setAppId(vo.getAppid());
                setAccountType(vo.getAccountType());
                setOfficialAccountId(vo.getId());
                setUserName(vo.getUserName());
                if (vo.getAccountType().equals(OfficialAccountTypeEnum.AUTHORIZATION.key())) {
                    setRefreshToken(vo.getAuthorizerAccessToken().getAuthorizerRefreshToken());
                    setAccessToken(vo.getAuthorizerAccessToken().getAuthorizerAccessToken());
                    setExpiresTime(vo.getAuthorizerAccessToken().getExpiresIn());
                } else if (vo.getAccountType().equals(OfficialAccountTypeEnum.UNAUTHORIZATION.key())) {
                    setSecret(vo.getOfficialAccountInfo().getAppSecret());
                    setRefreshToken(vo.getOfficialAccountInfo().getToken());
                    setAesKey(vo.getOfficialAccountInfo().getEncodingAesKey());
                    if (vo.getOfficialAccountAccessToken() != null) {
                        if (vo.getOfficialAccountAccessToken().getAccessToken() != null) {
                            setAccessToken(vo.getOfficialAccountAccessToken().getAccessToken());
                        }
                        if (vo.getOfficialAccountAccessToken().getExpiresIn() != null) {
                            setExpiresTime(vo.getOfficialAccountAccessToken().getExpiresIn());
                        }
                    }
                }
            }
        }));
        logger.info("" + wechatConfigMap.size());
        wechatConfigMap.forEach((aLong, wechatConfig) -> {
                    redisCache.set(aLong, wechatConfig);
                    redisCache.set(wechatConfig.getUserName(),aLong.toString());
                }
        );
        logger.info(wechatConfigMap.toString());
    }



    private void loadReplySetting(){
        List<OfficialAccount> officialAccountList = officialAccountMapper.selectAll();
        officialAccountList.forEach(officialAccount -> {
            WechatClient wechatClient = wechatFactory.getInstance(officialAccount.getId());
            WxMpMessageRouter wxMpMessageRouter = new WxMpMessageRouter(wechatClient);

        });
    }




}

