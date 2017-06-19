
package com.wuxianedu.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wuxianedu.domain.Grade;
import com.wuxianedu.exception.SelectStudentException;
import com.wuxianedu.exception.SystemException;
import com.wuxianedu.mapper.GradeMapper;

@Service
public class GradeService {

	@Resource
	private GradeMapper gradeMapper;
	//添加班级
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertGra(Grade grade) throws SystemException{
		try {
			gradeMapper.insertGrade(grade);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException("系统内部错误 GradeService-insertGra" + e);
		}
	}
	
	//根据班级名称查询
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly=true)
	public Grade findGrade(String name) throws SystemException, SelectStudentException{
			Grade grade = new Grade();
			grade.setClassName(name);
			Grade gra = null;
			System.out.println("111111111111111111111111111111111");
		try {
			gra = gradeMapper.queryGrade(grade);
		} catch (Exception e) {
			throw new SystemException("系统查找错误 GradeService-findGrade" + e);
		}
		
		if( gra == null){
			throw new SelectStudentException("班级查找错误");
		}
		return gra;
	}
	
	//查询所有班级
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Grade> queryAllGrad() throws SystemException, SelectStudentException{
		List<Grade> grades = null;
		try {
			grades = gradeMapper.queryAllGrade();
		} catch (Exception e) {
			throw new SystemException("系统查找错误GradeService-queryAllGrad" + e);
		}
		if(grades == null){
			throw new SelectStudentException("所有班级查询错误");
		}
		return grades;
	}
	
	//根据id删除
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SystemException.class})
	public void delGrade(int id) throws SystemException{
		try {
			gradeMapper.deleteGrade(id);
		} catch (Exception e) {
			throw new SystemException("系统删除错误GradeService-delGrade" + e);
		}
	}
	
	//更新班级
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SystemException.class})
	public void  updateGrad(Grade grade) throws SystemException{
		try {
			gradeMapper.updateGrade(grade);
		} catch (Exception e) {
			throw new SystemException("系统更新异常GradeService-updateGrad" + e);
		}
	}
	
	//查询符合条件的班级
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Grade> findSomeGrades(Grade grade) throws SystemException, SelectStudentException{
		List<Grade> grades = null;
		try {
			grades = gradeMapper.findGrade(grade);
		} catch (Exception e) {
			throw new SystemException("系统内部查询错误 GradeService-findSomeGrades" + e);
		}
		if(grades == null){
			throw new SelectStudentException("暂未开班");
		}
		return grades;
	}
	/*// 根据班级类型查询班级
	@RequestMapping("/findGradeByTyepsId")
	public List<Grade> findGradeByTyepsId(Types types) throws SystemException, SelectStudentException{
		List<Grade> grades = null;
		try {
			grades = gradeMapper.findGradeByTyepsId(types);
		} catch (Exception e) {
			throw new SystemException("系统内部查询错误 GradeService-findGradeByTyepsId" + e);
		}
		if(grades == null){
			throw new SelectStudentException("暂未开班");
		}
		return grades;
	}*/
}

