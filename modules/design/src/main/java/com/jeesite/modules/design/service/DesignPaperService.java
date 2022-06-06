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
import com.jeesite.modules.design.entity.DesignFFF;
import com.jeesite.modules.design.dao.DesignFFFDao;

/**
 * 设计图纸Service
 * @author wang_bo
 * @version 2022-06-06
 */
@Service
@Transactional(readOnly=true)
public class DesignPaperService extends CrudService<DesignPaperDao, DesignPaper> {
	
	@Autowired
	private DesignFFFDao designFFFDao;
	
	/**
	 * 获取单条数据
	 * @param designPaper
	 * @return
	 */
	@Override
	public DesignPaper get(DesignPaper designPaper) {
		DesignPaper entity = super.get(designPaper);
		if (entity != null){
			DesignFFF designFFF = new DesignFFF(entity);
			designFFF.setStatus(DesignFFF.STATUS_NORMAL);
			entity.setDesignFFFList(designFFFDao.findList(designFFF));
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
	 * @param designFFF
	 * @param designFFF.page 分页对象
	 * @return
	 */
	public Page<DesignFFF> findSubPage(DesignFFF designFFF) {
		Page<DesignFFF> page = designFFF.getPage();
		page.setList(designFFFDao.findList(designFFF));
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
		for (DesignFFF designFFF : designPaper.getDesignFFFList()){
			if (!DesignFFF.STATUS_DELETE.equals(designFFF.getStatus())){
				designFFF.setProductId(designPaper);
				if (designFFF.getIsNewRecord()){
					designFFFDao.insert(designFFF);
				}else{
					designFFFDao.update(designFFF);
				}
			}else{
				designFFFDao.delete(designFFF);
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
		DesignFFF designFFF = new DesignFFF();
		designFFF.setProductId(designPaper);
		designFFFDao.deleteByEntity(designFFF);
	}
	
}