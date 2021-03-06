package com.wuxianedu.mapper;

import java.util.List;

import com.wuxianedu.domain.Adviser;
import com.wuxianedu.domain.QueryBean;



public interface AdviserMapper {
	
	public List<Adviser>listAllAdviser();
	
	public void insertAdviser(Adviser adviser);
	
	public void updateAdviser(Adviser adviser);
	
	public List<Adviser>searchAdviser(Adviser adviser);
	
	public Adviser findAdviserById(int id);
	
	public void changeStatue(Adviser adviser);
	
	public Long countAdviser();
	
	public List<Adviser> showAdviserByPage(QueryBean queryBean);
	
	//��̬����
	public Long countSearchAdviserByPage(QueryBean queryBean);
	
	public List<Adviser> searchAdviserByPage(QueryBean queryBean);
	
	
}
