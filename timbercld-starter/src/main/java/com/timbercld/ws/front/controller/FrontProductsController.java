package com.timbercld.ws.front.controller;

import com.timbercld.core.page.PageData;
import com.timbercld.core.utils.Result;
import com.timbercld.ws.front.dto.FrontProductsDTO;
import com.timbercld.ws.front.service.FrontProductsService;
import com.timbercld.ws.shop.dto.ProductsDTO;
import com.timbercld.ws.shop.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("service/front/products")
public class FrontProductsController {
    @Autowired
    private ProductsService productsService;

    @Autowired
    private FrontProductsService frontProductsService;

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

    @GetMapping("ranklist")
    public Result rankList(@RequestParam Map<String, Object> params) {
        PageData<FrontProductsDTO> pageData = this.frontProductsService.rankList(params);
        return new Result<PageData<FrontProductsDTO>>().ok(pageData);
    }
}
