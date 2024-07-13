package com.imooc.RiskCtrlSys.commons.exception.enums;

import lombok.Getter;

/**
 * zxj
 * description: Redis异常枚举类
 * date: 2023
 */

@Getter
public enum RedisExceptionInfo implements BizExceptionInfo  {

    REDISTEMPLATE_NULL("-300", "RedisTemplate对象为null");

    private String exceptionCode;
    private String exceptionMsg;

    RedisExceptionInfo(String exceptionCode,
                       String exceptionMsg) {
        this.exceptionCode = exceptionCode;
        this.exceptionMsg = exceptionMsg;
    }
}
