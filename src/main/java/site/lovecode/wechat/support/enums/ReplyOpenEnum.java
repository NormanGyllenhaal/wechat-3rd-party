package site.lovecode.wechat.support.enums;

/**
 * Created by Administrator on 2016/4/26.
 */
public enum ReplyOpenEnum {


	close(0, "close"),

	open(1, "open");

	// 枚举值
	private final int key;

	// 枚举描述
	private final String desc;


	ReplyOpenEnum( final int key, final String desc ) {
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
