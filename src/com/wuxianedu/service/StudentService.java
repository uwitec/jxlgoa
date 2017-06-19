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
	
	
	//�����û����������ѯ
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
			throw new SystemException("�û��������벻ƥ��");
		}
		
		if(stud == null){
			throw new SelectStudentException("����Ϊ��");
		}
		return stud;
	}
	//����ѧ��
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={SystemException.class})
	public void insertStu(Student student) throws SystemException{
		try {
			studentMapper.insertStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException("ϵͳ�ڲ�����StudentService-insertStu" + e);
		}
	}
	
	//����id��ѯѧ��
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly=true)
	public Student findStudent(int id) throws SystemException, SelectStudentException{
			Student student2 = null;
		try {
			student2 = studentMapper.queryStudent(id);
		} catch (Exception e) {
			throw new SystemException("ϵͳ���Ҵ��� StudnetService-findStudent" + e);
		}
		if(student2 == null){
			throw new SelectStudentException("��δע��");
		}
		return student2;
	}
	
	//����idɾ��ѧ��
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SystemException.class})
	public void delStudent(int id) throws SystemException{
		try {
			studentMapper.deleteStudent(id);
		} catch (Exception e) {
			throw new SystemException("ϵͳɾ������StudentService-delStudent" + e);
		}
	}
	
	//����ѧ����Ϣ
	@Transactional(propagation=Propagation.REQUIRED)
	public void  updateStu(Student student) throws SystemException{
		try {
			studentMapper.updateStudent(student);
		} catch (Exception e) {
			throw new SystemException("ϵͳ�����쳣 StudentService-updateStu" + e);
		}
	}
	
	//��ѯ���������Ĳ���ѧ��
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Student> findSomeStudents(StudentBean studentBean) throws SystemException, SelectStudentException{
		List<Student> students = null;
		try {
			students = studentMapper.findStudent(studentBean);
		} catch (Exception e) {
			throw new SystemException("ϵͳ�ڲ���ѯ����StudentService-findSomeStudents" + e);
		}
		
		if( students == null){
			throw new SelectStudentException("ѧ�����Ҵ���");
		}
		return students;
	}
	
	//��ѯ����ѧ��
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Student> queryAllStudnet() throws SystemException, SelectStudentException{
		List<Student> students = null;
		try {
			students = studentMapper.queryAllStudents();
		} catch (Exception e) {
			throw new SystemException("��ѯ����ѧ������StudentService-queryAllStudent" + e);
		}
		if(students == null){
			throw new SelectStudentException("��ѯ����ѧ������");
		}
		return students;
	}
	
}