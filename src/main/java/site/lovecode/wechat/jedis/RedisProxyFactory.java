package site.lovecode.wechat.jedis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

import org.springframework.beans.factory.FactoryBean;

import redis.clients.util.Pool;

/**
 * 代理类,获取操作对象
 * <p>
 * 
 * @author norman
 * @Date 2014-5-21
 */
public class RedisProxyFactory implements InvocationHandler, FactoryBean<RedisCommands> {

	private final Pool<Object> pool;

	private final RedisCommands proxy;


	public RedisProxyFactory( Pool<Object> pool ) {
		this.pool = pool;
		proxy = (RedisCommands) Proxy.newProxyInstance(
			Thread.currentThread().getContextClassLoader(), new Class[ ] { RedisCommands.class }, this);
	}


	@Override
	public Object invoke( @SuppressWarnings( "hiding" ) Object proxy, Method method, Object[] args ) throws Throwable {
		Object jedis = pool.getResource();
		try {
			return method.invoke(jedis, args);
		} catch ( UndeclaredThrowableException e ) {
			throw e.getUndeclaredThrowable();
		} finally {
			pool.returnResource(jedis);
		}
	}


	@Override
	public RedisCommands getObject() throws Exception {
		return proxy;
	}


	@Override
	public Class<?> getObjectType() {
		return RedisCommands.class;
	}


	@Override
	public boolean isSingleton() {
		return true;
	}
}
