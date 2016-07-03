/**
 * ArticleHourDto.java site.lovecode.wechat.dto Copyright (c)
 * 2016,norman.
 */


package site.lovecode.wechat.dto;


import site.lovecode.wechat.util.Page;

import java.io.Serializable;
import java.util.List;


/**
 * 微信小时报数据体
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月24日
 * @version  1.0.0
 */


public class ArticleHourDto extends ArticleHourGroupDto implements Serializable{


	public ArticleHourDto( List<ArticleHourGroupDto> list, Page<ArticleHourGroupDto> page) {
		this.list = list;
		this.page = page;
	}

	public ArticleHourDto() {
	}


	private List<ArticleHourGroupDto> list;


	private Page<ArticleHourGroupDto> page;



	public List<ArticleHourGroupDto> getList() {
		return list;
	}

	public void setList(List<ArticleHourGroupDto> list) {
		this.list = list;
	}

	public Page<ArticleHourGroupDto> getPage() {
		return page;
	}

	public void setPage(Page<ArticleHourGroupDto> page) {
		this.page = page;
	}
}
