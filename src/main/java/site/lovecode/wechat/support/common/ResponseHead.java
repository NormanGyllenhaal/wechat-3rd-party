/**
 * ResponseHead.java cn.vko.core.common.response Copyright (c) 2014,
 * .
 */

package site.lovecode.wechat.support.common;

import java.io.Serializable;


/**
 * 所有应答的应答头部信息
 * <p>
 *
 * @author malei
 * @date 2014-11-18
 * @version 1.0.0
 */
public class ResponseHead implements Serializable {

	private static final long serialVersionUID = 1L;

	// 应答码
	private String statusCode;

	// 文字描述
	private String desc;


	// 默认构造器
	public ResponseHead() {
	}


	// 用于构造数据结构的构造器
	public ResponseHead(String statusCode, String desc ) {
		this.statusCode = statusCode;
		this.desc = desc;
	}


	public String getStatusCode() {
		return statusCode;
	}


	public void setStatusCode( String statusCode ) {
		this.statusCode = statusCode;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc( String desc ) {
		this.desc = desc;
	}

}
