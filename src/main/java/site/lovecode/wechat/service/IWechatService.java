package site.lovecode.wechat.service;


import site.lovecode.wechat.dto.OfficialAccountDto;
import site.lovecode.wechat.support.config.WechatConfig;

/**
 * Created by Administrator on 2016/4/13.
 */
public interface IWechatService {


	/**
	 * 生成消息处理器
	 * <p>
	 * 
	 *
	 * @param oaid 公众号id
	 * @param userName  公众号原始id
	 */
	void generateMessageRouter(Long oaid, String userName);


	/**
	 * 
	 * 获取公众号配置信息
	 * <p>
	 * 
	 *
	 * @param vo
	 * @return 
	 */
	WechatConfig getWechatConfig(OfficialAccountDto vo);


	/**
	 * 
	 * 添加公众号配置到redis中
	 * <p>
	 * 
	 *
	 * @param officialAccountId 
	 */
	public void addWechatConfigInRedis(Long officialAccountId);


}
