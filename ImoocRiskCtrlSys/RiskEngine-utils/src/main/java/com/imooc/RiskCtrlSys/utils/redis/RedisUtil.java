package com.imooc.RiskCtrlSys.utils.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * zxj
 * description: Redis工具类
 * date: 2023
 */

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * zxj
     * description: RedisTemplate set
     * @param key:
     * @param value:
     * @return void
     */
    public void stringSet(String key,Object value) {
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * zxj
     * description: get
     * @param key:
     * @return java.lang.Object
     */
    public Object stringGet(String key) {
        Object res = redisTemplate.opsForValue().get(key);
        return res;
    }

    /**
     * zxj
     * description: RedisTemplate hash set
     * @param key:
     * @param map:
     * @return void
     */
    public void  hashSet(String key, Map<String,Object> map) {
        redisTemplate.opsForHash().putAll(key,map);
    }

    /**
     * zxj
     * description: RedisTemplate hash get
     * @param key:
     * @param hashKey:
     * @return java.lang.Object
     */
    public Object hashGet(String key,String hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }
}
