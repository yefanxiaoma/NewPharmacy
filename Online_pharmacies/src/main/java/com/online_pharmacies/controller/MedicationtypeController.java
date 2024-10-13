package com.online_pharmacies.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.common.QueryPageParam;
import com.online_pharmacies.common.Result;
import com.online_pharmacies.entity.Medicationtype;
import com.online_pharmacies.service.MedicationtypeService;
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
 * @since 2024-09-25
 */
@RestController
@RequestMapping("/medicationtype")
public class MedicationtypeController {
    @Autowired
    MedicationtypeService medicationtypeService;
    @GetMapping("/list")
    public Result list(){
      List<Medicationtype> list = medicationtypeService.list();
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
        Page<Medicationtype> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        //模糊查询
        LambdaQueryWrapper<Medicationtype> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(name) && !"null".equals(name)) {
            lambdaQueryWrapper.like(Medicationtype::getTypeName, name);
        }
        IPage<Medicationtype> result = medicationtypeService.pageC(page,lambdaQueryWrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }
    /*
     * 分页+模糊查询
     * */
    @PostMapping("/listType")
    public Result listType(@RequestBody QueryPageParam query){
        HashMap<Object,Object> param = query.getParam();
        String name = (String)param.get("name");
        //分页
        Page<Medicationtype> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        //模糊查询
        LambdaQueryWrapper<Medicationtype> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(name) && !"null".equals(name)) {
            lambdaQueryWrapper.like(Medicationtype::getTypeName, name);
        }
        IPage<Medicationtype> result = medicationtypeService.pageType(page,lambdaQueryWrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }
    @PostMapping("/save")
    public Result save(@RequestBody Medicationtype medicationtype){
        return medicationtypeService.save(medicationtype)?Result.success():Result.fail();
    }
    @PostMapping("/update")
    public Result update(@RequestBody Medicationtype medicationtype){return medicationtypeService.updateById(medicationtype)?Result.success():Result.fail();}
    @GetMapping("/delete")
    public Result delete(@RequestParam String id) {
        return medicationtypeService.removeById(id) ? Result.success() : Result.fail();
    }
}
