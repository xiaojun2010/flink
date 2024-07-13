package com.imooc.RiskCtrlSys.utils.redis;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * zxj
 * description: Redis配置信息读取类
 * date: 2023
 */

/* **********************
 *
 * @ConfigurationProperties 读取 application.yml 的配置信息
 *
 * *********************/
@ConfigurationProperties(prefix = "spring.redis.cluster")
@Component
@Data
public class RedisProperties {

    /* **********************
     *
     * 注意两个地方：
     *
     * 1. 属性的名称要和 application.yml的键的名称相同
     * 2. 属性的数据类型要和 application.yml的对应的值得数据类型相同
     *
     * *********************/

    //集群节点列表
    private String nodes;

}
