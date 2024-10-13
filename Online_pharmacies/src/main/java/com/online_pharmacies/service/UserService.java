package com.online_pharmacies.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.entity.Medication;
import com.online_pharmacies.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Wang
 * @since 2024-09-12
 */
public interface UserService extends IService<User> {

    User getByUserno(String userno);

    User getByAdminno(String userno);

    List<User> listById(Integer userId);

    IPage<User> paging(Page<User> page, Wrapper<User> wrapper);
}
