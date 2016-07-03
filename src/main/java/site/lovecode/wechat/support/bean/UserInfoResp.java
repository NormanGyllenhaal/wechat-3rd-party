package site.lovecode.wechat.support.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;


public class UserInfoResp implements Serializable {

	private String appid;

	private String openid;

	private Integer subscribe;

	private String nickname;

	private Integer sex;

	private String language;

	private String city;

	private String province;

	private String country;

	private String headimgurl;

	@JSONField( name = "subscribe_time" )
	private Long subscribeTime;

	private String unionid;

	private String remark;

	private String grounpid;

	@JSONField( name = "tagid_list" )
	private List<Integer> tagIdList;


	private static final long serialVersionUID = 1L;


	/**
	 * @return appid
	 */
	public String getAppid() {
		return appid;
	}


	/**
	 * @param appid
	 */
	public void setAppid( String appid ) {
		this.appid = appid;
	}


	/**
	 * @return openid
	 */
	public String getOpenid() {
		return openid;
	}


	/**
	 * @param openid
	 */
	public void setOpenid( String openid ) {
		this.openid = openid;
	}


	public Integer getSubscribe() {
		return subscribe;
	}


	public void setSubscribe( Integer subscribe ) {
		this.subscribe = subscribe;
	}


	/**
	 * @return nickname
	 */
	public String getNickname() {
		return nickname;
	}


	/**
	 * @param nickname
	 */
	public void setNickname( String nickname ) {
		this.nickname = nickname;
	}


	/**
	 * @return sex
	 */
	public Integer getSex() {
		return sex;
	}


	/**
	 * @param sex
	 */
	public void setSex( Integer sex ) {
		this.sex = sex;
	}


	/**
	 * @return language
	 */
	public String getLanguage() {
		return language;
	}


	/**
	 * @param language
	 */
	public void setLanguage( String language ) {
		this.language = language;
	}


	/**
	 * @return city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city
	 */
	public void setCity( String city ) {
		this.city = city;
	}


	/**
	 * @return province
	 */
	public String getProvince() {
		return province;
	}


	/**
	 * @param province
	 */
	public void setProvince( String province ) {
		this.province = province;
	}


	/**
	 * @return headimgurl
	 */
	public String getHeadimgurl() {
		return headimgurl;
	}


	/**
	 * @param headimgurl
	 */
	public void setHeadimgurl( String headimgurl ) {
		this.headimgurl = headimgurl;
	}


	public Long getSubscribeTime() {
		return subscribeTime;
	}


	public void setSubscribeTime( Long subscribeTime ) {
		this.subscribeTime = subscribeTime;
	}


	/**
	 * @return unionid
	 */
	public String getUnionid() {
		return unionid;
	}


	/**
	 * @param unionid
	 */
	public void setUnionid( String unionid ) {
		this.unionid = unionid;
	}


	/**
	 * @return remark
	 */
	public String getRemark() {
		return remark;
	}


	/**
	 * @param remark
	 */
	public void setRemark( String remark ) {
		this.remark = remark;
	}


	/**
	 * @return grounpid
	 */
	public String getGrounpid() {
		return grounpid;
	}


	/**
	 * @param grounpid
	 */
	public void setGrounpid( String grounpid ) {
		this.grounpid = grounpid;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry( String country ) {
		this.country = country;
	}


	public List<Integer> getTagIdList() {
		return tagIdList;
	}


	public void setTagIdList( List<Integer> tagIdList ) {
		this.tagIdList = tagIdList;
	}


	@Override
	public String toString() {
		return "UserInfoResp{" + "appid='"
				+ appid + '\'' + ", openid='" + openid + '\'' + ", subscribe=" + subscribe + ", nickname='" + nickname
				+ '\'' + ", sex=" + sex + ", language='" + language + '\'' + ", city='" + city + '\'' + ", province='"
				+ province + '\'' + ", country='" + country + '\'' + ", headimgurl='" + headimgurl + '\''
				+ ", subscribeTime='" + subscribeTime + '\'' + ", unionid='" + unionid + '\'' + ", remark='" + remark
				+ '\'' + ", grounpid='" + grounpid + '\'' + '}';
	}
}
