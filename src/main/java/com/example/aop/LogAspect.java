package com.example.aop;


import com.alibaba.fastjson.JSONObject;
import com.example.mapper.OperateLogMapper;
import com.example.pojo.OperateLog;
import com.example.utils.Jwt;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LogAspect {
    @Autowired
    private OperateLogMapper operateLogMapper;
    @Autowired
    private HttpServletRequest request;
    @Around("@annotation(com.example.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {


        String jwt = request.getHeader("token");
        Claims claims = Jwt.parseJwt(jwt);
        log.info("jwt信息:{}",jwt);
        Integer operateUser = (Integer) claims.get("id");
        LocalDateTime operateTime = LocalDateTime.now();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);
        long begin = System.currentTimeMillis();


        Object result = joinPoint.proceed();
        long end = System. currentTimeMillis();

        String returnValue = JSONObject.toJSONString(result);
        long costTime = begin - end;
        OperateLog operateLog = new OperateLog(null,operateUser,operateTime,className,methodName,methodParams,returnValue,costTime);
        operateLogMapper.insert(operateLog);
        log.info("AOP记录日志:{}",operateLog);
        return result;

    }
}
