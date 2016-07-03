package site.lovecode.wechat.support.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by Administrator on 2016/5/10.
 */
public class TagsBean {


	/**
	 * id : 1
	 * name : 黑名单
	 * count : 0
	 */

	@JSONField( name = "tags" )
	private List<Tags> tags;


	public List<Tags> getTags() {
		return tags;
	}


	public void setTags( List<Tags> tags ) {
		this.tags = tags;
	}

	public static class Tags {

		@JSONField( name = "id" )
		private int id;

		@JSONField( name = "name" )
		private String name;

		@JSONField( name = "count" )
		private int count;


		public int getId() {
			return id;
		}


		public void setId( int id ) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName( String name ) {
			this.name = name;
		}


		public int getCount() {
			return count;
		}


		public void setCount( int count ) {
			this.count = count;
		}
	}
}
