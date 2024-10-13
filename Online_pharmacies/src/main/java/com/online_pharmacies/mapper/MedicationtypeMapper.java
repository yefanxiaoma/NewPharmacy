package com.online_pharmacies.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.entity.Medicationtype;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Wang
 * @since 2024-09-25
 */
@Mapper
public interface MedicationtypeMapper extends BaseMapper<Medicationtype> {

    IPage<Medicationtype> pageC(IPage<Medicationtype> page, @Param(Constants.WRAPPER) Wrapper<Medicationtype> wrapper);

    IPage<Medicationtype> pageType(IPage<Medicationtype> page, @Param(Constants.WRAPPER) Wrapper<Medicationtype> wrapper);
}
