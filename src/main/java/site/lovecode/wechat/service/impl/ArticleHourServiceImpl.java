/**
 * ArticleHourServiceImpl.java site.lovecode.wechat.service.impl
 * Copyright (c) 2016, norman.
 */


package site.lovecode.wechat.service.impl;


import org.springframework.stereotype.Service;
import site.lovecode.wechat.dto.ArticleHourDto;
import site.lovecode.wechat.dto.ArticleHourGroupDto;
import site.lovecode.wechat.mapper.ArticleHourMapper;
import site.lovecode.wechat.mapper.OrgOfficialAccountMapper;
import site.lovecode.wechat.service.IArticleHourService;
import site.lovecode.wechat.util.Page;

import javax.annotation.Resource;
import java.sql.Date;
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

@Service
public class ArticleHourServiceImpl implements IArticleHourService {

	@Resource
	private ArticleHourMapper articleHourMapper;


	@Resource
	private OrgOfficialAccountMapper orgOfficialAccountMapper;


	/**
	 * 
	 * 获取小时报
	 * <p>
	 * 
	 *
	 * @param orgId
	 * @param date
	 * @return
	 */
	@Override
	public ArticleHourDto getArticleHour(Long orgId, Date date, Page<ArticleHourGroupDto> page) {
		Long oaid = getOaid(orgId);
		ArticleHourDto articleHourDto = articleHourMapper.selectArticleHourTotal(oaid, date);
		page = getPage(oaid, date, page);
		List<ArticleHourGroupDto> dtoList = articleHourMapper.selectArticleHour(oaid, date, null, null);
		if(articleHourDto!=null){
			articleHourDto.setList(dtoList);
			articleHourDto.setPage(page);
		}
        return articleHourDto;
	}


	/**
	 * 分页获取小时报
	 * @param orgId
	 * @param date
	 * @param page
     * @return
     */
	@Override
	public Page<ArticleHourGroupDto> getArticleHourPage(Long orgId, Date date, Page<ArticleHourGroupDto> page) {
		Long oaid = getOaid(orgId);
		return getPage(oaid, date, page);
	}


	/**
	 * 获取文章小时列表
	 * @param orgId
	 * @param date
     * @return
     */
	public List<ArticleHourGroupDto> getArticleHourList(Long orgId, Date date){
		Long oaid = getOaid(orgId);
		List<ArticleHourGroupDto> dtoList = articleHourMapper.selectArticleHour(oaid, date, null, null);
		return dtoList;
	}


	private Page<ArticleHourGroupDto> getPage(Long oaid, Date date, Page<ArticleHourGroupDto> page){
		List<ArticleHourGroupDto> list = articleHourMapper.selectArticleHour(oaid, date, (page.getPage() - 1) * page.getPageSize(), page.getPageSize());
		Integer count  = articleHourMapper.selectArticleHourCount(oaid,date);
		page.setRecords(list);
		page.setCount(count);
		return page;
	}


	Long getOaid( Long orgId ) {
		return orgOfficialAccountMapper.getOfficialAccountIdByOrgId(orgId);
	}


}
