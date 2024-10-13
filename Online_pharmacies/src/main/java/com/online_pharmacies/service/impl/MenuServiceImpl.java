package com.online_pharmacies.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.entity.Menu;
import com.online_pharmacies.mapper.MenuMapper;
import com.online_pharmacies.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Wang
 * @since 2024-10-08
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public IPage<Menu> pageC(Page<Menu> page, LambdaQueryWrapper<Menu> lambdaQueryWrapper) {
        return menuMapper.pageC(page,lambdaQueryWrapper);
    }
}
