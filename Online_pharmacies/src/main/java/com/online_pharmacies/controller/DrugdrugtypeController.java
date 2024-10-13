package com.online_pharmacies.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.common.QueryPageParam;
import com.online_pharmacies.common.Result;
import com.online_pharmacies.entity.Drugdrugtype;
import com.online_pharmacies.entity.Medicationtype;
import com.online_pharmacies.entity.User;
import com.online_pharmacies.service.DrugdrugtypeService;
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
 * @since 2024-10-12
 */
@RestController
@RequestMapping("/drugdrugtype")
public class DrugdrugtypeController {
    @Autowired
    private DrugdrugtypeService drugdrugtypeService;
    /*
     * 分页+模糊查询
     * */
    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query){
        HashMap<Object,Object> param = query.getParam();
        String name = (String)param.get("name");
        //分页
        Page<Drugdrugtype> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        //模糊查询
        LambdaQueryWrapper<Drugdrugtype> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(name) && !"null".equals(name)) {
            lambdaQueryWrapper.like(Drugdrugtype::getTypeFId, name);
        }
        IPage<Drugdrugtype> result = drugdrugtypeService.pageC(page,lambdaQueryWrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }
    @PostMapping("/save")
    public Result save(@RequestBody Drugdrugtype drugdrugtype){
        return drugdrugtypeService.save(drugdrugtype)?Result.success():Result.fail();
    }
    @PostMapping("/update")
    public Result update(@RequestBody Drugdrugtype drugdrugtype){return drugdrugtypeService.updateById(drugdrugtype)?Result.success():Result.fail();}
    @GetMapping("/delete")
    public Result delete(@RequestParam String id){
        return drugdrugtypeService.removeById(id)?Result.success():Result.fail();
    }

}
