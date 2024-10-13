package com.online_pharmacies.service;

import com.online_pharmacies.entity.Medication;
import com.online_pharmacies.entity.Shoppingcart;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Wang
 * @since 2024-10-02
 */
public interface ShoppingcartService extends IService<Shoppingcart> {

    List<Medication> listById(Integer userId);

    Shoppingcart getByUserIdAndMedicationId(String userId, String medicationId);
}
