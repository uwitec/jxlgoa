package com.wuxianedu.mapper;

import java.util.List;

import com.wuxianedu.domain.Student;
import com.wuxianedu.domain.StudentBean;

public interface StudentMapper {
	
	//插入学生信息
	public void insertStudent(Student student);
	
	//根据名字删除信息
	public void deleteStudent(int id);
	
	//更新学生信息
	public void updateStudent(Student student);
	
	//查询学生信息
	public Student queryStudent(int id);
	
	//查询符合条件的学生
	public List<Student> findStudent(StudentBean studentBean);
	
	//查询所有学生
	public List<Student> queryAllStudents();
 	
	//根据用户名和密码查询
	public Student lookStudent(Student student);
}
