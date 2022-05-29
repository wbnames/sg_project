/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.factmana.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.factmana.entity.FactoryManufacturer;

/**
 * 生产厂商DAO接口
 * @author lyu
 * @version 2022-05-24
 */
@MyBatisDao
public interface FactoryManufacturerDao extends CrudDao<FactoryManufacturer> {
	
}