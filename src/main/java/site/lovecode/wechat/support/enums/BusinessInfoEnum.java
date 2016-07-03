package site.lovecode.wechat.support.enums;

/**
 * Created by Administrator on 2016/4/12.
 */
public enum BusinessInfoEnum {


	OPEN_STORE(1, "open_store"),

	OPEN_SCAN(2, "open_scan"),

	OPEN_PAY(3, "open_pay"),

	OPEN_CARD(4, "open_card"),

	OPEN_SHAKE(5, "open_shake");

	// 枚举值
	private final int key;

	// 枚举描述
	private final String desc;


	BusinessInfoEnum( final int key, final String desc ) {
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
