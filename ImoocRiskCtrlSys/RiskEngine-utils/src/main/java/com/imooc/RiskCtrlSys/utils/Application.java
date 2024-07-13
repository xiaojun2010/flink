package com.imooc.RiskCtrlSys.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * zxj
 * description: SpringBoot 启动类 (Hbase单元测试需要用到)
 * date: 2023
 */

@SpringBootApplication(exclude= { DataSourceAutoConfiguration.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
