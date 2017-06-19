package com.wuxianedu.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuxianedu.domain.Item;
import com.wuxianedu.domain.QueryBean;
import com.wuxianedu.domain.ResearchItemBean;
import com.wuxianedu.exception.ItemException;
import com.wuxianedu.exception.SystemException;
import com.wuxianedu.mapper.ItemMapper;
import com.wuxianedu.web.PageBean;
import com.wuxianedu.web.QueryResult;

@Service
public class ItemService {
	
	@Resource
	private ItemMapper itemMapper;
	
	public PageBean<Item> findAllItem(QueryBean queryBean) throws ItemException, SystemException{
		QueryResult<Item> queryResult=new QueryResult<Item>();
		long countAll;
		try{
			List<Item> list =(List<Item>) itemMapper.findAllItem(queryBean);
			queryResult.setList(list);
			countAll=itemMapper.countAllItem();
			queryResult.setTotalRecord((int)countAll);
		}catch(Exception e){
			e.printStackTrace();
			throw new SystemException("数据库查找错误-ItemService-findAllItem"+e);
		}
		PageBean<Item> pageBean = new PageBean<Item>();
		pageBean.setCurrentPage(queryBean.getCurrentPage());
		pageBean.setPageSize(queryBean.getPageSize());
		pageBean.setList(queryResult.getList());
		pageBean.setTotalRecord(queryResult.getTotalRecord());
		if(queryResult.getTotalRecord() == 0){
			throw new ItemException("查找所有数据为空！");
		}
		if(pageBean.getCurrentPage() > pageBean.getTotalPage()){
			queryBean.setCurrentPage(pageBean.getTotalPage());
			List<Item> list =(List<Item>) itemMapper.findAllItem(queryBean);
			queryResult.setList(list);
			pageBean.setCurrentPage(queryBean.getCurrentPage());
			pageBean.setList(queryResult.getList());
		}
		return pageBean;
	}
	
	public PageBean<Item> findItemByCondition(ResearchItemBean researchItemBean) throws ItemException, SystemException{
		QueryResult<Item> queryResult=new QueryResult<Item>();
		long countAll;
		try{
			List<Item> list =itemMapper.findItemByCondition(researchItemBean);
			queryResult.setList(list);
			countAll=itemMapper.countItemByCondition(researchItemBean);
			queryResult.setTotalRecord((int)countAll);
		}catch(Exception e){
			e.printStackTrace();
			throw new SystemException("数据库错误-ItemService-findItemByCondition"+e);
		}
		PageBean<Item> pageBean = new PageBean<Item>();
		QueryBean queryBean=researchItemBean.getQueryBean();
		pageBean.setCurrentPage(queryBean.getCurrentPage());
		pageBean.setPageSize(queryBean.getPageSize());
		pageBean.setList(queryResult.getList());
		pageBean.setTotalRecord(queryResult.getTotalRecord());
		if(queryResult.getTotalRecord() == 0){
			throw new ItemException("查找条件数据为空！");
		}
		if(pageBean.getCurrentPage() > pageBean.getTotalPage()){
			queryBean.setCurrentPage(pageBean.getTotalPage());
			List<Item> list =(List<Item>) itemMapper.findItemByCondition(researchItemBean);
			queryResult.setList(list);
			pageBean.setCurrentPage(queryBean.getCurrentPage());
			pageBean.setList(queryResult.getList());
		}
		return pageBean;
	}
	
	public Item findAItemById(Item items) throws SystemException{
		Item ite=null;
		try{
			ite=itemMapper.findAItem(items);
		}catch(Exception e){
			throw new SystemException("数据库错误-ItemService-findAItemById"+e);
		}
		return ite;
		
	}
	public void insertItem(Item items) throws SystemException{
		try{
			itemMapper.insertItem(items);
		}catch(Exception e){
			throw new SystemException("数据库错误-ItemService-insertItem"+e);
		}
	}
	
	public void updateItem(Item items) throws SystemException{
		try{
			itemMapper.updateItem(items);
		}catch(Exception e){
			throw new SystemException("数据库错误-ItemService-updateItem"+e);
		}
		
	}
	
	public void deleteItem(Item items) throws SystemException{
		try{
			itemMapper.deleteItem(items);
		}catch(Exception e){
			throw new SystemException("数据库错误-ItemService-deleteItem"+e);
		}
		
	}
	
	
	
	
//	public static void main(String[] args) {
//		AbstractApplicationContext context=new ClassPathXmlApplicationContext("com/wuxianedu/config/applicationContext.xml");
//		ItemService ser=(ItemService) context.getBean("itemService");
//		System.out.println(ser);
//		System.out.println(ser.findAllItem());
//		for (Item a : ser.findAllItem()) {
//			System.out.println(a.getTopic());
//		}
//	}

}
