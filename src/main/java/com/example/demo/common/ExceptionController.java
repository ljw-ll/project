package com.example.demo.common;

import com.example.demo.controller.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 自定义统一异常处理组件
 */
@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MyException.class)
    public ResultVo handleValidException(MyException e){
       return ResultVo.error(e.getCode(),e.getMessage());
    }
}
