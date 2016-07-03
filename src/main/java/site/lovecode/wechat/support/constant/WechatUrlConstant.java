package site.lovecode.wechat.support.constant;

/**
 * Created by Administrator on 2016/4/6.
 */
public class WechatUrlConstant {

	/**
	 * 获取component_access_token的url
	 */
	public static final String API_COMPONENT_TOKEN = "https://api.weixin.qq.com/cgi-bin/component/api_component_token";

	/**
	 * 获取预授权码url
	 */
	public static final String API_CREATE_PREAUTHCODE = "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token=";


	/**
	 *获取授权页面地址
	 */
	public static final String COMPONENT_LOGIN_PAGE = "https://mp.weixin.qq.com/cgi-bin/componentloginpage?";


	/**
	 * 使用授权码换取公众号的接口调用凭据和授权信息url
	 */
	public static final String API_QUERY_AUTH = "https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token=";


	/**
	 * 获取授权方公账号信息
	 */
	public static final String API_GET_AUTHORIZER_INFO = "https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info?component_access_token=";


	/**
	 * 获取（刷新）授权公众号的接口调用凭据（令牌）
	 */
	public static final String API_AUTHORIZER_TOKEN = "https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token?component_access_token=";


	/**
	 * 获取授权方选项设置信息
	 */
	public static final String API_GET_AUTHORIZER_OPTION = "https://api.weixin.qq.com/cgi-bin/component/ api_get_authorizer_option?component_access_token=";


	/**
	 * 设置授权方选项信息
	 */
	public static final String API_SET_AUTHORIZER_OPTION = "https://api.weixin.qq.com/cgi-bin/component/ api_set_authorizer_option?component_access_token=";


}
