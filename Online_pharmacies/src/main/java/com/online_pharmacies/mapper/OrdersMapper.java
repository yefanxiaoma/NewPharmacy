package com.online_pharmacies.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
public interface OrdersMapper extends BaseMapper<Orders> {

    boolean updateStatus(String id);

    List<Orders> listById(Integer userId);

    List<Orders> listType(Orders orders);

    boolean updates(String id);

    List<Orders> listAddress(Orders orders);

    IPage<Orders> pageC(IPage<Orders> page, @Param(Constants.WRAPPER) Wrapper<Orders> wrapper);

    boolean send(String id);
}
