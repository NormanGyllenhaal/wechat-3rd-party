/**
 * TagsDto.java site.lovecode.wechat.dto Copyright (c) 2016,
 *norman.
 */


package site.lovecode.wechat.dto;


import site.lovecode.wechat.entity.Tags;

import java.io.Serializable;
import java.util.List;


/**
 * 用户标签数据载体
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月11日 
 * @version  1.0.0	 
 */
public class TagsDto implements Serializable {


	private static final long serialVersionUID = 1L;


	private Integer userCount;


	private List<Tags> tagsList;


	public Integer getUserCount() {
		return userCount;
	}


	public void setUserCount( Integer userCount ) {
		this.userCount = userCount;
	}


	public List<Tags> getTagsList() {
		return tagsList;
	}


	public void setTagsList( List<Tags> tagsList ) {
		this.tagsList = tagsList;
	}


	@Override
	public String toString() {
		return "TagsDto [userCount=" + userCount + ", tagsList=" + tagsList + "]";
	}


}
