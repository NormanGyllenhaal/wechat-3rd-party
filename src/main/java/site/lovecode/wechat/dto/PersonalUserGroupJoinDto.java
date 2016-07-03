/**
 * PersonalUserGroupJoinDto.java site.lovecode.wechat.dto
 * Copyright (c) 2016,norman.
 */
/**
 * PersonalUserGroupJoinDto.java site.lovecode.wechat.dto
 * Copyright (c) 2016,norman.
 */


package site.lovecode.wechat.dto;

import java.io.Serializable;
import java.util.Set;


/**
 * 用户数据统计数据载体
 * <p>
 * TODO(这里描述这个类补充说明 – 可选)
 *
 * @author   yangpeng
 * @date	 2016年5月20日 
 * @version  1.0.0	 
 */
public class PersonalUserGroupJoinDto implements Serializable {


	private static final long serialVersionUID = 1L;

	private Set<PersonalUserGroupDto> sexList;

	private Set<PersonalUserGroupDto> languageList;

	private Set<PersonalUserGroupDto> provinceList;

	private Set<PersonalUserGroupDto> cityList;


	public Set<PersonalUserGroupDto> getSexList() {
		return sexList;
	}


	public void setSexList( Set<PersonalUserGroupDto> sexList ) {
		this.sexList = sexList;
	}


	public Set<PersonalUserGroupDto> getLanguageList() {
		return languageList;
	}


	public void setLanguageList( Set<PersonalUserGroupDto> languageList ) {
		this.languageList = languageList;
	}


	public Set<PersonalUserGroupDto> getProvinceList() {
		return provinceList;
	}


	public void setProvinceList( Set<PersonalUserGroupDto> provinceList ) {
		this.provinceList = provinceList;
	}


	public Set<PersonalUserGroupDto> getCityList() {
		return cityList;
	}


	public void setCityList( Set<PersonalUserGroupDto> cityList ) {
		this.cityList = cityList;
	}


	@Override
	public String toString() {
		return "PersonalUserGroupJoinDto [sexList="
				+ sexList + ", languageList=" + languageList + ", provinceList=" + provinceList + ", cityList="
				+ cityList + "]";
	}


}
