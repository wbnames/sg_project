/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.factmana.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.factmana.entity.FactoryManufacturer;
import com.jeesite.modules.factmana.dao.FactoryManufacturerDao;

/**
 * 生产厂商Service
 * @author lyu
 * @version 2022-05-24
 */
@Service
@Transactional(readOnly=true)
public class FactoryManufacturerService extends CrudService<FactoryManufacturerDao, FactoryManufacturer> {
	
	/**
	 * 获取单条数据
	 * @param factoryManufacturer
	 * @return
	 */
	@Override
	public FactoryManufacturer get(FactoryManufacturer factoryManufacturer) {
		return super.get(factoryManufacturer);
	}
	
	/**
	 * 查询分页数据
	 * @param factoryManufacturer 查询条件
	 * @param factoryManufacturer.page 分页对象
	 * @return
	 */
	@Override
	public Page<FactoryManufacturer> findPage(FactoryManufacturer factoryManufacturer) {
		return super.findPage(factoryManufacturer);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param factoryManufacturer
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(FactoryManufacturer factoryManufacturer) {
		super.save(factoryManufacturer);
	}
	
	/**
	 * 更新状态
	 * @param factoryManufacturer
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(FactoryManufacturer factoryManufacturer) {
		super.updateStatus(factoryManufacturer);
	}
	
	/**
	 * 删除数据
	 * @param factoryManufacturer
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(FactoryManufacturer factoryManufacturer) {
		super.delete(factoryManufacturer);
	}
	
}