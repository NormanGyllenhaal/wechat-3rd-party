package site.lovecode.wechat.support.enums;

/**
 * Created by Administrator on 2016/4/12.
 */
public enum AuthorizationInfoTypeEnum {

	COMPONENT_VERIFY_TICKET(1, "component_verify_ticket"),

	UNAUTHORIZED(2, "unauthorized"),

	AUTHORIZED(3, "authorized"),

	UPDATEAUTHORIZED(4, "updateauthorized");


	// 枚举值
	private final int key;

	// 枚举描述
	private final String desc;


	AuthorizationInfoTypeEnum( final int key, final String desc ) {
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
