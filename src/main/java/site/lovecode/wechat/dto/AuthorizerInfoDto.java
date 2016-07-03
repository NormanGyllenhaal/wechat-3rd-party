/**
 * AuthorizerInfoDto.java site.lovecode.wechat.dto Copyright
 * (c) 2016,norman.
 */


package site.lovecode.wechat.dto;


import site.lovecode.wechat.entity.AuthorizerInfo;
import site.lovecode.wechat.entity.OfficialAccount;

import java.io.Serializable;
import java.util.List;


/**
 * 授权公众号信息
 * <p>
 *
 * @author   yangpeng
 * @date	 2016年5月7日 
 * @version  1.0.0	 
 */
public class AuthorizerInfoDto implements Serializable {

	/**
	 * TODO（用一句话描述这个变量的含义）
	 */

	private static final long serialVersionUID = 1L;

	private AuthorizerInfo authorizerInfo;

	private OfficialAccount officialAccount;

	private List<FuncInfoDto> funcInfoList;


	/**
	 * 创建 AuthorizerInfoDto对象.
	 *
	 * @param authorizerInfo
	 * @param officialAccount
	 * @param funcInfoList
	 */

	public AuthorizerInfoDto(
			AuthorizerInfo authorizerInfo,
			OfficialAccount officialAccount,
			List<FuncInfoDto> funcInfoList ) {
		super();
		this.authorizerInfo = authorizerInfo;
		this.officialAccount = officialAccount;
		this.funcInfoList = funcInfoList;
	}


	/**
	 * 创建 AuthorizerInfoDto对象.
	 *
	 */

	public AuthorizerInfoDto() {
		super();
	}


	public AuthorizerInfo getAuthorizerInfo() {
		return authorizerInfo;
	}


	public void setAuthorizerInfo( AuthorizerInfo authorizerInfo ) {
		this.authorizerInfo = authorizerInfo;
	}


	public OfficialAccount getOfficialAccount() {
		return officialAccount;
	}


	public void setOfficialAccount( OfficialAccount officialAccount ) {
		this.officialAccount = officialAccount;
	}


	public List<FuncInfoDto> getFuncInfoList() {
		return funcInfoList;
	}


	public void setFuncInfoList( List<FuncInfoDto> funcInfoList ) {
		this.funcInfoList = funcInfoList;
	}


	@Override
	public String toString() {
		return "AuthorizerInfoDto [authorizerInfo="
				+ authorizerInfo + ", officialAccount=" + officialAccount + ", funcInfoList=" + funcInfoList + "]";
	}


}
