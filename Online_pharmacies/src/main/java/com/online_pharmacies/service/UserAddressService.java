package com.online_pharmacies.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.entity.UserAddress;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Wang
 * @since 2024-09-24
 */
public interface UserAddressService extends IService<UserAddress> {

    List<UserAddress> listById(Integer userId);

    IPage<UserAddress> pageC(Page<UserAddress> page, LambdaQueryWrapper<UserAddress> lambdaQueryWrapper);
}
