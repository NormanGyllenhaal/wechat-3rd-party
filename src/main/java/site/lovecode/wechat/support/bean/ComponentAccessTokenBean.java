package site.lovecode.wechat.support.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Administrator on 2016/4/1.
 */
public class ComponentAccessTokenBean {

	@JSONField( name = "component_access_token" )
	private String componentAccessToken;

	@JSONField( name = "expires_in" )
	private Integer expiresIn;


	public String getComponentAccessToken() {
		return componentAccessToken;
	}


	public void setComponentAccessToken( String componentAccessToken ) {
		this.componentAccessToken = componentAccessToken;
	}


	public Integer getExpiresIn() {
		return expiresIn;
	}


	public void setExpiresIn( Integer expiresIn ) {
		this.expiresIn = expiresIn;
	}


	@Override
	public String toString() {
		return "ComponentAccessTokenBean{"
				+ "componentAccessToken='" + componentAccessToken + '\'' + ", expiresIn='" + expiresIn + '\'' + '}';
	}
}
