package com.online_pharmacies.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Wang
 * @since 2024-10-08
 */
public interface MenuService extends IService<Menu> {

    IPage<Menu> pageC(Page<Menu> page, LambdaQueryWrapper<Menu> lambdaQueryWrapper);
}
