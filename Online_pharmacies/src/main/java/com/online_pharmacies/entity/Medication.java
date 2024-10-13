package com.online_pharmacies.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
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
 * @since 2024-09-05
 */
@Getter
@Setter
@TableName("medication")
@ApiModel(value = "Medication对象", description = "")
public class Medication implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("药品名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("通用名")
    @TableField("generic_name")
    private String genericName;

    @ApiModelProperty("剂型（如片剂、胶囊、液体等）")
    @TableField("dosage_form")
    private String dosageForm;

    @ApiModelProperty("给药途径（如口服、注射等）")
    @TableField("route_of_administration")
    private String routeOfAdministration;

    @ApiModelProperty("有效期")
    @TableField("expiry_date")
    private String expiryDate;

    @ApiModelProperty("价格")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty("库存数量")
    @TableField("stock_quantity")
    private Integer stockQuantity;

    @ApiModelProperty("药品原料")
    @TableField("description")
    private String description;

    @ApiModelProperty("药品作用")
    @TableField("power")
    private String power;

    @ApiModelProperty("记录创建时间")
    @TableField("created_at")
    private Date createdAt;

    @ApiModelProperty("记录更新时间")
    @TableField("updated_at")
    private Date updatedAt;

    @ApiModelProperty("药品图片")
    @TableField("image")
    private String image;
}
