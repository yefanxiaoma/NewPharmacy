package com.online_pharmacies.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.common.QueryPageParam;
import com.online_pharmacies.common.Result;
import com.online_pharmacies.entity.Menu;
import com.online_pharmacies.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Wang
 * @since 2024-10-08
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @GetMapping("/list")
    public Result list(@RequestParam String roleId){
        List<Menu> list = menuService.lambdaQuery().like(Menu::getMenuRight,roleId).list();
        return Result.success(list);
    }
    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query){
        HashMap<Object,Object> param = query.getParam();
        String name = (String)param.get("name");
        //分页
        Page<Menu> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        //模糊查询
        LambdaQueryWrapper<Menu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(name) && !"null".equals(name)) {
            lambdaQueryWrapper.like(Menu::getMenuName, name);
        }
        IPage<Menu> result = menuService.pageC(page,lambdaQueryWrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }
    @PostMapping("/save")
    public Result save(@RequestBody Menu menu){
        return menuService.save(menu)?Result.success():Result.fail();
    }
    @PostMapping("/update")
    public Result update(@RequestBody Menu menu){return menuService.updateById(menu)?Result.success():Result.fail();}
    @GetMapping("/delete")
    public Result delete(@RequestParam String id){
        return menuService.removeById(id)?Result.success():Result.fail();
    }
}
