package com.wuxianedu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wuxianedu.domain.Grade;
import com.wuxianedu.domain.Types;
import com.wuxianedu.exception.SelectStudentException;
import com.wuxianedu.exception.SystemException;
import com.wuxianedu.service.GradeService;

@Controller

@RequestMapping("/admin")
public class GradeHandler {

	@Resource
	private GradeService gradeService;
	
	//插入班级
	@RequestMapping("/insertGrad")
	public String insertGrad(Grade grade){
		try {
			gradeService.insertGra(grade);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return "insertGradSucc";
	}
	//根据班级名称查找班级信息
	@RequestMapping("/findGradeName")
	public ModelAndView findGradeName(String name){
		ModelAndView mav = new ModelAndView();
		Grade grade = null;
		try {
			grade = gradeService.findGrade(name);
			mav.addObject("grade", grade);
			mav.setViewName("gradeList");
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (SelectStudentException e) {
			e.printStackTrace();
		}
		return mav;
	}
	//根据id删除班级
	@RequestMapping("/deleteGradeById")
	public String deleteGradeById(int id){
		try {
			gradeService.delGrade(id);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return "redirect" + "";
	}
	
	//更新班级信息
	@RequestMapping("/updateGrades")
	public String updateGrades(Grade grade){
		try {
			gradeService.updateGrad(grade);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return "";
	}
	//列出所有班级信息
	@RequestMapping(value="/queryAllGrade")
	public ModelAndView queryAllGrade(Grade grade){
		System.out.println("44444444444444444444444444444444");
		ModelAndView mav = new ModelAndView();
		List<Grade> grades= null;
		try {
			grades = gradeService.queryAllGrad();
			 for (Grade grade2 : grades) {
					System.out.println(grade2);
				}
			mav.addObject("gradeLists", grades);
			mav.setViewName("gradeList");
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (SelectStudentException e) {
			e.printStackTrace();
		}
		return mav;
	}
	//按条件查找班级
	@RequestMapping(value="/getAllGrades")
	public ModelAndView getAllGrades(Grade grade){
		ModelAndView mav = new ModelAndView();
		List<Grade> list = null;
		try {
			System.out.println("222222222222222222222222222222");
			 list = gradeService.findSomeGrades(grade);
			 mav.addObject("AllGrades", list);
			 mav.setViewName("showGrades");
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (SelectStudentException e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	/*@RequestMapping("/findGradeByTypesId")
	@ResponseBody
	public List<Grade> findGradeByTypesId(Types types){
		List<Grade> grades = null;
		try {
			grades = gradeService.findGradeByTyepsId(types);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (SelectStudentException e) {
			e.printStackTrace();
		}
		return grades;
		
		
	}*/
}
