/**
 * FuncInfoEnum.java site.lovecode.wechat.support.enums Copyright
 * (c) 2016,norman.
 */


package site.lovecode.wechat.support.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;


/**
 * 微信功能列表枚举
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月7日 
 * @version  1.0.0	 
 */
public enum FuncInfoEnum {


	msg(1, "消息管理权限"),

	user(2, "用户管理权限"),

	account(3, "账号服务权限"),

	web(4, "网页服务权限"),

	store(5, "微信小店权限"),

	service(6, "微信多客服权限"),

	mass(7, "群发与通知权限"),

	card(8, "微信卡券权限"),

	sweep(9, "微信扫一扫权限"),

	wifi(10, "微信连WIFI权限"),

	source(11, "素材管理权限"),

	round(12, "微信摇周边权限"),

	doorStore(13, "微信门店权限"),

	pay(14, "微信支付权限"),

	menu(15, "自定义菜单权限");


	private final int key;

	// 枚举描述
	private final String desc;

	private static Map<Integer, String> map = new HashMap<>();

	static {
		for ( FuncInfoEnum funcInfoEnum : EnumSet.allOf(FuncInfoEnum.class) ) {
			map.put(funcInfoEnum.getKey(), funcInfoEnum.getDesc());
		}
	}


	FuncInfoEnum( final int key, final String desc ) {
		this.key = key;
		this.desc = desc;
	}


	public static String valueOf( int key ) {
		return map.get(key);
	}


	public int getKey() {
		return key;
	}


	public String getDesc() {
		return desc;
	}


}
