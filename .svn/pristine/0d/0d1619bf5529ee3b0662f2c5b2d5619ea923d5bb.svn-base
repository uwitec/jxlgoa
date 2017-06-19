package com.wuxianedu.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class PaperCondition {
	
	private int pid;
	private int iid;
	private String paperName;
	@NotEmpty(message="选择正确的类型")
	private String typeName;

	private QueryBean queryBean;
	
	public QueryBean getQueryBean() {
		return queryBean;
	}

	public void setQueryBean(QueryBean queryBean) {
		this.queryBean = queryBean;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public PaperCondition() {
		super();
	}

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	

}
