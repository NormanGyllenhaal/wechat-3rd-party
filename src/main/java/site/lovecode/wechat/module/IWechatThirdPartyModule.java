/**
 * IWechatThridPartyModule.java cn.vko.peixun.core.module.communication
 * Copyright (c) 2016, .
 */


package site.lovecode.wechat.module;


import org.apache.struts.util.ModuleException;
import site.lovecode.wechat.dto.AuthorizerInfoDto;
import site.lovecode.wechat.support.common.Response;

/**
 * 微信第三方消息接口
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月7日 
 * @version  1.0.0	 
 */
public interface IWechatThirdPartyModule {


	/**
	 * 
	 * 接收微信的component_verify_ticket,
	 * <p>
	 * 解密并保存
	 *
	 * @param msgSingnatrue
	 * @param timestamp
	 * @param nonce
	 * @throws Exception TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	public void receiveTicket(String xmlStr, String msgSingnatrue, String timestamp, String nonce) throws Exception;


	/**
	 * 
	 * 根据code获取公众号基本信息
	 * <p>
	 * 
	 *
	 * @param authCode 授权码
	 */
	public Response<AuthorizerInfoDto> getAuthCode(String authCode) throws Exception;


	/**
	 * 
	 * 生成授权url
	 * <p>
	 * 
	 *
	 * @return
	 * @throws Exception 微信异常
	 */
	public Response<String> getAuthorization() throws Exception;


	/**
	 * 
	 * 接收微信消息并处理
	 * <p>
	 *
	 * @return 回复消息
	 */
	public Response<String> getAllMessage(String xml, String msgSingnatrue, String timestamp, String nonce);


	/**
	 * 
	 * 刷新公众号数据
	 * <p>
	 * 
	 *
	 * @param oaid
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	Response<Boolean> refershData(Long oaid) throws ModuleException;



	/**
	 * 取消授权
	 *
	 * @param authorizerAppid
	 * @return
     */
	Response<Boolean> cancelAuthorization(String authorizerAppid);

}
