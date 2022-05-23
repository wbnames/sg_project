/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.design.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.design.entity.DesignProduct;

/**
 * 设计图纸DAO接口
 * @author wang_bo
 * @version 2022-05-24
 */
@MyBatisDao
public interface DesignProductDao extends CrudDao<DesignProduct> {
	
}