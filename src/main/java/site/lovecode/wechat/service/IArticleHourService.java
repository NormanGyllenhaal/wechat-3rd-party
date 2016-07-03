/**
 * IArticleHourService.java site.lovecode.wechat.service Copyright
 * (c) 2016, norman.
 */


package site.lovecode.wechat.service;


import site.lovecode.wechat.dto.ArticleHourDto;
import site.lovecode.wechat.dto.ArticleHourGroupDto;
import site.lovecode.wechat.util.Page;

import java.sql.Date;
import java.util.List;


/**
 * 获取图文小时
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月24日
 * @version  1.0.0
 */


public interface IArticleHourService {


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
	ArticleHourDto getArticleHour(Long orgId, Date date, Page<ArticleHourGroupDto> page);


    /**
	 *
	 * @param orgId
	 * @param date
	 * @param page
     * @return
     */
	Page<ArticleHourGroupDto> getArticleHourPage(Long orgId, Date date, Page<ArticleHourGroupDto> page);



	/**
	 * 获取文章小时列表
	 * @param orgId
	 * @param date
	 * @return
	 */
	 List<ArticleHourGroupDto> getArticleHourList(Long orgId, Date date);


}
