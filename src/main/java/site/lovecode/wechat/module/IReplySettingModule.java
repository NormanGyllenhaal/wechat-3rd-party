/**
 * IReplySettingModule.java cn.vko.peixun.core.module.communication Copyright
 * (c) 2016, .
 */
/**
 * IReplySettingModule.java cn.vko.peixun.core.module.communication Copyright
 * (c) 2016, .
 */


package site.lovecode.wechat.module;


import org.apache.struts.util.ModuleException;
import site.lovecode.wechat.support.common.Response;

/**
 * 自动回复信息接口
 * <p>
 * 
 *
 * @author   Administrator
 * @date	 2016年5月17日 
 * @version  1.0.0	 
 */
public interface IReplySettingModule {


	/**
	 * 
	 * 添加被添加自动回复
	 * <p>
	 * 
	 *
	 * @param oaid
	 * @param type
	 * @param content
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	public Response<Boolean> addFriendReplySetting(Long oaid, Integer type, String content) throws ModuleException;


	/**
	 * 
	 * 添加消息自动回复
	 * <p>
	 * 
	 *
	 * @param oaid
	 * @param type
	 * @param content
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	public Response<Boolean> addAutoReplySetting(Long oaid, Integer type, String content) throws ModuleException;

}
