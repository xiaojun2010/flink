package com.imooc.RiskCtrlSys.commons.exception.enums;

import lombok.Getter;

/**
 * zxj
 * description: Flink 配置信息异常枚举类
 * date: 2023
 */

@Getter
public enum FlinkPropertiesExceptionInfo implements BizExceptionInfo {

    PROPERTIES_NULL("-300", "配置参数不存在");

    private String exceptionCode;
    private String exceptionMsg;

    FlinkPropertiesExceptionInfo(
                String exceptionCode,
                String exceptionMsg) {
        this.exceptionCode = exceptionCode;
        this.exceptionMsg = exceptionMsg;
    }

}
