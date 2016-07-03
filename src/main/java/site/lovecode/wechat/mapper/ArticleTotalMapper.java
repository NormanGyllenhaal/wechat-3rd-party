package site.lovecode.wechat.mapper;


import org.apache.ibatis.annotations.Param;
import site.lovecode.wechat.common.mybatis.CommonMapper;
import site.lovecode.wechat.dto.ArticleTotalDto;
import site.lovecode.wechat.entity.ArticleTotal;
import site.lovecode.wechat.util.Page;

import java.sql.Date;
import java.util.List;

public interface ArticleTotalMapper extends CommonMapper<ArticleTotal> {


	/**
	 *
	 * @param beginDate
	 * @param endDate
     * @return
     */
	ArticleTotalDto selectJoinDetailAndSummary(@Param("articleTotalId") Long articleTotalId, @Param("beginDate") Date beginDate, @Param("endDate") Date endDate);

	/**
	 *
	 * @param page
	 * @param oaid
	 * @param beginDate
	 * @param endDate
     * @return
     */
	List<ArticleTotalDto> selectJoinDetail(@Param("page") Page<ArticleTotalDto> page, @Param("oaid") Long oaid, @Param("beginDate") Date beginDate, @Param("endDate") Date endDate);
}
