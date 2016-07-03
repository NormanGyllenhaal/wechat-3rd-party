/**
 * ArticleSummaryDto.java site.lovecode.wechat.dto Copyright
 * (c) 2016,norman.
 */


package site.lovecode.wechat.dto;


import site.lovecode.wechat.entity.ArticleSummary;
import site.lovecode.wechat.util.Page;

import java.util.List;


/**
 * 
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月24日
 * @version  1.0.0
 */


public class ArticleSummaryDto extends ArticleSummary {

	/**
	 * TODO（用一句话描述这个变量的含义）
	 */

	private static final long serialVersionUID = 1L;


	private List<ArticleDayDto> list;


	private Page<ArticleDayDto> page;


	public List<ArticleDayDto> getList() {
		return list;
	}

	public void setList(List<ArticleDayDto> list) {
		this.list = list;
	}

	public Page<ArticleDayDto> getPage() {
		return page;
	}

	public void setPage(Page<ArticleDayDto> page) {
		this.page = page;
	}
}
