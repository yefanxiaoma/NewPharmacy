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
 * @since 2024-10-02
 */
@Getter
@Setter
@TableName("shoppingcart")
@ApiModel(value = "Shoppingcart对象", description = "")
public class Shoppingcart implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cart_id", type = IdType.AUTO)
    private Integer cartId;

    @TableField("user_id")
    private Integer userId;

    @TableField("medication_id")
    private Integer medicationId;

    @TableField("medication_name")
    private String medicationName;

    @TableField("medication_image")
    private String medicationImage;

    @TableField("quantity")
    private Integer quantity;

    @TableField("price")
    private BigDecimal price;

    @TableField("total_price")
    private BigDecimal totalPrice;

    @TableField("created_at")
    private Date createdAt;

    @TableField("updated_at")
    private Date updatedAt;
}
