package com.wuxianedu.domain;

import java.util.Date;

public class Grade {

	private int gid;
	private String className;
	private Types types;
	private Date openTime;
	private String learningPhase;
	private String status;
	private Trainer trainer;
	private Adviser adviser;
	
	
	public Grade() {
		super();
	}
	
	public Grade(String className, Types types, Date openTime,
			String learningPhase, String status, Trainer trainer,
			Adviser adviser) {
		super();
		this.className = className;
		this.types = types;
		this.openTime = openTime;
		this.learningPhase = learningPhase;
		this.status = status;
		this.trainer = trainer;
		this.adviser = adviser;
	}
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	public Types getTypes() {
		return types;
	}
	public void setTypes(Types types) {
		this.types = types;
	}
	public Date getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	public String getLearningPhase() {
		return learningPhase;
	}
	public void setLearningPhase(String learningPhase) {
		this.learningPhase = learningPhase;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	public Adviser getAdviser() {
		return adviser;
	}
	public void setAdviser(Adviser adviser) {
		this.adviser = adviser;
	}

	@Override
	public String toString() {
		return "Grade [cid=" + gid + ", className=" + className + ", types="
				+ types + ", openTime=" + openTime + ", learningPhase="
				+ learningPhase + ", status=" + status + ", trainer=" + trainer
				+ ", adviser=" + adviser + "]";
	}

	
	
}
