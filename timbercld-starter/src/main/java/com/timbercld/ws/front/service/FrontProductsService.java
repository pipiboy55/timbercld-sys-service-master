package com.timbercld.ws.front.service;

import com.timbercld.core.page.PageData;
import com.timbercld.core.service.BasicService;
import com.timbercld.ws.front.dto.FrontProductsDTO;
import com.timbercld.ws.shop.entity.ProductsEntity;

import java.util.Map;

public interface FrontProductsService extends BasicService<ProductsEntity> {

    PageData<FrontProductsDTO> rankList(Map<String, Object> params);
}
