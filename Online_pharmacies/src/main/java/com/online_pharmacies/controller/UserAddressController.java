package com.online_pharmacies.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.common.QueryPageParam;
import com.online_pharmacies.common.Result;
import com.online_pharmacies.entity.Orders;
import com.online_pharmacies.entity.User;
import com.online_pharmacies.entity.UserAddress;
import com.online_pharmacies.service.UserAddressService;
import com.online_pharmacies.service.UserService;
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
 * @since 2024-09-24
 */
@RestController
@RequestMapping("/userAddress")
public class UserAddressController {
    @Autowired
    UserAddressService userAddressService;
    @Autowired
    UserService userService;
    @PostMapping("/saveAddress")
    public Result doSave(@RequestBody UserAddress userAddress){
     return userAddressService.save(userAddress)?Result.success():Result.fail();
 }
    @PostMapping("/updateAddress")
    public Result doMod(@RequestBody UserAddress userAddress){
        return userAddressService.updateById(userAddress)?Result.success():Result.fail();
    }
    @GetMapping("/deleteAddress")
    public Result delete(@RequestParam String id){
        return userAddressService.removeById(id)?Result.success():Result.fail();
    }
    @PostMapping("/list")
    public Result list(@RequestBody Map<String, Integer> params) {
        Integer userId = params.get("id");
        List<UserAddress> list = userAddressService.listById(userId);
        // 返回结果
        return Result.success(list);
    }
    /*
    * 检查手机号是否被绑定*/
    @GetMapping("/findByPhone")
    public Result findByPhone(@RequestParam String phone){
        List<User> list = userService.lambdaQuery().eq(User::getPhone,phone).list();
        return !list.isEmpty() ?Result.success(list):Result.fail();
    }
    /*
     * 分页+模糊查询
     * */
    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query){
        HashMap<Object,Object> param = query.getParam();
        String name = (String)param.get("name");
        //分页
        Page<UserAddress> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        //模糊查询
        LambdaQueryWrapper<UserAddress> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(name) && !"null".equals(name)) {
            lambdaQueryWrapper.like(UserAddress::getUsername, name);
        }
        IPage<UserAddress> result = userAddressService.pageC(page,lambdaQueryWrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }
}
