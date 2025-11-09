package com.example.controller;


import com.example.pojo.Emp;
import com.example.service.EmpService;
import com.example.utils.Jwt;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        Emp loginEmp = empService.loginEmp(emp);

        if(loginEmp != null) {
            Map<String,Object> map = new HashMap<>();
            map.put("id",loginEmp.getId());
            map.put("name",loginEmp.getName());
            map.put("username",loginEmp.getUsername());
            String jwt = Jwt.generateJwt(map);
            return Result.success(jwt);
        }
        return Result.error("登陆失败");

    }
}
