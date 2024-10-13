package com.online_pharmacies.service.impl;

import com.online_pharmacies.entity.Medication;
import com.online_pharmacies.entity.Shoppingcart;
import com.online_pharmacies.mapper.ShoppingcartMapper;
import com.online_pharmacies.service.ShoppingcartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Wang
 * @since 2024-10-02
 */
@Service
public class ShoppingcartServiceImpl extends ServiceImpl<ShoppingcartMapper, Shoppingcart> implements ShoppingcartService {
    @Autowired
    ShoppingcartMapper shoppingcartMapper;
    @Override
    public List<Medication> listById(Integer userId) {
        return shoppingcartMapper.listById(userId);
    }

    @Override
    public Shoppingcart getByUserIdAndMedicationId(String userId, String medicationId) {
        return shoppingcartMapper.findById(userId,medicationId);
    }
}
