package com.online_pharmacies.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.entity.Medicationtype;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Wang
 * @since 2024-09-25
 */
public interface MedicationtypeService extends IService<Medicationtype> {

    IPage<Medicationtype> pageC(Page<Medicationtype> page, LambdaQueryWrapper<Medicationtype> lambdaQueryWrapper);

    IPage<Medicationtype> pageType(Page<Medicationtype> page, LambdaQueryWrapper<Medicationtype> lambdaQueryWrapper);
}
