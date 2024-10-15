package com.online_pharmacies.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.entity.Orders;
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
public interface OrdersService extends IService<Orders> {

    Integer Save(Orders orders);

    boolean updateStatus(String id);

    List<Orders> listById(Integer userId);

    List<Orders> listType(Orders orders);

    boolean updates(String id);

    List<Orders> listAddress(Orders orders);

    IPage<Orders> pageC(Page<Orders> page, LambdaQueryWrapper<Orders> lambdaQueryWrapper);

    boolean send(String id);

    List<Orders> listNumber(Orders orders);
}
