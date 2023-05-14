package com.timbercld.ws.shop.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
    /**
     * 商铺名称
     */
    @TableField(exist=false)
    private String shopName;
    /**
     * 商铺ID
     */
    @TableField(exist=false)
    private Long dept_id;
}
