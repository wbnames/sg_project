/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.product.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.product.entity.ProductClassify;
import com.jeesite.modules.product.dao.ProductClassifyDao;

/**
 * 产品分类Service
 * @author lyu
 * @version 2022-05-26
 */
@Service
@Transactional(readOnly=true)
public class ProductClassifyService extends CrudService<ProductClassifyDao, ProductClassify> {
	
	/**
	 * 获取单条数据
	 * @param productClassify
	 * @return
	 */
	@Override
	public ProductClassify get(ProductClassify productClassify) {
		return super.get(productClassify);
	}
	
	/**
	 * 查询分页数据
	 * @param productClassify 查询条件
	 * @param productClassify.page 分页对象
	 * @return
	 */
	@Override
	public Page<ProductClassify> findPage(ProductClassify productClassify) {
		return super.findPage(productClassify);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param productClassify
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ProductClassify productClassify) {
		super.save(productClassify);
	}
	
	/**
	 * 更新状态
	 * @param productClassify
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ProductClassify productClassify) {
		super.updateStatus(productClassify);
	}
	
	/**
	 * 删除数据
	 * @param productClassify
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ProductClassify productClassify) {
		super.delete(productClassify);
	}
	
}