/**
 * ArticleShareHourBean.java site.lovecode.wechat.support.bean
 * Copyright (c) 2016,norman.
 */


package site.lovecode.wechat.support.bean;


import com.alibaba.fastjson.annotation.JSONField;
import site.lovecode.wechat.entity.ArticleShareHour;

import java.util.List;


/**
 * TODO(这里用一句话描述这个类的作用)
 * <p>
 * TODO(这里描述这个类补充说明 – 可选)
 *
 * @author   Administrator
 * @date	 2016年5月16日 
 * @version  1.0.0	 
 */
public class ArticleShareHourBean {

	@JSONField( name = "list" )
	private List<ArticleShareHour> list;


	public List<ArticleShareHour> getList() {
		return list;
	}


	public void setList( List<ArticleShareHour> list ) {
		this.list = list;
	}


}
