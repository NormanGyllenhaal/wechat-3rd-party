package site.lovecode.wechat.support.enums;

/**
 * Created by Administrator on 2016/4/12.
 */
public enum AuthorizationStatusEnum {

	AUTHORIZED(0, "authorized"),

	UNAUTHORIZED(1, "unauthorized");


	// 枚举值
	private final int key;

	// 枚举描述
	private final String desc;


	AuthorizationStatusEnum( final int key, final String desc ) {
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
