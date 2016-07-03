/**
 * PersonalUserGroupDto.java site.lovecode.wechat.dto
 * Copyright (c) 2016,norman.
 */


package site.lovecode.wechat.dto;

import java.io.Serializable;


/**
 * 
 * <p>
 * TODO(这里描述这个类补充说明 – 可选)
 *
 * @author   yangpeng
 * @date	 2016年5月20日 
 * @version  1.0.0	 
 */
public class PersonalUserGroupDto implements Serializable {


	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 数量
	 */
	private Integer count;

	/**
	 * 属性名称
	 */
	private String name;


	public Long getId() {
		return id;
	}


	public void setId( Long id ) {
		this.id = id;
	}


	public Integer getCount() {
		return count;
	}


	public void setCount( Integer count ) {
		this.count = count;
	}


	public String getName() {
		return name;
	}


	public void setName( String name ) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "PersonalUserGroupDto [id=" + id + ", count=" + count + ", name=" + name + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals( Object obj ) {
		if ( this == obj ) { return true; }
		if ( obj == null ) { return false; }
		if ( getClass() != obj.getClass() ) { return false; }
		PersonalUserGroupDto other = (PersonalUserGroupDto) obj;
		if ( count == null ) {
			if ( other.count != null ) { return false; }
		} else if ( !count.equals(other.count) ) { return false; }
		if ( id == null ) {
			if ( other.id != null ) { return false; }
		} else if ( !id.equals(other.id) ) { return false; }
		if ( name == null ) {
			if ( other.name != null ) { return false; }
		} else if ( !name.equals(other.name) ) { return false; }
		return true;
	}


}
