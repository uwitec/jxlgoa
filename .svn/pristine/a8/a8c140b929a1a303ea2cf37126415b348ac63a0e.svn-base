package com.wuxianedu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wuxianedu.domain.Grade;
import com.wuxianedu.domain.Student;
import com.wuxianedu.domain.StudentBean;
import com.wuxianedu.exception.SelectStudentException;
import com.wuxianedu.exception.SystemException;
import com.wuxianedu.service.StudentService;
@Controller
@RequestMapping("/admin")
public class StudentHandler {
	
	@Resource
	private StudentService studentService;
	
	//插入学生信息
	@RequestMapping("/insertStudent")
	public String inserStudent(Student student){
		try {
			System.out.println("pppppppppppppppppppppppp"+ student);
			studentService.insertStu(student);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return "insertSucc";
	}
	
	//更新学生信息
	@RequestMapping(value="/updateStudent",method=RequestMethod.POST)
	public String updatStudent(Student student){
		
		try {
				studentService.updateStu(student);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	//查询符合条件学生
	@RequestMapping(value="/getAllStudents",method=RequestMethod.POST)
	public ModelAndView getAllStudents(@ModelAttribute("studentBean") StudentBean studentBean,Student student){
//		System.out.println("11111111111111111111111111111111111______");
		ModelAndView mav = new ModelAndView();
		List<Student> list = null;
		
		studentBean.setGid(student.getSid());
		try {
			list = studentService.findSomeStudents(studentBean);
			for (Student students : list) {
				System.out.println(students);
			}
			mav.addObject("studentBean", list);
			mav.setViewName("showStudent");
			} catch (SystemException e) {
					e.printStackTrace();
			} catch (SelectStudentException e) {
					e.printStackTrace();
			}
		return mav;
	}
	
	//查询所有学生
	@RequestMapping(value="queryAllStud")
	public ModelAndView queryAllStud(){
		ModelAndView mav = new ModelAndView();
		List<Student> list = null;
		try {
			list = studentService.queryAllStudnet();
			mav.addObject("allStudents", list);
			mav.setViewName("studentList");
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (SelectStudentException e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	//通过id查询学生
	@RequestMapping("/getStudent")
	@ResponseBody
	public ModelAndView getStudent(Student student){
		ModelAndView mav = new ModelAndView();
		Integer id = student.getSid();
		Student stu = new Student();
		try {
			stu = studentService.findStudent(id);
			mav.addObject("student", stu);
			mav.setViewName("showstudent");
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (SelectStudentException e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	//通过id删除学生
	@RequestMapping("/delectStudent")
	public String deleteStudent(Student student){
		Integer id = student.getSid();
		try {
			studentService.delStudent(id);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return "/OA/admin/queryAllStud";
	}
	
}
