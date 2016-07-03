/**
 * PersonalUserTagReqDto.java site.lovecode.wechat.dto
 * Copyright (c) 2016,norman.
 */
/**
 * PersonalUserTagReqDto.java site.lovecode.wechat.dto
 * Copyright (c) 2016,norman.
 */


package site.lovecode.wechat.dto;

import java.util.List;


/**
 * 
 * <p>
 * TODO(这里描述这个类补充说明 – 可选)
 *
 * @author   yangpeng
 * @date	 2016年5月12日 
 * @version  1.0.0	 
 */
public class PersonalUserTagReqDto {

	private Long personalUserId;

	private List<Integer> tagIdList;


	public Long getPersonalUserId() {
		return personalUserId;
	}


	public void setPersonalUserId( Long personalUserId ) {
		this.personalUserId = personalUserId;
	}


	public List<Integer> getTagIdList() {
		return tagIdList;
	}


	public void setTagIdList( List<Integer> tagIdList ) {
		this.tagIdList = tagIdList;
	}


}
