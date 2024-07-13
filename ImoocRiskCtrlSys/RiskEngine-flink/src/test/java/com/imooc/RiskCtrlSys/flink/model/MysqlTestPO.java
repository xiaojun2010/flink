package com.imooc.RiskCtrlSys.flink.model;

import lombok.Data;

import java.io.Serializable;

/**
 * zxj
 * description: Mysql测试表POJO对象
 * date: 2023
 */

@Data
public class MysqlTestPO implements Serializable {
    private Long id;
    private String name;
    /**
     * Mysql操作的时间戳
     */
    private Long ts_ms;

    public MysqlTestPO() {
    }

    public MysqlTestPO(Long id, String name, Long ts_ms) {
        this.id = id;
        this.name = name;
        this.ts_ms = ts_ms;
    }
}
