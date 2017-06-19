package com.wuxianedu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wuxianedu.domain.Administrator;
import com.wuxianedu.domain.QueryBean;
import com.wuxianedu.domain.Trainer;
import com.wuxianedu.domain.Types;
import com.wuxianedu.exception.AdministratorException;
import com.wuxianedu.service.AdministratorMapperService;
import com.wuxianedu.service.TrainerMapperService;
import com.wuxianedu.service.TypersMapperService;
import com.wuxianedu.web.PageBean;
import com.wuxianedu.web.WebUtil;

@RequestMapping("/admin")
@Controller
public class AdminControl {

	@Resource
	private AdministratorMapperService administratorMapperService;
	@Resource
	private TrainerMapperService trainerMapperService;
	@Resource
	private TypersMapperService typersMapperService;
	
	@RequestMapping("/adminLogin")
	public String adminLogin(@Valid @ModelAttribute("adminUser") Administrator administrator, Errors errors, HttpSession session,HttpServletRequest request){
		if(errors.hasErrors()){
			System.out.println("错误信息为："+errors);
			return "admin_Login";
		}
		Administrator admin = null;
		try {
			 admin = administratorMapperService.adminLogin(administrator);
			 if(admin!=null){
				 QueryBean queryBean = WebUtil.regidter2FormBean(request, QueryBean.class);
					queryBean.setCurrentPage(queryBean.getCurrentPage());
					queryBean.setPageSize(queryBean.getPageSize());
					queryBean.setStartIndex((queryBean.getCurrentPage()-1)*queryBean.getPageSize());
					PageBean<Trainer>pageBean = trainerMapperService.pageBean(queryBean);
					List<Types>listType = typersMapperService.showAllType();
					request.setAttribute("pageBean", pageBean);
					request.setAttribute("listType", listType);
			 }
			 
		} catch (AdministratorException e) {
			//String message = e.getMessage().substring(e.getMessage().lastIndexOf(":") + 1);
			//errors.rejectValue("username", "adminuser.login.error", new Object[]{message}, "该用户名和密码不一致");//自定义异常
			return "admin_Login";
		}
		
		session.setAttribute("admin", admin.getUsername());
		return "admin_index";
	}
	
}
