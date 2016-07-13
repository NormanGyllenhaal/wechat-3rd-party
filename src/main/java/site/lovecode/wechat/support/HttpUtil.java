package site.lovecode.wechat.support;

import site.lovecode.wechat.util.DateUtil;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

public final class HttpUtil {

	public static String getURL( HttpServletRequest request ) {
		StringBuffer sb = request.getRequestURL();
		String queryString = request.getQueryString();
		if ( queryString != null ) { return sb.toString() + "?" + queryString; }
		return sb.toString();
	}


	/**
	 * Get Integer parameter from request. If specified parameter name is not
	 * found, the default value will be returned.
	 */
	public static int getInt(HttpServletRequest request, String paramName, int defaultValue ) {
		String s = request.getParameter(paramName);
		if ( s == null || s.equals("") ) { return defaultValue; }
		return Integer.parseInt(s);
	}


	/**
	 * Get Integer parameter from request. If specified parameter name is not
	 * found, an Exception will be thrown.
	 */
	public static int getInt(HttpServletRequest request, String paramName ) {
		String s = request.getParameter(paramName);
		return Integer.parseInt(s);
	}


	public static long getLong(HttpServletRequest request, String paramName, long defaultValue ) {
		String s = request.getParameter(paramName);
		if ( s == null || s.equals("") ) { return defaultValue; }
		return Long.parseLong(s);
	}


	public static long getLong(HttpServletRequest request, String paramName ) {
		String s = request.getParameter(paramName);
		return Long.parseLong(s);
	}


	/**
	 * Get String parameter from request. If specified parameter name is not
	 * found, the default value will be returned.
	 */
	public static String getString(HttpServletRequest request, String paramName, String defaultValue ) {
		String s = request.getParameter(paramName);
		if ( s == null || s.equals("") ) { return defaultValue; }
		return s;
	}


	/**
	 * Get String parameter from request. If specified parameter name is not
	 * found or empty, an Exception will be thrown.
	 */
	public static String getString(HttpServletRequest request, String paramName ) {
		String s = request.getParameter(paramName);
		if ( s == null || s.equals("") ) { throw new NullPointerException("Null parameter: " + paramName); }
		return s;
	}


	/**
	 * Get Boolean parameter from request. If specified parameter name is not
	 * found, an Exception will be thrown.
	 */
	public static boolean getBoolean(HttpServletRequest request, String paramName ) {
		String s = request.getParameter(paramName);
		return Boolean.parseBoolean(s);
	}


	/**
	 * Get Boolean parameter from request. If specified parameter name is not
	 * found, the default value will be returned.
	 */
	public static boolean getBoolean(HttpServletRequest request, String paramName, boolean defaultValue ) {
		String s = request.getParameter(paramName);
		if ( s == null || s.equals("") ) { return defaultValue; }
		return Boolean.parseBoolean(s);
	}


	/**
	 * Get float parameter from request. If specified parameter name is not
	 * found, an Exception will be thrown.
	 */
	public static float getFloat(HttpServletRequest request, String paramName ) {
		String s = request.getParameter(paramName);
		return Float.parseFloat(s);
	}


	/**
	 * Create a FormBean and bind data to it. Example: If found a parameter
	 * named "age", the object's setAge() method will be invoked if this method
	 * exists. If a setXxx() method exists but no corrsponding parameter, this
	 * setXxx() method will never be invoked.<br/>
	 * <b>NOTE:</b> only public setXxx() method can be invoked successfully.
	 */
	public static Object createFormBean(HttpServletRequest request, Class<?> c ) {
		Object bean;
		try {
			bean = c.newInstance();
		} catch ( Exception e ) {
			return new Object();
		}
		Method[] ms = c.getMethods();
		for ( int i = 0 ; i < ms.length ; i++ ) {
			String name = ms[i].getName();
			if ( name.startsWith("set") ) {
				Class<?>[] cc = ms[i].getParameterTypes();
				if ( cc.length == 1 ) {
					String type = cc[0].getName(); // parameter type
					try {
						// get property name:
						String prop = Character.toLowerCase(name.charAt(3)) + name.substring(4);
						// get parameter value:
						String param = getString(request, prop);
						if ( param != null && !param.equals("") ) {
							if ( type.equals("java.lang.String") ) {
								ms[i].invoke(bean, new Object[ ] { htmlEncode(param) });
							} else if ( type.equals("int") || type.equals("java.lang.Integer") ) {
								ms[i].invoke(bean, new Object[ ] { new Integer(param) });
							} else if ( type.equals("long") || type.equals("java.lang.Long") ) {
								ms[i].invoke(bean, new Object[ ] { new Long(param) });
							} else if ( type.equals("boolean") || type.equals("java.lang.Boolean") ) {
								ms[i].invoke(bean, new Object[ ] { Boolean.valueOf(param) });
							} else if ( type.equals("float") || type.equals("java.lang.Float") ) {
								ms[i].invoke(bean, new Object[ ] { new Float(param) });
							} else if ( type.equals("java.util.Date") ) {
								Date date = null;
								if ( param.indexOf(':') != (-1) ) {
									date = DateUtil.parseDateTime(param);
								} else {
									date = DateUtil.parseDate(param);
								}
								if ( date != null ) {
									ms[i].invoke(bean, new Object[ ] { date });
								} else {
									System.err.println("WARNING: date is null: " + param);
								}
							}
						}
					} catch ( Exception e ) {
						System.err.println("WARNING: Invoke method " + ms[i].getName() + " failed: " + e.getMessage());
					}
				}
			}
		}
		return bean;
	}


	public static String htmlEncode( String text ) {
		if ( text == null || "".equals(text) ) { return ""; }
		text = text.replace("<", "&lt;");
		text = text.replace(">", "&gt;");
		text = text.replace(" ", "&nbsp;");
		text = text.replace("\"", "&quot;");
		text = text.replace("\'", "&apos;");
		return text.replace("\n", "<br/>");
	}


	public static String htmlEncodeNotBlank( String text ) {
		if ( text == null || "".equals(text) ) { return ""; }
		text = text.replace("<", "&lt;");
		text = text.replace(">", "&gt;");
		text = text.replace("\"", "&quot;");
		text = text.replace("\'", "&apos;");
		return text.replace("\n", "<br/>");
	}


	public static String encode( String text ) {
		if ( text == null || "".equals(text) ) { return ""; }
		text = text.replace("<", "&lt;");
		text = text.replace(">", "&gt;");
		text = text.replace("\"", "&quot;");
		text = text.replace("\'", "&apos;");
		text = text.replace("&", "&amp;");
		return text.replace("\n", "<br/>");
	}


	public static String encodeHtml( String text ) {
		if ( text == null || "".equals(text) ) { return ""; }
		text = text.replace("&lt;", "<");
		text = text.replace("&gt;", ">");
		text = text.replace("&nbsp;", " ");
		text = text.replace("&quot;", "\"");
		text = text.replace("&apos;", "\'");
		return text.replace("<br/>", "\n");
	}


	public static String encodeHtml2( String text ) {
		if ( text == null || "".equals(text) ) { return ""; }
		text = text.replace("&lt;", "<");
		text = text.replace("&gt;", ">");
		text = text.replace("&nbsp;", " ");
		text = text.replace("&quot;", "");
		text = text.replace("&apos;", "");
		return text.replace("<br/>", "\n");
	}


	/**
	 * 获取客户端IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr( HttpServletRequest request ) {
		String ip = request.getHeader("x-forwarded-for");
		if ( (ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip)) ) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if ( (ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip)) ) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if ( (ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip)) ) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

}
