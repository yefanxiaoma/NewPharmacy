package com.online_pharmacies.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.entity.UserAddress;
import com.online_pharmacies.mapper.UserAddressMapper;
import com.online_pharmacies.service.UserAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Wang
 * @since 2024-09-24
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressService {
    @Autowired
    UserAddressMapper userAddressMapper;
    @Override
    public List<UserAddress> listById(Integer userId) {
        return userAddressMapper.listById(userId);
    }

    @Override
    public IPage<UserAddress> pageC(Page<UserAddress> page, LambdaQueryWrapper<UserAddress> lambdaQueryWrapper) {
        return userAddressMapper.pageC(page,lambdaQueryWrapper);
    }
}
