package com.imooc.RiskCtrlSys.commons.exception;

import com.imooc.RiskCtrlSys.commons.exception.custom.RedisException;
import com.imooc.RiskCtrlSys.commons.exception.enums.RedisExceptionInfo;

/**
 * zxj
 * description: 自定义异常类Demo
 * date: 2023
 */

public class CustomExceptionDemo {

    /**
     * zxj
     * description: 抛出自定义异常
     * @param :
     * @return void
     */
    public static void throwCustomException() throws RedisException {
        throw new RedisException(RedisExceptionInfo.REDISTEMPLATE_NULL);
    }
}
