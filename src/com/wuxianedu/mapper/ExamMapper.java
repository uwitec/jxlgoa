package com.wuxianedu.mapper;

import java.util.List;

import com.wuxianedu.domain.Exam;
import com.wuxianedu.domain.ExamCondition;
import com.wuxianedu.domain.Paper;
import com.wuxianedu.domain.QueryBean;

public interface ExamMapper {
	
	// 查询所有考试
	public List<Exam> findAllExam(QueryBean queryBean);
	
	// 查询共有多少场考试
	public long countAllExam();

	// 根据条件查询考试
	public List<Exam> findExamByCondition(ExamCondition examCondition);
	
	// 根据条件查询有多少场考试
	public long countByCondition(ExamCondition examCondition);
	
	// 根据试卷ID 查询
	public List<Exam> findExamByPaperId(Paper paper);
	
	// 根据班级ID查询考试
	public List<Exam> findExamByGrade(int cid);
	
	// 根据考试ID查询考试
	public Exam findExamByEid(Exam exam);
	
	// 创建一场考试
	public void createExam(Exam exam);
	
	// 修改一场考试
	public void updateExam(Exam exam);
	
	
}
