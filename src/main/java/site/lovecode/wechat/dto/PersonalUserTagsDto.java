/**
 * PersonalUserTagsDto.java site.lovecode.wechat.dto
 * Copyright (c) 2016,norman.
 */


package site.lovecode.wechat.dto;


import site.lovecode.wechat.util.Page;

import java.io.Serializable;


/**
 * 用户列表和标签数据载体
 * <p>
 *
 *
 * @author   yangeng
 * @date	 2016年5月12日 
 * @version  1.0.0	 
 */
public class PersonalUserTagsDto implements Serializable {

	/**
	 * TODO（用一句话描述这个变量的含义）
	 */

	private static final long serialVersionUID = 1L;


	/**
	 * 创建 PersonalUserTagsDto对象.
	 *
	 * @param page
	 * @param tagsDto
	 */

	public PersonalUserTagsDto(Page<PersonalUserDto> page, TagsDto tagsDto ) {
		super();
		this.page = page;
		this.tagsDto = tagsDto;
	}


	private Page<PersonalUserDto> page;

	private TagsDto tagsDto;


	public Page<PersonalUserDto> getPage() {
		return page;
	}


	public void setPage( Page<PersonalUserDto> page ) {
		this.page = page;
	}


	public TagsDto getTagsDto() {
		return tagsDto;
	}


	public void setTagsDto( TagsDto tagsDto ) {
		this.tagsDto = tagsDto;
	}


}
