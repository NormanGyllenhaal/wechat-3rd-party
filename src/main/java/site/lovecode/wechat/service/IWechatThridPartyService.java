package site.lovecode.wechat.service;


import me.chanjar.weixin.common.exception.WxErrorException;
import site.lovecode.wechat.dto.AuthorizerInfoDto;
import site.lovecode.wechat.support.bean.XmlDecryptingBean;

import java.io.IOException;

/**
 * Created by Administrator on 2016/4/8.
 */
public interface IWechatThridPartyService {

	/**
	 * 保存 component_verify_ticket
	 *
	 * @param xmlDecryptingBean
	 */
	void saveComponentVerifyTicket(XmlDecryptingBean xmlDecryptingBean) throws WxErrorException;


	/**
	 * 授权成功执行的操作
	 * 1.保存公众号基本信息
	 * 2.保存公众号详细信息
	 * 3.保存公众号access_token
	 * 4.保存公众号权限信息
	 * 5.保存公众号商业信息
	 * 异步执行的操作
	 * 1.批量拉取用户信息
	 * 2.获取用户自动回复配置，并初始化微信消息接收器
	 * 3.批量拉取用户永久素材
	 * 
	 *
	 * @throws IOException
	 */
	AuthorizerInfoDto saveInfo(String authCode) throws Exception;


	/**
	 * 生成用户的授权页面
	 * @return
	 * @throws IOException
	 */
	String getCompoentLoginUrl() throws IOException, WxErrorException;


	/**
	 *
	 * 用户取消授权，变更授权状态为取消
	 * @param authorizerAppid
	 */
	void changeAuthorizationStatus(String authorizerAppid);



	/**
	 * 
	 * 刷新用户数据
	 * <p>
	 * 
	 *
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	void refreshData(Long oaid) throws Exception;
}
