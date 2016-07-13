/**
 * JsonUtil.java cn.vko.core.common.util Copyright (c) 2014, .
 */

package site.lovecode.wechat.util;

import com.alibaba.fastjson.serializer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * json特殊操作
 * <p>
 *
 * @author 宋汝波
 * @date 2014年11月24日
 * @version 1.0.0
 */
public class JsonUtil {

	private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

	/**
	 * 对序列化的Long类型进行特殊处理,避免位数过大导致和js精度的丢失,只用于向页面发送json数据时使用
	 */
	static ObjectSerializer longSerializer = new ObjectSerializer() {

		@Override
		public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
			SerializeWriter out = serializer.getWriter();
			if ( object == null ) {
				if ( out.isEnabled(SerializerFeature.WriteNullNumberAsZero) ) {
					out.write('0');
				} else {
					out.writeNull();
				}
				return;
			}
			out.writeString(object.toString());
		}

	};


	/**
	 * 对Long型兼容js的json串
	 * <p>
	 *
	 * @param object
	 *            对象
	 * @return json字符串
	 */
	public static final String toCompatibleJSON( Object object, String format ) {
		SerializeWriter out = new SerializeWriter();
		try {
			// 此处必须new一个SerializeConfig,防止修改默认的配置
			JSONSerializer serializer = new JSONSerializer(out, new SerializeConfig());
			serializer.getMapping().put(Long.class, longSerializer);
			if ( format != null ) {
				serializer.getMapping().put(Date.class, new SimpleDateFormatSerializer(format));
			}
			serializer.write(object);
			return out.toString();
		} finally {
			out.close();
		}
	}


	public static final String toCompatibleJSON( Object object ) {
		return toCompatibleJSON(object, null);
	}


	public static void main( String[] args ) {
		logger.debug(toCompatibleJSON(new Date(), "yyyy-MM-dd"));
		logger.debug(toCompatibleJSON(new Date(), null));
	}
}
