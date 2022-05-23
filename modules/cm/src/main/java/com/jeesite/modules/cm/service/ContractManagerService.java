/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.cm.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.cm.entity.ContractManager;
import com.jeesite.modules.cm.dao.ContractManagerDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 合同管理Service
 * @author wang_bo
 * @version 2022-05-23
 */
@Service
@Transactional(readOnly=true)
public class ContractManagerService extends CrudService<ContractManagerDao, ContractManager> {
	
	/**
	 * 获取单条数据
	 * @param contractManager
	 * @return
	 */
	@Override
	public ContractManager get(ContractManager contractManager) {
		return super.get(contractManager);
	}
	
	/**
	 * 查询分页数据
	 * @param contractManager 查询条件
	 * @param contractManager.page 分页对象
	 * @return
	 */
	@Override
	public Page<ContractManager> findPage(ContractManager contractManager) {
		return super.findPage(contractManager);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param contractManager
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ContractManager contractManager) {
		super.save(contractManager);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(contractManager, contractManager.getId(), "contractManager_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(contractManager, contractManager.getId(), "contractManager_file");
	}
	
	/**
	 * 更新状态
	 * @param contractManager
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ContractManager contractManager) {
		super.updateStatus(contractManager);
	}
	
	/**
	 * 删除数据
	 * @param contractManager
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ContractManager contractManager) {
		super.delete(contractManager);
	}
	
}