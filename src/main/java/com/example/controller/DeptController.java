package com.example.controller;

import com.example.anno.Log;
import com.example.pojo.Dept;
import com.example.service.DeptService;
import com.example.service.impl.DeptServiceImpl;
import com.example.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j
@RestController
public class DeptController {



    @Autowired
    private DeptService deptService;
    @GetMapping("depts")
    public Result getAllDept() {
        List<Dept> deptList = deptService.getAllDept();
        return Result.success(deptList);
    }
    @Log
    @DeleteMapping("/depts/{id}")
    public Result delById(@PathVariable Integer id) {
        log.info(String.valueOf(id));
        deptService.delById(id);
        return Result.success();
    }
    @Log
    @PostMapping("/depts")
    public Result addDept(@RequestBody Dept dept) {
        log.info(dept.toString());
        deptService.addDept(dept);
        return Result.success();
    }
    @GetMapping("/depts/{id}")
    public Result selById(@PathVariable Integer id) {
        Dept dept = deptService.selById(id);
        return Result.success(dept);
    }
    @PutMapping("/depts")
    public Result amendDept(@RequestBody Dept dept) {
        deptService.amendDept(dept);
        return Result.success();
    }
}
