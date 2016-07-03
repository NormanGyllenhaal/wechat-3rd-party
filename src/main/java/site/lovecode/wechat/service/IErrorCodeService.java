/**
 * IErrorCodeService.java site.lovecode.wechat.service Copyright
 * (c) 2016, norman.
 */

package site.lovecode.wechat.service;


import site.lovecode.wechat.entity.ErrorCode;
import site.lovecode.wechat.util.Page;

/**
 * 测试分页查询
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月5日 
 * @version  1.0.0	 
 */
public interface IErrorCodeService {


	Page<ErrorCode> getErrorCodePage(Page<ErrorCode> page);

}
