package com.wuxianedu.service;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wuxianedu.domain.Exam;
import com.wuxianedu.domain.Item;
import com.wuxianedu.domain.Paper;
import com.wuxianedu.domain.PaperCondition;
import com.wuxianedu.domain.QueryBean;
import com.wuxianedu.domain.Types;
import com.wuxianedu.exception.PaperException;
import com.wuxianedu.exception.SystemException;
import com.wuxianedu.mapper.ExamMapper;
import com.wuxianedu.mapper.ItemMapper;
import com.wuxianedu.mapper.PaperMapper;
import com.wuxianedu.web.PageBean;
import com.wuxianedu.web.QueryResult;

@Service
public class PaperService {
	
	@Resource
	private ExamMapper examMapper;
	
	@Resource
	private PaperMapper paperMapper;
	
	@Resource
	private ItemMapper itemMapper;
	
	// 查找所有试卷
	public PageBean<Paper> findAllPaper(QueryBean queryBean) throws PaperException, SystemException{
		QueryResult<Paper> queryResult = new QueryResult<Paper>();
		long countAll;
		List<Paper> papers = null;
		try {
			papers = paperMapper.findAllPaper(queryBean);
			queryResult.setList(papers);
			countAll = paperMapper.countAllPaper();
			queryResult.setTotalRecord((int)countAll);
		} catch (Exception e) {
			throw new SystemException("系统错误");
		}
		if(queryResult.getTotalRecord() == 0){
			throw new PaperException("查找所有数据为空！");
		}
		PageBean<Paper> pageBean = new PageBean<Paper>();
		pageBean.setList(queryResult.getList());
		pageBean.setCurrentPage(queryBean.getCurrentPage());
		pageBean.setPageSize(queryBean.getPageSize());
		pageBean.setTotalRecord(queryResult.getTotalRecord());
		
		if(pageBean.getCurrentPage() > pageBean.getTotalPage()){
			queryBean.setCurrentPage(pageBean.getTotalPage());
			List<Paper> list =(List<Paper>) paperMapper.findAllPaper(queryBean);
			queryResult.setList(list);
			pageBean.setCurrentPage(queryBean.getCurrentPage());
			pageBean.setList(queryResult.getList());
		}
		return pageBean;
	}
	
	// 预览试卷
	public Paper findPaperAndItem(Paper paper) throws PaperException, SystemException{
		Paper papers = null;
		try {
			papers = paperMapper.findPaperAndItem(paper);
			
		} catch (Exception e) {
			throw new SystemException("系统错误");
		}
		if(papers == null){
			throw new PaperException("没有试卷");
		}
		return papers;
	}
	
	// 根据条件查询试卷
	public PageBean<Paper> findPaperByNameOrTypes(PaperCondition paperCondition) throws PaperException, SystemException{
		QueryResult<Paper> queryResult = new QueryResult<Paper>();
		QueryBean queryBean = paperCondition.getQueryBean();
		long count;
		List<Paper> papers = null;
		try {
			papers = paperMapper.findPaperByNameOrTypes(paperCondition);
			queryResult.setList(papers);
			count = paperMapper.countPaperByNameOrTypes(paperCondition);
			queryResult.setTotalRecord((int)count);
		} catch (Exception e) {
			throw new SystemException("系统错误");
		}
		if(queryResult.getTotalRecord() == 0){
			throw new PaperException("查找该类数据为空！");
		}
		PageBean<Paper> pageBean = new PageBean<Paper>();
		pageBean.setList(queryResult.getList());
		pageBean.setCurrentPage(queryBean.getCurrentPage());
		pageBean.setPageSize(queryBean.getPageSize());
		pageBean.setTotalRecord(queryResult.getTotalRecord());
		
		if(pageBean.getCurrentPage() > pageBean.getTotalPage()){
			queryBean.setCurrentPage(pageBean.getTotalPage());
			List<Paper> list =(List<Paper>) paperMapper.findPaperByNameOrTypes(paperCondition);
			queryResult.setList(list);
			pageBean.setCurrentPage(queryBean.getCurrentPage());
			pageBean.setList(queryResult.getList());
		}
		return pageBean;
	}
	
	// 创建新的试卷
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={SystemException.class})
	public void createPaper(Paper paper) throws SystemException, PaperException{
		Set<Item> items = itemMapper.findItemCreatePaper(paper);
		if(items == null){
			throw new PaperException("没有试题");
		}
		try {
			// 创建一个paper记录  并将插入后生成的主键返还至参数
			paperMapper.createBlankPaper(paper);
			
			PaperCondition paperCondition = new PaperCondition();
			for (Item item : items) {
				paperCondition.setPid(paper.getPid());
				paperCondition.setIid(item.getIid());
				paperMapper.createPaper(paperCondition);
			}
		} catch (Exception e) {
			throw new SystemException("系统错误");
		}
	}
	
	// 修改试卷
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={SystemException.class})
	public void updatePaper(Paper paper) throws SystemException{
		try {
			paperMapper.updatePaper(paper);
		} catch (Exception e) {
			throw new SystemException("系统错误");
		}
	}
	
	// 根据试卷类型查询
	public List<Paper> findPaperByTypesID(Types types) throws SystemException, PaperException{
		List<Paper> papers = null;
		try {
			papers = paperMapper.findPaperByTypesID(types);
		} catch (Exception e) {
			throw new SystemException("系统错误： PaperService-----findPaperByTypesID" + e);
		}
		if(papers == null){
			throw new PaperException("没有该类型试卷");
		}
		return papers;
	}
	
	// 删除试卷
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={SystemException.class})
	public void deletePaper(Paper paper) throws SystemException, PaperException{
		List<Exam> exams = examMapper.findExamByPaperId(paper);
		if(!exams.isEmpty()){
			throw new PaperException("该试卷正被使用无法删除");
		}else{
			try{
				paperMapper.deletePaperItem(paper);
				paperMapper.deletePaper(paper);
			}catch(Exception e){
				throw new SystemException("数据库错误-PaperService-deletepaper"+e);
			}
		}
	}
	
}
