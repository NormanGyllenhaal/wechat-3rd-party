package site.lovecode.service.impl;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import site.lovecode.client.impl.WechatClientImpl;
import site.lovecode.entity.AuthorizerAccessToken;
import site.lovecode.mapper.AuthorizerAccessTokenMapper;
import site.lovecode.service.WechatService;
import site.lovecode.support.bean.config.WechatConfig;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2016/4/13.
 */
@Service
public class WechatServiceImpl implements InitializingBean,WechatService{

    private Logger logger = LoggerFactory.getLogger(WechatServiceImpl.class);

    @Resource
    private UserAccessTokenMapper userAccessTokenMapper;

    @Resource
    private AuthorizerAccessTokenMapper authorizerAccessTokenMapper;

    @Resource
    private WxMpService wxMpService;

    @Override
    public void afterPropertiesSet() throws Exception {
       logger.info("加载所有公众号配置信息");
        List<AuthorizerAccessToken> authorizerAccessTokenList = authorizerAccessTokenMapper.selectAll();
        WechatClientImpl.wechatConfigMap = authorizerAccessTokenList.stream().collect(Collectors.toMap(AuthorizerAccessToken::getOfficialAccountId,authorizerAccessToken -> new WechatConfig(){
            {
                setAppId(authorizerAccessToken.getAuthorizerAppid());
                setRefreshToken(authorizerAccessToken.getAuthorizerRefreshToken());
                setAccessToken(authorizerAccessToken.getAuthorizerAccessToken());
                setExpiresTime(authorizerAccessToken.getCreateTime().getTime()+(authorizerAccessToken.getExpiresIn()*1000));
            }
        }));
        logger.info(WechatClientImpl.wechatConfigMap.toString());
    }


    public void getAccessToken(){
        try {
            wxMpService.setWxMpConfigStorage(WechatClientImpl.wechatConfigMap.get(414012288513605632L));
            wxMpService.getAccessToken();
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }


}

