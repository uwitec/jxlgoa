package com.wuxianedu.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ExamBean {
	
	private int eid;
	
	@NotNull(message="�༶����Ϊ��")
	private Integer cid;
	
	@NotNull(message="�Ծ���Ϊ��")
	private Integer pid;
	
	@NotEmpty(message="����������Ϊ��")
	private String examName;
	
	@NotEmpty(message="��ʼʱ�䲻��Ϊ��")
	private String startTime;
	
	@NotEmpty(message="����ʱ�䲻��Ϊ��")
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
