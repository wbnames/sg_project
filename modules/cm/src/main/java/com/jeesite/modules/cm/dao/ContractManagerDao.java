/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.cm.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.cm.entity.ContractManager;

/**
 * 合同管理DAO接口
 * @author wang_bo
 * @version 2022-05-23
 */
@MyBatisDao
public interface ContractManagerDao extends CrudDao<ContractManager> {
	
}