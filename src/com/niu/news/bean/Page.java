package com.niu.news.bean;

import java.util.List;

public class Page {
	// 总页数
	private int totalPageCount;
	// 页面大小
	private int pageSize = 5;
	// 记录总数
	private int totleCount;
	// 当前页码
	private int curPageNo = 1;
	// 每页新闻集合
	private List<News> newsList;

	public int getTotalPageCoun() {
		return totalPageCount;
	}

	public void setTotalPageCoun(int totleCount) {
		if (totleCount > 0) {
			this.totleCount = totleCount;
			this.totalPageCount = totleCount / pageSize == 0 ? totleCount
					/ pageSize : totleCount / pageSize + 1;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize > 0) {
			this.pageSize = pageSize;
		}
	}

	public int getTotleCount() {
		return totleCount;
	}

	public void setTotleCount(int totleCount) {
		this.totleCount = totleCount;
	}

	public int getCurPageNo() {
		if (totleCount == 0)
			return 0;
		return curPageNo;
	}

	public void setCurPageNo(int curPageNo) {
		this.curPageNo = curPageNo;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

}
