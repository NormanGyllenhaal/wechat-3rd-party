/**
 * OfficialAccountAuthorizerInfoDto.java
 * site.lovecode.wechat.dto Copyright (c) 2016,
 *norman.
 */


package site.lovecode.wechat.dto;


import site.lovecode.wechat.entity.AuthorizerInfo;
import site.lovecode.wechat.entity.OfficialAccount;

/**
 * 微信公众账号基本信息表
 * <p>
 *
 * @author   Administrator
 * @date	 2016年5月14日 
 * @version  1.0.0	 
 */
public class OfficialAccountAuthorizerInfoDto extends OfficialAccount {


	private static final long serialVersionUID = 1L;


	private AuthorizerInfo authorizerInfo;


	public AuthorizerInfo getAuthorizerInfo() {
		return authorizerInfo;
	}


	public void setAuthorizerInfo( AuthorizerInfo authorizerInfo ) {
		this.authorizerInfo = authorizerInfo;
	}


}
