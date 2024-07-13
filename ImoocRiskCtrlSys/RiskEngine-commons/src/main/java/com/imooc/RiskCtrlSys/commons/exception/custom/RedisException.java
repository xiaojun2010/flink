package com.imooc.RiskCtrlSys.commons.exception.custom;

import com.imooc.RiskCtrlSys.commons.exception.BizRuntimeException;
import com.imooc.RiskCtrlSys.commons.exception.enums.BizExceptionInfo;

/**
 * zxj
 * description: Redis 自定义异常类
 * date: 2023
 */

public class RedisException extends BizRuntimeException {


    public RedisException(BizExceptionInfo info) {
        super(info);
    }
}
