package com.timbercld.ws.shop.controller;

import com.timbercld.core.page.PageData;
import com.timbercld.core.utils.ConvertUtils;
import com.timbercld.core.utils.Result;
import com.timbercld.core.validator.AssertUtils;
import com.timbercld.core.validator.ValidatorUtils;
import com.timbercld.core.validator.group.DefaultGroup;
import com.timbercld.core.validator.group.SaveGroup;
import com.timbercld.core.validator.group.UpdateGroup;
import com.timbercld.ws.shop.dto.CustomerDTO;
import com.timbercld.ws.shop.entity.CustomerEntity;
import com.timbercld.ws.shop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("shop/customer")
public class CustomerController {
    @Autowired
    private CustomerService CustomerService;

    @PostMapping
    public Result save(@RequestBody CustomerDTO CustomerDTO) {
        ValidatorUtils.validateEntity(CustomerDTO, SaveGroup.class, DefaultGroup.class);
        this.CustomerService.save(CustomerDTO);
        return new Result();
    }

    @DeleteMapping("delete/{id}")
    public Result delete(@PathVariable Long id) {
        AssertUtils.isNull(id, "id");

        this.CustomerService.deleteById(id);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody CustomerDTO CustomerDTO) {
        ValidatorUtils.validateEntity(CustomerDTO, UpdateGroup.class, DefaultGroup.class);
        this.CustomerService.updateById(ConvertUtils.sourceToTarget(CustomerDTO, CustomerEntity.class));
        return new Result();
    }

    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        CustomerDTO CustomerDTO = this.CustomerService.get(id);
        return new Result<CustomerDTO>().ok(CustomerDTO);
    }

    @GetMapping("page")
    public Result page(@RequestParam Map<String, Object> params) {
        PageData<CustomerDTO> pageData = this.CustomerService.page(params);
        return new Result<PageData<CustomerDTO>>().ok(pageData);
    }
}
