/**
 * MenuDto.java site.lovecode.wechat.dto Copyright (c) 2016,
 *norman.
 */


package site.lovecode.wechat.dto;


import site.lovecode.wechat.entity.Menu;

import java.util.List;


/**
 * 
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月24日
 * @version  1.0.0
 */


public class MenuDto extends Menu {


	private static final long serialVersionUID = 1L;


	List<Menu> subMenu;


	public List<Menu> getSubMenu() {
		return subMenu;
	}


	public void setSubMenu( List<Menu> subMenu ) {
		this.subMenu = subMenu;
	}


}
