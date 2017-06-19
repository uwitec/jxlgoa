package com.wuxianedu.mapper;

import java.util.List;

import com.wuxianedu.domain.Grade;
import com.wuxianedu.domain.Types;

public interface GradeMapper {
	
	//插入班级信息
	public void insertGrade(Grade grade);
	
	//根据id删除信息
	public void deleteGrade(int id);
	
	//更新班级信息
	public void updateGrade(Grade grade);
	
	//查询班级信息
	public Grade queryGrade(Grade grade);
	
	//查询所有班级
	public List<Grade> queryAllGrade();
	
	//按条件查询班级
	public List<Grade> findGrade(Grade grade);
	
	// 根据班级类型查询班级
	public List<Grade> findGradeByTyepsId(Types types);
}
