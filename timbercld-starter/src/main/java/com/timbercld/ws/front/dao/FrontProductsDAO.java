package com.timbercld.ws.front.dao;

import com.timbercld.core.dao.BasicDao;
import com.timbercld.ws.shop.entity.ProductsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FrontProductsDAO extends BasicDao<ProductsEntity> {

    List<ProductsEntity> getSaleRankList(Map<String, Object> params);
}
