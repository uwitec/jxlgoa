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

import com.wuxianedu.domain.QueryBean;
import com.wuxianedu.domain.Trainer;
import com.wuxianedu.domain.Types;
import com.wuxianedu.service.TrainerMapperService;
import com.wuxianedu.service.TypersMapperService;
import com.wuxianedu.web.PageBean;
import com.wuxianedu.web.WebUtil;

@Controller
@RequestMapping("/admin")
public class TrainerControl {
	
	@Resource
	private TrainerMapperService trainerMapperService;
	@Resource
	private TypersMapperService typersMapperService;
	
	@RequestMapping("/getTrainerList")
	public String getTrainerList(Model model){
		List<Trainer>list = trainerMapperService.listAllTrainer();
		List<Types>listType = typersMapperService.showAllType();
		model.addAttribute("list", list);
		model.addAttribute("listType", listType);
		return "WEB-INF/xg/listTrainer";
	}
	
	@RequestMapping("/getTrainerByPage")
	public String getTrainerByPage(HttpServletRequest request){
		
		QueryBean queryBean = WebUtil.regidter2FormBean(request, QueryBean.class);
		queryBean.setCurrentPage(queryBean.getCurrentPage());
		queryBean.setPageSize(queryBean.getPageSize());
		queryBean.setStartIndex((queryBean.getCurrentPage()-1)*queryBean.getPageSize());
		PageBean<Trainer>pageBean = trainerMapperService.pageBean(queryBean);
		List<Types>listType = typersMapperService.showAllType();
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("listType", listType);
		return "admin_index";
	}
	
	
	@RequestMapping("/searchTrainerByPage")
	public String searchTrainerByPage(HttpServletRequest request) throws ParseException{
		
		String trainerName = request.getParameter("trainerName").trim();
		String selectType = request.getParameter("selectType").trim();
		String entryTime = request.getParameter("entryTime").trim();
		String selectStatus = request.getParameter("selectStatus").trim();
		
		QueryBean queryBean = WebUtil.regidter2FormBean(request, QueryBean.class);
		queryBean.setCurrentPage(queryBean.getCurrentPage());
		queryBean.setPageSize(queryBean.getPageSize());
		queryBean.setStartIndex((queryBean.getCurrentPage()-1)*queryBean.getPageSize());
		
		Trainer trainer = new Trainer();	
		if(!trainerName.equals("")){
			trainer.setTrainerName(trainerName);
		}
		//if id,从session获取，
		
		
		if( !selectType.equals("")){
			Types types = new Types();
			int id = Integer.parseInt(selectType);
			id = Integer.parseInt(selectType);
			types.setId(id);
			request.getSession().setAttribute("typeId", selectType);
			System.out.println("11");
			trainer.setTypes(types);
		}else{
			String typeId =(String)request.getSession().getAttribute("typeId");
			System.out.println("typeid------>"+typeId);
			if(typeId==null){
				System.out.println("11111");
			}else{
				Types types = new Types();
				int id = Integer.parseInt(typeId);
				types.setId(id);
				trainer.setTypes(types);
			}
			
		}
		if(!entryTime.equals("")){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(entryTime);
			trainer.setEntryTime(date);
		}
		if(!selectStatus.equals("")){
			trainer.setStatus(selectStatus);
			request.getSession().setAttribute("status", selectStatus);
		}else{
			String status = (String)request.getSession().getAttribute("status");
			if(status==null){
			}else{
				trainer.setStatus(status);
			}
			
		}
		
		queryBean.setTrainer(trainer);
		PageBean<Trainer>pageBean = trainerMapperService.searchPageBean(queryBean);
		List<Types>listType = typersMapperService.showAllType();
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("listType", listType);
		return "admin/trainer/showSearchTrainer";
	}
	
