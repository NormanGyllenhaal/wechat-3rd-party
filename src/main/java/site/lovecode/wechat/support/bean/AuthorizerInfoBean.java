package site.lovecode.wechat.support.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by Administrator on 2016/4/6.
 */
public class AuthorizerInfoBean {

	@JSONField( name = "authorizer_info" )
	private AuthorizerInfo authorizerInfo;

	@JSONField( name = "authorization_info" )
	private AuthorizationInfo authorizeationInfo;


	public AuthorizerInfo getAuthorizerInfo() {
		return authorizerInfo;
	}


	public void setAuthorizerInfo( AuthorizerInfo authorizerInfo ) {
		this.authorizerInfo = authorizerInfo;
	}


	public AuthorizationInfo getAuthorizeationInfo() {
		return authorizeationInfo;
	}


	public void setAuthorizeationInfo( AuthorizationInfo authorizeationInfo ) {
		this.authorizeationInfo = authorizeationInfo;
	}


	@Override
	public String toString() {
		return "AuthorizerInfoBean{"
				+ "authorizerInfo=" + authorizerInfo + ", authorizeationInfo=" + authorizeationInfo + '}';
	}

	public class AuthorizationInfo {

		@JSONField( name = "authorizer_appid" )
		private String authorizerAppid;

		@JSONField( name = "func_info" )
		private List<FuncInfoObject> funcInfo;


		public String getAuthorizerAppid() {
			return authorizerAppid;
		}


		public void setAuthorizerAppid( String authorizerAppid ) {
			this.authorizerAppid = authorizerAppid;
		}


		@Override
		public String toString() {
			return "AuthorizationInfo{" + "authorizerAppid='" + authorizerAppid + '\'' + ", funcInfo=" + funcInfo + '}';
		}
	}

	public class AuthorizerInfo {

		@JSONField( name = "nick_name" )
		private String nickName;

		@JSONField( name = "head_img" )
		private String headImg;

		@JSONField( name = "service_type_info" )
		private IdBean serviceTypeInfo;

		@JSONField( name = "verify_type_info" )
		private IdBean verifyTypeInfo;

		@JSONField( name = "user_name" )
		private String userName;

		@JSONField( name = "alias" )
		private String alizs;

		@JSONField( name = "qrcode_url" )
		private String qrcodeUrl;

		@JSONField( name = "business_info" )
		private BusinessInfoBean businessInfoBean;


		public String getNickName() {
			return nickName;
		}


		public void setNickName( String nickName ) {
			this.nickName = nickName;
		}


		public String getHeadImg() {
			return headImg;
		}


		public void setHeadImg( String headImg ) {
			this.headImg = headImg;
		}


		public IdBean getServiceTypeInfo() {
			return serviceTypeInfo;
		}


		public void setServiceTypeInfo( IdBean serviceTypeInfo ) {
			this.serviceTypeInfo = serviceTypeInfo;
		}


		public IdBean getVerifyTypeInfo() {
			return verifyTypeInfo;
		}


		public void setVerifyTypeInfo( IdBean verifyTypeInfo ) {
			this.verifyTypeInfo = verifyTypeInfo;
		}


		public String getUserName() {
			return userName;
		}


		public void setUserName( String userName ) {
			this.userName = userName;
		}


		public String getAlizs() {
			return alizs;
		}


		public void setAlizs( String alizs ) {
			this.alizs = alizs;
		}


		public String getQrcodeUrl() {
			return qrcodeUrl;
		}


		public void setQrcodeUrl( String qrcodeUrl ) {
			this.qrcodeUrl = qrcodeUrl;
		}


		public BusinessInfoBean getBusinessInfoBean() {
			return businessInfoBean;
		}


		public void setBusinessInfoBean( BusinessInfoBean businessInfoBean ) {
			this.businessInfoBean = businessInfoBean;
		}


		@Override
		public String toString() {
			return "AuthorizerInfo{"
					+ "nickName='" + nickName + '\'' + ", headImg='" + headImg + '\'' + ", serviceTypeInfo="
					+ serviceTypeInfo + ", verifyTypeInfo=" + verifyTypeInfo + ", userName='" + userName + '\''
					+ ", alizs='" + alizs + '\'' + ", qrcodeUrl='" + qrcodeUrl + '\'' + ", businessInfo="
					+ businessInfoBean + '}';
		}

		public class BusinessInfoBean {

			@JSONField( name = "open_pay" )
			private Integer openPay;

			@JSONField( name = "open_shake" )
			private Integer openShake;

			@JSONField( name = "open_scan" )
			private Integer openScan;

			@JSONField( name = "open_card" )
			private Integer openCard;

			@JSONField( name = "open_store" )
			private Integer openStore;


			public Integer getOpenPay() {
				return openPay;
			}


			public void setOpenPay( Integer openPay ) {
				this.openPay = openPay;
			}


			public Integer getOpenShake() {
				return openShake;
			}


			public void setOpenShake( Integer openShake ) {
				this.openShake = openShake;
			}


			public Integer getOpenScan() {
				return openScan;
			}


			public void setOpenScan( Integer openScan ) {
				this.openScan = openScan;
			}


			public Integer getOpenCard() {
				return openCard;
			}


			public void setOpenCard( Integer openCard ) {
				this.openCard = openCard;
			}


			public Integer getOpenStore() {
				return openStore;
			}


			public void setOpenStore( Integer openStore ) {
				this.openStore = openStore;
			}


			@Override
			public String toString() {
				return "BusinessInfo{"
						+ "openPay=" + openPay + ", openShake=" + openShake + ", openScan=" + openScan + ", openCard="
						+ openCard + ", openStore=" + openStore + '}';
			}
		}


	}
}
