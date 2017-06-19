package com.wuxianedu.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuxianedu.domain.Adviser;
import com.wuxianedu.domain.QueryBean;
import com.wuxianedu.service.AdviserMapperService;
import com.wuxianedu.web.PageBean;
import com.wuxianedu.web.WebUtil;

@Controller
@RequestMapping("/adviser")
public class AdviserControl {
	
	@Resource
	private AdviserMapperService adviserMapperService;
	
	@RequestMapping("/getAdviserList")
	public String getAdviserList(Model model){
		List<Adviser> list = adviserMapperService.listAllAdviser();
		model.addAttribute("listAdviser", list);
		return "WEB-INF/xg/listAdviser";
	}
	
	
	//≤È—Ø∑÷“≥
	@RequestMapping("/searchAdviserByPage")
	public String searchAdviserByPage(HttpServletRequest request) throws ParseException{
		
		String adviserName = request.getParameter("adviserName").trim();
		String entryTime = request.getParameter("entryTime").trim();
		String selectType = request.getParameter("selectType").trim();
		
		QueryBean queryBean = WebUtil.regidter2FormBean(request, QueryBean.class);
		queryBean.setCurrentPage(queryBean.getCurrentPage());
		queryBean.setPageSize(queryBean.getPageSize());
		queryBean.setStartIndex((queryBean.getCurrentPage()-1)*queryBean.getPageSize());
		Adviser adviser = new Adviser();
		
		if(!adviserName.equals("")){
			adviser.setAdviserName(adviserName);
		}
		if(!entryTime.equals("")){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(entryTime);
			adviser.setEntryTime(date);
		}
		if(!selectType.equals("")){
			adviser.setStatus(selectType);
			request.getSession().setAttribute("selectType", selectType);
		}else{
			String selectStr = (String)request.getSession().getAttribute("selectType");
			if(selectStr == null){
				
			}else{
				adviser.setStatus(selectStr);
			}
		}
		queryBean.setAdviser(adviser);
		System.out.println("========="+queryBean);
		PageBean<Adviser> pageBean = adviserMapperService.searchPageBean(queryBean);
		request.setAttribute("pageBean", pageBean);
		return "admin/adviser/showSearchAdviser";
		
	}
	
	@ResponseBody
	@RequestMapping("/updateStatu")
	public Adviser updateStatu(int id, String value) throws IOException{
		
		Adviser adviser = adviserMapperService.findAdviserById(id);
		System.out.println("=====================+++++"+id+"====000000000"+value);
		adviser.setStatus(value);
		System.out.println(id+"----"+value);
		adviserMapperService.changeStatue(adviser);
		return adviser;
	}
	
	@RequestMapping("/updateAdviserPre")
	public String updateAdviserPre(int id,Model model){
		Adviser adviser = adviserMapperService.findAdviserById(id);
		model.addAttribute("adviser", adviser);
		
		return "admin/adviser/updateAdviser";
	}
	
	@RequestMapping("/updateAdviser")
	public String updateAdviser(HttpServletRequest request) throws ParseException{
		
		String adviserName = request.getParameter("adviserName");
		String entryTime = request.getParameter("entryTime");
		String workExperience = request.getParameter("workExperience");
		String status = request.getParameter("selectStatus");
		String aid = request.getParameter("aid");
		System.out.println("adviserName-->"+adviserName+";entryName--->"+entryTime);
		System.out.println("workExperience-->"+workExperience+";status--->"+status);
		
		Adviser adviser = new Adviser();
		adviser.setAdviserName(adviserName);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(entryTime);
		adviser.setEntryTime(date);
		adviser.setWorkExperience(Integer.parseInt(workExperience));
		adviser.setStatus(status);
		adviser.setAid(Integer.parseInt(aid));
		adviserMapperService.updateAdviser(adviser);
		
		QueryBean queryBean = WebUtil.regidter2FormBean(request, QueryBean.class);
		queryBean.setCurrentPage(queryBean.getCurrentPage());
		queryBean.setPageSize(queryBean.getPageSize());
		queryBean.setStartIndex((queryBean.getCurrentPage()-1)*queryBean.getPageSize());
		PageBean<Adviser> pageBean = adviserMapperService.pageBean(queryBean);
		request.setAttribute("pageBean", pageBean);
		
		return "admin/adviser/listAdviser";
	}
	
	@RequestMapping("/searchAdviser")
	public String searchAdviser(HttpServletRequest request,Model model) throws ParseException{
		String adviserName = request.getParameter("adviserName").trim();
		String entryTime = request.getParameter("entryTime").trim();
		String selectType = request.getParameter("selectType").trim();
		
		System.out.println("adviserName-->"+adviserName+";entryTime--->"+entryTime+";selectType--->"+selectType);
		Adviser adviser = new Adviser();
		if(!adviserName.equals("")){
			adviser.setAdviserName(adviserName);
		}
		if(!entryTime.equals("")){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(entryTime);
			adviser.setEntryTime(date);
		}
		if(!selectType.equals("")){
			adviser.setStatus(selectType);
		}
		System.out.println("adviser------------+++"+adviser);
		List<Adviser>list = adviserMapperService.searchAdviser(adviser);
		model.addAttribute("list", list);
		return "WEB-INF/xg/showSearchAdviser";
	}
	
	@RequestMapping("/addAdviserPre")
	public String addAdviserPre(){
		
		return "admin/adviser/addAdviser";
	}
	
	@RequestMapping("/addAdviser")
	public String addAdviser(HttpServletRequest request) throws ParseException{
		String adviserName = request.getParameter("adviserName");
		String entryTime = request.getParameter("entryTime");
		String workExperience = request.getParameter("workExperience");
		String status = request.getParameter("selectStatus");
		
		Adviser adviser = new Adviser();
		adviser.setAdviserName(adviserName);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(entryTime);
		adviser.setEntryTime(date);
		adviser.setWorkExperience(Integer.parseInt(workExperience));
		adviser.setStatus(status);
		adviserMapperService.insertAdviser(adviser);
		
		QueryBean queryBean = WebUtil.regidter2FormBean(request, QueryBean.class);
		queryBean.setCurrentPage(queryBean.getCurrentPage());
		queryBean.setPageSize(queryBean.getPageSize());
		queryBean.setStartIndex((queryBean.getCurrentPage()-1)*queryBean.getPageSize());
		PageBean<Adviser> pageBean = adviserMapperService.pageBean(queryBean);
		request.setAttribute("pageBean", pageBean);
		return "admin/adviser/listAdviser";
	}
	
	@RequestMapping("/getAdviserByPage")
	public String getAdviserByPage(HttpServletRequest request){
		QueryBean queryBean = WebUtil.regidter2FormBean(request, QueryBean.class);
		queryBean.setCurrentPage(queryBean.getCurrentPage());
		queryBean.setPageSize(queryBean.getPageSize());
		queryBean.setStartIndex((queryBean.getCurrentPage()-1)*queryBean.getPageSize());
		PageBean<Adviser> pageBean = adviserMapperService.pageBean(queryBean);
		request.setAttribute("pageBean", pageBean);
		return "admin/adviser/listAdviser";
	}

}
