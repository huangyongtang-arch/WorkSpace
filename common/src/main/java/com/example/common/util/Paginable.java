package com.example.common.util;

/**
 * 分页接口
 * 
 * @author liufang
 * 
 */
public interface Paginable {
	/**
	 * 总记录数
	 * 
	 * @return
	 */
	public long getTotalCount();

	/**
	 * 总页
	 * 
	 * @return
	 */
	public long getTotalPage();

	/**
	 * 每页记录
	 * 
	 * @return
	 */
	public long getPageSize();

	/**
	 * 当前页号
	 * 
	 * @return
	 */
	public long getPageNo();

	/**
	 * 是否第一
	 * 
	 * @return
	 */
	public boolean isFirstPage();

	/**
	 *
	 * 
	 * @return
	 */
	public boolean isLastPage();

	/**
	 * 返回下页的页
	 */
	public long getNextPage();

	/**
	 * 返回上页的页
	 */
	public long getPrePage();
}
