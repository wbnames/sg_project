/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.cm.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.cm.entity.PaymentPlan;

/**
 * 收款计划DAO接口
 * @author wang_bo
 * @version 2022-05-30
 */
@MyBatisDao
public interface PaymentPlanDao extends CrudDao<PaymentPlan> {
	
}