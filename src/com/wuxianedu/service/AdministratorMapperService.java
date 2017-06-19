package com.wuxianedu.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wuxianedu.domain.Administrator;
import com.wuxianedu.exception.AdministratorException;
import com.wuxianedu.mapper.AdministratorMapper;

@Service
public class AdministratorMapperService {

	@Resource
	public AdministratorMapper administratorMapper;
	
	public Administrator adminLogin(Administrator administrator) throws AdministratorException{
		
		Administrator admin = administratorMapper.adminLogin(administrator);
		if(admin == null){
			throw new AdministratorException("没有找到对应用户");
		}
		return admin;
	}
}
