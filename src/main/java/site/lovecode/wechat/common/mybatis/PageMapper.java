/**
 * PageMapper.java site.lovecode.wechat.mybatis.mybatis.mapper Copyright (c) 2016,
 * norman.
 */


package site.lovecode.wechat.common.mybatis;

import org.apache.ibatis.annotations.SelectProvider;
import site.lovecode.wechat.util.Page;

import java.util.List;




/**
 * 分页查询
 * <p>
 *
 * @author   yangpeng
 * @date	 2016年5月5日 
 * @version  1.0.0	 
 */
public interface PageMapper<T> {


	@SelectProvider( type = PageProvider.class, method = "dynamicSQL" )
	List<T> selectPage(Page<T> page);

}
