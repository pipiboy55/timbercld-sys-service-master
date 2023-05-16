package com.timbercld.ws.shop.controller;

import com.timbercld.core.page.PageData;
import com.timbercld.core.utils.ConvertUtils;
import com.timbercld.core.utils.Result;
import com.timbercld.core.validator.AssertUtils;
import com.timbercld.core.validator.ValidatorUtils;
import com.timbercld.core.validator.group.DefaultGroup;
import com.timbercld.core.validator.group.SaveGroup;
import com.timbercld.core.validator.group.UpdateGroup;
import com.timbercld.ws.shop.dto.OrderDTO;
import com.timbercld.ws.shop.entity.OrderEntity;
import com.timbercld.ws.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("shop/order")
public class OrderController {
    @Autowired
    private OrderService OrderService;

    @PostMapping
    public Result save(@RequestBody OrderDTO OrderDTO) {
        ValidatorUtils.validateEntity(OrderDTO, SaveGroup.class, DefaultGroup.class);
        this.OrderService.save(OrderDTO);
        return new Result();
    }

    @DeleteMapping("delete/{id}")
    public Result delete(@PathVariable Long id) {
        AssertUtils.isNull(id, "id");

        this.OrderService.deleteById(id);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody OrderDTO OrderDTO) {
        ValidatorUtils.validateEntity(OrderDTO, UpdateGroup.class, DefaultGroup.class);
        this.OrderService.updateById(ConvertUtils.sourceToTarget(OrderDTO, OrderEntity.class));
        return new Result();
    }

    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        OrderDTO OrderDTO = this.OrderService.get(id);
        return new Result<OrderDTO>().ok(OrderDTO);
    }

    @GetMapping("page")
    public Result page(@RequestParam Map<String, Object> params) {
        PageData<OrderDTO> pageData = this.OrderService.page(params);
        return new Result<PageData<OrderDTO>>().ok(pageData);
    }
}
