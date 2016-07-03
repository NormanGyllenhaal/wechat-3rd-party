package site.lovecode.wechat.mapper;


import org.apache.ibatis.annotations.Param;
import site.lovecode.wechat.common.mybatis.CommonMapper;
import site.lovecode.wechat.dto.ArticleDayDto;
import site.lovecode.wechat.dto.ArticleSummaryDto;
import site.lovecode.wechat.entity.ArticleDay;

import java.sql.Date;
import java.util.List;

public interface ArticleDayMapper extends CommonMapper<ArticleDay> {


    /**
     * @param beginDate
     * @param endDate
     * @return
     */
    ArticleSummaryDto selectJoinArticleSummary(@Param("oaid") Long oaid, @Param("beginDate") Date beginDate, @Param("endDate") Date endDate);


    /**
     * 条件查询总数
     *
     * @param oaid
     * @param beginDate
     * @param endDate
     * @return
     */
    Integer selectJoinSummaryCount(@Param("oaid") Long oaid, @Param("beginDate") Date beginDate, @Param("endDate") Date endDate);


    /**
     * 分页获取每天图文统计
     *
     * @param oaid
     * @param beginDate
     * @param endDate
     * @return
     */
    List<ArticleDayDto> selectJoinSummaryPage(@Param("oaid") Long oaid, @Param("beginDate") Date beginDate, @Param("endDate") Date endDate, @Param("index") Integer index, @Param("size") Integer size);
}
