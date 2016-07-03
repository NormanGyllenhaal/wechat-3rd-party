/**
 * JedisCommands.java com.jiajiao.core.cache.jedis Copyright (c) 2014,
 *norman.
 */

package site.lovecode.wechat.jedis;

import redis.clients.jedis.BinaryJedisCommands;
import redis.clients.jedis.JedisCommands;

/**
 * redis访问接口
 * <p>
 * 
 * @author norman
 * @Date 2014-7-18
 */
public interface RedisCommands extends JedisCommands, BinaryJedisCommands {

}
