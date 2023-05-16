package com.timbercld.ws.shop.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "示例商品")
@EqualsAndHashCode(callSuper = false)
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 创建者
     */
    private Long  creatorId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 更新者
     */
    private Long updaterId;
    /**
     * 更新时间
     */
    private Date updateDate;

    private Long shopId;
    private Long productsId;
    private Long customerId;
    private Integer quantity;
    private Float amount;
    private String comment;
}
