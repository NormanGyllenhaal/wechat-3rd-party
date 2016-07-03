package site.lovecode.wechat.common.mybatis;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Set;

/**
 * Created by Administrator on 2016/4/12.
 */
public class BatchProvider extends MapperTemplate {

	public BatchProvider( Class<?> mapperClass, MapperHelper mapperHelper ) {
		super(mapperClass, mapperHelper);
	}


	/**
	 * 批量插入
	 *
	 * @param ms
	 */
	public String batchInsert( MappedStatement ms ) {
		Class<?> entityClass = getEntityClass(ms);
		StringBuilder sql = new StringBuilder();
		// 获取全部列
		Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
		// Identity列只能有一个
		Boolean hasIdentityKey = false;
		// 先处理cache或bind节点
		for ( EntityColumn column : columnList ) {
			if ( !column.isInsertable() ) {
				continue;
			}
			if ( StringUtil.isNotEmpty(column.getSequenceName()) ) {} else if ( column.isIdentity() ) {
				// 这种情况下,如果原先的字段有值,需要先缓存起来,否则就一定会使用自动增长
				// 这是一个bind节点
				sql.append(SqlHelper.getBindCache(column));
				// 如果是Identity列，就需要插入selectKey
				// 如果已经存在Identity列，抛出异常
				if ( hasIdentityKey ) {
					// jdbc类型只需要添加一次
					if ( column.getGenerator() != null && column.getGenerator().equals("JDBC") ) {
						continue;
					}
					throw new RuntimeException(ms.getId()
							+ "对应的实体类" + entityClass.getCanonicalName() + "中包含多个MySql的自动增长列,最多只能有一个!");
				}
				// 插入selectKey
				newSelectKeyMappedStatement(ms, column);
				hasIdentityKey = true;
			} else if ( column.isUuid() ) {
				// uuid的情况，直接插入bind节点
				sql.append(SqlHelper.getBindValue(column, getUUID()));
			}
		}
		sql.append(SqlHelper.insertIntoTable(entityClass, tableName(entityClass)));
		sql.append(SqlHelper.insertColumns(entityClass, false, false, false));
		sql.append("<trim prefix=\"VALUES(\" suffix=\")\" suffixOverrides=\",\">");
		for ( EntityColumn column : columnList ) {
			if ( !column.isInsertable() ) {
				continue;
			}
			// 优先使用传入的属性值,当原属性property!=null时，用原属性
			// 自增的情况下,如果默认有值,就会备份到property_cache中,所以这里需要先判断备份的值是否存在
			if ( column.isIdentity() ) {
				sql.append(SqlHelper.getIfCacheNotNull(column, column.getColumnHolder(null, "_cache", ",")));
			} else {
				// 其他情况值仍然存在原property中
				sql.append(SqlHelper.getIfNotNull(column, column.getColumnHolder(null, null, ","), isNotEmpty()));
			}
			// 当属性为null时，如果存在主键策略，会自动获取值，如果不存在，则使用null
			// 序列的情况
			if ( StringUtil.isNotEmpty(column.getSequenceName()) ) {
				sql.append(SqlHelper.getIfIsNull(column, getSeqNextVal(column) + " ,", false));
			} else if ( column.isIdentity() ) {
				sql.append(SqlHelper.getIfCacheIsNull(column, column.getColumnHolder() + ","));
			} else if ( column.isUuid() ) {
				sql.append(SqlHelper.getIfIsNull(column, column.getColumnHolder(null, "_bind", ","), isNotEmpty()));
			} else {
				// 当null的时候，如果不指定jdbcType，oracle可能会报异常，指定VARCHAR不影响其他
				sql.append(SqlHelper.getIfIsNull(column, column.getColumnHolder(null, null, ","), isNotEmpty()));
			}
		}
		sql.append("</trim>");
		return sql.toString();
	}


