package com.wuxianedu.domain;

public class ExamInfoStateBean {
	
	private Exam exam;
	private String state;
	private String score;
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public ExamInfoStateBean() {
		super();
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	

}
