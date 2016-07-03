/**
 * FuncInfoDto.java site.lovecode.wechat.dto Copyright (c)
 * 2016,norman.
 */


package site.lovecode.wechat.dto;


import site.lovecode.wechat.entity.FuncInfo;

/**
 * 微信授权方公众号权限
 * <p>
 * 
 *
 * @author   yangpeng
 * @date	 2016年5月7日 
 * @version  1.0.0	 
 */
public class FuncInfoDto extends FuncInfo {

	/**
	 * TODO（用一句话描述这个变量的含义）
	 */

	private static final long serialVersionUID = 1L;


	private String funcDesc;


	private Integer status;


	public String getFuncDesc() {
		return funcDesc;
	}


	public void setFuncDesc( String funcDesc ) {
		this.funcDesc = funcDesc;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus( Integer status ) {
		this.status = status;
	}


}
