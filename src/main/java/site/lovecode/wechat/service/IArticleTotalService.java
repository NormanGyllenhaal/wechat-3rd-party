/**
 * IArticleTotalService.java site.lovecode.wechat.service
 * Copyright (c) 2016, norman.
 */


package site.lovecode.wechat.service;


import site.lovecode.wechat.dto.ArticleTotalDto;
import site.lovecode.wechat.util.Page;

import java.sql.Date;


/**
 * 图文分析接口
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月21日
 * @version  1.0.0
 */


public interface IArticleTotalService {


	/**
	 * 
	 * 分页获取文章分页
	 * <p>
	 * 
	 *
	 * @param page 分页
	 * @param orgId 机构id
	 * @return
	 */
	Page<ArticleTotalDto> getArticleOne(Page<ArticleTotalDto> page, Long orgId, Date beigiDate, Date endDate);


	/**
	 * 获取单篇文章的详情信息
	 * @param beigiDate
	 * @param endDate
     * @return
     */
	ArticleTotalDto getArticleOneDetail(Long articleTotalId, Date beigiDate, Date endDate);

}
