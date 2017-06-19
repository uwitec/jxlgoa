package com.wuxianedu.mapper;

import java.util.List;

import com.wuxianedu.domain.Grade;
import com.wuxianedu.domain.Types;

public interface GradeMapper {
	
	//����༶��Ϣ
	public void insertGrade(Grade grade);
	
	//����idɾ����Ϣ
	public void deleteGrade(int id);
	
	//���°༶��Ϣ
	public void updateGrade(Grade grade);
	
	//��ѯ�༶��Ϣ
	public Grade queryGrade(Grade grade);
	
	//��ѯ���а༶
	public List<Grade> queryAllGrade();
	
	//��������ѯ�༶
	public List<Grade> findGrade(Grade grade);
	
	// ���ݰ༶���Ͳ�ѯ�༶
	public List<Grade> findGradeByTyepsId(Types types);
}