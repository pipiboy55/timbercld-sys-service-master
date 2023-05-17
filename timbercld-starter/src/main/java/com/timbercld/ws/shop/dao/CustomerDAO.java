package com.timbercld.ws.shop.dao;

import com.timbercld.core.dao.BasicDao;
import com.timbercld.ws.shop.entity.CustomerEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerDAO extends BasicDao<CustomerEntity> {

    List<CustomerEntity> getCustomerList(Map<String, Object> params);
}
