package com.atguigu.gulimall.product.exception;

import com.atguigu.common.exception.BizCodeEnume;
import com.atguigu.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述: 处理全局异常
 *
 * @author: Gxf
 * @date: 2025年12月25日 11:56
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.atguigu.gulimall.product.controller")
//@ControllerAdvice(basePackages = "com.atguigu.gulimall.product.controller")
public class GulimallExceptionControllerAdvice {

    /**
     * 处理校验异常
     * @param e
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidationException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        // 校验失败，提取错误信息
        Map<String, String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return R.error(BizCodeEnume.VAILD_EXCEPTION.getCode(), BizCodeEnume.VAILD_EXCEPTION.getMsg()).put("data", errorMap);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable){
        return R.error(BizCodeEnume.UNKNOW_EXCEPTION.getCode(), BizCodeEnume.UNKNOW_EXCEPTION.getMsg());
    }

}
