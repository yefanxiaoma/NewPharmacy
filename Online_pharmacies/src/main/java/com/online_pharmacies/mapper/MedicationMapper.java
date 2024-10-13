package com.online_pharmacies.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.entity.Medication;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Wang
 * @since 2024-09-05
 */
@Mapper
public interface MedicationMapper extends BaseMapper<Medication> {

    IPage<Medication> pageC(IPage<Medication> page, @Param(Constants.WRAPPER) Wrapper<Medication> wrapper);

    List<Medication> listById(Integer medicationId);

    IPage<Medication> hotPage(IPage<Medication> page,  @Param(Constants.WRAPPER) Wrapper<Medication> wrapper);
}
