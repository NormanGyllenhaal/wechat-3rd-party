/**
 * IErrorCodeModule.java cn.vko.peixun.core.module.communication Copyright (c)
 * 2016, .
 */


package site.lovecode.wechat.module;


import site.lovecode.wechat.entity.ErrorCode;
import site.lovecode.wechat.support.common.Response;
import site.lovecode.wechat.util.Page;

/**
 * 示例代码
 * <p>
 *
 * @author   Administrator
 * @date	 2016年5月5日 
 * @version  1.0.0	 
 */
public interface IErrorCodeModule {


	Response<Page<ErrorCode>> getErrorCodePage(Page<ErrorCode> page);

}
