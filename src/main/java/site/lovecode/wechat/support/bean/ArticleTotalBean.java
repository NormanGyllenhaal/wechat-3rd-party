/**
 * ArticleTotalBean.java site.lovecode.wechat.support.bean
 * Copyright (c) 2016,norman.
 */
/**
 * ArticleTotalBean.java site.lovecode.wechat.support.bean
 * Copyright (c) 2016,norman.
 */


package site.lovecode.wechat.support.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;


/**
 * 图文群发总数据
 * <p>
 * TODO(这里描述这个类补充说明 – 可选)
 *
 * @author   yangpeng
 * @date	 2016年5月16日 
 * @version  1.0.0	 
 */
public class ArticleTotalBean {

	@JSONField( name = "list" )
	private List<ArticleTotalSubBean> articleTotalList;


	public List<ArticleTotalSubBean> getArticleTotalList() {
		return articleTotalList;
	}


	public void setArticleTotalList( List<ArticleTotalSubBean> articleTotalList ) {
		this.articleTotalList = articleTotalList;
	}


}
