package com.timbercld.ws.shop.controller;

import com.timbercld.core.page.PageData;
import com.timbercld.core.utils.ConvertUtils;
import com.timbercld.core.utils.Result;
import com.timbercld.core.validator.AssertUtils;
import com.timbercld.core.validator.ValidatorUtils;
import com.timbercld.core.validator.group.DefaultGroup;
import com.timbercld.core.validator.group.SaveGroup;
import com.timbercld.core.validator.group.UpdateGroup;
import com.timbercld.ws.shop.dto.ProductsDTO;
import com.timbercld.ws.shop.entity.ProductsEntity;
import com.timbercld.ws.shop.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("shop/products")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @PostMapping()
    public Result save(@RequestBody ProductsDTO productsDTO) {
        ValidatorUtils.validateEntity(productsDTO, SaveGroup.class, DefaultGroup.class);
        this.productsService.save(productsDTO);
        return new Result();
    }

    @DeleteMapping("delete/{id}")
    public Result delete(@PathVariable Long id) {
        AssertUtils.isNull(id, "id");

        this.productsService.deleteById(id);

        return new Result();
    }

    @PutMapping()
    public Result update(@RequestBody ProductsDTO productsDTO) {
        ValidatorUtils.validateEntity(productsDTO, UpdateGroup.class, DefaultGroup.class);
        this.productsService.updateById(ConvertUtils.sourceToTarget(productsDTO, ProductsEntity.class));
        return new Result();
    }

    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        ProductsDTO productsDTO = this.productsService.get(id);
        return new Result<ProductsDTO>().ok(productsDTO);
    }

    @GetMapping("page")
    public Result page(@RequestParam Map<String, Object> params) {
        PageData<ProductsDTO> pageData = this.productsService.page(params);
        return new Result<PageData<ProductsDTO>>().ok(pageData);
    }
}
