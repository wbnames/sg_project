/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.product.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.product.entity.ProductClassify;

/**
 * 产品分类DAO接口
 * @author lyu
 * @version 2022-05-24
 */
@MyBatisDao
public interface ProductClassifyDao extends CrudDao<ProductClassify> {
	
}