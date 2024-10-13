package com.online_pharmacies.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.entity.Medication;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Wang
 * @since 2024-09-05
 */
public interface MedicationService extends IService<Medication> {

    IPage<Medication> pageC(Page<Medication> page, LambdaQueryWrapper<Medication> lambdaQueryWrapper);

    List<Medication> listById(Integer medicationId);

    IPage<Medication> hotPage(Page<Medication> page, LambdaQueryWrapper<Medication> lambdaQueryWrapper);
}
