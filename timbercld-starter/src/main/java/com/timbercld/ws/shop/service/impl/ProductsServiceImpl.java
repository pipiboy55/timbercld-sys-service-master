package com.timbercld.ws.shop.service.impl;

import com.timbercld.core.page.PageData;
import com.timbercld.core.service.impl.BasicServiceImpl;
import com.timbercld.core.utils.ConvertUtils;
import com.timbercld.ws.shop.dao.ProductsDAO;
import com.timbercld.ws.shop.dto.ProductsDTO;
import com.timbercld.ws.shop.entity.ProductsEntity;
import com.timbercld.ws.shop.service.ProductsService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductsServiceImpl extends BasicServiceImpl<ProductsDAO, ProductsEntity> implements ProductsService {
    @Override
    public PageData<ProductsDTO> page(Map<String, Object> params) {
        return null;
    }

    @Override
    public ProductsDTO get(Long id) {
        return null;
    }

    @Override
    public void save(ProductsDTO dto) {
        this.basicDao.insert(ConvertUtils.sourceToTarget(dto, ProductsEntity.class));
    }

    @Override
    public void delete(Long[] ids) {

    }
}
