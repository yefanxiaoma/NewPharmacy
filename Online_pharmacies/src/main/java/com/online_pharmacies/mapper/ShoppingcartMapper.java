package com.online_pharmacies.mapper;

import com.online_pharmacies.entity.Medication;
import com.online_pharmacies.entity.Shoppingcart;
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
 * @since 2024-10-02
 */
@Mapper
public interface ShoppingcartMapper extends BaseMapper<Shoppingcart> {

    List<Medication> listById(Integer userId);

    Shoppingcart findById(@Param("userId") String userId, @Param("medicationId") String medicationId);
}
