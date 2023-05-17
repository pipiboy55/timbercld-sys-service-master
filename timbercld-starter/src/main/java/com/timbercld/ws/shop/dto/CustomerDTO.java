package com.timbercld.ws.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerDTO implements Serializable {

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

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String realName;
    /**
     * 头像
     */
    private String headUrl;
    /**
     * 性别   0：男   1：女    2：保密
     */
    private Integer gender;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String mobile;
}
