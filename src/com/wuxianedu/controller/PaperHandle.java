package com.wuxianedu.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wuxianedu.domain.Paper;
import com.wuxianedu.domain.PaperBean;
import com.wuxianedu.domain.PaperCondition;
import com.wuxianedu.domain.QueryBean;
import com.wuxianedu.domain.Types;
import com.wuxianedu.exception.PaperException;
import com.wuxianedu.exception.SystemException;
import com.wuxianedu.service.PaperService;
import com.wuxianedu.web.PageBean;

@Controller
@RequestMapping("/paper")
public class PaperHandle {
	
	@Resource
	private PaperService paperService;
	
	@RequestMapping("/findAllPaper")
	public String findAllPaper(QueryBean queryBean, Model model){
		PageBean<Paper> pageBean = null;
		try {
			pageBean=paperService.findAllPaper(queryBean);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PaperException e) {
			e.printStackTrace();
		}
		model.addAttribute("paperPageBean",pageBean);
		return "admin/paper/showPaper";
	}
	
	@RequestMapping("/findPaperById")
	public String findPaperById(Paper paper, Model model){
		try {
			paper = paperService.findPaperAndItem(paper);
		} catch (PaperException e) {
			e.printStackTrace();
			return "";
		} catch (SystemException e) {
			e.printStackTrace();
			return "";
		}
		model.addAttribute("paper", paper);
		return "admin/paper/updatePaper";
	}
	
	@RequestMapping("/findPaperAndItem")
	public ModelAndView findPaperAndItem(Paper paper){
		ModelAndView mav = new ModelAndView();
		try {
			paper = paperService.findPaperAndItem(paper);
		} catch (PaperException e) {
			e.printStackTrace();
			mav.setViewName("admin/paper/showPaper");
			return mav;
		} catch (SystemException e) {
			e.printStackTrace();
			mav.setViewName("admin/paper/showPaper");
			return mav;
		}
		mav.addObject("paper", paper);
		mav.setViewName("admin/paper/showOnePaper");
		return mav;
	}
	
	@RequestMapping("/findPaperByNameOrTypes")
	public ModelAndView findPaperByNameOrTypes(@Valid @ModelAttribute("paperCondition") PaperCondition paperCondition,
			Errors errors, QueryBean queryBean, HttpSession session){
		if(paperCondition.getTypeName() != null && !"".equals(paperCondition.getTypeName())){
			session.setAttribute("paperConditionTypesName", paperCondition.getTypeName());
		}else{
			paperCondition.setTypeName((String)session.getAttribute("paperConditionTypesName"));
		}
		if(paperCondition.getPaperName() != null && !"".equals(paperCondition.getPaperName())){
			session.setAttribute("paperConditionPaperName", paperCondition.getPaperName());
		}else{
			paperCondition.setPaperName((String)session.getAttribute("paperConditionPaperName"));
		}
		paperCondition.setQueryBean(queryBean);
		ModelAndView mav = new ModelAndView();
		PageBean<Paper> pageBean = null;
		try {
			pageBean = paperService.findPaperByNameOrTypes(paperCondition);
		} catch (PaperException e) {
			e.printStackTrace();
			mav.setViewName("admin/paper/showPaperByCondition");
			return mav;
		} catch (SystemException e) {
			e.printStackTrace();
			mav.setViewName("admin/paper/showPaperByCondition");
			return mav;
		}
		mav.addObject("paperPageBeanByCondition", pageBean);
		mav.setViewName("admin/paper/showPaperByCondition");
		return mav;
	}
	
	@RequestMapping("/createPaper")
	public String createPaper(@Valid @ModelAttribute("paperBean")PaperBean paperBean, Errors errors){
		if(errors.hasErrors()){
			return "admin/paper/createPaper";
		}
		int questionNumber;
		try {
			questionNumber = Integer.parseInt(paperBean.getQuestionNumber());
		} catch (Exception e) {
			return "admin/paper/createPaper";
		}
		int typesId = Integer.parseInt(paperBean.getTypesId());
		Paper paper = new Paper();
		paper.setPaperName(paperBean.getPaperName());
		paper.setQuestionNumber(questionNumber);
		paper.setCreateTime(new Timestamp(System.currentTimeMillis()));
		Types types = new Types();
		types.setId(typesId);
		paper.setTypes(types);
		try {
			paperService.createPaper(paper);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PaperException e) {
			e.printStackTrace();
			return "admin/paper/createPaper";
		}
		return "redirect:/paper/findAllPaper";
	}
	
	@RequestMapping("/updatePaper")
	public String updatePaper(@Valid @ModelAttribute("paper") Paper paper, Errors error){
		if(error.hasErrors()){
			return "admin/paper/updatePaper";
		}
		try {
			paperService.updatePaper(paper);
		} catch (SystemException e) {
			e.printStackTrace();
			return "";
		}
		return "redirect:/paper/findAllPaper";
	}
	
	@RequestMapping("/findPaperByTypesID")
	@ResponseBody
	public List<Paper> findPaperByTypesID(Types types){
		List<Paper> papers = null;
		try {
			papers = paperService.findPaperByTypesID(types);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PaperException e) {
			e.printStackTrace();
		} 
		return papers;
	}
	
	@RequestMapping("/deletePaper")
	@ResponseBody
	public String deletePaper(Paper paper){
		try {
			paperService.deletePaper(paper);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PaperException e) {
			return "useing And defeat";
		}
		return "success";
	}
}
