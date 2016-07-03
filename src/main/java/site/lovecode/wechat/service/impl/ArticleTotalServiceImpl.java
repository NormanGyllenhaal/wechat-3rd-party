/**
 * ArticleTotalServiceImpl.java site.lovecode.wechat.service.impl
 * Copyright (c) 2016, norman.
 */


package site.lovecode.wechat.service.impl;


import org.springframework.stereotype.Service;
import site.lovecode.wechat.dto.ArticleTotalDto;
import site.lovecode.wechat.mapper.ArticleTotalMapper;
import site.lovecode.wechat.mapper.OrgOfficialAccountMapper;
import site.lovecode.wechat.service.IArticleTotalService;
import site.lovecode.wechat.util.Page;

import javax.annotation.Resource;
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

@Service
public class ArticleTotalServiceImpl  implements IArticleTotalService {

	@Resource
	private ArticleTotalMapper articleTotalMapper;

	@Resource
	private OrgOfficialAccountMapper orgOfficialAccountMapper;


	/**
	 * 
	 * 分页获取单篇文章统计数据
	 * <p>
	 * 
	 *
	 * @param page 分页
	 * @param orgId 机构id
	 * @return
	 */
	@Override
	public Page<ArticleTotalDto> getArticleOne(Page<ArticleTotalDto> page, Long orgId, Date beigiDate, Date endDate) {
		articleTotalMapper.selectJoinDetail(page, getOaid(orgId),beigiDate,endDate);
		return page;
	}

	/**
	 * 获取图文统计详细信息
	 * @param articleTotalId
	 * @param beigiDate
	 * @param endDate
     * @return
     */
	@Override
	public ArticleTotalDto getArticleOneDetail( Long articleTotalId, Date beigiDate, Date endDate) {
		return articleTotalMapper.selectJoinDetailAndSummary(articleTotalId,beigiDate,endDate);
	}



	Long getOaid( Long orgId ) {
		return orgOfficialAccountMapper.getOfficialAccountIdByOrgId(orgId);
	}


}
