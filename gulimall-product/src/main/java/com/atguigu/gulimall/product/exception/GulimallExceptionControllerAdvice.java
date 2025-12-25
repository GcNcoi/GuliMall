package com.atguigu.gulimall.product.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年12月25日 11:56
 */
@ControllerAdvice(basePackages = "com.atguigu.gulimall.product.controller")
public class GulimallExceptionControllerAdvice {

    /**
     * 处理校验异常
     * @param e
     */
    @ExceptionHandler(value = Exception.class)
    public void handleValidationException(Exception e){
        e.printStackTrace();
    }

}
