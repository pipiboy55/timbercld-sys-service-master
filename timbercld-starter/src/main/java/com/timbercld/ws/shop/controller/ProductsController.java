package com.timbercld.ws.shop.controller;

import com.timbercld.core.utils.Result;
import com.timbercld.core.validator.ValidatorUtils;
import com.timbercld.core.validator.group.DefaultGroup;
import com.timbercld.core.validator.group.SaveGroup;
import com.timbercld.ws.shop.dto.ProductsDTO;
import com.timbercld.ws.shop.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("shop/products")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @PostMapping("save")
    public Result save(@RequestBody ProductsDTO productsDTO) {
        ValidatorUtils.validateEntity(productsDTO, SaveGroup.class, DefaultGroup.class);
        this.productsService.save(productsDTO);
        return new Result();
    }

    @DeleteMapping("delete/{id}")
    public Result delete(@PathVariable Long id) {
        return null;
    }

    @PutMapping("update")
    public Result update(@RequestBody ProductsDTO productsDTO) {
        return null;
    }

    @GetMapping("get")
    public Result get(@PathVariable Long id) {
        return null;
    }

    @GetMapping("page")
    public Result page(@RequestParam Map<String, Object> params) {
        return null;
    }
}
