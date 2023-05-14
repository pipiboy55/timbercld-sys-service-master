package com.timbercld.ws.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.timbercld.core.constant.Constant;
import com.timbercld.core.page.PageData;
import com.timbercld.core.service.impl.BasicServiceImpl;
import com.timbercld.core.utils.ConvertUtils;
import com.timbercld.utils.QueryUtil;
import com.timbercld.ws.shop.dao.ProductsDAO;
import com.timbercld.ws.shop.dto.ProductsDTO;
import com.timbercld.ws.shop.entity.ProductsEntity;
import com.timbercld.ws.shop.service.ProductsService;
import com.timbercld.ws.system.filter.DataFilter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductsServiceImpl extends BasicServiceImpl<ProductsDAO, ProductsEntity> implements ProductsService {
    @Override
    @DataFilter(tableAlias = "t1")
    public PageData<ProductsDTO> page(Map<String, Object> params) {
        IPage<ProductsEntity> page = this.basicDao.selectPage(
                getPage(params, Constant.UPDATE_DATE, QueryUtil.isAsc(params)),
                getWrapper(params));
        List<ProductsEntity> list = this.basicDao.getProductsList(getQueryParams(params));
        return getPageData(list, page.getTotal(), ProductsDTO.class);
    }

    private Map<String, Object> getQueryParams(Map<String, Object> params){
        return params;
    }

    private QueryWrapper<ProductsEntity> getWrapper(Map<String, Object> params) {
        QueryWrapper<ProductsEntity> wrapper = new QueryWrapper<>();
        return wrapper;
    }

    @Override
    public ProductsDTO get(Long id) {

        return ConvertUtils.sourceToTarget(basicDao.selectById(id), ProductsDTO.class);
    }

    @Override
    public void save(ProductsDTO dto) {
        this.basicDao.insert(ConvertUtils.sourceToTarget(dto, ProductsEntity.class));
    }

    @Override
    public void delete(Long[] ids) {

    }
}
