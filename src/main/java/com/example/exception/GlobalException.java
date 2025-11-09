package com.example.exception;


import com.example.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(Exception.class)
    public Result ex(Exception e) {
        e.printStackTrace();
        return Result.error("操作失败");
    }
}
