package com.timbercld.ws.shop.dao;

import com.timbercld.core.dao.BasicDao;
import com.timbercld.ws.shop.entity.ProductsEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductsDAO extends BasicDao<ProductsEntity> {
}
