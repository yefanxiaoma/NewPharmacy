package com.online_pharmacies.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.entity.Drugdrugtype;
import com.online_pharmacies.entity.Medicationtype;
import com.online_pharmacies.mapper.DrugdrugtypeMapper;
import com.online_pharmacies.service.DrugdrugtypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Wang
 * @since 2024-10-12
 */
@Service
public class DrugdrugtypeServiceImpl extends ServiceImpl<DrugdrugtypeMapper, Drugdrugtype> implements DrugdrugtypeService {
    @Autowired
    private DrugdrugtypeMapper drugdrugtypeMapper;
    @Override
    public IPage<Drugdrugtype> pageC(Page<Drugdrugtype> page, LambdaQueryWrapper<Drugdrugtype> lambdaQueryWrapper) {
        return drugdrugtypeMapper.pageC(page,lambdaQueryWrapper);
    }
}
