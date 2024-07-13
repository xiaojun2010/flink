package com.imooc.RiskCtrlSys.api.exception;

import com.imooc.RiskCtrlSys.commons.exception.custom.RedisException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * zxj
 * description: 全局的异常捕抓 (Api)
 * date: 2023
 */

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = RedisException.class)
    public void RedisExceptionHandler(RedisException e) {

        //TODO 错误处理
    }
}
