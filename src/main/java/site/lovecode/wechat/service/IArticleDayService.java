/**
 * IArticleDayService.java site.lovecode.wechat.service Copyright
 * (c) 2016, norman.
 */


package site.lovecode.wechat.service;


import site.lovecode.wechat.dto.ArticleDayDto;
import site.lovecode.wechat.dto.ArticleSummaryDto;
import site.lovecode.wechat.util.Page;

import java.sql.Date;
import java.util.List;


/**
 * 图文每日数据业务逻辑层
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月24日
 * @version  1.0.0
 */


public interface IArticleDayService {


	/**
	 * 
	 * 获取到图文日报
	 * <p>
	 * 
	 *
	 * @param orgId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	 ArticleSummaryDto getArticleDay(Long orgId, Date beginDate, Date endDate, Page<ArticleDayDto> page);


	/**
	 * 分页获取图文日报
	 * @param orgId
	 * @param beginDate
	 * @param endDate
     * @return
     */
	Page<ArticleDayDto> getArticleDayPage(Long orgId, Date beginDate, Date endDate, Page<ArticleDayDto> page);



	/**
	 * 获取每日图文数据列表
	 * @param orgId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	 List<ArticleDayDto> getArticleDayList(Long orgId, Date beginDate, Date endDate);

}
