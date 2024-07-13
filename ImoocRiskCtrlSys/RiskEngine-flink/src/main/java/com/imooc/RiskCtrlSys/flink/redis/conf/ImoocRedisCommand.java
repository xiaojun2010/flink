package com.imooc.RiskCtrlSys.flink.redis.conf;

import lombok.Getter;

/**
 * zxj
 * description: Redis命令的枚举类
 * date: 2023
 */

@Getter
public enum ImoocRedisCommand {

    GET(ImoocRedisDataType.STRING);

    private ImoocRedisDataType imoocRedisDataType;

    ImoocRedisCommand(ImoocRedisDataType imoocRedisDataType) {
        this.imoocRedisDataType = imoocRedisDataType;
    }
}
