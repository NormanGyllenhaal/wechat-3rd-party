package site.lovecode.wechat.support.singleton;

import me.chanjar.weixin.mp.api.WxMpMessageRouter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2016/4/27.
 */
public class MessageRouterSingleton {

	private static MessageRouterSingleton messageRouterSingleton = new MessageRouterSingleton();


	private MessageRouterSingleton() {
		this.wxMpMessageRouterMap = new ConcurrentHashMap<>();
	}


	public static MessageRouterSingleton getInstance() {
		return messageRouterSingleton;
	}

	private final Map<String, WxMpMessageRouter> wxMpMessageRouterMap;


	public WxMpMessageRouter getWxMpMessageRouter( String userName ) {
		return this.wxMpMessageRouterMap.get(userName);
	}


	public void putWxMpMessageRouter( String userName, WxMpMessageRouter wxMpMessageRouter ) {
		wxMpMessageRouterMap.put(userName, wxMpMessageRouter);
	}


}
