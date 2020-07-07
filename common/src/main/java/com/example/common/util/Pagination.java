package com.example.common.util;

import java.util.List;

/**
 * 列表分页
 * 
 * @author liufang
 * 
 */
@SuppressWarnings("serial")
public class Pagination extends SimplePage implements java.io.Serializable,
		Paginable {

	public Pagination() {
	}

	/**
	 * 
	 * @param pageNo
	 *            当前是第几页
	 * @param pageSize
	 *            每页几条数据
	 * @param totalCount
	 *            总共几条数据
	 */
	public Pagination(int pageNo, int pageSize, int totalCount) {
		super(pageNo, pageSize, totalCount);
	}

	/**
	 * 
	 * @param pageNo
	 *            当前是第几页
	 * @param pageSize
	 *            每页几条数据
	 * @param totalCount
	 *            总共几条数据
	 * @param list
	 *            分页内容
	 */
	public Pagination(int pageNo, int pageSize, long totalCount, List<?> list) {
		super(pageNo, pageSize, totalCount);
		this.list = list;
	}

	/**
	 * 
	 * @return
	 */
	public long getFirstResult() {
		return (pageNo - 1) * pageSize;
	}

	/**
	 * 当前页的数据
	 */
	private List<?> list;

	/**
	 * 获得分页内容
	 * 
	 * @return
	 */
	public List<?> getList() {
		return list;
	}

	/**
	 * 设置分页内容
	 * 
	 * @param list
	 */
	@SuppressWarnings("rawtypes")
	public void setList(List list) {
		this.list = list;
	}
}
