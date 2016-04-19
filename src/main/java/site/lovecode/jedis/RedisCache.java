/**
 * RedisCache.java cn.vko.core.web.cache Copyright (c) 2014, 北京微课创景教育科技有限公司版权所有.
 */

package site.lovecode.jedis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.BinaryJedisCommands;
import site.lovecode.util.SerializeUtil;

import java.io.Serializable;


/**
 * redis 缓存工具类
 * <p>
 *
 * @author hubin
 * @date 2014-11-18
 * @version 1.0.0
 */
public class RedisCache {

	private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);

	private BinaryJedisCommands redis;



	/**
	 * redis里面添加key-value格式的数据
	 * <p>
	 * 
	 * @param key
	 *            缓存关键字

	 */
	public boolean set( final String key, final Serializable value ) {
		return set(key, 0, value);
	}






	/**
	 * redis里面添加key-value格式的数据
	 * <p>
	 * 
	 * @param key
	 *            缓存关键字
	 * @param seconds
	 *            有效时长(秒)
	 * @param value
	 *            缓存值
	 */
	public boolean set( final String key, final int seconds, final Serializable value ) {
		boolean rlt = false;
		try {
			byte[] key_ = key.getBytes();
			byte[] value_ = SerializeUtil.serialize(value);
			String result = "NO";
			if ( seconds >= 1 ) {
				result = redis.setex(key_, seconds, value_);
			} else {
				result = redis.set(key_, value_);
			}
			if ( "OK".equals(result) ) {
				rlt = true;
			}
		} catch ( Exception e ) {
			logger.error(e.getMessage(), e);
		}
		return rlt;
	}


	/**
	 * 根据key从redis取出value
	 * <p>
	 *
	 *
	 * @param key
	 *            缓存关键字
	 * @return Serializable
	 */
	public Object get( final String key ) {
		Object t = null;
		try {
			byte[] keyBytes = key.getBytes();
			byte[] bytes = redis.get(keyBytes);
			t = SerializeUtil.unserialize(bytes);
		} catch ( Exception e ) {
			logger.error(e.getMessage(), e);
		}
		return t;
	}


	/**
	 * 根据key从redis删除指定内容
	 * <p>
	 *
	 * @param key
	 *            缓存关键字
	 * @return boolean
	 */
	public boolean del( final String key ) {
		boolean rlt = false;
		try {
			byte[] keyBytes = key.getBytes();
			Long result = redis.del(keyBytes);
			if ( result > 0 ) {
				rlt = true;
			}
		} catch ( Exception e ) {
			logger.error(e.getMessage(), e);
		}
		return rlt;
	}


	public boolean expire( final String key, int seconds ) {
		boolean rlt = false;
		try {
			byte[] keyBytes = key.getBytes();
			Long result = redis.expire(keyBytes, seconds);
			if ( result > 0 ) {
				rlt = true;
			}
		} catch ( Exception e ) {
			logger.error(e.getMessage(), e);
		}
		return rlt;
	}


	public BinaryJedisCommands getRedis() {
		return redis;
	}


	public void setRedis( BinaryJedisCommands redis ) {
		this.redis = redis;
	}


}
