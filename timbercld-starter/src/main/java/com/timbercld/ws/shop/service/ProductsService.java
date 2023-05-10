package com.timbercld.ws.shop.service;

import com.timbercld.core.page.PageData;
import com.timbercld.core.service.BasicService;
import com.timbercld.ws.shop.dto.ProductsDTO;
import com.timbercld.ws.shop.entity.ProductsEntity;

import java.util.Map;

public interface ProductsService extends BasicService<ProductsEntity> {

    PageData<ProductsDTO> page(Map<String, Object> params);

    ProductsDTO get(Long id);

    void save(ProductsDTO dto);

    void delete(Long[] ids);
}
