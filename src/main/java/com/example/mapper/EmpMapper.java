package com.example.mapper;

import com.example.pojo.Dept;
import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {
    public abstract List<Emp> selEmp(Integer page,Integer pageSize,String name, Short gender, LocalDate begin, LocalDate end);
    public abstract Integer CountEmp();
    public abstract void delEmp(List<Integer> ids);
    public abstract void addEmp(Emp emp);
    public abstract Emp selEmpById(Integer id);
    public abstract void updEmp(Emp emp);
    public abstract Emp loginEmp(Emp emp);
    public abstract void delById(Integer deptId);
}
