package site.lovecode.client;


import me.chanjar.weixin.common.bean.WxMenu;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.stereotype.Service;

/**
 * 微信接口调用客户端
 * @author Yang Peng
 * @date:2015-2-5 上午11:02:53
 */

public interface WechatClient {

	/**
	 * 获取accessToken
	 * @param appid
	 * @param appsecret
	 * @return
	 * @throws Exception
	 */
	public String getAccessToken(String appid, String appsecret) throws Exception;
	/**
	 * 获取用户的openid
	 * @param appid
	 * @param secret
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public String getOpenId(String appid, String secret, String code) throws Exception;
	/**
	 * 获取用户信息
	 * @param access_token
	 * @param openid
	 * @return
	 * @throws Exception
	 */
	public String getUser(String access_token, String openid) throws Exception;


	/**
	 * 获取WxMpService实例
	 * @return
     */
	public WxMpService getWxMpService();



	public WxMpService getWxMpService(String appId,String secret,String token,String aeskey);


	/**
	 * 设置自定义菜单
	 * @return
     */
	public Boolean setMenu(WxMenu wxMenu);


	/**
	 * 获取自定义菜单
	 * @return
	 * @throws WxErrorException
     */
	public WxMenu getMenu() throws WxErrorException;


	/**
	 * 主动发送消息
	 * @param openId
	 * @throws WxErrorException
     */
	public void setMessage(String openId) throws WxErrorException;




}
