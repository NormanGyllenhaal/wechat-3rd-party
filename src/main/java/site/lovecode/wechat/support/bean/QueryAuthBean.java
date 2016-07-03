package site.lovecode.wechat.support.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by Administrator on 2016/4/5.
 */
public class QueryAuthBean {

	@JSONField( name = "authorization_info" )
	private AuthOrizationInfo authOrizationInfo;


	public AuthOrizationInfo getAuthOrizationInfo() {
		return authOrizationInfo;
	}


	public void setAuthOrizationInfo( AuthOrizationInfo authOrizationInfo ) {
		this.authOrizationInfo = authOrizationInfo;
	}


	@Override
	public String toString() {
		return "QueryAuthBean{" + "authOrizationInfo=" + authOrizationInfo + '}';
	}


	public class AuthOrizationInfo {

		@JSONField( name = "authorizer_appid" )
		private String authorizerAppid;

		@JSONField( name = "authorizer_access_token" )
		private String authorizerAccessToken;

		@JSONField( name = "expires_in" )
		private Integer expriesIn;

		@JSONField( name = "authorizer_refresh_token" )
		private String authorizerRefreshToken;

		@JSONField( name = "func_info" )
		private List<FuncInfoObject> funcInfoList;


		public String getAuthorizerAppid() {
			return authorizerAppid;
		}


		public void setAuthorizerAppid( String authorizerAppid ) {
			this.authorizerAppid = authorizerAppid;
		}


		public String getAuthorizerAccessToken() {
			return authorizerAccessToken;
		}


		public void setAuthorizerAccessToken( String authorizerAccessToken ) {
			this.authorizerAccessToken = authorizerAccessToken;
		}


		public Integer getExpriesIn() {
			return expriesIn;
		}


		public void setExpriesIn( Integer expriesIn ) {
			this.expriesIn = expriesIn;
		}


		public String getAuthorizerRefreshToken() {
			return authorizerRefreshToken;
		}


		public void setAuthorizerRefreshToken( String authorizerRefreshToken ) {
			this.authorizerRefreshToken = authorizerRefreshToken;
		}


		public List<FuncInfoObject> getFuncInfoList() {
			return funcInfoList;
		}


		public void setFuncInfoList( List<FuncInfoObject> funcInfoList ) {
			this.funcInfoList = funcInfoList;
		}


		@Override
		public String toString() {
			return "AuthOrizationInfo{"
					+ "authorizerAppid='" + authorizerAppid + '\'' + ", authorizerAccessToken='"
					+ authorizerAccessToken + '\'' + ", expriesIn='" + expriesIn + '\'' + ", authorizerRefreshToken='"
					+ authorizerRefreshToken + '\'' + ", funcInfoList=" + funcInfoList + '}';
		}

	}


}
