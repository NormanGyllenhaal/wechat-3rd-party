/**
 * PersonalUserDto.java site.lovecode.wechat.dto Copyright
 * (c) 2016,norman.
 */


package site.lovecode.wechat.dto;


import site.lovecode.wechat.entity.PersonalUser;
import site.lovecode.wechat.entity.PersonalUserTags;

import java.util.List;

/**
 * 微信粉丝数据体
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月10日 
 * @version  1.0.0	 
 */
public class PersonalUserDto extends PersonalUser {

	/**
	 * TODO（用一句话描述这个变量的含义）
	 */

	private static final long serialVersionUID = 1L;


	private List<PersonalUserTags> tagsList;


	public List<PersonalUserTags> getTagsList() {
		return tagsList;
	}


	public void setTagsList( List<PersonalUserTags> tagsList ) {
		this.tagsList = tagsList;
	}


}
