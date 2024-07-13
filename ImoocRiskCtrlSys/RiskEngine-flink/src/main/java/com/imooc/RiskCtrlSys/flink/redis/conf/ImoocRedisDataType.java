package com.imooc.RiskCtrlSys.flink.redis.conf;

import lombok.Getter;

/**
 * zxj
 * description: Redis数据类型的枚举类
 * date: 2023
 */

@Getter
public enum ImoocRedisDataType {

    STRING,
    HASH,
    LIST,
    SET,
    SORTED_SET,
    ;

    ImoocRedisDataType() {
    }
}
