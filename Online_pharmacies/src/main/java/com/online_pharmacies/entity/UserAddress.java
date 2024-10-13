package com.online_pharmacies.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Wang
 * @since 2024-09-24
 */
@Getter
@Setter
@TableName("user_address")
@ApiModel(value = "UserAddress对象", description = "")
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("收货人姓名")
    @TableField("username")
    private String username;

    @ApiModelProperty("手机号")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty("省份")
    @TableField("province")
    private String province;

    @ApiModelProperty("城市")
    @TableField("city")
    private String city;

    @ApiModelProperty("区县")
    @TableField("district")
    private String district;

    @ApiModelProperty("详细地址")
    @TableField("detail")
    private String detail;

    @ApiModelProperty("外键")
    @TableField("user_id")
    private Integer userId;

    @TableField("update_time")
    private Date updateTime;

    @ApiModelProperty("是否为默认地址")
    @TableField("is_default")
    private Boolean isDefault;
}
