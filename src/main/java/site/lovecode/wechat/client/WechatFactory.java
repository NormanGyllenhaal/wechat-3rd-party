package site.lovecode.wechat.client;


import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import site.lovecode.wechat.jedis.RedisCache;
import site.lovecode.wechat.support.config.WechatConfig;
import site.lovecode.wechat.support.enums.OfficialAccountTypeEnum;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/4/19.
 */


@Service
public class WechatFactory {


	private final Logger logger = LoggerFactory.getLogger(WechatFactory.class);

	@Resource
	private WechatClient wechatAuthorizationClient;

	@Resource
	private WechatClient wechatBindClient;

	@Resource
	private RedisCache redisCache;


	public WechatClient getWechatClient() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		Long officialAccountId = Long.parseLong(request.getParameter("oaid"));
		return getInstance(officialAccountId);
	}


	public WechatClient getWechatClient( String userName ) {
		logger.info(redisCache.getValue(userName));
		Long officialAccountId = Long.parseLong(redisCache.getValue(userName));
		return getInstance(officialAccountId);
	}


	public WechatClient getInstance( Long officialAccountId ) {
		WechatConfig wechatConfig = JSON.parseObject(redisCache.getValue(officialAccountId), WechatConfig.class);
		if ( wechatConfig.getAccountType().equals(OfficialAccountTypeEnum.AUTHORIZATION.key()) ) {
			wechatAuthorizationClient.setWxMpConfigStorage(wechatConfig);
			return wechatAuthorizationClient;
		} else {
			wechatBindClient.setWxMpConfigStorage(wechatConfig);
			return wechatBindClient;
		}
	}

}
