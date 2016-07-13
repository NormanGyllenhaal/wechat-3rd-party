/**
 * IMenuModule.java cn.vko.peixun.core.module.communication Copyright (c) 2016,
 * .
 */


package site.lovecode.wechat.module;


import org.apache.struts.util.ModuleException;
import site.lovecode.wechat.dto.MenuDto;
import site.lovecode.wechat.dto.MenuMediaDto;
import site.lovecode.wechat.dto.MenuReqDto;
import site.lovecode.wechat.support.common.Response;

/**
 *  自定义菜单服务层接口
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月25日
 * @version  1.0.0
 */


public interface IMenuModule {


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
	public Response<Boolean> createMenu(MenuReqDto menuReqDto, Long orgId) throws ModuleException;


	/**
	 * 
	 * 获取菜单列表
	 * <p>
	 * 
	 *
	 * @param orgId
	 * @return
	 */
	public Response<MenuDto> getMenu(Long orgId);


	/**
	 * 
	 * 获取一个菜单详细信息
	 * <p>
	 * 
	 *
	 * @param menuId
	 * @return
	 */
	public Response<MenuMediaDto> getMenuOne(Long menuId);

}
