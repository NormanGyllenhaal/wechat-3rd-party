/**
 * ArticleDayServiceImpl.java site.lovecode.wechat.service.impl
 * Copyright (c) 2016, norman.
 */


package site.lovecode.wechat.service.impl;


import org.springframework.stereotype.Service;
import site.lovecode.wechat.dto.ArticleDayDto;
import site.lovecode.wechat.dto.ArticleSummaryDto;
import site.lovecode.wechat.mapper.ArticleDayMapper;
import site.lovecode.wechat.mapper.OrgOfficialAccountMapper;
import site.lovecode.wechat.service.IArticleDayService;
import site.lovecode.wechat.util.Page;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;


/**
 * 每日图文统计数据
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月24日
 * @version  1.0.0
 */

@Service
public class ArticleDayServiceImpl implements IArticleDayService {

	@Resource
	private ArticleDayMapper articleDayMapper;

	@Resource
	private OrgOfficialAccountMapper orgOfficialAccountMapper;


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
	@Override
	public ArticleSummaryDto getArticleDay(Long orgId, Date beginDate, Date endDate, Page<ArticleDayDto> page) {
		Long oaid = getOaid(orgId);
		ArticleSummaryDto articleSummaryDto = articleDayMapper.selectJoinArticleSummary(oaid, beginDate, endDate);
		Page<ArticleDayDto> articleDayPage = getArticleDayPage(orgId, beginDate, endDate, page);
		articleSummaryDto.setPage(articleDayPage);
		return articleSummaryDto;
	}


	/**
	 * 获取每日图文数据分页
	 * @param orgId
	 * @param beginDate
	 * @param endDate
	 * @param page
     * @return
     */
	@Override
	public Page<ArticleDayDto> getArticleDayPage(Long orgId, Date beginDate, Date endDate,Page<ArticleDayDto> page) {
		Long oaid = getOaid(orgId);
		List<ArticleDayDto> dtoList = articleDayMapper.selectJoinSummaryPage(oaid, beginDate, endDate,(page.getPage()-1)*page.getPageSize(),page.getPageSize());
		Integer count = articleDayMapper.selectJoinSummaryCount(oaid, beginDate, endDate);
		page.setCount(count);
		page.setRecords(dtoList);
		return page;
	}


	/**
	 * 获取每日图文数据列表
	 * @param orgId
	 * @param beginDate
	 * @param endDate
     * @return
     */
	public List<ArticleDayDto> getArticleDayList(Long orgId, Date beginDate, Date endDate){
		Long oaid = getOaid(orgId);
		List<ArticleDayDto> dtoList = articleDayMapper.selectJoinSummaryPage(oaid, beginDate, endDate,null,null);
		return dtoList;
	}



	Long getOaid( Long orgId ) {
		return orgOfficialAccountMapper.getOfficialAccountIdByOrgId(orgId);
	}


}
