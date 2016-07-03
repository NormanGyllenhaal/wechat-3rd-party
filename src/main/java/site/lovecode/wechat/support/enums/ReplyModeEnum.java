package site.lovecode.wechat.support.enums;

/**
 * Created by Administrator on 2016/4/25.
 */
public enum ReplyModeEnum {

	reply_all(1, "reply_all"),

	random_one(2, "random_one");


	// 枚举值
	private final int key;

	// 枚举描述
	private final String desc;


	ReplyModeEnum( final int key, final String desc ) {
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
