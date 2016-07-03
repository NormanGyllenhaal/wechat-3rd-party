package site.lovecode.wechat.support.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Administrator on 2016/4/13.
 */
public class AuthorizerTokenBean {

	@JSONField( name = "authorizer_access_token" )
	private String authorizerAccessToken;

	@JSONField( name = "expires_in" )
	private Integer expiresIn;

	@JSONField( name = "authorizer_refresh_token" )
	private String authorizerRefreshToken;


	public String getAuthorizerAccessToken() {
		return authorizerAccessToken;
	}


	public void setAuthorizerAccessToken( String authorizerAccessToken ) {
		this.authorizerAccessToken = authorizerAccessToken;
	}


	public Integer getExpiresIn() {
		return expiresIn;
	}


	public void setExpiresIn( Integer expiresIn ) {
		this.expiresIn = expiresIn;
	}


	public String getAuthorizerRefreshToken() {
		return authorizerRefreshToken;
	}


	public void setAuthorizerRefreshToken( String authorizerRefreshToken ) {
		this.authorizerRefreshToken = authorizerRefreshToken;
	}


	@Override
	public String toString() {
		return "AuthorizerTokenBean{"
				+ "authorizerAccessToken='" + authorizerAccessToken + '\'' + ", expiresIn=" + expiresIn
				+ ", authorizerRefreshToken='" + authorizerRefreshToken + '\'' + '}';
	}
}
