/**
 * ArticleTotalDto.java site.lovecode.wechat.dto Copyright
 * (c) 2016,norman.
 */


package site.lovecode.wechat.dto;


import site.lovecode.wechat.entity.ArticleSummary;
import site.lovecode.wechat.entity.ArticleTotal;
import site.lovecode.wechat.entity.ArticleTotalDetail;

import java.util.List;


/**
 * 微信群发总数据载体
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月21日
 * @version  1.0.0
 */


public class ArticleTotalDto extends ArticleTotal {


	private static final long serialVersionUID = 1L;


	private ArticleTotalDetail articleTotalDetail;


	private List<ArticleSummary> articleSummaryList;


	public ArticleTotalDetail getArticleTotalDetail() {
		return articleTotalDetail;
	}


	public void setArticleTotalDetail( ArticleTotalDetail articleTotalDetail ) {
		this.articleTotalDetail = articleTotalDetail;
	}


	public List<ArticleSummary> getArticleSummaryList() {
		return articleSummaryList;
	}


	public void setArticleSummaryList( List<ArticleSummary> articleSummaryList ) {
		this.articleSummaryList = articleSummaryList;
	}


}
