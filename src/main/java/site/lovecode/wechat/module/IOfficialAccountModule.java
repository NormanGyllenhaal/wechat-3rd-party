/**
 * IOfficialAccountModule.java cn.vko.peixun.core.module.communication Copyright
 * (c) 2016, .
 */


package site.lovecode.wechat.module;


import site.lovecode.wechat.dto.OfficialAccountReqDto;
import site.lovecode.wechat.entity.OfficialAccount;
import site.lovecode.wechat.support.common.Response;

import java.util.List;

/**
 * 微信公众号基本信息业务接口
 * <p>
 *
 * @author   yangpeng
 * @date	 2016年5月9日 
 * @version  1.0.0	 
 */
public interface IOfficialAccountModule {


	/**
	 * 
	 * 保存手动绑定的公众号信息
	 * <p>
	 * 
	 *
	 * @param officialAccountReqDto 公众号信息
	 */
	public void saveOfficialAccountInfo(OfficialAccountReqDto officialAccountReqDto);


	/**
	 * 
	 * 获取所有公众号列表
	 * <p>
	 * 
	 *
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	public Response<List<OfficialAccount>> getOfficialAccount();

}
