/*
 * Copyright 2007-2009 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package site.lovecode.wechat.support;

import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface Invocation {

	/**
	 * 获取在URI、flash信息、请求查询串(即问号后的xx=yyy)中所带的参数值
	 * <p>
	 * URI中的参数需要通过在控制器方法中通过类似@ReqMapping(path="user_${name}")进行声明， 才可以获取name的参数
	 * <br>
	 * 
	 * @param name
	 * @return
	 */
	public String getParameter(String name);


	/**
	 * 设置一个和本次调用关联的属性。这个属性可以在多个拦截器中共享。
	 * 
	 * @param name
	 * @param value
	 * @return
	 */
	public Invocation setAttribute(String name, Object value);


	/**
	 * 获取前面拦截器或代码设置的，和本次调用相关的属性
	 * 
	 * @param name
	 * @return
	 */
	public Object getAttribute(String name);


	/**
	 * 
	 * @param name
	 */
	public void removeAttribute(String name);


	/**
	 * 返回本次调用的 {@link HttpServletRequest}对象
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest();


	/**
	 * session信息
	 */
	public HttpSession getSession();


	/**
	 * 返回本次调用的 {@link HttpServletResponse}对象
	 * 
	 * @return
	 */
	public HttpServletResponse getResponse();


	/**
	 * 
	 * @return
	 */
	public WebApplicationContext getApplicationContext();


	/**
	 * 
	 * @return
	 */
	public ServletContext getServletContext();

}
