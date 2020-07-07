package com.example.common.util;

/**
 * 
 * 
 * @author liufang
 * 
 */
public class SimplePage implements Paginable {
	public static final int DEF_COUNT = 20;

	/**
	 * 当前是第几页
	 * @param pageNo
	 * @return if pageNo==null or pageNo<1 then return 1 else return pageNo
	 */
	public static int cpn(Integer pageNo) {
		return (pageNo == null || pageNo < 1) ? 1 : pageNo;
	}

	public SimplePage() {

	}

	/**
	 * 
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页几条数据
	 * @param totalCount
	 *            总共几条数据
	 */
	public SimplePage(int pageNo, int pageSize, long totalCount) {
		setTotalCount(totalCount);
		setPageSize(pageSize);
		setPageNo(pageNo);
		adjustPageNo();
		setTotalPage();
	}

	/**
	 * 调整页码，使不超过最大页
	 */
	public void adjustPageNo() {
		if (pageNo == 1) {
			return;
		}
		long tp = getTotalPage();
		if (pageNo > tp) {
			pageNo = tp;
		}
	}

	/**
	 * 获得页码
	 */
	@Override
	public long getPageNo() {
		return pageNo;
	}

	/**
	 * 每页几条数据
	 */
	@Override
	public long getPageSize() {
		return pageSize;
	}

	/**
	 * 总共几条数据
	 */
	@Override
	public long getTotalCount() {
		return totalCount;
	}

	/**
	 * 总共几页
	 */
	@Override
	public long getTotalPage() {
		long totalPage = 0;
		if(totalCount != 0){
			totalPage = totalCount / pageSize;
			if (totalPage == 0 ||totalCount % pageSize != 0) {
				totalPage++;
			}
		}
		return totalPage;
	}

	/**
	 * 是否第一
	 */
	@Override
	public boolean isFirstPage() {
		return pageNo <= 1;
	}

	/**
	 * 是否
	 */
	@Override
	public boolean isLastPage() {
		return pageNo >= getTotalPage();
	}

	/**
	 * 下一页页
	 */
	@Override
	public long getNextPage() {
		if (isLastPage()) {
			return pageNo;
		} else {
			return pageNo + 1;
		}
	}

	/**
	 * 上一页页
	 */
	@Override
	public long getPrePage() {
		if (isFirstPage()) {
			return pageNo;
		} else {
			return pageNo - 1;
		}
	}

	protected long totalCount = 0;
	protected long pageSize = 20;
	protected long pageNo = 1;
	protected long totalPage = 0;

	/**
	 * if totalCount<0 then totalCount=0
	 * 
	 * @param totalCount
	 */
	public void setTotalCount(long totalCount) {
		if (totalCount < 0) {
			this.totalCount = 0;
		} else {
			this.totalCount = totalCount;
		}
	}
	
	public void setTotalPage() {
		totalPage = this.getTotalPage();
	}

	/**
	 * if pageSize< 1 then pageSize=DEF_COUNT
	 * 
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		if (pageSize < 1) {
			this.pageSize = DEF_COUNT;
		} else {
			this.pageSize = pageSize;
		}
	}

	/**
	 * if pageNo < 1 then pageNo=1
	 * 
	 * @param pageNo
	 */
	public void setPageNo(int pageNo) {
		if(totalCount == 0){
			this.pageNo = 0;
			return;
		}
		if (pageNo < 1) {
			this.pageNo = 1;
		} else {
			this.pageNo = pageNo;
		}
	}
}
