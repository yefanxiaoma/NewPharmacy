package com.online_pharmacies.service;

import com.online_pharmacies.entity.OrderDetail;
import com.online_pharmacies.entity.OrderItems;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Wang
 * @since 2024-10-05
 */
public interface OrderItemsService extends IService<OrderItems> {


    List<OrderItems> listDetail(OrderItems orderItems);
}
