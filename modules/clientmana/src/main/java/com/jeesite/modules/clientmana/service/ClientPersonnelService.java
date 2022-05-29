/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.clientmana.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.clientmana.entity.ClientPersonnel;
import com.jeesite.modules.clientmana.dao.ClientPersonnelDao;

/**
 * 单位联系人Service
 * @author lyu
 * @version 2022-05-24
 */
@Service
@Transactional(readOnly=true)
public class ClientPersonnelService extends CrudService<ClientPersonnelDao, ClientPersonnel> {
	
	/**
	 * 获取单条数据
	 * @param clientPersonnel
	 * @return
	 */
	@Override
	public ClientPersonnel get(ClientPersonnel clientPersonnel) {
		return super.get(clientPersonnel);
	}
	
	/**
	 * 查询分页数据
	 * @param clientPersonnel 查询条件
	 * @param clientPersonnel.page 分页对象
	 * @return
	 */
	@Override
	public Page<ClientPersonnel> findPage(ClientPersonnel clientPersonnel) {
		return super.findPage(clientPersonnel);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param clientPersonnel
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ClientPersonnel clientPersonnel) {
		super.save(clientPersonnel);
	}
	
	/**
	 * 更新状态
	 * @param clientPersonnel
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ClientPersonnel clientPersonnel) {
		super.updateStatus(clientPersonnel);
	}
	
	/**
	 * 删除数据
	 * @param clientPersonnel
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ClientPersonnel clientPersonnel) {
		super.delete(clientPersonnel);
	}
	
}