/**
 * ArticleHourBean.java site.lovecode.wechat.support.bean
 * Copyright (c) 2016,norman.
 */


package site.lovecode.wechat.support.bean;


import com.alibaba.fastjson.annotation.JSONField;
import site.lovecode.wechat.entity.ArticleHour;

import java.util.List;


/**
 * 获取图文统计分时数据
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月16日 
 * @version  1.0.0	 
 */
public class ArticleHourBean {

	@JSONField( name = "list" )
	private List<ArticleHour> list;


	public List<ArticleHour> getList() {
		return list;
	}


	public void setList( List<ArticleHour> list ) {
		this.list = list;
	}


}
