package com.imooc.RiskCtrlSys.commons.exception.custom;

import com.imooc.RiskCtrlSys.commons.exception.BizRuntimeException;
import com.imooc.RiskCtrlSys.commons.exception.enums.BizExceptionInfo;
import com.imooc.RiskCtrlSys.commons.exception.enums.RedisExceptionInfo;
import lombok.extern.slf4j.Slf4j;

/**
 * zxj
 * description: Flink 配置信息自定义错误
 * date: 2023
 */

@Slf4j
public class FlinkPropertiesException extends BizRuntimeException {

    public FlinkPropertiesException(BizExceptionInfo info) {
        super(info);
    }
}
