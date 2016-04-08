/**
 * Identity.java net.yunxiaoyuan Copyright (c) 2014, 北京微课创景教育科技有限公司版权所有.
 */

package site.lovecode.common.mybatis;


/**
 * 实体实现此接口表示有主键id,且如果插入时为null, 则自动通过idworker获取id并赋值
 * <p>
 * 
 * @author 宋汝波
 * @date 2014年11月13日
 * @version 1.0.0
 */
public interface Identity {

	public void setId(Long id);


	public Long getId();
}
