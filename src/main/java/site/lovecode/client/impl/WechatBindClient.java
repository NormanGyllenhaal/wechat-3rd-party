package site.lovecode.client.impl;


import me.chanjar.weixin.common.bean.WxAccessToken;
import me.chanjar.weixin.common.bean.result.WxError;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.springframework.stereotype.Service;
import site.lovecode.jedis.RedisCache;
import site.lovecode.mapper.OfficialAccountAccessTokenMapper;
import site.lovecode.support.bean.config.WechatConfig;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by Administrator on 2016/4/19.
 */
@Service( "wechatBindClient" )
public class WechatBindClient extends WechatClientImpl {


	@Resource
	private OfficialAccountAccessTokenMapper officialAccountAccessTokenMapper;

	@Resource
	private RedisCache redisCache;


	@Override
	public String getAccessToken( boolean forceRefresh ) throws WxErrorException {
		if ( forceRefresh ) {
			wxMpConfigStorage.expireAccessToken();
		}
		if ( wxMpConfigStorage.isAccessTokenExpired() ) {
			synchronized ( globalAccessTokenRefreshLock ) {
				if ( wxMpConfigStorage.isAccessTokenExpired() ) {
					String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential"
							+ "&appid=" + wxMpConfigStorage.getAppId() + "&secret=" + wxMpConfigStorage.getSecret();
					try {
						HttpGet httpGet = new HttpGet(url);
						if ( httpProxy != null ) {
							RequestConfig config = RequestConfig.custom().setProxy(httpProxy).build();
							httpGet.setConfig(config);
						}
						CloseableHttpResponse response = getHttpclient().execute(httpGet);
						String resultContent = new BasicResponseHandler().handleResponse(response);
						WxError error = WxError.fromJson(resultContent);
						if ( error.getErrorCode() != 0 ) { throw new WxErrorException(error); }
						WxAccessToken accessToken = WxAccessToken.fromJson(resultContent);
						wxMpConfigStorage.updateAccessToken(accessToken.getAccessToken(), accessToken.getExpiresIn());
						WechatConfig wechatConfig = (WechatConfig) wxMpConfigStorage;
						log.info("更新redis中的值");
						redisCache.setValue(wechatConfig.getOfficialAccountId(), wechatConfig);
						log.info("更新数据库中的access_token");
						officialAccountAccessTokenMapper.updateByOfficialAccount(
							accessToken.getAccessToken(),
							(accessToken.getExpiresIn() * 1000) + System.currentTimeMillis(),
							wechatConfig.getOfficialAccountId());

					} catch ( ClientProtocolException e ) {
						throw new RuntimeException(e);
					} catch ( IOException e ) {
						throw new RuntimeException(e);
					}
				}
			}
		}
		return wxMpConfigStorage.getAccessToken();
	}
}
