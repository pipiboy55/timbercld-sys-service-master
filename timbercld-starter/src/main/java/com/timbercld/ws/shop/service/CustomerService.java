package com.timbercld.ws.shop.service;

import com.timbercld.core.page.PageData;
import com.timbercld.core.service.BasicService;
import com.timbercld.ws.shop.dto.CustomerDTO;
import com.timbercld.ws.shop.entity.CustomerEntity;

import java.util.Map;

public interface CustomerService extends BasicService<CustomerEntity> {

    PageData<CustomerDTO> page(Map<String, Object> params);

    CustomerDTO get(Long id);

    void save(CustomerDTO dto);

    void delete(Long[] ids);
}
