package com.example.service;

import com.example.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {


    List<Dept> getAllDept();
    void delById(Integer id);
    void addDept(Dept dept);
    Dept selById(Integer id);
    void amendDept(Dept dept);
}
