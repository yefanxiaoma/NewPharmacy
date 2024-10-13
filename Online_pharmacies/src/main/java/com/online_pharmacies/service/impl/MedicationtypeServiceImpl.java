package com.online_pharmacies.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.entity.Medicationtype;
import com.online_pharmacies.mapper.MedicationtypeMapper;
import com.online_pharmacies.service.MedicationtypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Wang
 * @since 2024-09-25
 */
@Service
public class MedicationtypeServiceImpl extends ServiceImpl<MedicationtypeMapper, Medicationtype> implements MedicationtypeService {
    @Resource
    private MedicationtypeMapper medicationtypeMapper;
    @Override
    public IPage<Medicationtype> pageC(Page<Medicationtype> page, LambdaQueryWrapper<Medicationtype> lambdaQueryWrapper) {
        return medicationtypeMapper.pageC(page,lambdaQueryWrapper);
    }

    @Override
    public IPage<Medicationtype> pageType(Page<Medicationtype> page, LambdaQueryWrapper<Medicationtype> lambdaQueryWrapper) {
        return medicationtypeMapper.pageType(page,lambdaQueryWrapper);
    }
}
