package site.lovecode.wechat.support.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by Administrator on 2016/5/14.
 */
public class UserCumulateBean {

	/**
	 * ref_date : 2014-12-07
	 * cumulate_user : 1217056
	 */

	@JSONField( name = "list" )
	private List<ListBean> list;


	public List<ListBean> getList() {
		return list;
	}


	public void setList( List<ListBean> list ) {
		this.list = list;
	}

	public static class ListBean {

		@JSONField( name = "ref_date" )
		private String refDate;

		@JSONField( name = "cumulate_user" )
		private int cumulateUser;


		public String getRefDate() {
			return refDate;
		}


		public void setRefDate( String refDate ) {
			this.refDate = refDate;
		}


		public int getCumulateUser() {
			return cumulateUser;
		}


		public void setCumulateUser( int cumulateUser ) {
			this.cumulateUser = cumulateUser;
		}
	}
}
