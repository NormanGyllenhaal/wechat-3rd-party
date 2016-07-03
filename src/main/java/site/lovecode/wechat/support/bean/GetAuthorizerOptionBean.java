package site.lovecode.wechat.support.bean;

/**
 * Created by Administrator on 2016/4/11.
 */
public class GetAuthorizerOptionBean {


	/**
	 * 授权公众号appid
	 */
	private String authorizerAppid;

	/**
	 * 选项名称
	 */
	private String OptionName;

	/**
	 * 选项值
	 */
	private String OptionValue;


	public String getAuthorizerAppid() {
		return authorizerAppid;
	}


	public void setAuthorizerAppid( String authorizerAppid ) {
		this.authorizerAppid = authorizerAppid;
	}


	public String getOptionName() {
		return OptionName;
	}


	public void setOptionName( String optionName ) {
		OptionName = optionName;
	}


	public String getOptionValue() {
		return OptionValue;
	}


	public void setOptionValue( String optionValue ) {
		OptionValue = optionValue;
	}


	@Override
	public String toString() {
		return "GetAuthorizerOptionBean{"
				+ "authorizerAppid='" + authorizerAppid + '\'' + ", OptionName='" + OptionName + '\''
				+ ", OptionValue='" + OptionValue + '\'' + '}';
	}
}
