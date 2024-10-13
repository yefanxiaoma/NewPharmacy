package com.online_pharmacies.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.entity.User;
import com.online_pharmacies.mapper.UserMapper;
import com.online_pharmacies.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Wang
 * @since 2024-09-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User getByUserno(String userno) {
       return userMapper.selectUserno(userno);
    }

    @Override
    public User getByAdminno(String userno) {
        return userMapper.selectAdminno(userno);
    }

    @Override
    public List<User> listById(Integer userId) {
        return userMapper.listPersonal(userId);
    }

    @Override
    public IPage<User> paging(Page<User> page, Wrapper<User> wrapper) {
        return  userMapper.paging(page,wrapper);
    }
}
