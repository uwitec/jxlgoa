package com.wuxianedu.utils;

import java.util.Date;

import com.wuxianedu.domain.Exam;

public class JudgeExamTimeUtils {
	
	public static String judgeTime(Exam exam){
		
		Date dateStart=exam.getStartTime();
		Date dateEnd=exam.getEndTime();
		Date dateNow=new Date();
		if(dateNow.getTime()>dateEnd.getTime()){
			return "考试结束";
		}
		if(dateNow.getTime()<dateStart.getTime()-1000*60*10){
			return "未开始";
		}
		if((dateNow.getTime()>=dateStart.getTime()-1000*60*10)&&(dateNow.getTime()<=1000*60*10+dateStart.getTime())){
			return "<a href='/OA/beginExam?id="+exam.getEid()+"'>进入考试</a>";
			
		}
		if(dateNow.getTime()>1000*60*10+dateStart.getTime()){
			return "考试进行中";
			
		}
		
		return "无";
	}
}
