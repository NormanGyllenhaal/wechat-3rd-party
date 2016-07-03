package site.lovecode.wechat.support.enums;

/**
 * Created by Administrator on 2016/4/15.
 */
public enum OfficialAccountTypeEnum {


	AUTHORIZATION(1, "授权绑定"),

	UNAUTHORIZATION(2, "非授权绑定");


	// 枚举值
	private final int key;

	// 枚举描述
	private final String desc;


	OfficialAccountTypeEnum( final int key, final String desc ) {
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
