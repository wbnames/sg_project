/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.design.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.design.entity.DesignPaper;
import com.jeesite.modules.design.dao.DesignPaperDao;
import com.jeesite.modules.file.utils.FileUploadUtils;
import com.jeesite.modules.design.entity.DesignPP;
import com.jeesite.modules.design.dao.DesignPPDao;

/**
 * 设计图纸Service
 * @author wang_bo
 * @version 2022-05-30
 */
@Service
@Transactional(readOnly=true)
public class DesignPaperService extends CrudService<DesignPaperDao, DesignPaper> {
	
	@Autowired
	private DesignPPDao designPPDao;
	
	/**
	 * 获取单条数据
	 * @param designPaper
	 * @return
	 */
	@Override
	public DesignPaper get(DesignPaper designPaper) {
		DesignPaper entity = super.get(designPaper);
		if (entity != null){
			DesignPP designPP = new DesignPP(entity);
			designPP.setStatus(DesignPP.STATUS_NORMAL);
			entity.setDesignPPList(designPPDao.findList(designPP));
		}
		return entity;
	}
	
	/**
	 * 查询分页数据
	 * @param designPaper 查询条件
	 * @param designPaper.page 分页对象
	 * @return
	 */
	@Override
	public Page<DesignPaper> findPage(DesignPaper designPaper) {
		return super.findPage(designPaper);
	}
	
	/**
	 * 查询子表分页数据
	 * @param designPP
	 * @param designPP.page 分页对象
	 * @return
	 */
	public Page<DesignPP> findSubPage(DesignPP designPP) {
		Page<DesignPP> page = designPP.getPage();
		page.setList(designPPDao.findList(designPP));
		return page;
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param designPaper
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(DesignPaper designPaper) {
		super.save(designPaper);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(designPaper, designPaper.getId(), "designPaper_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(designPaper, designPaper.getId(), "designPaper_file");
		// 保存 DesignPaper子表
		for (DesignPP designPP : designPaper.getDesignPPList()){
			if (!DesignPP.STATUS_DELETE.equals(designPP.getStatus())){
				designPP.setProductionCode(designPaper);
				if (designPP.getIsNewRecord()){
					designPPDao.insert(designPP);
				}else{
					designPPDao.update(designPP);
				}
			}else{
				designPPDao.delete(designPP);
			}
		}
	}
	
	/**
	 * 更新状态
	 * @param designPaper
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(DesignPaper designPaper) {
		super.updateStatus(designPaper);
	}
	
	/**
	 * 删除数据
	 * @param designPaper
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(DesignPaper designPaper) {
		super.delete(designPaper);
		DesignPP designPP = new DesignPP();
		designPP.setProductionCode(designPaper);
		designPPDao.deleteByEntity(designPP);
	}
	
}