/**
 * PersonalUserIdReqDto.java site.lovecode.wechat.dto
 * Copyright (c) 2016,norman.
 */


package site.lovecode.wechat.dto;

import java.util.List;


/**
 * 用户id数据体
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月13日 
 * @version  1.0.0	 
 */
public class PersonalUserIdReqDto {


	private List<Long> personalUserIdList;


	public List<Long> getPersonalUserIdList() {
		return personalUserIdList;
	}


	public void setPersonalUserIdList( List<Long> personalUserIdList ) {
		this.personalUserIdList = personalUserIdList;
	}


}
