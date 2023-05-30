package com.timbercld.ws.front.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "示例商品")
@EqualsAndHashCode(callSuper = false)
public class FrontProductsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String productName;

    private String productImg;

}
