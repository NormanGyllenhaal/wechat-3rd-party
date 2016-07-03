package site.lovecode.wechat.support.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by Administrator on 2016/5/10.
 */
public class TagsUserBean {


	/**
	 * count : 2
	 * data : {"openid":["ocYxcuAEy30bX0NXmGn4ypqx3tI0","ocYxcuBt0mRugKZ7tGAHPnUaOW7Y"]}
	 * next_openid : ocYxcuBt0mRugKZ7tGAHPnUaOW7Y
	 */

	@JSONField( name = "count" )
	private int count;

	@JSONField( name = "data" )
	private DataBean data;

	@JSONField( name = "next_openid" )
	private String nextOpenid;


	public int getCount() {
		return count;
	}


	public void setCount( int count ) {
		this.count = count;
	}


	public DataBean getData() {
		return data;
	}


	public void setData( DataBean data ) {
		this.data = data;
	}


	public String getNextOpenid() {
		return nextOpenid;
	}


	public void setNextOpenid( String nextOpenid ) {
		this.nextOpenid = nextOpenid;
	}

	public static class DataBean {

		@JSONField( name = "openid" )
		private List<String> openid;


		public List<String> getOpenid() {
			return openid;
		}


		public void setOpenid( List<String> openid ) {
			this.openid = openid;
		}
	}
}
