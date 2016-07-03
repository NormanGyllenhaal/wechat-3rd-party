package site.lovecode.wechat.mapper;


import org.apache.ibatis.annotations.Param;
import site.lovecode.wechat.common.mybatis.CommonMapper;
import site.lovecode.wechat.dto.MediaDto;
import site.lovecode.wechat.entity.Media;
import site.lovecode.wechat.util.Page;

import java.util.List;

public interface MediaMapper extends CommonMapper<Media> {


	List<MediaDto> selectJoinMediaNews(
			@Param("page") Page<MediaDto> page, @Param("oaid") Long oaid, @Param("type") Integer type,
			@Param("mediaType") Integer mediaType);


	List<Media> selectByTypePage(
			@Param("page") Page<Media> page, @Param("oaid") Long oaid, @Param("type") Integer type);
}
