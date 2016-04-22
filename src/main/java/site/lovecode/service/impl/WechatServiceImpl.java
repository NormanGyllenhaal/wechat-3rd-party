package site.lovecode.service.impl;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import site.lovecode.entity.OfficialAccount;
import site.lovecode.jedis.RedisCache;
import site.lovecode.mapper.OfficialAccountMapper;
import site.lovecode.service.WechatService;
import site.lovecode.support.bean.config.WechatConfig;
import site.lovecode.support.bean.enums.OfficialAccountTypeEnum;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2016/4/13.
 */
@Service
public class WechatServiceImpl implements InitializingBean, WechatService, Serializable {

    private Logger logger = LoggerFactory.getLogger(WechatServiceImpl.class);

    @Resource
    private RedisCache redisCache;

    @Resource
    private WxMpService wechatAuthorizationClient;

    @Resource
    private OfficialAccountMapper officialAccountMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
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


    public void getAccessToken() {
        try {
            wechatAuthorizationClient.getAccessToken();
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }


}

