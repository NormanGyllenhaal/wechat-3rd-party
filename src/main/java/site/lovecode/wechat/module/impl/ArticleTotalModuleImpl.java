/**
 * ArticleTotalModuleImpl.java cn.vko.peixun.module.communication.module
 * Copyright (c) 2016, .
 */


package site.lovecode.wechat.module.impl;


import org.springframework.stereotype.Service;
import site.lovecode.wechat.dto.*;
import site.lovecode.wechat.module.IArticleTotalModule;
import site.lovecode.wechat.service.IArticleDayService;
import site.lovecode.wechat.service.IArticleHourService;
import site.lovecode.wechat.service.IArticleTotalService;
import site.lovecode.wechat.support.common.Response;
import site.lovecode.wechat.util.Page;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 图文总数据服务层
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月21日
 * @version  1.0.0
 */

@Service
public class ArticleTotalModuleImpl extends AbstractModule implements IArticleTotalModule {

	@Resource
	private IArticleTotalService articleTotalServiceImpl;

	@Resource
	private IArticleDayService articleDayServiceImpl;

	@Resource
	private IArticleHourService articleHourServiceImpl;


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
	@Override
	public Response<Page<ArticleTotalDto>> getArticleOne(Page<ArticleTotalDto> page, Long orgId, Date beginDate, Date endDate ) {
		return success(articleTotalServiceImpl.getArticleOne(page, orgId,beginDate,endDate));
	}

	/**
	 * 获取单篇问题统计详情
	 * @param articleTotalId
	 * @param beginDate
	 * @param endDate
     * @return
     */
	@Override
	public Response<ArticleTotalDto> getArticleOneDetail( Long articleTotalId, Date beginDate, Date endDate) {
		return success(articleTotalServiceImpl.getArticleOneDetail(articleTotalId,beginDate,endDate));
	}


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
	@Override
	public Response<ArticleSummaryDto> getArticleDay(Page<ArticleDayDto> page, Long orgId, Date beginDate, Date endDate ) {
		return success(articleDayServiceImpl.getArticleDay(orgId, beginDate, endDate,page));
	}


	/**
	 * 分页获取每日图文
	 * @param page
	 * @param orgId
	 * @param beginDate
	 * @param endDate
     * @return
     */
	public Response<Page<ArticleDayDto>>  getArticelDayPage(Page<ArticleDayDto> page, Long orgId, Date beginDate, Date endDate ){
		return success(articleDayServiceImpl.getArticleDayPage(orgId,beginDate,endDate,page));
	}


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
	@Override
	public Response<ArticleHourDto> getArticleHour(Long orgId, Date date, Page<ArticleHourGroupDto> page) {
		return success(articleHourServiceImpl.getArticleHour(orgId,date,page));
	}


	/**
	 * 分页获取图文小时数据
	 * @param orgId
	 * @param date
	 * @param page
     * @return
     */
	public Response<Page<ArticleHourGroupDto>>  getArticleHourPage(Long orgId,Date date,Page<ArticleHourGroupDto> page){
          return success(articleHourServiceImpl.getArticleHourPage(orgId,date,page));
	}


	/**
	 * 获取excel图文每日excel数据
	 * @param orgId
	 * @param beginDate
	 * @param endDate
     * @return
     */
	public Response<List<Map<String,Object>>> getArticleDayExcel(Long orgId, Date beginDate, Date endDate ){
		List<ArticleDayDto> articleDayList = articleDayServiceImpl.getArticleDayList(orgId, beginDate, endDate);
		List<Map<String, Object>> collect = articleDayList.stream().map(ArticleDayDto::toMap).collect(Collectors.toList());
		return success(collect);
	}


	/**
	 * 获取excel图文每小数数据
	 * @param orgId
	 * @param date
     * @return
     */
	public Response<List<Map<String,Object>>> getArticleHourExcel(Long orgId, Date date ){
		List<ArticleHourGroupDto> articleHourList = articleHourServiceImpl.getArticleHourList(orgId, date);
		return success(articleHourList.stream().map(ArticleHourGroupDto::toMap).collect(Collectors.toList()));
	}


}
