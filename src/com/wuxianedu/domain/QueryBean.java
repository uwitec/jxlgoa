package com.wuxianedu.domain;

import javax.validation.constraints.Pattern;

import com.wuxianedu.domain.Trainer;


public class QueryBean {
	
	private int currentPage = 1;//当前页码数
	private int pageSize = 5;//当前页显示记录的条数
	
	private int startIndex;//当前页显示记录在数据表的其实位置
	private int startBookIndex;
	private int startUserIndex;
	private int startOrderIndex;
	
	private Trainer trainer;
	private Adviser adviser;
	
	public Adviser getAdviser() {
		return adviser;
	}

	public void setAdviser(Adviser adviser) {
		this.adviser = adviser;
	}

	public QueryBean() {
		super();
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartIndex() {
		startIndex = (currentPage - 1) * pageSize;
		return startIndex;
	}
	
	public void setStartOrderIndex(int startOrderIndex) {
		this.startOrderIndex = startOrderIndex;
	}

	@Override
	public String toString() {
		return "QueryBean [currentPage=" + currentPage + ", pageSize="
				+ pageSize + ", startIndex=" + startIndex + ", startBookIndex="
				+ startBookIndex + ", startUserIndex=" + startUserIndex
				+ ", startOrderIndex=" + startOrderIndex + "]";
	}
	
}
