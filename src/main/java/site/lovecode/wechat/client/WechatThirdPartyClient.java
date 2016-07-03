package site.lovecode.wechat.client;


import me.chanjar.weixin.common.exception.WxErrorException;
import site.lovecode.wechat.support.bean.*;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/1.
 */
public interface WechatThirdPartyClient {

	/**
	 * 获取刷新component_access_token
	 *
	 * @return
	 */
	ComponentAccessTokenBean refreshComponentAccessToken() throws WxErrorException;


	/**
	 * 获取预授权码pre_auth_code
	 *
	 * @return
	 * @throws IOException
	 */
	PreAuthCodeBean getPreAuthCode() throws WxErrorException;


	/**
	 * 获取授权页面地址
	 *
	 * @param perAuthCode
	 * @return
	 */
	String getAuthOrizationUrl(String perAuthCode);


	/**
	 * 使用授权码换取公众号的接口调用凭据和授权信息
	 *
	 * @param authorizationCode
	 * @return
	 * @throws IOException
	 */
	QueryAuthBean queryAuth(String authorizationCode) throws WxErrorException;


	/**
	 * 获取授权方公账号信息
	 *
	 * @param authorizerAppid
	 * @return
	 */
	AuthorizerInfoBean getAuthorizerInfo(String authorizerAppid) throws WxErrorException;


	/**
	 * 获取（刷新）授权公众号的接口调用凭据（令牌）
	 *
	 * @param authorizerAppid
	 * @param authorizerRefreshToken
	 * @return
	 */
	AuthorizerTokenBean refreshAuthorizerToken(String authorizerAppid, String authorizerRefreshToken)
		throws WxErrorException;


	/**
	 * 获取授权方的选项设置信息
	 *
	 * @param authorizerAppid
	 * @param optionName
	 * @return
	 */
	GetAuthorizerOptionBean getAuthorizerOption(String authorizerAppid, String optionName) throws WxErrorException;


	/**
	 * 设置授权方选项信息
	 *
	 * @param authorizerAppid
	 * @param maps
	 */
	void setAuthorizerOption(String authorizerAppid, Map<String, String> maps) throws WxErrorException;


}
