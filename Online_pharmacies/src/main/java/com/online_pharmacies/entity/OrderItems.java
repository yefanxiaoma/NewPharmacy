package com.online_pharmacies.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
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
 * @since 2024-10-05
 */
@Getter
@Setter
@TableName("order_items")
@ApiModel(value = "OrderItems对象", description = "")
public class OrderItems implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "order_item_id", type = IdType.AUTO)
    private Integer orderItemId;

    @TableField("order_id")
    private Integer orderId;

    @TableField("medication_id")
    private Integer medicationId;

    @TableField("quantity")
    private Integer quantity;

    @TableField("price")
    private BigDecimal price;

    @TableField("total_price")
    private BigDecimal totalPrice;
}
