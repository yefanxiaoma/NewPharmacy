package com.online_pharmacies.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Wang
 */
@Data
public class OrderDetail {
    private String name;
    private String image;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal totalPrice;
}
