package site.lovecode.wechat.support.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/4/21.
 */
public class UserInfoListResp implements Serializable {

	/**
	 * TODO（用一句话描述这个变量的含义）
	 */

	private static final long serialVersionUID = 1L;

	@JSONField( name = "user_info_list" )
	private List<UserInfoResp> list;


	public List<UserInfoResp> getList() {
		return list;
	}


	public void setList( List<UserInfoResp> list ) {
		this.list = list;
	}


	@Override
	public String toString() {
		return "UserInfoListResp{" + "list=" + list + '}';
	}
}
