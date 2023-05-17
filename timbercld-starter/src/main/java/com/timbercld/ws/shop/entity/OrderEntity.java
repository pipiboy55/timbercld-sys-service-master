package com.timbercld.ws.shop.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.timbercld.core.entity.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@TableName("shop_order")
public class OrderEntity extends BasicEntity {

    private Long shopId;
    private Long productsId;
    private Long customerId;
    private Integer quantity;
    private Float amount;
    private String comment;

    @TableField(exist=false)
    private String shopName;

    @TableField(exist=false)
    private String productsName;

    @TableField(exist=false)
    private String customerName;

    /**
     * 商铺ID
     */
    @TableField(exist=false)
    private Long dept_id;
}
