/**
 * MenuOfTypeEnum.java site.lovecode.wechat.support.enums
 * Copyright (c) 2016,norman.
 */


package site.lovecode.wechat.support.enums;


/**
 * 
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月24日
 * @version  1.0.0
 */


public enum MenuOfTypeEnum {


	text(1, "text"),

	img(2, "img"),

	voice(3, "voice"),

	video(4, "video"),

	news(5, "news"),

	view(6, "view");


	// 枚举值
	private final int key;

	// 枚举描述
	private final String desc;


	MenuOfTypeEnum( final int key, final String desc ) {
		this.key = key;
		this.desc = desc;
	}


	public int key() {
		return key;
	}


	public String desc() {
		return desc;
	}

}
