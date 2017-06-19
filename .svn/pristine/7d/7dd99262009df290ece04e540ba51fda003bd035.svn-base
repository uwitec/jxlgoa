package com.wuxianedu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wuxianedu.domain.QueryBean;
import com.wuxianedu.domain.Trainer;
import com.wuxianedu.mapper.TrainerMapper;
import com.wuxianedu.web.PageBean;
import com.wuxianedu.web.QueryResult;

@Transactional
@Service
public class TrainerMapperService {

	@Resource
	private TrainerMapper trainerMapper;
	
	public List<Trainer> listAllTrainer(){
		return trainerMapper.listAllTrainer();
	}
	
	public void updateTrainer(Trainer trainer){
		trainerMapper.updateTrainer(trainer);
	}
	
	public void insertTrainer(Trainer trainer){
		trainerMapper.insertTrainer(trainer);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void endClass(Trainer trainer){
		 trainerMapper.endClass(trainer);
	}
	
	public void leaveJob(Trainer trainer){
		trainerMapper.leaveJob(trainer);
	}
	
	public List<Trainer>searchTrainer(Trainer trainer){
		return trainerMapper.searchTrainer(trainer);
	}
	
	public Trainer findTrainerById(int id){
		return trainerMapper.findTrainerById(id);
	}
	
	public Long countTrainer(){
		return trainerMapper.countTrainer();
	}
	
	
	
	public List<Trainer> showTrainerByPage(QueryBean queryBean){
		return trainerMapper.showTrainerByPage(queryBean);
	}
	
	public QueryResult<Trainer> queryResult(QueryBean queryBean){
		QueryResult<Trainer>result = new QueryResult<Trainer>();
		Long totalNum = countTrainer();
		int num = (int)totalNum.intValue();
		result.setTotalRecord(num);
		List<Trainer>list = showTrainerByPage(queryBean);
		result.setList(list);
		return result;
	}
	
	public PageBean<Trainer>  pageBean(QueryBean queryBean){
		
		QueryResult<Trainer> result = queryResult(queryBean);
		PageBean<Trainer> pageBean = new PageBean<Trainer>();
		pageBean.setCurrentPage(queryBean.getCurrentPage());
		pageBean.setList(result.getList());
		pageBean.setPageSize(queryBean.getPageSize());
		pageBean.setTotalRecord(result.getTotalRecord());
		return pageBean;
	}
	
	public Long countSearchTrainerByPage(QueryBean queryBean){
		return trainerMapper.countSearchTrainerByPage(queryBean);
	}
	
	public List<Trainer> searchTrainerByPage(QueryBean queryBean){
		return trainerMapper.searchTrainerByPage(queryBean);
	}
	
	public QueryResult<Trainer> searchResult(QueryBean queryBean){
		QueryResult<Trainer>result = new QueryResult<Trainer>();
		Long totalNum = countSearchTrainerByPage(queryBean);
		int num = (int)totalNum.intValue();
		result.setTotalRecord(num);
		List<Trainer>list = searchTrainerByPage(queryBean);
		result.setList(list);
		return result;
	}
	
	public PageBean<Trainer> searchPageBean(QueryBean queryBean){
		QueryResult<Trainer> result = searchResult(queryBean);
		PageBean<Trainer> pageBean = new PageBean<Trainer>();
		pageBean.setCurrentPage(queryBean.getCurrentPage());
		pageBean.setList(result.getList());
		pageBean.setPageSize(queryBean.getPageSize());
		pageBean.setTotalRecord(result.getTotalRecord());
		return pageBean;
	}
	
	
}
