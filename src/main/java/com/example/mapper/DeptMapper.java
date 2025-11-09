package com.example.mapper;

import com.example.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
    @Select("select * from my_tli.dept")
    public abstract List<Dept> getAllDept();
    @Delete("delete from my_tli.dept where id = #{id}")
    public abstract void delById(Integer id);
    @Insert("insert into my_tli.dept(name, create_time, update_time) values (#{name},#{createTime},#{updateTime});")
    public abstract void addDept(Dept dept);
    @Select("select * from my_tli.dept where id = #{id}")
    public  abstract Dept selById(Integer id);
    @Update("update my_tli.dept set name = #{name},update_time = #{updateTime} where id = #{id}")
    public  abstract void amendDept(Dept dept);
}
