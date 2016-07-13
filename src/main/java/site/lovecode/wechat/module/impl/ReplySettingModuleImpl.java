/**
 * ReplySettingModuleImpl.java cn.vko.peixun.module.communication.module
 * Copyright (c) 2016, .
 */


package site.lovecode.wechat.module.impl;


import org.apache.struts.util.ModuleException;
import site.lovecode.wechat.module.IReplySettingModule;
import site.lovecode.wechat.service.IReplySettingService;
import site.lovecode.wechat.support.common.Response;

import javax.annotation.Resource;




/**
 * 自动回复设置业务层
 * <p>
 * TODO(这里描述这个类补充说明 – 可选)
 *
 * @author   yangpeng
 * @date	 2016年5月17日 
 * @version  1.0.0	 
 */
public class ReplySettingModuleImpl extends AbstractModule implements IReplySettingModule {

	@Resource
	private IReplySettingService replySettingServiceImpl;


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
	@Override
	public Response<Boolean> addFriendReplySetting(Long oaid, Integer type, String content ) throws ModuleException {
		Boolean result = true;
		try {
			replySettingServiceImpl.setAddFriendReplySetting(oaid, type, content);
		} catch ( Exception e ) {
			result = false;
			throw new ModuleException("添加被添加回复异常");
		}
		return success(result);
	}


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
	@Override
	public Response<Boolean> addAutoReplySetting( Long oaid, Integer type, String content ) throws ModuleException {
		Boolean result = true;
		try {
			replySettingServiceImpl.setAutoReplySetting(oaid, type, content);
		} catch ( Exception e ) {
			result = false;
			throw new ModuleException("添加自动回复异常");
		}
		return success(result);
	}

}
