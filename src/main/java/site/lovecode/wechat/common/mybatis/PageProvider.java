/**
 * PageProvider.java site.lovecode.wechat.mybatis.mybatis.mapper Copyright (c)
 * 2016, norman.
 */


package site.lovecode.wechat.common.mybatis;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;


/**
 * 分页查询实现
 * <p>
 *
 * @author   Administrator
 * @date	 2016年5月5日 
 * @version  1.0.0	 
 */
public class PageProvider extends MapperTemplate {


	/**
	 * 创建 PageProvider对象.
	 *
	 * @param mapperClass
	 * @param mapperHelper
	 */

	public PageProvider( Class<?> mapperClass, MapperHelper mapperHelper ) {
		super(mapperClass, mapperHelper);
	}


	/**
	* 分页查询所有结果
	*
	* @param ms
	* @return
	*/
	public String selectPage( MappedStatement ms ) {
		final Class<?> entityClass = getEntityClass(ms);
		// 修改返回值类型为实体类型
		setResultType(ms, entityClass);
		StringBuilder sql = new StringBuilder();
		sql.append(SqlHelper.selectAllColumns(entityClass));
		sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
		sql.append(SqlHelper.orderByDefault(entityClass));
		return sql.toString();
	}

}
