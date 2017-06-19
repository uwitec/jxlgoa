package com.wuxianedu.mapper;

import java.util.List;

import com.wuxianedu.domain.Paper;
import com.wuxianedu.domain.PaperCondition;
import com.wuxianedu.domain.QueryBean;
import com.wuxianedu.domain.Types;

public interface PaperMapper {

	// 查找所有试卷
	public List<Paper> findAllPaper(QueryBean queryBean);
	
	// 查询多有试卷数量
	public long countAllPaper();
	
	// 预览试卷
	public Paper findPaperAndItem(Paper paper);
	
	// 根据条件查找试卷
	public List<Paper> findPaperByNameOrTypes(PaperCondition paperCondition);
	
	// 根据条件查询有多少试卷
	public long countPaperByNameOrTypes(PaperCondition paperCondition);
	
	// 创建空白试卷
	public void createBlankPaper(Paper paper);
	
	// 创建完整试卷--将空白试卷与试题关系起来
	public void createPaper(PaperCondition paperCondition);
	
	// 更新试卷
	public void updatePaper(Paper paper);
	
	// 根据试卷类型查询
	public List<Paper> findPaperByTypesID(Types types);
	
	// 删除试卷与试题的关系
		public void deletePaperItem(Paper paper);
	
	// 删除试卷
	public void deletePaper(Paper paper);
}
