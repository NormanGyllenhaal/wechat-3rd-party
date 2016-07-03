/**
 * ArticleSummaryBean.java site.lovecode.wechat.support.bean
 * Copyright (c) 2016,norman.
 */


package site.lovecode.wechat.support.bean;


import com.alibaba.fastjson.annotation.JSONField;
import site.lovecode.wechat.entity.ArticleSummary;

import java.util.List;


/**
 * 图文群发数据
 * <p>
 * 
 *
 * @author   Administrator
 * @date	 2016年5月16日 
 * @version  1.0.0	 
 */
public class ArticleSummaryBean {


	@JSONField( name = "list" )
	private List<ArticleSummary> articleSummaryList;


	public List<ArticleSummary> getArticleSummaryList() {
		return articleSummaryList;
	}


	public void setArticleSummaryList( List<ArticleSummary> articleSummaryList ) {
		this.articleSummaryList = articleSummaryList;
	}


}
