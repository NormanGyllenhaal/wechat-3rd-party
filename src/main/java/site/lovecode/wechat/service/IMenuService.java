package site.lovecode.wechat.service;


import me.chanjar.weixin.common.exception.WxErrorException;
import site.lovecode.wechat.dto.MenuDto;
import site.lovecode.wechat.dto.MenuMediaDto;
import site.lovecode.wechat.dto.MenuReqDto;

/**
 * Created by Administrator on 2016/4/19.
 */
public interface IMenuService {


	/**
	 * 
	 * 创建自定义菜单
	 * <p>
	 * 
	 *
	 * @param menuReqDto 菜单列表
	 * @param orgId
	 */
	void createMenu(MenuReqDto menuReqDto, Long orgId) throws WxErrorException;


	/**
	 * 
	 * 根据机构id获取菜单列表
	 * <p>
	 * 
	 *
	 * @param orgId
	 * @return
	 */
	MenuDto getMenu(Long orgId);


	/**
	 * 
	 * 根据菜单id获取菜单信息
	 * <p>
	 * 
	 *
	 * @param menuId
	 * @return
	 */
	MenuMediaDto getMenuOne(Long menuId);


}
