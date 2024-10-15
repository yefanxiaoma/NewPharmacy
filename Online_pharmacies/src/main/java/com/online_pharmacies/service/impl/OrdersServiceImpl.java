package com.online_pharmacies.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.entity.Orders;
import com.online_pharmacies.mapper.OrdersMapper;
import com.online_pharmacies.service.OrdersService;
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
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
    @Autowired
    OrdersMapper ordersMapper;
    @Override
    public Integer Save(Orders orders) {
        if (this.save(orders)) {
            return orders.getOrderId();
        }
        return null;
    }

    @Override
    public boolean updateStatus(String id) {
        return ordersMapper.updateStatus(id);
    }

    @Override
    public List<Orders> listById(Integer userId) {
        return ordersMapper.listById(userId);
    }

    @Override
    public List<Orders> listType(Orders orders) {
        return ordersMapper.listType(orders);
    }

    @Override
    public boolean updates(String id) {
        return ordersMapper.updates(id);
    }

    @Override
    public List<Orders> listAddress(Orders orders) {
        return ordersMapper.listAddress(orders);
    }

    @Override
    public IPage<Orders> pageC(Page<Orders> page, LambdaQueryWrapper<Orders> lambdaQueryWrapper) {
        return ordersMapper.pageC(page,lambdaQueryWrapper);
    }

    @Override
    public boolean send(String id) {
        return ordersMapper.send(id);
    }

    @Override
    public List<Orders> listNumber(Orders orders) {
        return ordersMapper.listNumber(orders);
    }

}
