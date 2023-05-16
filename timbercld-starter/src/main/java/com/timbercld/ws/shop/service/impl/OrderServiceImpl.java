package com.timbercld.ws.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.timbercld.core.constant.Constant;
import com.timbercld.core.page.PageData;
import com.timbercld.core.service.impl.BasicServiceImpl;
import com.timbercld.core.utils.ConvertUtils;
import com.timbercld.utils.QueryUtil;
import com.timbercld.ws.shop.dao.OrderDAO;
import com.timbercld.ws.shop.dto.OrderDTO;
import com.timbercld.ws.shop.entity.OrderEntity;
import com.timbercld.ws.shop.service.OrderService;
import com.timbercld.ws.system.filter.DataFilter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl extends BasicServiceImpl<OrderDAO, OrderEntity> implements OrderService {
    @Override
    @DataFilter(tableAlias = "t2")
    public PageData<OrderDTO> page(Map<String, Object> params) {
        IPage<OrderEntity> page = this.basicDao.selectPage(
                getPage(params, Constant.UPDATE_DATE, QueryUtil.isAsc(params)),
                getWrapper(params));
        List<OrderEntity> list = this.basicDao.getOrderList(getQueryParams(params));
        return getPageData(list, page.getTotal(), OrderDTO.class);
    }

    private Map<String, Object> getQueryParams(Map<String, Object> params){
        return params;
    }

    private QueryWrapper<OrderEntity> getWrapper(Map<String, Object> params) {
        QueryWrapper<OrderEntity> wrapper = new QueryWrapper<>();
        return wrapper;
    }

    @Override
    public OrderDTO get(Long id) {

        return ConvertUtils.sourceToTarget(basicDao.selectById(id), OrderDTO.class);
    }

    @Override
    public void save(OrderDTO dto) {
        this.basicDao.insert(ConvertUtils.sourceToTarget(dto, OrderEntity.class));
    }

    @Override
    public void delete(Long[] ids) {

    }
}
