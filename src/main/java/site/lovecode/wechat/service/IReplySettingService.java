package site.lovecode.wechat.service;

import me.chanjar.weixin.common.exception.WxErrorException;

/**
 * Created by Administrator on 2016/4/22.
 */
public interface IReplySettingService {

	/**
	 * 
	 * 获取自动回复设置
	 * <p>
	 * 
	 *
	 * @param oaid
	 * @throws WxErrorException 
	 */
	void getAutoReplySetting(Long oaid) throws WxErrorException;


	/**
	 * 
	 * 设置被添加自动回复
	 * <p>
	 * 
	 *
	 * @param oaid
	 * @param type
	 * @param content TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	void setAddFriendReplySetting(Long oaid, Integer type, String content);


	/**
	 * 
	 * 设置消息自动回复
	 * <p>
	 * 
	 *
	 * @param oaid
	 * @param type
	 * @param content TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	void setAutoReplySetting(Long oaid, Integer type, String content);
}
