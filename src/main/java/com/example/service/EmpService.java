package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 员工管理
 */

public interface EmpService {

    PageBean selEmp(Integer page, Integer pageSize,String name,Short gender, LocalDate begin, LocalDate end);
    void delEmp(List<Integer> ids);

    void addEmp(Emp emp);

    Emp selEmpById(Integer id);

    void updEmp(Emp emp);

    Emp loginEmp(Emp emp);
}
