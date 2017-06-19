package com.wuxianedu.domain;

public class ExamResultBean {
	
	private String paper_id;
	private String[] result=new String[100];
	public ExamResultBean() {
		super();
	}
	public String getPaper_id() {
		return paper_id;
	}
	public void setPaper_id(String paper_id) {
		this.paper_id = paper_id;
	}
	public String[] getResult() {
		return result;
	}
	public void setResult(String[] result) {
		this.result = result;
	}
	
	
	

}
