package com.online_pharmacies.mapper;

import com.online_pharmacies.entity.OrderDetail;
import com.online_pharmacies.entity.OrderItems;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Wang
 * @since 2024-10-05
 */
@Mapper
public interface OrderItemsMapper extends BaseMapper<OrderItems> {
    List<OrderItems> listDetail(OrderItems orderItems);
}
