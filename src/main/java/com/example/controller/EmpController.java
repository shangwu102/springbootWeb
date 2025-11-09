package com.example.controller;

import com.example.anno.Log;
import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.service.EmpService;
import com.example.utils.Result;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 员工管理Controller
 */
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/emps")
    public Result selEmp(Integer page, Integer pageSize, String name, Short gender, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        PageBean pageBean = empService.selEmp(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }
    @Log
    @DeleteMapping("/emps/{ids}")
    public Result delEmp(@PathVariable List<Integer> ids) {
        empService.delEmp(ids);
        return Result.success();
    }
    @Log
    @PostMapping("emps")
    public Result addEmp(@RequestBody Emp emp) {
        empService.addEmp(emp);
        return Result.success();
    }
    @GetMapping("/emps/{id}")
    public Result selEmpById(@PathVariable Integer id) {
        Emp emp = empService.selEmpById(id);
        return Result.success(emp);
    }
    @Log
    @PutMapping("/emps")
    public Result updEmp(@RequestBody Emp emp) {
        empService.updEmp(emp);
       return Result.success(emp);
    }
}
