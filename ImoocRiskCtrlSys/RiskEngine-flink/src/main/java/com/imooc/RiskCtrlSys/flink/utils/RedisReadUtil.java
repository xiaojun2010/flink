package com.imooc.RiskCtrlSys.flink.utils;

import com.imooc.RiskCtrlSys.flink.redis.conf.ImoocRedisCommand;
import com.imooc.RiskCtrlSys.flink.redis.source.ImoocRedisSource;
import com.imooc.RiskCtrlSys.model.RedisPO;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * zxj
 * description: Flink读取Redis工具类
 * date: 2023
 */

public class RedisReadUtil {

    /**
     * zxj
     * description: Flink添加Source
     * @param env: Flink上下文环境
     * @param imoocRedisCommand: redis命令
     * @param key:  redis键
     * @return org.apache.flink.streaming.api.datastream.DataStream<com.imooc.RiskCtrlSys.model.RedisPO>
     */
    public static DataStream<RedisPO> read(
            StreamExecutionEnvironment env,
            ImoocRedisCommand imoocRedisCommand,
            String key
            ) {

       return env.addSource(new ImoocRedisSource(imoocRedisCommand,key));
    }
}
