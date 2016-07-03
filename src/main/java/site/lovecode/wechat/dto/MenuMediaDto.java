/**
 * MenuMediaDto.java site.lovecode.wechat.dto Copyright (c)
 * 2016,norman.
 */


package site.lovecode.wechat.dto;


import site.lovecode.wechat.entity.Menu;

/**
 * 
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月25日
 * @version  1.0.0
 */


public class MenuMediaDto extends Menu {


	private static final long serialVersionUID = 1L;

	private MediaDto media;


	public MediaDto getMedia() {
		return media;
	}


	public void setMedia( MediaDto media ) {
		this.media = media;
	}


}
