/**
 * MenuOfLevelEnum.java site.lovecode.wechat.support.enums
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


public enum MenuOfLevelEnum {


	one(1, "one"),


	two(2, "two");


	// 枚举值
	private final int key;

	// 枚举描述
	private final String desc;


	MenuOfLevelEnum( final int key, final String desc ) {
		this.key = key;
		this.desc = desc;
	}


	public static Boolean getBoolean( Integer key ) {
		if ( key.equals(0) ) {
			return false;
		} else if ( key.equals(1) ) {
			return true;
		} else {
			return null;
		}
	}


	public int key() {
		return key;
	}


	public String desc() {
		return desc;
	}


}
