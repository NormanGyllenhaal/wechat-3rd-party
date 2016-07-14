/**
 * MenuModuleImpl.java cn.vko.peixun.module.communication.module Copyright (c)
 * 2016, .
 */


package site.lovecode.wechat.module.impl;


import me.chanjar.weixin.common.exception.WxErrorException;
import org.apache.struts.util.ModuleException;
import org.springframework.stereotype.Service;
import site.lovecode.wechat.dto.MenuDto;
import site.lovecode.wechat.dto.MenuMediaDto;
import site.lovecode.wechat.dto.MenuReqDto;
import site.lovecode.wechat.module.IMenuModule;
import site.lovecode.wechat.service.IMenuService;
import site.lovecode.wechat.support.common.Response;

import javax.annotation.Resource;




/**
 * 自定义菜单服务层
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月25日
 * @version  1.0.0
 */

@Service
public class MenuModuleImpl extends AbstractModule implements IMenuModule {


	@Resource
	private IMenuService menuServiceImpl;


	/**
	 * 
	 * 创建菜单
	 * <p>
	 * 
	 *
	 * @param menuReqDto
	 * @param orgId
	 * @return
	 */
	@Override
	public Response<Boolean> createMenu(MenuReqDto menuReqDto, Long orgId ) throws ModuleException {
		Boolean result = true;
		try {
			menuServiceImpl.createMenu(menuReqDto, orgId);
		} catch ( WxErrorException e ) {
			result = false;
			e.printStackTrace();
			throw new ModuleException(
					String.valueOf(e.getError().getErrorCode()), e.getError().getErrorMsg(), e.getCause());
		}
		return success(result);
	}


	/**
	 * 
	 * 获取菜单列表
	 * <p>
	 * 
	 *
	 * @param orgId
	 * @return
	 */
	@Override
	public Response<MenuDto> getMenu(Long orgId ) {
		return success(menuServiceImpl.getMenu(orgId));
	}


	/**
	 * 
	 * 获取一个菜单详细信息
	 * <p>
	 * 
	 *
	 * @param menuId
	 * @return
	 */
	@Override
	public Response<MenuMediaDto> getMenuOne(Long menuId ) {
		return success(menuServiceImpl.getMenuOne(menuId));
	}


}
