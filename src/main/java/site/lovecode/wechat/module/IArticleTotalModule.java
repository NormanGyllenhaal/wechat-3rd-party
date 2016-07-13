/**
 * IArticleTotalModule.java cn.vko.peixun.core.module.communication Copyright
 * (c) 2016, .
 */


package site.lovecode.wechat.module;


import site.lovecode.wechat.dto.*;
import site.lovecode.wechat.support.common.Response;
import site.lovecode.wechat.util.Page;

import java.sql.Date;
import java.util.List;
import java.util.Map;


/**
 * 单片图文统计服务接口
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月21日
 * @version  1.0.0
 */


public interface IArticleTotalModule {


	/**
	 * 
	 * 获取单篇文章的图文统计数据
	 * <p>
	 * 
	 *
	 * @param page 分页对象
	 * @param orgId 机构id
	 * @return
	 */
	public Response<Page<ArticleTotalDto>> getArticleOne(Page<ArticleTotalDto> page, Long orgId, Date beginDate, Date endDate);


    /**
	 * 单篇文章详细信息
	 * @param articleTotalId
	 * @param beginDate
	 * @param endDate
     * @return
     */
	public Response<ArticleTotalDto> getArticleOneDetail(Long articleTotalId, Date beginDate, Date endDate);


	/**
	 * 
	 * 获取图文日报
	 * <p>
	 * 
	 *
	 * @param orgId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public Response<ArticleSummaryDto> getArticleDay(Page<ArticleDayDto> page, Long orgId, Date beginDate, Date endDate);




	/**
	 * 分页获取每日图文
	 * @param page
	 * @param orgId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	 Response<Page<ArticleDayDto>>  getArticelDayPage(Page<ArticleDayDto> page, Long orgId, Date beginDate, Date endDate);


	/**
	 * 
	 * 获取图文小时数
	 * <p>
	 * 
	 *
	 * @param orgId
	 * @param date
	 * @return
	 */
	 Response<ArticleHourDto> getArticleHour(Long orgId, Date date, Page<ArticleHourGroupDto> page);


	/**
	 * 分页获取图文数据
	 * @param orgId
	 * @param date
	 * @param page
     * @return
     */
	 Response<Page<ArticleHourGroupDto>>  getArticleHourPage(Long orgId, Date date, Page<ArticleHourGroupDto> page);



	/**
	 * 获取excel图文每日excel数据
	 * @param orgId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public Response<List<Map<String,Object>>> getArticleDayExcel(Long orgId, Date beginDate, Date endDate);



	/**
	 * 获取excel图文每小数数据
	 * @param orgId
	 * @param date
	 * @return
	 */
	public Response<List<Map<String,Object>>> getArticleHourExcel(Long orgId, Date date);


}
