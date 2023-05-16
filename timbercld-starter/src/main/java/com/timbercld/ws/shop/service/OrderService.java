package com.timbercld.ws.shop.service;

import com.timbercld.core.page.PageData;
import com.timbercld.core.service.BasicService;
import com.timbercld.ws.shop.dto.OrderDTO;
import com.timbercld.ws.shop.entity.OrderEntity;

import java.util.Map;

public interface OrderService extends BasicService<OrderEntity> {

    PageData<OrderDTO> page(Map<String, Object> params);

    OrderDTO get(Long id);

    void save(OrderDTO dto);

    void delete(Long[] ids);
}
