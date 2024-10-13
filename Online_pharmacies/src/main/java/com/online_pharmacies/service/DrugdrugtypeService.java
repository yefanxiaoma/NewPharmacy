package com.online_pharmacies.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.entity.Drugdrugtype;
import com.baomidou.mybatisplus.extension.service.IService;
import com.online_pharmacies.entity.Medicationtype;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Wang
 * @since 2024-10-12
 */
public interface DrugdrugtypeService extends IService<Drugdrugtype> {

    IPage<Drugdrugtype> pageC(Page<Drugdrugtype> page, LambdaQueryWrapper<Drugdrugtype> lambdaQueryWrapper);
}
