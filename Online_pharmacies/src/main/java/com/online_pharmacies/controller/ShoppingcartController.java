package com.online_pharmacies.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.online_pharmacies.common.Result;
import com.online_pharmacies.entity.Medication;
import com.online_pharmacies.entity.Shoppingcart;
import com.online_pharmacies.service.ShoppingcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Wang
 * @since 2024-10-02
 */
@RestController
@RequestMapping("/shoppingcart")
public class ShoppingcartController {
    @Autowired
    ShoppingcartService shoppingcartService;

    @PostMapping("/save")
    public Result saveCart(@RequestBody Shoppingcart shoppingcart){
        return shoppingcartService.save(shoppingcart)?Result.success():Result.fail();
    }
    @PostMapping("/findId")
    public Result findId(@RequestBody Shoppingcart shoppingcart){
        Shoppingcart currentCartItem = shoppingcartService.getByUserIdAndMedicationId(
                shoppingcart.getUserId().toString(), shoppingcart.getMedicationId().toString());
        if (currentCartItem != null) {
            return Result.success();
        }else {
            return Result.fail();
        }
    }
    @PostMapping("/update")
    public Result updateCart(@RequestBody Shoppingcart shoppingcart) {
        // 查询当前购物车中药品的数量
        Shoppingcart currentCartItem = shoppingcartService.getByUserIdAndMedicationId(
                shoppingcart.getUserId().toString(), shoppingcart.getMedicationId().toString());
        // 如果购物车中存在该药品
        if (currentCartItem != null) {
            // 获取当前数量和单价
            int currentQuantity = currentCartItem.getQuantity();
            BigDecimal totalPrice = currentCartItem.getPrice();
            // 计算新的数量和总价
            int newQuantity = currentQuantity + shoppingcart.getQuantity();
            BigDecimal newTotalPrice = totalPrice.multiply(BigDecimal.valueOf(newQuantity));;
            // 更新数量和总价
            currentCartItem.setQuantity(newQuantity);
            currentCartItem.setTotalPrice(newTotalPrice);
            boolean updateSuccess = shoppingcartService.updateById(currentCartItem);
            return updateSuccess ? Result.success() : Result.fail();
        } else {
            return Result.fail();
        }
    }
    @PostMapping("/list")
    public Result list(@RequestBody Map<String, Integer> params) {
        Integer userId = params.get("id");
        List<Medication> list = shoppingcartService.listById(userId);
        // 返回结果
        return Result.success(list);
    }
    @GetMapping("/delete")
    public Result delete(@RequestParam String id){
        return shoppingcartService.removeById(id)?Result.success():Result.fail();
    }
    @PostMapping("/deletecart")
    public Result deletecart(@RequestBody List<String> ids){
        return shoppingcartService.removeBatchByIds(ids)?Result.success():Result.fail();
    }
}
