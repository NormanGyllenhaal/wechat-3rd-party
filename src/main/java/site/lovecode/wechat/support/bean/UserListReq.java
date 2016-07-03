package site.lovecode.wechat.support.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2016/4/21.
 */
public class UserListReq {

	@JSONField( name = "user_list" )
	private List<UserOpenidReq> userOpenidReqList;


	public List<UserOpenidReq> getUserOpenidReqList() {
		return userOpenidReqList;
	}


	public void setUserOpenidReqList( List<UserOpenidReq> userOpenidReqList ) {
		this.userOpenidReqList = userOpenidReqList;
	}


	public void setUserOpenidList( List<String> openidList ) {
		this.userOpenidReqList = openidList.stream().map(s -> new UserOpenidReq() {

			{
				setOpenid(s);
				setLang("zh-CN");
			}
		}).collect(Collectors.toList());
	}
}
