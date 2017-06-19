package com.wuxianedu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wuxianedu.domain.Student;
import com.wuxianedu.domain.StudentLoginBean;
import com.wuxianedu.exception.SelectStudentException;
import com.wuxianedu.exception.SystemException;
import com.wuxianedu.service.StudentService;

@Controller
public class StudentLoginHandler {
	
	@Resource
	private StudentService studentSerivce;
	@RequestMapping("studentLogin")
	public String login(@Valid @ModelAttribute("studentLoginBean")StudentLoginBean studentLoginBean,Errors errors,HttpSession session){
		if(errors.hasErrors())
			return "studentLogin";
		Student student=null;
		try {
			student=studentSerivce.lookStu(studentLoginBean.getPhone(), studentLoginBean.getPassword());
		} catch (SystemException e) {
			e.printStackTrace();
			//errors.rejectValue("phone","�û����벻һ��");
			return "studentLogin";
		} catch (SelectStudentException e) {
			e.printStackTrace();
			return "studentLogin";
		}
		System.out.println(student);
		session.setAttribute("studentInfo", student);
		return "redirect:/teacher/index.html";
	}
	
	@RequestMapping("studentCancel")
	public String studentCancel(HttpSession session){
		session.removeAttribute("studentInfo");
		return "redirect:/studentLogin.jsp";
	}

}
