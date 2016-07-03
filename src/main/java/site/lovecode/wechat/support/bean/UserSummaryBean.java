/**
 * UserSummaryBean.java site.lovecode.wechat.support.bean
 * Copyright (c) 2016,norman.
 */


package site.lovecode.wechat.support.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;


/**
 * 用户增减数据bena
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月14日 
 * @version  1.0.0	 
 */
public class UserSummaryBean {

	/**
	 * ref_date : 2014-12-07
	 * user_source : 0
	 * new_user : 0
	 * cancel_user : 0
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
		private Date refDate;

		@JSONField( name = "user_source" )
		private int userSource;

		@JSONField( name = "new_user" )
		private int newUser;

		@JSONField( name = "cancel_user" )
		private int cancelUser;


		public Date getRefDate() {
			return refDate;
		}


		public void setRefDate( Date refDate ) {
			this.refDate = refDate;
		}


		public int getUserSource() {
			return userSource;
		}


		public void setUserSource( int userSource ) {
			this.userSource = userSource;
		}


		public int getNewUser() {
			return newUser;
		}


		public void setNewUser( int newUser ) {
			this.newUser = newUser;
		}


		public int getCancelUser() {
			return cancelUser;
		}


		public void setCancelUser( int cancelUser ) {
			this.cancelUser = cancelUser;
		}
	}

}
