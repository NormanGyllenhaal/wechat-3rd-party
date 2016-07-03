package site.lovecode.wechat.support.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Administrator on 2016/4/5.
 */
public class PreAuthCodeBean {

	@JSONField( name = "pre_auth_code" )
	private String preAuthCode;

	@JSONField( name = "expires_in" )
	private String expiresIn;


	public String getPreAuthCode() {
		return preAuthCode;
	}


	public void setPreAuthCode( String preAuthCode ) {
		this.preAuthCode = preAuthCode;
	}


	public String getExpiresIn() {
		return expiresIn;
	}


	public void setExpiresIn( String expiresIn ) {
		this.expiresIn = expiresIn;
	}


	@Override
	public String toString() {
		return "PreAuthCodeBean{" + "preAuthCode='" + preAuthCode + '\'' + ", expiresIn='" + expiresIn + '\'' + '}';
	}
}
