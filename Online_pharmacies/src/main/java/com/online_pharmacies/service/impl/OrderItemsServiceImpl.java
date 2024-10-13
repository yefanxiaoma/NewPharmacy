package com.online_pharmacies.service.impl;

import com.online_pharmacies.entity.OrderDetail;
import com.online_pharmacies.entity.OrderItems;
import com.online_pharmacies.mapper.OrderItemsMapper;
import com.online_pharmacies.service.OrderItemsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Wang
 * @since 2024-10-05
 */
@Service
public class OrderItemsServiceImpl extends ServiceImpl<OrderItemsMapper, OrderItems> implements OrderItemsService {
    @Autowired
    private OrderItemsMapper orderItemsMapper;

    @Override
    public List<OrderItems> listDetail(OrderItems orderItems) {
        return orderItemsMapper.listDetail(orderItems);
    }
}
