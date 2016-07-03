package site.lovecode.wechat.dto;


import site.lovecode.wechat.entity.AuthorizerAccessToken;
import site.lovecode.wechat.entity.OfficialAccount;
import site.lovecode.wechat.entity.OfficialAccountAccessToken;
import site.lovecode.wechat.entity.OfficialAccountInfo;

/**
 * Created by Administrator on 2016/4/18.
 */
public class OfficialAccountDto extends OfficialAccount {

	/**
	 * TODO（用一句话描述这个变量的含义）
	 */

	private static final long serialVersionUID = 1L;

	private AuthorizerAccessToken authorizerAccessToken;

	private OfficialAccountInfo officialAccountInfo;

	private OfficialAccountAccessToken officialAccountAccessToken;


	public AuthorizerAccessToken getAuthorizerAccessToken() {
		return authorizerAccessToken;
	}


	public void setAuthorizerAccessToken( AuthorizerAccessToken authorizerAccessToken ) {
		this.authorizerAccessToken = authorizerAccessToken;
	}


	public OfficialAccountInfo getOfficialAccountInfo() {
		return officialAccountInfo;
	}


	public void setOfficialAccountInfo( OfficialAccountInfo officialAccountInfo ) {
		this.officialAccountInfo = officialAccountInfo;
	}


	public OfficialAccountAccessToken getOfficialAccountAccessToken() {
		return officialAccountAccessToken;
	}


	public void setOfficialAccountAccessToken( OfficialAccountAccessToken officialAccountAccessToken ) {
		this.officialAccountAccessToken = officialAccountAccessToken;
	}


	@Override
	public String toString() {
		return "OfficialAccountVo{"
				+ "authorizerAccessToken=" + authorizerAccessToken + ", officialAccountInfo=" + officialAccountInfo
				+ ", officialAccountAccessToken=" + officialAccountAccessToken + '}';
	}


	@Override
	public Long getId() {
		return super.getId();
	}


	@Override
	public void setId( Long id ) {
		super.setId(id);
	}
}
