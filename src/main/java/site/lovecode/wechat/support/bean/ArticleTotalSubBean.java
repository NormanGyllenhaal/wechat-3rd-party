/**
 * ArticleTotalSubBean.java site.lovecode.wechat.support.bean
 * Copyright (c) 2016,norman.
 */


package site.lovecode.wechat.support.bean;


import com.alibaba.fastjson.annotation.JSONField;
import site.lovecode.wechat.entity.ArticleTotal;
import site.lovecode.wechat.entity.ArticleTotalDetail;

import java.util.List;


/**
 * 
 * <p>
 * TODO(这里描述这个类补充说明 – 可选)
 *
 * @author   yangpeng
 * @date	 2016年5月16日 
 * @version  1.0.0	 
 */
public class ArticleTotalSubBean extends ArticleTotal {


	/**
	 * TODO（用一句话描述这个变量的含义）
	 */

	private static final long serialVersionUID = 1L;

	@JSONField( name = "details" )
	private List<ArticleTotalDetail> details;


	public List<ArticleTotalDetail> getDetails() {
		return details;
	}


	public void setDetails( List<ArticleTotalDetail> details ) {
		this.details = details;
	}


	@Override
	public String toString() {
		return "ArticleTotalSubBean [details=" + details + "]";
	}


}
