package com.wuxianedu.service;

import java.util.List;

import javax.annotation.Resource;



import org.springframework.stereotype.Service;

import com.wuxianedu.domain.Types;
import com.wuxianedu.exception.SystemException;
import com.wuxianedu.mapper.TypesAndItemMapper;

@Service
public class GetTypesService {
	
	@Resource
	private TypesAndItemMapper typesAndItemMapper;
	
	public List<Types> getTypesAll() throws SystemException{
		List<Types> list=null;
		try{
			list=typesAndItemMapper.getTypes();
		}catch(Exception e){
			throw new SystemException("ϵͳ�쳣+GetTypesService+getTypesAll"+e);
		}
		return list;
	}

}
