package com.example.service.impl;

import com.example.mapper.DeptMapper;
import com.example.mapper.EmpMapper;
import com.example.pojo.Dept;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> getAllDept() {
        return deptMapper.getAllDept();
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delById(Integer id) {
        deptMapper.delById(id);
        empMapper.delById(id);
    }

    @Override
    public void addDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.addDept(dept);
    }

    @Override
    public Dept selById(Integer id) {
        deptMapper.selById(id);

        return deptMapper.selById(id);
    }

    @Override
    public void amendDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.amendDept(dept);
    }
}
