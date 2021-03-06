package com.wuxianedu.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wuxianedu.domain.Student;
import com.wuxianedu.domain.StudentSelfUpdateBean;
import com.wuxianedu.exception.SelectStudentException;
import com.wuxianedu.exception.SystemException;
import com.wuxianedu.service.StudentService;
import com.wuxianedu.utils.FileUtil;

@Controller
public class StudentInfoAndOperationHandler {
	
	@Resource
	private StudentService studentService;
	
	@RequestMapping("showSelfInfo")
	public ModelAndView showSelfInfo(HttpSession session){
		ModelAndView mav=new ModelAndView();
		Student student=(Student) session.getAttribute("studentInfo");
		try {
			student=studentService.lookStu(student.getPhone(), student.getPassword());
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (SelectStudentException e) {
			e.printStackTrace();
		}
		System.out.println(student);
		mav.addObject("studentInfo", student);
		mav.setViewName("teacher/showStudentInfo");
		return mav;
	}
	
	@RequestMapping("updateAndShowSelfInfo")
	public ModelAndView updateAndShowSelfInfo( HttpSession session){
		ModelAndView mav=new ModelAndView();
		StudentInfoAndOperationHandler siah=new StudentInfoAndOperationHandler();
		StudentSelfUpdateBean studentSelfUpdateBean=new StudentSelfUpdateBean();
		Student student=(Student) session.getAttribute("studentInfo");
		try {
			student=studentService.findStudent(student.getSid());
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (SelectStudentException e) {
			e.printStackTrace();
		}
		studentSelfUpdateBean.setBirthday(siah.getStringTime(student.getBirthday()));
		studentSelfUpdateBean.setGender(student.getGender());
		studentSelfUpdateBean.setNativePlace(student.getNativePlace());
		studentSelfUpdateBean.setPassword(student.getPassword());
		studentSelfUpdateBean.setPhone(student.getPhone());
		studentSelfUpdateBean.setStudentName(student.getStudentName());
		mav.addObject("studentSelfUpdateBean", studentSelfUpdateBean);
		mav.setViewName("teacher/studentUpdateSelfInfo");
		return mav;
	}

	
	
	@RequestMapping(value="/updateStudentInfo",method=RequestMethod.POST)
	public String addStudent(@Valid @ModelAttribute("studentSelfUpdateBean")StudentSelfUpdateBean studentSelfUpdateBean,Errors errors,HttpSession session,@RequestParam(value = "file",required = false)MultipartFile file,
			HttpServletRequest request){
			StudentInfoAndOperationHandler siah=new StudentInfoAndOperationHandler();
			if(errors.hasErrors()){
				return "teacher/studentUpdateSelfInfo";
			}
		 	//文件保存路径
	        String pathRoot = request.getSession().getServletContext().getRealPath("/studentImages");
	        //文件名
	        String fileName = file.getOriginalFilename();  
	        //uuid名
	        String names = UUID.randomUUID().toString()+ fileName;
	    	//截取文件名
			String last = names.substring(names.lastIndexOf(".")+1);
			names = names.substring(0, ((names.length())-(fileName.length())))+"."+last;
			//随机存储文件
			String path = FileUtil.generateFilename(pathRoot, names);
			//获取保存在数据库的文件名
			String picture = "studentImages"+path.substring(pathRoot.length(), path.length());
			try {
				file.transferTo(new File(path));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}  
			Student student=(Student) session.getAttribute("studentInfo");
			student.setStudentName(studentSelfUpdateBean.getStudentName());
			student.setBirthday(siah.getTime(studentSelfUpdateBean.getBirthday()));
			student.setGender(studentSelfUpdateBean.getGender());
			student.setPhone(studentSelfUpdateBean.getPhone());
			student.setNativePlace(studentSelfUpdateBean.getNativePlace());
			student.setPassword(studentSelfUpdateBean.getPassword());
			student.setPhotoAddress(picture);
			try {
				studentService.updateStu(student);
			} catch (SystemException e) {
				e.printStackTrace();
			}
			
			Student student1=null;
			try {
				student1=(Student) session.getAttribute("studentInfo");
				student1=studentService.findStudent(student.getSid());
			} catch (SystemException e) {
				e.printStackTrace();
			} catch (SelectStudentException e) {
				e.printStackTrace();
			}
			
			session.setAttribute("studentInfo", student1);
			return "forward:showSelfInfo.do";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@RequestMapping("updateStudentInfo")
	public String updateStudentInfo(@Valid @ModelAttribute("studentSelfUpdateBean") StudentSelfUpdateBean studentSelfUpdateBean,Errors errors,HttpSession session){
		StudentInfoAndOperationHandler siah=new StudentInfoAndOperationHandler();
		if(errors.hasErrors()){
			return "studentUpdateSelfInfo";
		}
		Student student=(Student) session.getAttribute("studentInfo");
		student.setStudentName(studentSelfUpdateBean.getStudentName());
		student.setBirthday(siah.getTime(studentSelfUpdateBean.getBirthday()));
		student.setGender(studentSelfUpdateBean.getGender());
		student.setPhone(studentSelfUpdateBean.getPhone());
		student.setNativePlace(studentSelfUpdateBean.getNativePlace());
		student.setPassword(studentSelfUpdateBean.getPassword());
		try {
			studentService.updateStu(student);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		Student student1=null;
		try {
			student1=(Student) session.getAttribute("studentInfo");
			student1=studentService.findStudent(student.getSid());
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (SelectStudentException e) {
			e.printStackTrace();
		}
		
		session.setAttribute("studentInfo", student1);
		return "forward:showSelfInfo.do";
	}*/
	
	
	
	
	
	
	public Date getTime(String date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date1=null;
		try {
			date1 = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		return date1;
	}
	
	public String getStringTime(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date1=sdf.format(date);
		return date1;
	}
	
 
	    public  String encodeStr(String str) {  
	    	if(str==null||"".equals(str)){
	    		return "";
	    	}
	        try {  
	            return new String(str.getBytes("ISO-8859-1"), "UTF-8");  
	        } catch (UnsupportedEncodingException e) {  
	            e.printStackTrace();  
	            return null;  
	        }  
	    }  
	 
	
}
