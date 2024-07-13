package com.imooc.RiskCtrlSys.flink.redis.conf;

import com.imooc.RiskCtrlSys.flink.utils.ParameterUtil;
import org.apache.flink.api.java.utils.ParameterTool;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * zxj
 * description: Jedis配置类~
 * date: 2023
 */

public class JedisConf {

    public static JedisCluster getJedisCluster() throws IOException {

        ParameterTool parameterTool =
                ParameterUtil.getParameters();
        String host = parameterTool.get("redis.host");
        String port = parameterTool.get("redis.port");

        /* **********************
         *
         * 知识点：
         *
         * Jedis对象
         *
         * JedisPool : 用于redis单机版
         * JedisCluster: 用于redis集群
         *
         * JedisCluster对象能够自动发现正常的redis结节
         *
         * *********************/

        HostAndPort hostAndPort = new HostAndPort(
                host,
                Integer.parseInt(port)
        );
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(hostAndPort);

        return new JedisCluster(nodes);

    }
}
