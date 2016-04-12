package site.lovecode.plugin.mybatis;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import site.lovecode.common.mybatis.Identity;
import site.lovecode.util.IdWorker;


/**
 * 
 * 主键自动赋值实现
 */
@Intercepts( { @Signature( type = Executor.class, method = "update", args = { MappedStatement.class, Object.class } ) } )
public class IdentityInterceptor implements Interceptor {

	@Override
	public Object intercept( Invocation invocation ) throws Throwable {
		MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
		if ( mappedStatement.getSqlCommandType() != SqlCommandType.INSERT ) { return invocation.proceed(); }
		Object[] objs = invocation.getArgs();


		if ( objs != null ) {
			for ( int i = 0 ; i < objs.length ; i++ ) {
				if ( objs[i] instanceof Identity) {
					Identity identity = (Identity) objs[i];
					if ( identity.getId() != null ) {
						continue;
					}
					identity.setId(IdWorker.getId());
				} else if ( objs[i] instanceof List || objs[i] instanceof DefaultSqlSession) {
					List<?> list = (List<?>) objs[i];
					for ( Object object : list ) {
						if ( object instanceof Identity ) {
							Identity identity = (Identity) object;
							if ( identity.getId() != null ) {
								continue;
							}
							identity.setId(IdWorker.getId());
						}
					}
				}
			}
		}
		return invocation.proceed();

	}


	@Override
	public Object plugin( Object target ) {
		return Plugin.wrap(target, this);
	}


	@Override
	public void setProperties( Properties properties ) {

	}




}
