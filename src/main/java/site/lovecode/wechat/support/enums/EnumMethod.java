/**
 * EnumMethod.java site.lovecode.wechat.common.enums Copyright (c) 2016,
 * 北京微课九天教育科技有限公司版权所有.
 */

package site.lovecode.wechat.support.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.*;


/**
 * 封装枚举中用到的系列方法
 * <p>
 *
 * @author   7
 * @date	 2016年4月25日 
 * @version  1.0.0	 
 */
public abstract class EnumMethod {

	private static final Logger logger = LoggerFactory.getLogger(EnumMethod.class);

	public enum FieldType {
		key, desc;
	}


	// 以Map形式返回数据
	public static Map<Integer, String> getKeyAndDesc( Class<? extends IEnum> clazz ) {
		Map<Integer, String> result = new HashMap<Integer, String>();
		try {
			for ( Object enu : Arrays.asList(clazz.getEnumConstants()) ) {
				Integer key = null;
				String value = null;
				for ( Method method : clazz.getDeclaredMethods() ) {
					if ( method.getName().equals(FieldType.key.name()) ) {
						key = (Integer) method.invoke(enu);
					}
					if ( method.getName().equals(FieldType.desc.name()) ) {
						value = (String) method.invoke(enu);
					}
				}
				result.put(key, value);
			}
		} catch ( Exception e ) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}


	// 对枚举封装下拉列表,为添加修改页面做下拉列表用
	public static List<Map<String, String>> getList( Class<? extends IEnum> clazz ) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			for ( Object obj : Arrays.asList(clazz.getEnumConstants()) ) {
				Map<String, String> map = new HashMap<String, String>();
				for ( Method method : clazz.getDeclaredMethods() ) {
					if ( method.getName().equals("key") ) {
						map.put("key", method.invoke(obj) + "");
					}
					if ( method.getName().equals("desc") ) {
						map.put("desc", method.invoke(obj) + "");
					}
				}

				list.add(map);
			}
		} catch ( Exception e ) {
			logger.error(e.getMessage(), e);
		}
		return list;
	}
}
