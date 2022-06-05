/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.cm.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.cm.entity.PaymentPlan;
import com.jeesite.modules.cm.dao.PaymentPlanDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 收款计划Service
 * @author wang_bo
 * @version 2022-06-06
 */
@Service
@Transactional(readOnly=true)
public class PaymentPlanService extends CrudService<PaymentPlanDao, PaymentPlan> {
	
	/**
	 * 获取单条数据
	 * @param paymentPlan
	 * @return
	 */
	@Override
	public PaymentPlan get(PaymentPlan paymentPlan) {
		return super.get(paymentPlan);
	}
	
	/**
	 * 查询分页数据
	 * @param paymentPlan 查询条件
	 * @param paymentPlan.page 分页对象
	 * @return
	 */
	@Override
	public Page<PaymentPlan> findPage(PaymentPlan paymentPlan) {
		return super.findPage(paymentPlan);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param paymentPlan
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(PaymentPlan paymentPlan) {
		super.save(paymentPlan);
		// 保存上传附件
		FileUploadUtils.saveFileUpload(paymentPlan, paymentPlan.getId(), "paymentPlan_file");
	}
	
	/**
	 * 更新状态
	 * @param paymentPlan
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(PaymentPlan paymentPlan) {
		super.updateStatus(paymentPlan);
	}
	
	/**
	 * 删除数据
	 * @param paymentPlan
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(PaymentPlan paymentPlan) {
		super.delete(paymentPlan);
	}
	
}