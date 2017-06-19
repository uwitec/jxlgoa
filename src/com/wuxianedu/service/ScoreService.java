package com.wuxianedu.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuxianedu.domain.ScoreBean;
import com.wuxianedu.mapper.ScoreMapper;


@Service
public class ScoreService {
	
	@Resource
	private ScoreMapper scoreMapper;
	
	public void insert(String score,String student_id,String exam_id){
		ScoreBean scoreBean=new ScoreBean();
		scoreBean.setScore(score);
		scoreBean.setStudent_id(student_id);
		scoreBean.setExam_id(exam_id);
		scoreMapper.insertScore(scoreBean);
	}
	
	public String selectScore(String student_id,String exam_id){
		ScoreBean scoreBean=new ScoreBean();
		scoreBean.setStudent_id(student_id);
		scoreBean.setExam_id(exam_id);
		if(scoreMapper.selectScore(scoreBean)==null){
			return "";
		}
		return scoreMapper.selectScore(scoreBean).getScore();
	}

}
