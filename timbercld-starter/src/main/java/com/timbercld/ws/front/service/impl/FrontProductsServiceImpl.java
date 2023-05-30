package com.timbercld.ws.front.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.timbercld.core.constant.Constant;
import com.timbercld.core.page.PageData;
import com.timbercld.core.service.impl.BasicServiceImpl;
import com.timbercld.utils.QueryUtil;
import com.timbercld.ws.front.dao.FrontProductsDAO;
import com.timbercld.ws.front.dto.FrontProductsDTO;
import com.timbercld.ws.front.service.FrontProductsService;
import com.timbercld.ws.shop.entity.ProductsEntity;
import com.timbercld.ws.system.filter.DataFilter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FrontProductsServiceImpl extends BasicServiceImpl<FrontProductsDAO, ProductsEntity> implements FrontProductsService {
    @Override
    public PageData<FrontProductsDTO> rankList(Map<String, Object> params) {
        IPage<ProductsEntity> page = this.basicDao.selectPage(
                getPage(params, Constant.UPDATE_DATE, QueryUtil.isAsc(params)),
                getWrapper(params));
        List<ProductsEntity> list = this.basicDao.getSaleRankList(getQueryParams(params));
        return getPageData(list, page.getTotal(), FrontProductsDTO.class);
    }

    private Map<String, Object> getQueryParams(Map<String, Object> params){
        return params;
    }

    private QueryWrapper<ProductsEntity> getWrapper(Map<String, Object> params) {
        QueryWrapper<ProductsEntity> wrapper = new QueryWrapper<>();
        return wrapper;
    }

}
