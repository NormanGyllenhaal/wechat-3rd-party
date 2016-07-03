package site.lovecode.wechat.support.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by Administrator on 2016/4/11.
 */
public class OpenidBean {


	private Integer total;

	private Integer count;

	private Openid data;

	@JSONField( name = "next_openid" )
	private String nextOpenid;


	public class Openid {

		protected List<String> openid;


		public List<String> getOpenid() {
			return openid;
		}


		public void setOpenid( List<String> openid ) {
			this.openid = openid;
		}
	}


	public Integer getTotal() {
		return total;
	}


	public void setTotal( Integer total ) {
		this.total = total;
	}


	public Integer getCount() {
		return count;
	}


	public void setCount( Integer count ) {
		this.count = count;
	}


	public Openid getData() {
		return data;
	}


	public void setData( Openid data ) {
		this.data = data;
	}


	public String getNextOpenid() {
		return nextOpenid;
	}


	public void setNextOpenid( String nextOpenid ) {
		this.nextOpenid = nextOpenid;
	}


	@Override
	public String toString() {
		return "OpenidBean{"
				+ "total=" + total + ", count=" + count + ", data=" + data + ", nextOpenid='" + nextOpenid + '\'' + '}';
	}
}
