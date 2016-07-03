package site.lovecode.wechat.mapper;


import org.apache.ibatis.annotations.Param;
import site.lovecode.wechat.common.mybatis.CommonMapper;
import site.lovecode.wechat.dto.ArticleHourDto;
import site.lovecode.wechat.dto.ArticleHourGroupDto;
import site.lovecode.wechat.entity.ArticleHour;

import java.sql.Date;
import java.util.List;

public interface ArticleHourMapper extends CommonMapper<ArticleHour> {


	/**
	 * 
	 * 根据日期查询小时统计信息
	 * <p>
	 * 
	 *
	 * @param oaid
	 * @param date
	 * @return
	 */
	 List<ArticleHourGroupDto> selectArticleHour(@Param("oaid") Long oaid, @Param("refDate") Date date, @Param("index") Integer index, @Param("size") Integer size);


    /**
	 * 根据日期查询来源总数
	 * @param oaid
	 * @param date
	 * @return
     */
	ArticleHourDto selectArticleHourTotal(@Param("oaid") Long oaid, @Param("refDate") Date date);


    /**
	 * 根据日期查询总条数
	 * @param oaid
	 * @param date
	 * @return
     */
	Integer selectArticleHourCount(@Param("oaid") Long oaid, @Param("refDate") Date date);




}
