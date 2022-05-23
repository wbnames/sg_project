/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.logistics.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.logistics.entity.ShipmentsLogistics;
import com.jeesite.modules.logistics.dao.ShipmentsLogisticsDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 发货管理Service
 * @author wang_bo
 * @version 2022-05-24
 */
@Service
@Transactional(readOnly=true)
public class ShipmentsLogisticsService extends CrudService<ShipmentsLogisticsDao, ShipmentsLogistics> {
	
	/**
	 * 获取单条数据
	 * @param shipmentsLogistics
	 * @return
	 */
	@Override
	public ShipmentsLogistics get(ShipmentsLogistics shipmentsLogistics) {
		return super.get(shipmentsLogistics);
	}
	
	/**
	 * 查询分页数据
	 * @param shipmentsLogistics 查询条件
	 * @param shipmentsLogistics.page 分页对象
	 * @return
	 */
	@Override
	public Page<ShipmentsLogistics> findPage(ShipmentsLogistics shipmentsLogistics) {
		return super.findPage(shipmentsLogistics);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param shipmentsLogistics
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ShipmentsLogistics shipmentsLogistics) {
		super.save(shipmentsLogistics);
		// 保存上传附件
		FileUploadUtils.saveFileUpload(shipmentsLogistics, shipmentsLogistics.getId(), "shipmentsLogistics_file");
	}
	
	/**
	 * 更新状态
	 * @param shipmentsLogistics
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ShipmentsLogistics shipmentsLogistics) {
		super.updateStatus(shipmentsLogistics);
	}
	
	/**
	 * 删除数据
	 * @param shipmentsLogistics
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ShipmentsLogistics shipmentsLogistics) {
		super.delete(shipmentsLogistics);
	}
	
}