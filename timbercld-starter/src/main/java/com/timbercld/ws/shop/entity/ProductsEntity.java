package com.timbercld.ws.shop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.timbercld.core.entity.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@TableName("shop_product")
public class ProductsEntity extends BasicEntity {
    private String productName;
    private float productPrice;
    private String productIntro;
    private String productImg;
}
