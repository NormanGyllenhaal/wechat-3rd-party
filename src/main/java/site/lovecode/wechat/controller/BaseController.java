package site.lovecode.wechat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import site.lovecode.wechat.support.AjaxResult;
import site.lovecode.wechat.support.common.CodeConstants;
import site.lovecode.wechat.support.common.WebException;
import site.lovecode.wechat.util.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * 所有控制器的父类
 * <p>
 * 
 * @author 马磊
 * @Date 2015-11-26
 */
@SuppressWarnings( "rawtypes" )
public abstract class BaseController implements HandlerInterceptor {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());






	// 此方法在进入Controller之前执行,必须返回true后才能继续执行后面的逻辑
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler )
		throws Exception {
		return true;
	}


	// 此方法在Controller执行之后页面渲染之前执行
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView )
		throws Exception {


	}


	// 此方法在页面渲染之后执行，通常用作清空资源用
	@Override
	public void
			afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex )
				throws Exception {

	}


	/**
	 * 获取分页对象
	 * <p>
	 *
	 */
	protected <T> Page<T> getPage() {
		return getPage(20);
	}


	/**
	 * 获取分页对象
	 * <p>
	 * 
	 * @param size
	 *            分页数量
	 */
	@SuppressWarnings( "unchecked" )
	protected <T> Page<T> getPage( int size ) {
		/*int pageSize = HttpUtil.getInt(inv.getRequest(), "_size", size);
		int pageIndex = HttpUtil.getInt(inv.getRequest(), "_index", 1);*//**//*
		Page page = new Page(pageIndex, pageSize);
		return page;*/
		return null;
	}


	/**
	 * 
	 * 获取公众号id
	 * <p>
	 * 
	 *
	 * @return 
	 */
	protected Long getOaid() {
		/*return HttpUtil.getLong(inv.getRequest(), "oaid");*/
		return null;
	}


	/**
	 * 
	 * 测试方法 获取orgId
	 * <p>
	 * 
	 *
	 * @return TODO(这里描述每个参数,如果有返回值描述返回值,如果有异常描述异常)
	 */
	protected Long getOrgId() {
		/*return HttpUtil.getLong(inv.getRequest(), "orgId");*/
		return null;
	}





	/**
	 * 判断是否为合法的视图地址
	 * <p>
	 * 
	 * @param modelAndView
	 *            spring 视图对象
	 * @return boolean
	 */
	protected boolean isLegalView( ModelAndView modelAndView ) {
		boolean legal = false;
		if ( modelAndView != null ) {
			String viewUrl = modelAndView.getViewName();
			if ( viewUrl != null && viewUrl.contains("redirect:") ) {
				legal = false;
			} else {
				legal = true;
			}
		}
		return legal;
	}


	/**
	 * 自动判断是否跨域
	 * 
	 * @param ajax
	 *            ajax返回结果
	 * @param format
	 *            日期格式
	 * 
	 * @return 返回JSON字符串
	 */
	/*protected String callback( AjaxResult ajax, String format ) {
		String callback = inv.getRequest().getParameter("callback");
		// 如果不是跨域请求
		if ( callback == null ) { return JsonUtil.toCompatibleJSON(ajax, format); }
		// 是跨域请求
		StringBuffer json = new StringBuffer();
		json.append(callback).append("(");
		json.append(JsonUtil.toCompatibleJSON(ajax, format)).append(")");

		return json.toString();
	}
*/

	/**
	 * 自动判断是否跨域
	 * 
	 * @param obj
	 *            obj返回结果
	 * @param format
	 *            日期格式
	 * 
	 * @return 返回JSON字符串
	 */
	protected String callback( Object obj, String format ) {
		/*String callback = inv.getRequest().getParameter("callback");
		// 如果不是跨域请求
		if ( callback == null ) { return JsonUtil.toCompatibleJSON(obj, format); }
		// 是跨域请求
		StringBuffer json = new StringBuffer();
		json.append(callback).append("(");
		json.append(JsonUtil.toCompatibleJSON(obj, format)).append(")");

		return json.toString();*/
		return null;
	}


	/**
	 * 自动判定是否有跨域操作,转成字符串并返回
	 * <p>
	 *
	 * @param object
	 * @return 跨域或不跨域的字符串
	 */
	protected String callback( AjaxResult object ) {
		return callback(object, null);
	}


	protected String callback( Boolean result, String message ) {
		if ( result ) {
			return callbackSuccess(null);
		} else {
			return callbackFail(message);
		}
	}


	protected String callbackSuccess( Object obj ) {
		return callback(new AjaxResult(obj));
	}


	protected String callbackFail( String message ) {
		return callback(new AjaxResult(false, message));
	}


	protected WebException failException(String desc ) {
		return new WebException(CodeConstants.EXCEPTION, desc);
	}


	/*protected String redirectTo( String url ) {
		StringBuffer rto = new StringBuffer("redirect:");
		rto.append(inv.getRequest().getContextPath());
		rto.append(url);
		return rto.toString();
	}*/





	/**
	 * 得到当前登陆用户的ID
	 * <p>
	 *
	 * @return 当前登陆用户的ID
	 */
	protected Long getCurrentUserId() {
		return 1L;
		// SSOToken st = getSSOToken();
		// if ( st == null ) { return null; }
		// return st.getUserId();
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
}
