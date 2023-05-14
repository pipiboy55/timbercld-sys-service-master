package com.timbercld.ws.shop.dao;

import com.timbercld.core.dao.BasicDao;
import com.timbercld.ws.shop.entity.ProductsEntity;
import com.timbercld.ws.system.filter.DataFilter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductsDAO extends BasicDao<ProductsEntity> {

    List<ProductsEntity> getProductsList(Map<String, Object> params);
}
