package com.wuxianedu.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wuxianedu.domain.Exam;
import com.wuxianedu.domain.ExamBean;
import com.wuxianedu.domain.ExamCondition;
import com.wuxianedu.domain.Grade;
import com.wuxianedu.domain.Paper;
import com.wuxianedu.domain.QueryBean;
import com.wuxianedu.exception.ExamException;
import com.wuxianedu.exception.SystemException;
import com.wuxianedu.mapper.ExamMapper;
import com.wuxianedu.web.PageBean;
import com.wuxianedu.web.QueryResult;

@Service
public class ExamService {
	
	@Resource
	private ExamMapper examMapper;
	
	// ��ѯ���п���
	public PageBean<Exam> findAllExam(QueryBean queryBean) throws ExamException, SystemException{
		QueryResult<Exam> queryResult = new QueryResult<Exam>();
		long countAll;
		List<Exam> exams = null;
		try {
			exams = examMapper.findAllExam(queryBean);
			queryResult.setList(exams);
			countAll = examMapper.countAllExam();
			queryResult.setTotalRecord((int)countAll);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		if(queryResult.getTotalRecord() == 0){
			throw new ExamException("û�п���");
		}
		PageBean<Exam> pageBean = new PageBean<Exam>();
		pageBean.setList(queryResult.getList());
		pageBean.setCurrentPage(queryBean.getCurrentPage());
		pageBean.setPageSize(queryBean.getPageSize());
		pageBean.setTotalRecord(queryResult.getTotalRecord());
		
		if(pageBean.getCurrentPage() > pageBean.getTotalPage()){
			queryBean.setCurrentPage(pageBean.getTotalPage());
			List<Exam> list = examMapper.findAllExam(queryBean);
			queryResult.setList(list);
			pageBean.setCurrentPage(queryBean.getCurrentPage());
			pageBean.setList(queryResult.getList());
		}
		return pageBean;
	}
	
	// ����������ѯ����
	public PageBean<Exam> findExamByCondition(ExamCondition examCondition) throws ExamException, SystemException{
		QueryResult<Exam> queryResult = new QueryResult<Exam>();
		QueryBean queryBean = examCondition.getQueryBean();
		long count;
		List<Exam> exams = null;
		try {
			exams = examMapper.findExamByCondition(examCondition);
			queryResult.setList(exams);
			count = examMapper.countByCondition(examCondition);
			queryResult.setTotalRecord((int)count);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		if(queryResult.getTotalRecord() == 0){
			throw new ExamException("û�и����Ϳ���");
		}
		PageBean<Exam> pageBean = new PageBean<Exam>();
		pageBean.setList(queryResult.getList());
		pageBean.setCurrentPage(queryBean.getCurrentPage());
		pageBean.setPageSize(queryBean.getPageSize());
		pageBean.setTotalRecord(queryResult.getTotalRecord());
		
		if(pageBean.getCurrentPage() > pageBean.getTotalPage()){
			queryBean.setCurrentPage(pageBean.getTotalPage());
			List<Exam> list =(List<Exam>) examMapper.findExamByCondition(examCondition);
			queryResult.setList(list);
			pageBean.setCurrentPage(queryBean.getCurrentPage());
			pageBean.setList(queryResult.getList());
		}
		return pageBean;
	}
	
	// ���ݰ༶��ѯ����
	public List<Exam> findExamByGrade(int cid) throws SystemException, ExamException{
		List<Exam> exams = null;
		try {
			exams = examMapper.findExamByGrade(cid);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		if(exams == null){
			throw new ExamException("���޿���");
		}
		return exams;
	}
	
	// ���ݿ���ID ��ѯ����
	public Exam findExamByEid(Exam exam) throws SystemException, ExamException{
		Exam ex = null;
		try {
			ex = examMapper.findExamByEid(exam);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		if(ex == null){
			throw new ExamException("û���ҵ��ÿ���");
		}
		return ex;
	}
	
	// ��������
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={SystemException.class})
	public void createExam(ExamBean examBean) throws SystemException, ExamException{
		Exam exam = new Exam();
		Paper paper = new Paper();
		Grade grade = new Grade();
		paper.setPid(examBean.getPid());
		grade.setGid(examBean.getCid());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date startTime = null;
		Date endTime = null;
		try {
			startTime = sdf.parse(examBean.getStartTime());
			endTime = sdf.parse(examBean.getEndTime());
		} catch (ParseException e1) {
			throw new ExamException("ʱ�䲻���Ϲ淶");
		}
		exam.setExamName(examBean.getExamName());
		exam.setGrade(grade);
		exam.setPaper(paper);
		exam.setStartTime(startTime);
		exam.setEndTime(endTime);
		try {
			examMapper.createExam(exam);
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}
	
	// �޸Ŀ���
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={SystemException.class})
	public void updateExam(Exam exam) throws SystemException{
		try {
			examMapper.updateExam(exam);
		} catch (Exception e) {
			throw new SystemException(e);
		}
	}
}