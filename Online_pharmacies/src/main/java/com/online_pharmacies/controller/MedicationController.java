package com.online_pharmacies.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online_pharmacies.common.HotPageParam;
import com.online_pharmacies.common.QueryPageParam;
import com.online_pharmacies.common.Result;
import com.online_pharmacies.entity.Drugdrugtype;
import com.online_pharmacies.entity.Medication;
import com.online_pharmacies.entity.User;
import com.online_pharmacies.entity.UserAddress;
import com.online_pharmacies.service.MedicationService;
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
 * @since 2024-09-05
 */
@RestController
@RequestMapping("/medication")
public class MedicationController {
    @Autowired
    private MedicationService medicationService;
    /*
     * 分页+模糊查询
     * */
    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query){
        HashMap<Object,Object> param = query.getParam();
        String name = (String)param.get("name");
        //分页
        Page<Medication> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        //模糊查询
        LambdaQueryWrapper<Medication> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(name) && !"null".equals(name)) {
            lambdaQueryWrapper.like(Medication::getName, name);
        }
        IPage<Medication> result = medicationService.pageC(page,lambdaQueryWrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }
    @PostMapping("/hotPage")
    public Result hotPage(@RequestBody HotPageParam hotPageParam){
        HashMap<Object,Object> param = hotPageParam.getParam();
        String name = (String)param.get("name");
        //分页
        Page<Medication> page = new Page<>();
        page.setCurrent(hotPageParam.getHotNum());
        page.setSize(hotPageParam.getHotSize());
        //模糊查询
        LambdaQueryWrapper<Medication> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(name) && !"null".equals(name)) {
            lambdaQueryWrapper.like(Medication::getName, name);
        }
        IPage<Medication> result = medicationService.hotPage(page,lambdaQueryWrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }
    @PostMapping("/list")
    public Result list(@RequestBody Map<String, Integer> params) {
        Integer medicationId = params.get("id");
        List<Medication> list = medicationService.listById(medicationId);
        // 返回结果
        return Result.success(list);
    }
    @PostMapping("/save")
    public Result save(@RequestBody Medication medication){
        return medicationService.save(medication)?Result.success():Result.fail();
    }
    @PostMapping("/update")
    public Result update(@RequestBody Medication medication){return medicationService.updateById(medication)?Result.success():Result.fail();}
    @GetMapping("/delete")
    public Result delete(@RequestParam String id){
        return medicationService.removeById(id)?Result.success():Result.fail();
    }

    @GetMapping("/listall")
    public Result listall(){
        List<Medication> list = medicationService.list();
        return Result.success(list);
    }
}
