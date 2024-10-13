package com.online_pharmacies.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.entity.Drugdrugtype;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.online_pharmacies.entity.Medication;
import com.online_pharmacies.entity.Medicationtype;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Wang
 * @since 2024-10-12
 */
@Mapper
public interface DrugdrugtypeMapper extends BaseMapper<Drugdrugtype> {

    IPage<Drugdrugtype> pageC(Page<Drugdrugtype> page, @Param(Constants.WRAPPER) Wrapper<Drugdrugtype> wrapper);
}
