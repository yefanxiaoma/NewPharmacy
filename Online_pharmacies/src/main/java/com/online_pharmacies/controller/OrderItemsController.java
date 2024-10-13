package com.online_pharmacies.controller;

import com.online_pharmacies.common.Result;
import com.online_pharmacies.entity.OrderItems;
import com.online_pharmacies.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Wang
 * @since 2024-10-05
 */
@RestController
@RequestMapping("/orderItems")
public class OrderItemsController {
    @Autowired
    OrderItemsService orderItemsService;
    @PostMapping("/submit")
    public Result sumbit(@RequestBody OrderItems orderItems){
        return orderItemsService.save(orderItems)?Result.success():Result.fail();
    }
    @PostMapping("/list")
    public Result list (@RequestBody OrderItems orderItems){
       List<OrderItems> list =  orderItemsService.listDetail(orderItems);
        // 返回结果
        return Result.success(list);
    }
}
