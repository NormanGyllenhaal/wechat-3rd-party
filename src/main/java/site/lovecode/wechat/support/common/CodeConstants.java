/**
 * Code.java cn.vko.core.common.code Copyright (c) 2014, .
 */

package site.lovecode.wechat.support.common;


/**
 * 这里定义所有的返回异常的代码
 * 
 * @author malei
 * @date 2015-11-22
 * @version 1.0.0
 */
public class CodeConstants {

	// 正确返回数据时的应答码
	public static String SUCCESS = "000000";

	// 异常时返回的应答码
	public static String EXCEPTION = "000001";

	// 参数校验未通过时的应答码
	public static String PARAM_ERROR = "000002";

	// 校验登陆信息异常时的应答码
	public static String AUTH_ERROR = "000003";

	// 无权限访问时的应答码
	public static String NO_PERMISSION = "000004";

	// TOKEN失效时返回应答码
	public static String TOKEN_INVALID = "000005";


	// 参数校验未通过文本描述
	public static String PARAM_ERROR_DESC = "参数校验未通过,请检查.";

	// 无权访问的文本描述
	public static String NO_PERMISSION_DESC = "您未获访问此链接的权限,请联系管理员.";

	// module层发生异常的描述信息
	public static String EXCEPTION_MODULE_DESC = "module层发生异常,请联系接口开发人员.";

	// WEB层发生异常的描述信息
	public static String EXCEPTION_WEB_DESC = "系统忙,请稍后再试.";

}
