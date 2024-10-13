package com.online_pharmacies.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.entity.Medication;
import com.online_pharmacies.mapper.MedicationMapper;
import com.online_pharmacies.service.MedicationService;
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
 * @since 2024-09-05
 */
@Service
public class MedicationServiceImpl extends ServiceImpl<MedicationMapper, Medication> implements MedicationService {
    @Resource
    private MedicationMapper medicationMapper;
    @Override
    public IPage<Medication> pageC(Page<Medication> page, LambdaQueryWrapper<Medication> lambdaQueryWrapper) {
        return medicationMapper.pageC(page,lambdaQueryWrapper);
    }

    @Override
    public List<Medication> listById(Integer medicationId) {
        return medicationMapper.listById(medicationId);
    }

    @Override
    public IPage<Medication> hotPage(Page<Medication> page, LambdaQueryWrapper<Medication> lambdaQueryWrapper) {
        return medicationMapper.hotPage(page,lambdaQueryWrapper);
    }
}
