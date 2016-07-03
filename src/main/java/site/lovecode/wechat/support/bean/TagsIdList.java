package site.lovecode.wechat.support.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by Administrator on 2016/5/10.
 */
public class TagsIdList {


	@JSONField( name = "tagid_list" )
	private List<Integer> tagidList;


	public List<Integer> getTagidList() {
		return tagidList;
	}


	public void setTagidList( List<Integer> tagidList ) {
		this.tagidList = tagidList;
	}
}
