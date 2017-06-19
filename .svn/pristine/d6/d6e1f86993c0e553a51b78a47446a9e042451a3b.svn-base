package com.wuxianedu.controller;


import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wuxianedu.domain.Item;
import com.wuxianedu.domain.ItemBean;
import com.wuxianedu.domain.QueryBean;
import com.wuxianedu.domain.ResearchItemBean;
import com.wuxianedu.domain.Types;
import com.wuxianedu.exception.ItemException;
import com.wuxianedu.exception.SystemException;
import com.wuxianedu.service.ItemService;
import com.wuxianedu.web.PageBean;

@Controller
public class ItemHandler {

	@Resource
	private ItemService itemService;
	
	//查找所有试题
	@RequestMapping("findAllItem")
	public ModelAndView findAllItem(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		PageBean<Item> pageBean = null;
		QueryBean queryBean=new QueryBean();
		String currentPage=request.getParameter("currentPage");
		if((currentPage==null)||("".equals(currentPage))){
			currentPage="1";
		}
		queryBean.setCurrentPage(Integer.parseInt(currentPage));
		queryBean.setStartIndex((Integer.parseInt(currentPage) - 1) * queryBean.getPageSize());
		try {
			pageBean=itemService.findAllItem(queryBean);
		} catch (ItemException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
			
		}
		mav.addObject("Itemlist",pageBean);
		mav.setViewName("admin/items/showItem");
		return mav;
		
	}
	//添加试题
	@RequestMapping("insertItem")
	public String insertItem(@Valid @ModelAttribute("itemBean")ItemBean itemBean,Errors errors){
		if(errors.hasErrors()){
			return "admin/items/addItem";	
		}
		try {
			Item items=new Item();
			items.setTopic(itemBean.getTopic());
			items.setOptionA(itemBean.getOptionA());
			items.setOptionB(itemBean.getOptionB());
			items.setOptionC(itemBean.getOptionC());
			items.setOptionD(itemBean.getOptionD());
			items.setAnswer(itemBean.getAnswer());
			Types types=new Types();
			types.setId(Integer.parseInt(itemBean.getTypes()));
			items.setTypes(types);
			itemService.insertItem(items);
		} catch (SystemException e) {
			e.printStackTrace();
			return "admin/items/addItem";
		}
		return "redirect:/findAllItem.do";
	}
	
	@RequestMapping("findAItem")
	public ModelAndView findAItem(Item items){
		ModelAndView mav=new ModelAndView();
		Item ite=null;
		try {
			ite=itemService.findAItemById(items);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		ItemBean itemBean=new ItemBean();
		itemBean.setIid(ite.getIid());
		itemBean.setTopic(ite.getTopic());
		itemBean.setOptionA(ite.getOptionA());
		itemBean.setOptionB(ite.getOptionB());
		itemBean.setOptionC(ite.getOptionC());
		itemBean.setOptionD(ite.getOptionD());
		itemBean.setAnswer(ite.getAnswer());
		itemBean.setTypes(ite.getTypes().getId()+"");
		System.out.println();
		mav.addObject("items", itemBean);
		mav.setViewName("admin/items/updateAItem");
		return mav;
	}
	//修改试题
	@RequestMapping("updateItem")
	public String updateItem(@Valid @ModelAttribute("items")ItemBean itemBean,Errors errors){
		ItemHandler its=new ItemHandler();
		itemBean.setTopic(its.encodeStr(itemBean.getTopic()));
		itemBean.setOptionA(its.encodeStr(itemBean.getOptionA()));
		itemBean.setOptionB(its.encodeStr(itemBean.getOptionB()));
		itemBean.setOptionC(its.encodeStr(itemBean.getOptionC()));
		itemBean.setOptionD(its.encodeStr(itemBean.getOptionD()));
		if(errors.hasErrors()){
			return "admin/items/updateAItem";	
		}
		try {
			Item items=new Item();
			items.setIid(itemBean.getIid());
			items.setTopic(itemBean.getTopic());
			items.setOptionA(itemBean.getOptionA());
			items.setOptionB(itemBean.getOptionB());
			items.setOptionC(itemBean.getOptionC());
			items.setOptionD(itemBean.getOptionD());
			items.setAnswer(itemBean.getAnswer());
			Types types=new Types();
			types.setId(Integer.parseInt(itemBean.getTypes()));
			items.setTypes(types);
			itemService.updateItem(items);
		} catch (SystemException e) {
			e.printStackTrace();
			return "admin/items/updateAItem";
		}
		return "redirect:/findAllItem.do";
	}
	
	//删除试题
	@ResponseBody
	@RequestMapping("deleteItem")
	public String deleteItem(Item items){
		try {
			itemService.deleteItem(items);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	
	//按条件查找
	@RequestMapping("findItemByCondition")
	public ModelAndView findItemByCondition( @ModelAttribute("researchItemBean")ResearchItemBean researchItemBean,HttpServletRequest request,HttpSession session){
		ModelAndView mav=new ModelAndView();
		QueryBean queryBean=new QueryBean();
		String currentPage=request.getParameter("currentPage");
		if((currentPage==null)||("".equals(currentPage))){
			currentPage="1";
		}
		queryBean.setCurrentPage(Integer.parseInt(currentPage));
		queryBean.setStartIndex((Integer.parseInt(currentPage) - 1) * queryBean.getPageSize());
		PageBean<Item> pageBean = null;
		try {
			if(researchItemBean.getType_id()!=null&&(!"".equals(researchItemBean.getType_id()))){
				if("0".equals(researchItemBean.getType_id())){
					researchItemBean.setType_id("");
				}
				session.setAttribute("itemsTypes_id",researchItemBean.getType_id());
			}else{
				researchItemBean.setType_id((String) session.getAttribute("itemsTypes_id"));
			}
			//做判断id
			researchItemBean.setQueryBean(queryBean);
			pageBean=itemService.findItemByCondition(researchItemBean);
			
		} catch (ItemException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		mav.addObject("Itemlist",pageBean);
		mav.setViewName("admin/items/showByConditionItem");
		return mav;
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
