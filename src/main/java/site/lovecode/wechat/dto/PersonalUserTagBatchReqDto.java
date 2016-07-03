/**
 * PersonalUserTagBatchReqDto.java site.lovecode.wechat.dto
 * Copyright (c) 2016,norman.
 */
/**
 * PersonalUserTagBatchReqDto.java site.lovecode.wechat.dto
 * Copyright (c) 2016,norman.
 */


package site.lovecode.wechat.dto;

import java.util.List;


/**
 *  
 * <p>
 * 
 *
 * @author   Administrator
 * @date	 2016年5月13日 
 * @version  1.0.0	 
 */
public class PersonalUserTagBatchReqDto {


	private List<Integer> tagIdList;


	private List<Long> personalUserIdList;


	public List<Integer> getTagIdList() {
		return tagIdList;
	}


	public void setTagIdList( List<Integer> tagIdList ) {
		this.tagIdList = tagIdList;
	}


	public List<Long> getPersonalUserIdList() {
		return personalUserIdList;
	}


	public void setPersonalUserIdList( List<Long> personalUserIdList ) {
		this.personalUserIdList = personalUserIdList;
	}


}
