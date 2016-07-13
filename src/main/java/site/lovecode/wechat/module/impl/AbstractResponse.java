/**
 * AbstractResponse.java site.lovecode.wechatcore.common.service Copyright (c) 2014,
 * .
 */

package site.lovecode.wechat.module.impl;

import org.springframework.util.ReflectionUtils;
import site.lovecode.wechat.support.common.CodeConstants;
import site.lovecode.wechat.support.common.Response;
import site.lovecode.wechat.support.common.ResponseHead;

import java.lang.reflect.Field;
import java.util.*;



/**
 * 所有Module、Endpoint、Service层的父类需要继承的类
 * <p>
 * 封装了Module层和Endpoint层以及Service层需要公用到的方法等
 * 
 * @author malei
 * @date 2014-11-20
 * @version 1.0.0
 */
public abstract class AbstractResponse {


	/**
	 * 正常返回情况下的头部封装
	 */
	public ResponseHead successHead() {
		return new ResponseHead(CodeConstants.SUCCESS, "正常返回");
	}


	/**
	 * 正常情况下不校验参数的一站式返回结果
	 * 
	 * @param body
	 *            应答体
	 * @return 返回数据结构
	 */
	public <T> Response<T> success(T body ) {
		return new Response<T>(successHead(), body);
	}


	/**
	 * 程序发生异常时可调用此方法返回数据体
	 * 
	 * @param <T>
	 * 
	 * @param code
	 *            错误代码
	 * @param desc
	 *            错误描述
	 * @return 返回错误时数据体
	 */
	public <T> Response<T> fail( final String code, final String desc ) {
		return new Response<T>(new ResponseHead(code, desc), null);
	}


	/**
	 * 针对返回boolean类型时true的情况
	 * 
	 * @return 返回true类型的数据对象
	 */
	public Response<Boolean> successOfBoolean() {
		return new Response<Boolean>(successHead(), true);
	}


	/**
	 * 针对返回boolean类型时false的情况
	 * 
	 * @return 返回false类型的数据对象
	 */
	public Response<Boolean> failOfBoolean() {
		return new Response<Boolean>(successHead(), false);
	}


	/**
	 * 针对修改或删除时需要返回执行成功结果时
	 * 
	 * @param col
	 *            执行操作影响的行数
	 * @return 根据col判断执行操作结果
	 */
	public Response<Boolean> result( final int col ) {
		return (col > 0) ? successOfBoolean() : failOfBoolean();
	}


	/**
	 * 以list中对象的某个属性做键值,转换成map
	 * <p>
	 *
	 * @param list
	 *            要转换的list
	 * 
	 * @param property
	 *            list中对象的属性,作为键值
	 * 
	 * @return 转换后的map
	 */
	public static <V> Map<Long, V> list2Map( List<V> list, String property ) {
		if ( list == null ) { return Collections.emptyMap(); }
		Map<Long, V> map = new LinkedHashMap<Long, V>(list.size());
		for ( V v : list ) {
			Field field = ReflectionUtils.findField(v.getClass(), property);
			ReflectionUtils.makeAccessible(field);
			Object fieldValue = ReflectionUtils.getField(field, v);
			map.put((Long) fieldValue, v);
		}
		return map;
	}


	/**
	 * 以list中对象某个属性作为key，将其转为Map<K,V>
	 * 
	 * @param list
	 *            待转换对象
	 * 
	 * @param property
	 *            作为key的属性
	 * 
	 * @return 返回转化后的Map对象
	 */
	@SuppressWarnings( "unchecked" )
	public static <K, V> Map<K, V> list2MapByKey( List<V> list, String property ) {
		if ( list == null ) { return Collections.emptyMap(); }
		Map<K, V> map = new LinkedHashMap<K, V>(list.size());
		for ( V v : list ) {
			Field field = ReflectionUtils.findField(v.getClass(), property);
			ReflectionUtils.makeAccessible(field);
			Object fieldValue = ReflectionUtils.getField(field, v);
			map.put((K) fieldValue, v);
		}
		return map;
	}


	/**
	 * 将对象集中的某个属性转换从对相集中取出放入Set中
	 * 
	 * @param list
	 *            待转换对象
	 * 
	 * @param property
	 *            指定属性
	 * 
	 * @return 返回转换结果集
	 */
	@SuppressWarnings( "unchecked" )
	public static <T> Set<T> list2Set( List<?> list, String property ) {
		if ( list == null ) { return Collections.emptySet(); }
		Set<T> set = new HashSet<T>(list.size());
		for ( Object v : list ) {
			Field field = ReflectionUtils.findField(v.getClass(), property);
			ReflectionUtils.makeAccessible(field);
			Object fieldValue = ReflectionUtils.getField(field, v);
			set.add((T) fieldValue);
		}
		return set;
	}


	public static <V> Map<Long, List<V>> list2MapList( List<V> list, String property ) {
		if ( list == null ) { return Collections.emptyMap(); }
		Map<Long, List<V>> map = new LinkedHashMap<Long, List<V>>(list.size());
		for ( V v : list ) {
			Field field = ReflectionUtils.findField(v.getClass(), property);
			ReflectionUtils.makeAccessible(field);
			Object fieldValue = ReflectionUtils.getField(field, v);
			List<V> lst = map.get(fieldValue);
			if ( lst == null ) {
				lst = new ArrayList<V>();
				map.put((Long) fieldValue, lst);
			}
			lst.add(v);
		}
		return map;
	}


	@SuppressWarnings( "unchecked" )
	public static <V> List<V> listProperty( List<?> list, String property ) {
		if ( list == null ) { return Collections.emptyList(); }
		List<V> result = new ArrayList<V>();
		for ( Object v : list ) {
			Field field = ReflectionUtils.findField(v.getClass(), property);
			ReflectionUtils.makeAccessible(field);
			Object fieldValue = ReflectionUtils.getField(field, v);
			result.add((V) fieldValue);
		}
		return result;
	}


	public static String join( Collection<String> collection, String dot ) {
		StringBuilder str = new StringBuilder();
		Iterator<String> iterator = collection.iterator();
		boolean addDot = false;
		while ( iterator.hasNext() ) {
			if ( addDot ) {
				str.append(dot);
			}
			String value = iterator.next();
			if ( value != null ) {
				str.append(value);
				addDot = true;
			}
		}
		return str.toString();
	}


}
