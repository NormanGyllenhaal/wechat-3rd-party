package site.lovecode.wechat.module.impl;


import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import org.apache.struts.util.ModuleException;
import org.springframework.stereotype.Service;
import site.lovecode.wechat.client.impl.WechatThirdPartyClientImpl;
import site.lovecode.wechat.dto.AuthorizerInfoDto;
import site.lovecode.wechat.module.IWechatThirdPartyModule;
import site.lovecode.wechat.service.IWechatThridPartyService;
import site.lovecode.wechat.support.bean.WechatXmlMessage;
import site.lovecode.wechat.support.bean.XmlDecryptingBean;
import site.lovecode.wechat.support.common.Response;
import site.lovecode.wechat.support.enums.AuthorizationInfoTypeEnum;
import site.lovecode.wechat.support.singleton.MessageRouterSingleton;
import site.lovecode.wechat.util.WechatCryptUtil;
import site.lovecode.wechat.util.WechatMsgCryptUtil;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/3/25.
 */
@Service
public class WechatThirdPartyModuleImpl extends AbstractModule implements IWechatThirdPartyModule {


	@Resource
	private IWechatThridPartyService wechatThridPartyService;


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
	@Override
	public void receiveTicket( String xmlStr, String msgSingnatrue, String timestamp, String nonce ) throws Exception {
		try {
			String result = WechatMsgCryptUtil.WechatMsgDecrypt(xmlStr, msgSingnatrue, timestamp, nonce);
			logger.info("解密后明文: " + result);
			XmlDecryptingBean xmlDecryptingBean = XmlDecryptingBean.getBean(result);
			logger.info(xmlDecryptingBean.toString());
			// 如果是ticket推送消息，保存componentVerifyTicket
			if ( xmlDecryptingBean.getInfoType().equals(AuthorizationInfoTypeEnum.COMPONENT_VERIFY_TICKET.desc()) ) {
				wechatThridPartyService.saveComponentVerifyTicket(xmlDecryptingBean);
			}
			// 如果是取消授权通知
			if ( xmlDecryptingBean.getInfoType().equals(AuthorizationInfoTypeEnum.UNAUTHORIZED.desc()) ) {
				wechatThridPartyService.changeAuthorizationStatus(xmlDecryptingBean.getAuthorizerAppid());
			}
		} catch ( Exception e ) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}


	/**
	 * 
	 * 根据code获取公众号基本信息
	 * <p>
	 * 
	 *
	 * @param authCode 授权码
	 * @throws Exception 
	 */
	@Override
	public Response<AuthorizerInfoDto> getAuthCode(String authCode ) throws Exception {
		try {
			return success(wechatThridPartyService.saveInfo(authCode));
		} catch ( Exception e ) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}


	/**
	 * 
	 * 生成授权url
	 * <p>
	 * 
	 *
	 * @return
	 * @throws Exception 微信异常
	 */
	@Override
	public Response<String> getAuthorization() throws Exception {
		return success(wechatThridPartyService.getCompoentLoginUrl());
	}


	/**
	 * 
	 * 接收微信消息并处理
	 * <p>
	 *
	 * @return 回复消息
	 */
	@Override
	public Response<String> getAllMessage( String xml, String msgSingnatrue, String timestamp, String nonce ) {
		logger.info("收到你的消息了呦");
		String str = "success";
		WxMpXmlMessage msg = WechatXmlMessage.fromEncryptedXml(
			xml, WechatThirdPartyClientImpl.wechatThirdPartyConfig, timestamp, nonce, msgSingnatrue);
		logger.info(msg.toString());
		WxMpXmlOutMessage reMsg = MessageRouterSingleton.getInstance().getWxMpMessageRouter(msg.getToUserName())
				.route(msg);
		if ( reMsg != null ) {
			str = WechatCryptUtil.toEncryptedXml(WechatThirdPartyClientImpl.wechatThirdPartyConfig, reMsg);
		}
		return success(str);
	}


	/**
	 * 
	 * 刷新公众号数据
	 * <p>
	 * 
	 *
	 * @param oaid
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	@Override
	public Response<Boolean> refershData( Long oaid ) throws ModuleException {
		Boolean result = true;
		try {
			wechatThridPartyService.refreshData(oaid);
		} catch ( Exception e ) {
			result = false;
			throw new ModuleException("刷新异常");
		}
		return success(result);
	}


	/**
	 * 取消公众号授权
	 * @param authorizerAppid
	 * @return
     */
	public Response<Boolean> cancelAuthorization(String authorizerAppid ){
		Boolean result = true;
		try{
			wechatThridPartyService.changeAuthorizationStatus(authorizerAppid);
		}catch (Exception e){
			result = false;
			e.printStackTrace();
		}
		return success(result);
	}


}