	//动态查询
	@RequestMapping("/searchTrainer")
	public String searchTrainer(HttpServletRequest request,Model model) throws ParseException{
		String trainerName = request.getParameter("trainerName").trim();
		String selectType = request.getParameter("selectType").trim();
		String entryTime = request.getParameter("entryTime").trim();
		String selectStatus = request.getParameter("selectStatus").trim();
		
		System.out.println("trainerName-->"+trainerName+";selectType-->"+selectType);
		System.out.println("entryName-->"+entryTime+";selectStatus-->"+selectStatus);
		
		Trainer trainer = new Trainer();	
		
		if(!trainerName.equals("")){
			trainer.setTrainerName(trainerName);
		}
		if( !selectType.equals("")){
			Types types = new Types();
			int id = Integer.parseInt(selectType);
			types.setId(id);
			trainer.setTypes(types);
		}
		if(!entryTime.equals("")){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(entryTime);
			trainer.setEntryTime(date);
		}
		if(!selectStatus.equals("")){
			System.out.println("222");
			trainer.setStatus(selectStatus);
		}
		
		List<Trainer>list = trainerMapperService.searchTrainer(trainer);
		model.addAttribute("list", list);
		return "admin/trainer/showSearchTrainer";
	}
	
	@ResponseBody
	@RequestMapping("/updateStatu")
	public Trainer updateStatu(int id, String value) throws IOException{
		Trainer trainer = trainerMapperService.findTrainerById(id);
		if(value.equals("结课") || value.equals("离职")){
			trainer.setStatus(value);
			trainerMapperService.endClass(trainer);
		}
		return trainer;
	}
	@RequestMapping("/updateTrainerPre")
	public String updateTrainerPre(int id,Model model){
		
		Trainer trainer = trainerMapperService.findTrainerById(id);
		List<Types>listType = typersMapperService.showAllType();
		model.addAttribute("listType", listType);
		model.addAttribute("trainer", trainer);
	//	return "WEB-INF/xg/updateTrainer";
		return "admin/trainer/updateTrainer";
	}
	
	@RequestMapping("/updateTrainer")
	public String updateTrainer(HttpServletRequest request,Model model) throws ParseException{
		String trainerId = request.getParameter("tid").trim();
		String trainerName = request.getParameter("trainerName").trim();
		String selectType = request.getParameter("selectType").trim();
		String entryTime = request.getParameter("entryTime").trim();
		String workExperience = request.getParameter("workExperience").trim();
		String selectStatus = request.getParameter("selectStatus").trim();
		
		Trainer trainer = new Trainer();
		trainer.setTrainerName(trainerName);
		Types types = new Types();
		int id = Integer.parseInt(selectType);
		types.setId(id);
		trainer.setTypes(types);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(entryTime);
		trainer.setEntryTime(date);
		int workTime = Integer.parseInt(workExperience);
		trainer.setWorkExperience(workTime);
		trainer.setStatus(selectStatus);
		int trid = Integer.parseInt(trainerId);
		trainer.setTid(trid);
		trainerMapperService.updateTrainer(trainer);
		
		QueryBean queryBean = WebUtil.regidter2FormBean(request, QueryBean.class);
		queryBean.setCurrentPage(queryBean.getCurrentPage());
		queryBean.setPageSize(queryBean.getPageSize());
		queryBean.setStartIndex((queryBean.getCurrentPage()-1)*queryBean.getPageSize());
		PageBean<Trainer>pageBean = trainerMapperService.pageBean(queryBean);
		List<Types>listType = typersMapperService.showAllType();
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("listType", listType);
		
		return "admin_index";
	}
	
	@RequestMapping("/addTrainerPre")
	public String addTrainerPre(Model model){
		List<Types>listType = typersMapperService.showAllType();
		model.addAttribute("listType", listType);
		return "admin/trainer/addTrainer";
	}
	
	@RequestMapping("/addTrainer")
	public String addTrainer(HttpServletRequest request) throws ParseException{
		
		String trainerName = request.getParameter("trainerName");
		String selectType = request.getParameter("selectType");
		String entryTime = request.getParameter("entryTime");
		String selectStatus = request.getParameter("selectStatus");
		
		
		Trainer trainer = new Trainer();
		trainer.setTrainerName(trainerName);
		
		Types types = new Types();
		int id = Integer.parseInt(selectType);
		types.setId(id);
		trainer.setTypes(types);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(entryTime);
		trainer.setEntryTime(date);
		trainer.setStatus(selectStatus);
		trainerMapperService.insertTrainer(trainer);
		return "index";
	}
	
}
