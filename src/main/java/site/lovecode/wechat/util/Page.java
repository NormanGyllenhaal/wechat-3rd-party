package site.lovecode.wechat.util;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.min;

/**
 * Page is not a domain object but is used to store and fetch page information.
 *
 * @author king.zhu
 */
@SuppressWarnings( { "serial" } )
public class Page<T> implements Serializable {

	private static final int DEF_PAGE_VIEW_SIZE = 10;

	/** 当前页 */
	private int page;

	/** 当前页显示记录条数 */
	private int pageSize;

	/** 取得查询总记录数 */
	private int count;

	/**
	 * 动作类型 <li>0：无动作</li> <li>1：首页</li> <li>2：前一页</li> <li>3：后一页</li> <li>4：末页</li>
	 * <li>5：跳转页</li> <li>6：重新设定每页记录数</li>
	 */
	private int actionType;

	List<T> records = Collections.emptyList();

	/** ajax 分页时用到的相对地址的Url */
	private String url;


	/**
	 * (空)
	 */
	public Page(Page<?> page ) {
		this.page = page.getPage();
		this.pageSize = page.getPageSize();
		this.count = page.getCount();
		this.actionType = page.getActionType();
	}


	/**
	 * 根据当前显示页与每页显示记录数设置查询信息初始对象
	 * 
	 * @param page
	 *            当前显示页号
	 */
	public Page(int page ) {
		this(page, DEF_PAGE_VIEW_SIZE);
	}


	public Page(Integer page, Integer pageSize ) {
		this.page = (null == page || page <= 0) ? 1 : page;
		this.pageSize = (null == pageSize || pageSize <= 0) ? DEF_PAGE_VIEW_SIZE : pageSize;
	}


	/**
	 * 取得动作类型
	 * 
	 * @return 动作类型
	 */
	public int getActionType() {
		return actionType;
	}


	/**
	 * 设置动作类型
	 * 
	 * @param actionType
	 *            动作类型
	 */

	public void setActionType( int actionType ) {
		this.actionType = actionType;
	}


	/**
	 * 取得当前显示页号
	 * 
	 * @return 当前显示页号
	 */
	public int getPage() {
		return page <= 0 ? 1 : page;
	}


	public int getPageNo() {
		return page <= 0 ? 1 : page;
	}


	public boolean getHasPrevious() {
		return page > 1;
	}


	public boolean getHasNext() {
		return page < getPages();
	}


	/**
	 * 设置当前页
	 * 
	 * @param page
	 *            当前页
	 */
	public void setPage( int page ) {
		this.page = page;
	}


	public void setPageNo( int page ) {
		this.page = page;
	}


	/**
	 * 取得当前显示页号最多显示条数
	 * 
	 * @return 当前显示页号最多显示条数
	 */
	public int getPageSize() {
		return pageSize <= 0 ? DEF_PAGE_VIEW_SIZE : pageSize;
	}


	/**
	 * 设置当前页显示记录条数
	 * 
	 * @param pageSize
	 *            当前页显示记录条数
	 */
	public void setPageSize( int pageSize ) {
		this.pageSize = pageSize;
	}


	/**
	 * 取得查询取得记录总数
	 * 
	 * @return 取得查询取得记录总数
	 */
	public int getCount() {
		return count;
	}


	/**
	 * 设置查询取得记录总数
	 * 
	 * @param count
	 *            查询取得记录总数
	 */
	public void setCount( int count ) {
		this.count = count < 0 ? 0 : count;
		if ( this.count == 0 ) {
			page = 0;
			return;
		}
		switch ( actionType ) {
			case 1 : // 第一页
				page = 1;
				break;
			case 2 : // 前一页
				page = min(getPages(), page - 1);
				break;
			case 3 : // 后一页
				page = min(getPages(), page + 1);
				break;
			case 4 : // 最末页
				page = getPages();
				break;
			case 5 : // 指定页
			case 6 : // 重新设定每页显示条数时
			case 0 : // 无设定时
			default:
				page = min(getPages(), getPage());
		}

	}


	/**
	 * 取得当前查询总页数
	 * 
	 * @return 当前查询总页数
	 */
	public int getPages() {
		return (count + getPageSize() - 1) / getPageSize();
	}


	/**
	 * 取得起始显示记录号
	 * 
	 * @return 起始显示记录号
	 */
	public int getStartNo() {
		return (getPage() - 1) * getPageSize() + 1;
	}


	/**
	 * 取得结束显示记录号
	 * 
	 * @return 结束显示记录号
	 */
	public int getEndNo() {
		return Math.min(getPage() * getPageSize(), count);
	}


	/**
	 * 取得前一显示页码
	 * 
	 * @return 前一显示页码
	 */
	public int getPrePageNo() {
		return Math.max(getPage() - 1, 1);
	}


	/**
	 * 取得后一显示页码
	 * 
	 * @return 后一显示页码
	 */
	public int getNextPageNo() {
		return Math.min(getPage() + 1, getPages());
	}


	public List<T> getRecords() {
		return records;
	}


	public void setRecords( List<T> records ) {
		this.records = records;
	}


	// dwz 分页参数
	public void setPageNumber( int pageNumber ) {
		setPage(pageNumber);
	}


	public String getUrl() {
		return url;
	}


	public void setUrl( String url ) {
		this.url = url;
	}


}
