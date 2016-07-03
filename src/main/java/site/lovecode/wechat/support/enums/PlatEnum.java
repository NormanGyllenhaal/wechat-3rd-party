package site.lovecode.wechat.support.enums;

/**
 * Created by Administrator on 2016/4/25.
 */
public enum PlatEnum {

	weixin(1, "weixin"),

	my(2, "my");


	// 枚举值
	private final int key;

	// 枚举描述
	private final String desc;


	PlatEnum( final int key, final String desc ) {
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
