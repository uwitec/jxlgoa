package com.wuxianedu.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wuxianedu.domain.Student;
import com.wuxianedu.domain.StudentBean;
import com.wuxianedu.exception.SelectStudentException;
import com.wuxianedu.exception.SystemException;
import com.wuxianedu.mapper.StudentMapper;

@Service
public class StudentService {

	@Resource
	private StudentMapper studentMapper;
	
	
	//根据用户名和密码查询
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Student lookStu(String phone,String password) throws SystemException, SelectStudentException{
		Student student = new Student();
		student.setPhone(phone);
		student.setPassword(password);
		Student stud = null;
		try {
			stud = studentMapper.lookStudent(student);
			
			Date birDate = stud.getBirthday();
			Date registerDate = stud.getRegisterTime();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
			String birString = sdf.format(birDate);
			String registerString = sdf.format(registerDate);
			java.sql.Date upbirDate = java.sql.Date.valueOf(birString);
			java.sql.Date regiterDate = java.sql.Date.valueOf(registerString);
			stud.setBirthday(upbirDate );
			stud.setRegisterTime(regiterDate);
			
		} catch (Exception e) {
			throw new SystemException("用户名和密码不匹配");
		}
		
		if(stud == null){
			throw new SelectStudentException("不能为空");
		}
		return stud;
	}
	//添加学生
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={SystemException.class})
	public void insertStu(Student student) throws SystemException{
		try {
			studentMapper.insertStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException("系统内部错误StudentService-insertStu" + e);
		}
	}
	
	//根据id查询学生
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly=true)
	public Student findStudent(int id) throws SystemException, SelectStudentException{
			Student student2 = null;
		try {
			student2 = studentMapper.queryStudent(id);
		} catch (Exception e) {
			throw new SystemException("系统查找错误 StudnetService-findStudent" + e);
		}
		if(student2 == null){
			throw new SelectStudentException("还未注册");
		}
		return student2;
	}
	
	//根据id删除学生
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SystemException.class})
	public void delStudent(int id) throws SystemException{
		try {
			studentMapper.deleteStudent(id);
		} catch (Exception e) {
			throw new SystemException("系统删除错误StudentService-delStudent" + e);
		}
	}
	
	//更新学生信息
	@Transactional(propagation=Propagation.REQUIRED)
	public void  updateStu(Student student) throws SystemException{
		try {
			studentMapper.updateStudent(student);
		} catch (Exception e) {
			throw new SystemException("系统更新异常 StudentService-updateStu" + e);
		}
	}
	
	//查询符合条件的部分学生
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Student> findSomeStudents(StudentBean studentBean) throws SystemException, SelectStudentException{
		List<Student> students = null;
		try {
			students = studentMapper.findStudent(studentBean);
		} catch (Exception e) {
			throw new SystemException("系统内部查询错误StudentService-findSomeStudents" + e);
		}
		
		if( students == null){
			throw new SelectStudentException("学生查找错误");
		}
		return students;
	}
	
	//查询所有学生
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Student> queryAllStudnet() throws SystemException, SelectStudentException{
		List<Student> students = null;
		try {
			students = studentMapper.queryAllStudents();
		} catch (Exception e) {
			throw new SystemException("查询所有学生错误StudentService-queryAllStudent" + e);
		}
		if(students == null){
			throw new SelectStudentException("查询所有学生错误");
		}
		return students;
	}
	
}
