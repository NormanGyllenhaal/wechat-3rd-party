/**
 * PersonalUserTermDto.java site.lovecode.wechat.dto
 * Copyright (c) 2016,norman.
 */

package site.lovecode.wechat.dto;


/**
 * 用户查询条件
 * <p>
 *
 * @author   Administrator
 * @date	 2016年5月10日 
 * @version  1.0.0	 
 */
public class PersonalUserTermDto {


	private Long officialAccountId;

	private Long personalUserId;

	private String nickName;

	private Integer status;

	private Integer tagId;

	private String openId;


	public Long getOfficialAccountId() {
		return officialAccountId;
	}


	public void setOfficialAccountId( Long officialAccountId ) {
		this.officialAccountId = officialAccountId;
	}


	public Long getPersonalUserId() {
		return personalUserId;
	}


	public void setPersonalUserId( Long personalUserId ) {
		this.personalUserId = personalUserId;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName( String nickName ) {
		this.nickName = nickName;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus( Integer status ) {
		this.status = status;
	}


	public Integer getTagId() {
		return tagId;
	}


	public void setTagId( Integer tagId ) {
		this.tagId = tagId;
	}


	public String getOpenId() {
		return openId;
	}


	public void setOpenId( String openId ) {
		this.openId = openId;
	}


}
