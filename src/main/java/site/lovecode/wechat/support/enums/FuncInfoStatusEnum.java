/**
 * FuncInfoStatusEnum.java site.lovecode.wechat.support.enums
 * Copyright (c) 2016,norman.
 */
/**
 * FuncInfoStatusEnum.java site.lovecode.wechat.support.enums
 * Copyright (c) 2016,norman.
 */


package site.lovecode.wechat.support.enums;


/**
 * 权限状态枚举值
 * <p>
 * 
 *
 * @author   yangpegn
 * @date	 2016年5月7日 
 * @version  1.0.0	 
 */
public enum FuncInfoStatusEnum {


	close(0, "close"),

	open(1, "open");

	// 枚举值
	private final int key;

	// 枚举描述
	private final String desc;


	FuncInfoStatusEnum( final int key, final String desc ) {
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
