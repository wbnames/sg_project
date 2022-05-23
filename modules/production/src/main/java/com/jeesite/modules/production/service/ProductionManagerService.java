/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.production.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.production.entity.ProductionManager;
import com.jeesite.modules.production.dao.ProductionManagerDao;
import com.jeesite.modules.production.entity.DesignProductProduction;
import com.jeesite.modules.production.dao.DesignProductProductionDao;
import com.jeesite.modules.production.entity.DesignPaperProduction;
import com.jeesite.modules.production.dao.DesignPaperProductionDao;

/**
 * 生产管理Service
 * @author wang_bo
 * @version 2022-05-24
 */
@Service
@Transactional(readOnly=true)
public class ProductionManagerService extends CrudService<ProductionManagerDao, ProductionManager> {
	
	@Autowired
	private DesignProductProductionDao designProductProductionDao;
	
	@Autowired
	private DesignPaperProductionDao designPaperProductionDao;
	
	/**
	 * 获取单条数据
	 * @param productionManager
	 * @return
	 */
	@Override
	public ProductionManager get(ProductionManager productionManager) {
		ProductionManager entity = super.get(productionManager);
		if (entity != null){
			DesignProductProduction designProductProduction = new DesignProductProduction(entity);
			designProductProduction.setStatus(DesignProductProduction.STATUS_NORMAL);
			entity.setDesignProductProductionList(designProductProductionDao.findList(designProductProduction));
			DesignPaperProduction designPaperProduction = new DesignPaperProduction(entity);
			designPaperProduction.setStatus(DesignPaperProduction.STATUS_NORMAL);
			entity.setDesignPaperProductionList(designPaperProductionDao.findList(designPaperProduction));
		}
		return entity;
	}
	
	/**
	 * 查询分页数据
	 * @param productionManager 查询条件
	 * @param productionManager.page 分页对象
	 * @return
	 */
	@Override
	public Page<ProductionManager> findPage(ProductionManager productionManager) {
		return super.findPage(productionManager);
	}
	
	/**
	 * 查询子表分页数据
	 * @param designProductProduction
	 * @param designProductProduction.page 分页对象
	 * @return
	 */
	public Page<DesignProductProduction> findSubPage(DesignProductProduction designProductProduction) {
		Page<DesignProductProduction> page = designProductProduction.getPage();
		page.setList(designProductProductionDao.findList(designProductProduction));
		return page;
	}
	
	/**
	 * 查询子表分页数据
	 * @param designPaperProduction
	 * @param designPaperProduction.page 分页对象
	 * @return
	 */
	public Page<DesignPaperProduction> findSubPage(DesignPaperProduction designPaperProduction) {
		Page<DesignPaperProduction> page = designPaperProduction.getPage();
		page.setList(designPaperProductionDao.findList(designPaperProduction));
		return page;
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param productionManager
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ProductionManager productionManager) {
		super.save(productionManager);
		// 保存 ProductionManager子表
		for (DesignProductProduction designProductProduction : productionManager.getDesignProductProductionList()){
			if (!DesignProductProduction.STATUS_DELETE.equals(designProductProduction.getStatus())){
				designProductProduction.setProductionCode(productionManager);
				if (designProductProduction.getIsNewRecord()){
					designProductProductionDao.insert(designProductProduction);
				}else{
					designProductProductionDao.update(designProductProduction);
				}
			}else{
				designProductProductionDao.delete(designProductProduction);
			}
		}
		// 保存 ProductionManager子表
		for (DesignPaperProduction designPaperProduction : productionManager.getDesignPaperProductionList()){
			if (!DesignPaperProduction.STATUS_DELETE.equals(designPaperProduction.getStatus())){
				designPaperProduction.setProductionCode(productionManager);
				if (designPaperProduction.getIsNewRecord()){
					designPaperProductionDao.insert(designPaperProduction);
				}else{
					designPaperProductionDao.update(designPaperProduction);
				}
			}else{
				designPaperProductionDao.delete(designPaperProduction);
			}
		}
	}
	
	/**
	 * 更新状态
	 * @param productionManager
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ProductionManager productionManager) {
		super.updateStatus(productionManager);
	}
	
	/**
	 * 删除数据
	 * @param productionManager
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ProductionManager productionManager) {
		super.delete(productionManager);
		DesignProductProduction designProductProduction = new DesignProductProduction();
		designProductProduction.setProductionCode(productionManager);
		designProductProductionDao.deleteByEntity(designProductProduction);
		DesignPaperProduction designPaperProduction = new DesignPaperProduction();
		designPaperProduction.setProductionCode(productionManager);
		designPaperProductionDao.deleteByEntity(designPaperProduction);
	}
	
}