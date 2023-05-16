package com.timbercld.ws.shop.dao;

import com.timbercld.core.dao.BasicDao;
import com.timbercld.ws.shop.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDAO extends BasicDao<OrderEntity> {

    List<OrderEntity> getOrderList(Map<String, Object> params);
}
