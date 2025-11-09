package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean selEmp(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        page = (page - 1) * pageSize;
        List<Emp> empList = empMapper.selEmp(page, pageSize,name, gender, begin,end);
        Integer countEmp = empMapper.CountEmp();
        PageBean pageBean = new PageBean();
        pageBean.setTotal(countEmp);
        pageBean.setRows(empList);
        return pageBean;
    }

    @Override
    public void delEmp(List<Integer> ids) {
        empMapper.delEmp(ids);
    }

    @Override
    public void addEmp(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.addEmp(emp);
    }

    @Override
    public Emp selEmpById(Integer id) {
        return empMapper.selEmpById(id);
    }

    @Override
    public void updEmp(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updEmp(emp);
    }

    @Override
    public Emp loginEmp(Emp emp) {
        return empMapper.loginEmp(emp);
    }

}
