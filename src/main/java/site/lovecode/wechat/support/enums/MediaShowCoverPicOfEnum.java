/**
 * MediaShowCoverPicOfEnum.java site.lovecode.wechat.support.enums
 * Copyright (c) 2016,norman.
 */


package site.lovecode.wechat.support.enums;


/**
 * 媒体封面枚举
 * <p>
 * TODO(这里描述这个类补充说明 – 可选)
 *
 * @author   yangpeng
 * @date	 2016年5月19日 
 * @version  1.0.0	 
 */
public enum MediaShowCoverPicOfEnum {


	display(0, "display"),


	show(1, "show");


	// 枚举值
	private final int key;

	// 枚举描述
	private final String desc;


	MediaShowCoverPicOfEnum( final int key, final String desc ) {
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
