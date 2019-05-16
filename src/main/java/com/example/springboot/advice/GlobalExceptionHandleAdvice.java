package com.example.springboot.advice;

import com.example.springboot.ResponseResult;
import com.example.springboot.controller.UserController;
import org.springframework.dao.DataAccessException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yc
 * @version 1.0
 * @project springboot
 * @description 全局异常处理器，例如对Validator校验框架产生的异常，数据库访问异常统一做处理返回
 * @date 2019-04-20 04:59
 */

@ControllerAdvice(basePackages = "com.example.springboot.controller")
public class GlobalExceptionHandleAdvice {

    @ExceptionHandler(value ={Exception.class})
    @ResponseBody
    public ResponseResult globalExceptionHandler(Exception e){

          if(e instanceof DataAccessException){

              return ResponseResult.builder().code(500).message("fail").data("数据库服务器发生异常！！！").build();
          }
        BindingResult bindResult = null;

        if (e instanceof BindException) {
            bindResult = ((BindException) e).getBindingResult();
        } else if (e instanceof MethodArgumentNotValidException) {
            bindResult = ((MethodArgumentNotValidException) e).getBindingResult();
        }
        String msg;
        if (bindResult != null && bindResult.hasErrors()) {
            msg = bindResult.getAllErrors().get(0).getDefaultMessage();
            return ResponseResult.builder().code(500).message("fail").data(msg).build();
        }
        return ResponseResult.builder().code(500).message("fail").data("服务器发生未知异常！！！").build();
    }
}
