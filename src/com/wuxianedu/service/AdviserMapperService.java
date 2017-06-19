package com.wuxianedu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuxianedu.domain.Adviser;
import com.wuxianedu.domain.QueryBean;
import com.wuxianedu.domain.Trainer;
import com.wuxianedu.mapper.AdviserMapper;
import com.wuxianedu.web.PageBean;
import com.wuxianedu.web.QueryResult;

@Service
public class AdviserMapperService {
	
	@Resource
	private AdviserMapper adviserMapper;
	
	public List<Adviser> listAllAdviser(){
		return adviserMapper.listAllAdviser();
	}
	
	public void insertAdviser(Adviser adviser){
		adviserMapper.insertAdviser(adviser);
	}
	
	public void updateAdviser(Adviser adviser){
		adviserMapper.updateAdviser(adviser);
	}
	
	public List<Adviser>searchAdviser(Adviser adviser){
		return adviserMapper.searchAdviser(adviser);
	}
	
	public Adviser findAdviserById(int id){
		return adviserMapper.findAdviserById(id);
	}
	
	public void changeStatue(Adviser adviser){
		adviserMapper.changeStatue(adviser);
	}
	
	public Long countAdviser(){
		return adviserMapper.countAdviser();
	}
	
	public List<Adviser> listAdviserByLimit(QueryBean queryBean){
		return adviserMapper.showAdviserByPage(queryBean);
	}
	
	public QueryResult<Adviser> queryResult(QueryBean queryBean){
		
		QueryResult<Adviser> result = new QueryResult<Adviser>();
		Long totalNum = countAdviser();
		int num = (int)totalNum.intValue();
		result.setTotalRecord(num);
		List<Adviser>list = listAdviserByLimit(queryBean);
		result.setList(list);
		return result;
	}
	
	public PageBean<Adviser> pageBean(QueryBean queryBean){
		
		QueryResult<Adviser> result = queryResult(queryBean);
		PageBean<Adviser> pageBean = new PageBean<Adviser>();
		pageBean.setCurrentPage(queryBean.getCurrentPage());
		pageBean.setList(result.getList());
		pageBean.setPageSize(queryBean.getPageSize());
		pageBean.setTotalRecord(result.getTotalRecord());
		return pageBean;
	}
	
	
	public Long countSearchAdviserByPage(QueryBean queryBean){
		return adviserMapper.countSearchAdviserByPage(queryBean);
	}
	public List<Adviser> searchAdviser(QueryBean queryBean){
		return adviserMapper.searchAdviserByPage(queryBean);
	}
	
	public QueryResult<Adviser> querySearchResult(QueryBean queryBean){
		QueryResult<Adviser> result = new QueryResult<Adviser>();
		Long totalNum = countSearchAdviserByPage(queryBean);
		
		int num = (int)totalNum.intValue();
		result.setTotalRecord(num);
		List<Adviser>list = searchAdviser(queryBean);
		result.setList(list);
		return result;
	}
	
	public PageBean<Adviser> searchPageBean(QueryBean queryBean){
		QueryResult<Adviser> result = querySearchResult(queryBean);
		PageBean<Adviser> pageBean = new PageBean<Adviser>();
		pageBean.setCurrentPage(queryBean.getCurrentPage());
		pageBean.setList(result.getList());
		pageBean.setPageSize(queryBean.getPageSize());
		pageBean.setTotalRecord(result.getTotalRecord());
		return pageBean;
	}
}
