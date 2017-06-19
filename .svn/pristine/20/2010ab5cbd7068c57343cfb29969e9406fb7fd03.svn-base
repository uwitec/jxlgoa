package com.wuxianedu.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ExamBean {
	
	private int eid;
	
	@NotNull(message="班级不能为空")
	private Integer cid;
	
	@NotNull(message="试卷不能为空")
	private Integer pid;
	
	@NotEmpty(message="考试名不能为空")
	private String examName;
	
	@NotEmpty(message="开始时间不能为空")
	private String startTime;
	
	@NotEmpty(message="结束时间不能为空")
	private String endTime;
	
	public ExamBean() {
		super();
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	
	
}
