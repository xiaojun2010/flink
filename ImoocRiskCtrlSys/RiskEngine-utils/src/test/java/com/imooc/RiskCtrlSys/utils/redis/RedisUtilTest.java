package com.imooc.RiskCtrlSys.utils.redis;

import com.imooc.RiskCtrlSys.utils.Application;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * zxj
 * description: Redis工具类单元测试
 * date:  2023
*/
@SpringBootTest(classes = Application.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RedisUtilTest {

    @Autowired
    private RedisUtil redisUtil;


    @DisplayName("测试RedisTemplate set")
    @Test
    @Order(1)
    void testStringSet() {

        redisUtil.stringSet("imooc:set", "this is test redis set");

    }

    @DisplayName("测试RedisTemplate get")
    @Test
    @Order(2)
    void testStringGet() {
        String value = (String)redisUtil.stringGet("imooc:set");
        System.out.println(value);

    }

    @DisplayName("测试redis hash set")
    @Test
    @Order(3)
    void testHashSet() {
        Map<String, Object> map = new HashMap<>();
        map.put("i","imooc");
        map.put("re","RiskEngine");
        redisUtil.hashSet("imooc:hash", map);
    }

    @DisplayName("测试RedisTemplate hash get")
    @Test
    @Order(4)
    void testHashGet() {

        String value = (String)redisUtil.hashGet("imooc:hash", "i");
        System.out.println(value);
    }
}
