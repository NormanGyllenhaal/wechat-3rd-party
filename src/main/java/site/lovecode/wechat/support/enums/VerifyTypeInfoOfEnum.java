/**
 * VerifyTypeInfoOfEnum.java site.lovecode.wechat.support.enums
 * Copyright (c) 2016,norman.
 */


package site.lovecode.wechat.support.enums;


/**
 * TODO(这里用一句话描述这个类的作用)
 * <p>
 * TODO(这里描述这个类补充说明 – 可选)
 *
 * @author   Administrator
 * @date	 2016年5月14日 
 * @version  1.0.0	 
 */
public enum VerifyTypeInfoOfEnum {


	unverify(-1, "unverify"),

	verify(0, "verify");


	// 枚举值
	private final int key;

	// 枚举描述
	private final String desc;


	VerifyTypeInfoOfEnum( final int key, final String desc ) {
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
