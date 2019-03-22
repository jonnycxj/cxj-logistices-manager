package com.sxt.pojo;

public class BasePage {
	
	protected Integer pageNum=1;
	
	protected Integer pageSize=5;

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "BasePage [pageNum=" + pageNum + ", pageSize=" + pageSize + "]";
	}
}
