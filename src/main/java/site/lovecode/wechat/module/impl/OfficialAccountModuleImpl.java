/**
 * OfficialAccountModuleImpl.java cn.vko.peixun.module.communication.module
 * Copyright (c) 2016, .
 */


package site.lovecode.wechat.module.impl;


import org.springframework.stereotype.Service;
import site.lovecode.wechat.dto.OfficialAccountReqDto;
import site.lovecode.wechat.entity.OfficialAccount;
import site.lovecode.wechat.module.IOfficialAccountModule;
import site.lovecode.wechat.service.IOfficialAccountService;
import site.lovecode.wechat.support.common.Response;

import javax.annotation.Resource;
import java.util.List;


/**
 * 微信公众号基本信息业务层实现
 * <p>
 *
 *
 * @author   yangpeng
 * @date	 2016年5月9日 
 * @version  1.0.0	 
 */
@Service
public class OfficialAccountModuleImpl extends AbstractModule implements IOfficialAccountModule {

	@Resource
	private IOfficialAccountService officialAccountService;


	/**
	 * 
	 * 保存手动绑定的公众号信息
	 * <p>
	 * 
	 *
	 * @param officialAccountReqDto 公众号信息
	 */
	@Override
	public void saveOfficialAccountInfo( OfficialAccountReqDto officialAccountReqDto ) {
		officialAccountService.saveOfficialAccount(officialAccountReqDto);
	}


	/**
	 * 
	 * 获取所有公众号列表
	 * <p>
	 * 
	 *
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@Override
	public Response<List<OfficialAccount>> getOfficialAccount() {
		return success(officialAccountService.getAllOfficialAccount());
	}

}
