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
import com.jeesite.modules.production.entity.DesignDDD;
import com.jeesite.modules.production.dao.DesignDDDDao;
import com.jeesite.modules.production.entity.DesignPPP;
import com.jeesite.modules.production.dao.DesignPPPDao;

/**
 * 生产管理Service
 * @author wang_bo
 * @version 2022-05-30
 */
@Service
@Transactional(readOnly=true)
public class ProductionManagerService extends CrudService<ProductionManagerDao, ProductionManager> {
	
	@Autowired
	private DesignDDDDao designDDDDao;
	
	@Autowired
	private DesignPPPDao designPPPDao;
	
	/**
	 * 获取单条数据
	 * @param productionManager
	 * @return
	 */
	@Override
	public ProductionManager get(ProductionManager productionManager) {
		ProductionManager entity = super.get(productionManager);
		if (entity != null){
			DesignDDD designDDD = new DesignDDD(entity);
			designDDD.setStatus(DesignDDD.STATUS_NORMAL);
			entity.setDesignDDDList(designDDDDao.findList(designDDD));
			DesignPPP designPPP = new DesignPPP(entity);
			designPPP.setStatus(DesignPPP.STATUS_NORMAL);
			entity.setDesignPPPList(designPPPDao.findList(designPPP));
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
	 * @param designDDD
	 * @param designDDD.page 分页对象
	 * @return
	 */
	public Page<DesignDDD> findSubPage(DesignDDD designDDD) {
		Page<DesignDDD> page = designDDD.getPage();
		page.setList(designDDDDao.findList(designDDD));
		return page;
	}
	
	/**
	 * 查询子表分页数据
	 * @param designPPP
	 * @param designPPP.page 分页对象
	 * @return
	 */
	public Page<DesignPPP> findSubPage(DesignPPP designPPP) {
		Page<DesignPPP> page = designPPP.getPage();
		page.setList(designPPPDao.findList(designPPP));
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
		for (DesignDDD designDDD : productionManager.getDesignDDDList()){
			if (!DesignDDD.STATUS_DELETE.equals(designDDD.getStatus())){
				designDDD.setProductionCode(productionManager);
				if (designDDD.getIsNewRecord()){
					designDDDDao.insert(designDDD);
				}else{
					designDDDDao.update(designDDD);
				}
			}else{
				designDDDDao.delete(designDDD);
			}
		}
		// 保存 ProductionManager子表
		for (DesignPPP designPPP : productionManager.getDesignPPPList()){
			if (!DesignPPP.STATUS_DELETE.equals(designPPP.getStatus())){
				designPPP.setProductId(productionManager);
				if (designPPP.getIsNewRecord()){
					designPPPDao.insert(designPPP);
				}else{
					designPPPDao.update(designPPP);
				}
			}else{
				designPPPDao.delete(designPPP);
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
		DesignDDD designDDD = new DesignDDD();
		designDDD.setProductionCode(productionManager);
		designDDDDao.deleteByEntity(designDDD);
		DesignPPP designPPP = new DesignPPP();
		designPPP.setProductId(productionManager);
		designPPPDao.deleteByEntity(designPPP);
	}
	
}