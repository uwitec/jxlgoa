package com.wuxianedu.domain;


public class ExamCondition {
	
	private String className;
	private String examName;
	
	private QueryBean queryBean;

	public ExamCondition() {
		super();
	}
	
	public QueryBean getQueryBean() {
		return queryBean;
	}

	public void setQueryBean(QueryBean queryBean) {
		this.queryBean = queryBean;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}
	
	

}