	public String batchInsertSelective( MappedStatement ms ) {
		Class<?> entityClass = getEntityClass(ms);
		StringBuilder sql = new StringBuilder();
		// 获取全部列
		Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
		// Identity列只能有一个
		Boolean hasIdentityKey = false;
		// 先处理cache或bind节点
		for ( EntityColumn column : columnList ) {
			if ( !column.isInsertable() ) {
				continue;
			}
			if ( StringUtil.isNotEmpty(column.getSequenceName()) ) {
				// sql.append(column.getColumn() + ",");
			} else if ( column.isIdentity() ) {
				// 这种情况下,如果原先的字段有值,需要先缓存起来,否则就一定会使用自动增长
				// 这是一个bind节点
				sql.append(SqlHelper.getBindCache(column));
				// 如果是Identity列，就需要插入selectKey
				// 如果已经存在Identity列，抛出异常
				if ( hasIdentityKey ) {
					// jdbc类型只需要添加一次
					if ( column.getGenerator() != null && column.getGenerator().equals("JDBC") ) {
						continue;
					}
					throw new RuntimeException(ms.getId()
							+ "对应的实体类" + entityClass.getCanonicalName() + "中包含多个MySql的自动增长列,最多只能有一个!");
				}
				// 插入selectKey
				newSelectKeyMappedStatement(ms, column);
				hasIdentityKey = true;
			} else if ( column.isUuid() ) {
				// uuid的情况，直接插入bind节点
				sql.append(SqlHelper.getBindValue(column, getUUID()));
			}
		}
		sql.append(SqlHelper.insertIntoTable(entityClass, tableName(entityClass)));
		sql.append("<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">");
		for ( EntityColumn column : columnList ) {
			if ( !column.isInsertable() ) {
				continue;
			}
			if ( StringUtil.isNotEmpty(column.getSequenceName()) || column.isIdentity() || column.isUuid() ) {
				sql.append(column.getColumn() + ",");
			} else {
				sql.append(SqlHelper.getIfNotNull(column, column.getColumn() + ",", isNotEmpty()));
			}
		}
		sql.append("</trim>");
		sql.append("<trim prefix=\"VALUES(\" suffix=\")\" suffixOverrides=\",\">");
		for ( EntityColumn column : columnList ) {
			if ( !column.isInsertable() ) {
				continue;
			}
			// 优先使用传入的属性值,当原属性property!=null时，用原属性
			// 自增的情况下,如果默认有值,就会备份到property_cache中,所以这里需要先判断备份的值是否存在
			if ( column.isIdentity() ) {
				sql.append(SqlHelper.getIfCacheNotNull(column, column.getColumnHolder(null, "_cache", ",")));
			} else {
				// 其他情况值仍然存在原property中
				sql.append(SqlHelper.getIfNotNull(column, column.getColumnHolder(null, null, ","), isNotEmpty()));
			}
			// 当属性为null时，如果存在主键策略，会自动获取值，如果不存在，则使用null
			// 序列的情况
			if ( StringUtil.isNotEmpty(column.getSequenceName()) ) {
				sql.append(SqlHelper.getIfIsNull(column, getSeqNextVal(column) + " ,", isNotEmpty()));
			} else if ( column.isIdentity() ) {
				sql.append(SqlHelper.getIfCacheIsNull(column, column.getColumnHolder() + ","));
			} else if ( column.isUuid() ) {
				sql.append(SqlHelper.getIfIsNull(column, column.getColumnHolder(null, "_bind", ","), isNotEmpty()));
			}
		}
		sql.append("</trim>");
		return sql.toString();
	}


	/**
	* 通过主键更新全部字段
	*
	* @param ms
	*/
	public String batchUpdate( MappedStatement ms ) {
		Class<?> entityClass = getEntityClass(ms);
		StringBuilder sql = new StringBuilder();
		sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
		sql.append(SqlHelper.updateSetColumns(entityClass, null, false, false));
		sql.append(SqlHelper.wherePKColumns(entityClass));
		return sql.toString();
	}


	/**
	 * 通过主键更新不为null的字段
	 *
	 * @param ms
	 * @return
	 */
	public String batchUpdateSelective( MappedStatement ms ) {
		Class<?> entityClass = getEntityClass(ms);
		StringBuilder sql = new StringBuilder();
		sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
		sql.append(SqlHelper.updateSetColumns(entityClass, null, true, isNotEmpty()));
		sql.append(SqlHelper.wherePKColumns(entityClass));
		return sql.toString();
	}


	/**
	 * 通过条件删除
	 *
	 * @param ms
	 * @return
	 */
	public String batchDelete( MappedStatement ms ) {
		Class<?> entityClass = getEntityClass(ms);
		StringBuilder sql = new StringBuilder();
		sql.append(SqlHelper.deleteFromTable(entityClass, tableName(entityClass)));
		sql.append(SqlHelper.whereAllIfColumns(entityClass, isNotEmpty()));
		return sql.toString();
	}


}
