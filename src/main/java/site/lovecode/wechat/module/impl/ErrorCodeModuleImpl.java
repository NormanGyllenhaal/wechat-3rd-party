/**
 * ErrorCodeModule.java cn.vko.peixun.module.communication.module Copyright (c)
 * 2016, .
 */


package site.lovecode.wechat.module.impl;


import site.lovecode.wechat.entity.ErrorCode;
import site.lovecode.wechat.module.IErrorCodeModule;
import site.lovecode.wechat.service.IErrorCodeService;
import site.lovecode.wechat.support.common.Response;
import site.lovecode.wechat.util.Page;

import javax.annotation.Resource;


/**
 * 示例代码
 * <p>

 *
 * @author   Administrator
 * @date	 2016年5月5日 
 * @version  1.0.0	 
 */
public class ErrorCodeModuleImpl extends AbstractModule implements IErrorCodeModule {


	@Resource( name = "errorCodeServiceImpl" )
	private IErrorCodeService errorCodeServiceImpl;


	@Override
	public Response<Page<ErrorCode>> getErrorCodePage(Page<ErrorCode> page ) {
		return success(errorCodeServiceImpl.getErrorCodePage(page));
	}

}
