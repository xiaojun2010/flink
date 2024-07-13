package com.imooc.RiskCtrlSys.flink.utils;

import com.imooc.RiskCtrlSys.flink.redis.conf.ImoocRedisCommand;
import com.imooc.RiskCtrlSys.model.RedisPO;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * author: Wu
 * description: redis读取工具类单元测试
 * date:  2023
*/
class RedisReadUtilTest {

    @DisplayName("测试自定义Source读取Redis,Redis数据类型是String类型")
    @Test
    void testReadByCustomSourceWithString() throws Exception {
        StreamExecutionEnvironment env =
                StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<RedisPO> dataStream = RedisReadUtil.read(
                env,
                ImoocRedisCommand.GET,
                "imooc:bahir"
        );

        dataStream.print();
        env.execute();
    }
}
