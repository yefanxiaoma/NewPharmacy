package com.online_pharmacies.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.common.QueryPageParam;
import com.online_pharmacies.common.Result;
import com.online_pharmacies.entity.Medication;
import com.online_pharmacies.entity.Orders;
import com.online_pharmacies.entity.UserAddress;
import com.online_pharmacies.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Wang
 * @since 2024-10-05
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    OrdersService ordersService;
    @PostMapping("/submit")
    public Result submit(@RequestBody Orders orders){
       Integer orderId =  ordersService.Save(orders);
        if (orderId != null) {
            return Result.success(orderId);
        } else {
            return Result.fail();
        }
    }
    @PostMapping("/update")
    public Result update(@RequestParam String id){
       return ordersService.updateStatus(id)?Result.success():Result.fail();
    }
    @PostMapping("/updates")
    public Result updates(@RequestParam String id){
        return ordersService.updates(id)?Result.success():Result.fail();
    }

    @PostMapping("/send")
    public Result send(@RequestParam String id){
        return ordersService.send(id)?Result.success():Result.fail();
    }

    @PostMapping("/list")
    public Result list(@RequestBody Map<String, Integer> params) {
        Integer userId = params.get("id");
        List<Orders> list = ordersService.listById(userId);
        // 返回结果
        return Result.success(list);
    }
    @PostMapping("/listType")
    public Result listType(@RequestBody Orders orders) {

        List<Orders> list = ordersService.listType(orders);
        // 返回结果
        return Result.success(list);
    }
    @PostMapping("/listAddress")
    public Result listAddress(@RequestBody Orders orders) {

        List<Orders> list = ordersService.listAddress(orders);
        // 返回结果
        return Result.success(list);
    }
    /*
     * 分页+模糊查询
     * */
    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query){
        HashMap<Object,Object> param = query.getParam();
        String name = (String)param.get("name");
        //分页
        Page<Orders> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        //模糊查询
        LambdaQueryWrapper<Orders> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(name) && !"null".equals(name)) {
            lambdaQueryWrapper.like(Orders::getStatus, name);
        }
        IPage<Orders> result = ordersService.pageC(page,lambdaQueryWrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }
}
