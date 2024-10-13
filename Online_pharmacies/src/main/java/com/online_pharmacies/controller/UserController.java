package com.online_pharmacies.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.common.QueryPageParam;
import com.online_pharmacies.common.Result;
import com.online_pharmacies.entity.Medicationtype;
import com.online_pharmacies.entity.Menu;
import com.online_pharmacies.entity.User;
import com.online_pharmacies.service.MenuService;
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
 * @since 2024-09-12
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;

   @PostMapping("/login")
   public Result login(@RequestBody User user){
       User userFromDb = userService.getByUserno(user.getUserno());
       if (userFromDb != null && userFromDb.getPassword().equals(user.getPassword())) {
           HashMap<String, Object> res = new HashMap<>();
           res.put("user", userFromDb);
           return Result.success(res);
       }
       return Result.fail();
   }
   @PostMapping("/adminlogin")
    public Result adminlogin(@RequestBody User user){
       List<User> list = userService.lambdaQuery()
               .eq(User::getUserno,user.getUserno())
               .eq(User::getPassword,user.getPassword()).list();
       if(!list.isEmpty()){
           User user1 = list.get(0);
           if (user1.getRoleId() != 1 && user1.getRoleId() != 0) {
               return Result.fail();
           }
           List<Menu> menuList = menuService.lambdaQuery().like(Menu::getMenuRight,user1.getRoleId()).list();
           HashMap<String,Object> res = new HashMap<>();
           res.put("admin",user1);
           res.put("menu",menuList);
           return Result.success(res);
       }
       return Result.fail();
   }
    /*
     * 账号唯一性
     * */
    @GetMapping("/findByNo")
    public Result findByNo(@RequestParam String no){
        List<User> list = userService.lambdaQuery().eq(User::getUserno,no).list();
        return !list.isEmpty() ?Result.success(list):Result.fail();
    }
    @PostMapping("/list")
    public Result list(@RequestBody Map<String, Integer> params) {
        Integer userId = params.get("id");
        List<User> list = userService.listById(userId);
        // 返回结果
        return Result.success(list);
    }
    @GetMapping("/listall")
    public Result listall(){
        List<User> list = userService.list();
        return Result.success(list);
    }
    /*
     * 分页+模糊查询
     * */
    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query){
        HashMap<Object,Object> param = query.getParam();
        String name = (String)param.get("name");
        String no = (String)param.get("no");
        String roleId = (String)param.get("roleId");
        //分页
        Page<User> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        //模糊查询
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(name) && !"null".equals(name)) {
            lambdaQueryWrapper.like(User::getName, name);
        }
        if(StringUtils.isNotBlank(no)) {
            lambdaQueryWrapper.like(User::getUserno, no);
        }
        if(StringUtils.isNotBlank(roleId)) {
            lambdaQueryWrapper.eq(User::getRoleId, roleId);
        }
        IPage<User> result = userService.paging(page,lambdaQueryWrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }
    @PostMapping("/save")
    public Result save(@RequestBody User user){
        return userService.save(user)?Result.success():Result.fail();
    }
    @PostMapping("/update")
    public Result update(@RequestBody User user){return userService.updateById(user)?Result.success():Result.fail();}
    @GetMapping("/delete")
    public Result delete(@RequestParam String id){
        return userService.removeById(id)?Result.success():Result.fail();
    }

}
