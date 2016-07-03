/**
 * TagBean.java site.lovecode.wechat.support.bean Copyright (c)
 * 2016,norman.
 */


package site.lovecode.wechat.support.bean;


/**
 * 标签bean
 * <p>
 *
 * @author   yangpeng
 * @date	 2016年5月10日 
 * @version  1.0.0	 
 */
public class TagBean {


	private Tag tag;


	public Tag getTag() {
		return tag;
	}


	public void setTag( Tag tag ) {
		this.tag = tag;
	}


	public static class Tag {

		private String name;

		private Integer id;


		public String getName() {
			return name;
		}


		public void setName( String name ) {
			this.name = name;
		}


		public Integer getId() {
			return id;
		}


		public void setId( Integer id ) {
			this.id = id;
		}


	}


}
