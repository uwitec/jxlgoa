package com.wuxianedu.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Adviser {
	
	private int aid;
	private String adviserName;
	private Date entryTime;
	private int workExperience;
	private String status;
	public Adviser() {
		super();
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAdviserName() {
		return adviserName;
	}
	public void setAdviserName(String adviserName) {
		this.adviserName = adviserName;
	}
	public Date getEntryTime() {
		
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		Date date=new Date(entryTime.getTime());
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
		String time=sdf.format(date);
		java.sql.Date uptime=java.sql.Date.valueOf(time);
		this.entryTime = uptime;
	}
	public int getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(int workExperience) {
		this.workExperience = workExperience;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
