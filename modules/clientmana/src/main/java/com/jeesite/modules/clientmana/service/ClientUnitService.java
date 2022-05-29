/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.clientmana.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.clientmana.entity.ClientUnit;
import com.jeesite.modules.clientmana.dao.ClientUnitDao;

/**
 * 客户单位Service
 * @author lyu
 * @version 2022-05-24
 */
@Service
@Transactional(readOnly=true)
public class ClientUnitService extends CrudService<ClientUnitDao, ClientUnit> {
	
	/**
	 * 获取单条数据
	 * @param clientUnit
	 * @return
	 */
	@Override
	public ClientUnit get(ClientUnit clientUnit) {
		return super.get(clientUnit);
	}
	
	/**
	 * 查询分页数据
	 * @param clientUnit 查询条件
	 * @param clientUnit.page 分页对象
	 * @return
	 */
	@Override
	public Page<ClientUnit> findPage(ClientUnit clientUnit) {
		return super.findPage(clientUnit);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param clientUnit
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ClientUnit clientUnit) {
		super.save(clientUnit);
	}
	
	/**
	 * 更新状态
	 * @param clientUnit
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ClientUnit clientUnit) {
		super.updateStatus(clientUnit);
	}
	
	/**
	 * 删除数据
	 * @param clientUnit
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ClientUnit clientUnit) {
		super.delete(clientUnit);
	}
	
}