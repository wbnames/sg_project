/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.constru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.constru.entity.ConstruTask;
import com.jeesite.modules.constru.dao.ConstruTaskDao;
import com.jeesite.modules.file.utils.FileUploadUtils;
import com.jeesite.modules.constru.entity.DesignPaperCopy1;
import com.jeesite.modules.constru.dao.DesignPaperCopy1Dao;
import com.jeesite.modules.constru.entity.ProductClassifyCopy1;
import com.jeesite.modules.constru.dao.ProductClassifyCopy1Dao;
import com.jeesite.modules.constru.entity.ConstructionTeamCopy1;
import com.jeesite.modules.constru.dao.ConstructionTeamCopy1Dao;

/**
 * 施工任务Service
 * @author lyu
 * @version 2022-06-06
 */
@Service
@Transactional(readOnly=true)
public class ConstruTaskService extends CrudService<ConstruTaskDao, ConstruTask> {
	
	@Autowired
	private DesignPaperCopy1Dao designPaperCopy1Dao;
	
	@Autowired
	private ProductClassifyCopy1Dao productClassifyCopy1Dao;
	
	@Autowired
	private ConstructionTeamCopy1Dao constructionTeamCopy1Dao;
	
	/**
	 * 获取单条数据
	 * @param construTask
	 * @return
	 */
	@Override
	public ConstruTask get(ConstruTask construTask) {
		ConstruTask entity = super.get(construTask);
		if (entity != null){
			DesignPaperCopy1 designPaperCopy1 = new DesignPaperCopy1(entity);
			designPaperCopy1.setStatus(DesignPaperCopy1.STATUS_NORMAL);
			entity.setDesignPaperCopy1List(designPaperCopy1Dao.findList(designPaperCopy1));
			ProductClassifyCopy1 productClassifyCopy1 = new ProductClassifyCopy1(entity);
			productClassifyCopy1.setStatus(ProductClassifyCopy1.STATUS_NORMAL);
			entity.setProductClassifyCopy1List(productClassifyCopy1Dao.findList(productClassifyCopy1));
			ConstructionTeamCopy1 constructionTeamCopy1 = new ConstructionTeamCopy1(entity);
			constructionTeamCopy1.setStatus(ConstructionTeamCopy1.STATUS_NORMAL);
			entity.setConstructionTeamCopy1List(constructionTeamCopy1Dao.findList(constructionTeamCopy1));
		}
		return entity;
	}
	
	/**
	 * 查询分页数据
	 * @param construTask 查询条件
	 * @param construTask.page 分页对象
	 * @return
	 */
	@Override
	public Page<ConstruTask> findPage(ConstruTask construTask) {
		return super.findPage(construTask);
	}
	
	/**
	 * 查询子表分页数据
	 * @param designPaperCopy1
	 * @param designPaperCopy1.page 分页对象
	 * @return
	 */
	public Page<DesignPaperCopy1> findSubPage(DesignPaperCopy1 designPaperCopy1) {
		Page<DesignPaperCopy1> page = designPaperCopy1.getPage();
		page.setList(designPaperCopy1Dao.findList(designPaperCopy1));
		return page;
	}
	
	/**
	 * 查询子表分页数据
	 * @param productClassifyCopy1
	 * @param productClassifyCopy1.page 分页对象
	 * @return
	 */
	public Page<ProductClassifyCopy1> findSubPage(ProductClassifyCopy1 productClassifyCopy1) {
		Page<ProductClassifyCopy1> page = productClassifyCopy1.getPage();
		page.setList(productClassifyCopy1Dao.findList(productClassifyCopy1));
		return page;
	}
	
	/**
	 * 查询子表分页数据
	 * @param constructionTeamCopy1
	 * @param constructionTeamCopy1.page 分页对象
	 * @return
	 */
	public Page<ConstructionTeamCopy1> findSubPage(ConstructionTeamCopy1 constructionTeamCopy1) {
		Page<ConstructionTeamCopy1> page = constructionTeamCopy1.getPage();
		page.setList(constructionTeamCopy1Dao.findList(constructionTeamCopy1));
		return page;
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param construTask
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ConstruTask construTask) {
		super.save(construTask);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(construTask, construTask.getId(), "construTask_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(construTask, construTask.getId(), "construTask_file");
		// 保存 ConstruTask子表
		for (DesignPaperCopy1 designPaperCopy1 : construTask.getDesignPaperCopy1List()){
			if (!DesignPaperCopy1.STATUS_DELETE.equals(designPaperCopy1.getStatus())){
				designPaperCopy1.setProductionCode(construTask);
				if (designPaperCopy1.getIsNewRecord()){
					designPaperCopy1Dao.insert(designPaperCopy1);
				}else{
					designPaperCopy1Dao.update(designPaperCopy1);
				}
			}else{
				designPaperCopy1Dao.delete(designPaperCopy1);
			}
		}
		// 保存 ConstruTask子表
		for (ProductClassifyCopy1 productClassifyCopy1 : construTask.getProductClassifyCopy1List()){
			if (!ProductClassifyCopy1.STATUS_DELETE.equals(productClassifyCopy1.getStatus())){
				productClassifyCopy1.setCntruId(construTask);
				if (productClassifyCopy1.getIsNewRecord()){
					productClassifyCopy1Dao.insert(productClassifyCopy1);
				}else{
					productClassifyCopy1Dao.update(productClassifyCopy1);
				}
			}else{
				productClassifyCopy1Dao.delete(productClassifyCopy1);
			}
		}
		// 保存 ConstruTask子表
		for (ConstructionTeamCopy1 constructionTeamCopy1 : construTask.getConstructionTeamCopy1List()){
			if (!ConstructionTeamCopy1.STATUS_DELETE.equals(constructionTeamCopy1.getStatus())){
				constructionTeamCopy1.setConstruId(construTask);
				if (constructionTeamCopy1.getIsNewRecord()){
					constructionTeamCopy1Dao.insert(constructionTeamCopy1);
				}else{
					constructionTeamCopy1Dao.update(constructionTeamCopy1);
				}
			}else{
				constructionTeamCopy1Dao.delete(constructionTeamCopy1);
			}
		}
	}
	
	/**
	 * 更新状态
	 * @param construTask
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ConstruTask construTask) {
		super.updateStatus(construTask);
	}
	
	/**
	 * 删除数据
	 * @param construTask
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ConstruTask construTask) {
		super.delete(construTask);
		DesignPaperCopy1 designPaperCopy1 = new DesignPaperCopy1();
		designPaperCopy1.setProductionCode(construTask);
		designPaperCopy1Dao.deleteByEntity(designPaperCopy1);
		ProductClassifyCopy1 productClassifyCopy1 = new ProductClassifyCopy1();
		productClassifyCopy1.setCntruId(construTask);
		productClassifyCopy1Dao.deleteByEntity(productClassifyCopy1);
		ConstructionTeamCopy1 constructionTeamCopy1 = new ConstructionTeamCopy1();
		constructionTeamCopy1.setConstruId(construTask);
		constructionTeamCopy1Dao.deleteByEntity(constructionTeamCopy1);
	}
	
}