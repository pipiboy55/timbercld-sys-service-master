package com.timbercld.ws.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.timbercld.core.constant.Constant;
import com.timbercld.core.page.PageData;
import com.timbercld.core.service.impl.BasicServiceImpl;
import com.timbercld.core.utils.ConvertUtils;
import com.timbercld.utils.QueryUtil;
import com.timbercld.ws.shop.dao.CustomerDAO;
import com.timbercld.ws.shop.dto.CustomerDTO;
import com.timbercld.ws.shop.entity.CustomerEntity;
import com.timbercld.ws.shop.service.CustomerService;
import com.timbercld.ws.system.filter.DataFilter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl extends BasicServiceImpl<CustomerDAO, CustomerEntity> implements CustomerService {
    @Override
    @DataFilter(tableAlias = "t2")
    public PageData<CustomerDTO> page(Map<String, Object> params) {
        IPage<CustomerEntity> page = this.basicDao.selectPage(
                getPage(params, Constant.UPDATE_DATE, QueryUtil.isAsc(params)),
                getWrapper(params));
        List<CustomerEntity> list = this.basicDao.getCustomerList(getQueryParams(params));
        return getPageData(list, page.getTotal(), CustomerDTO.class);
    }

    private Map<String, Object> getQueryParams(Map<String, Object> params){
        return params;
    }

    private QueryWrapper<CustomerEntity> getWrapper(Map<String, Object> params) {
        QueryWrapper<CustomerEntity> wrapper = new QueryWrapper<>();
        return wrapper;
    }

    @Override
    public CustomerDTO get(Long id) {

        return ConvertUtils.sourceToTarget(basicDao.selectById(id), CustomerDTO.class);
    }

    @Override
    public void save(CustomerDTO dto) {
        this.basicDao.insert(ConvertUtils.sourceToTarget(dto, CustomerEntity.class));
    }

    @Override
    public void delete(Long[] ids) {

    }
}
