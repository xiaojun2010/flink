package com.imooc.RiskCtrlSys.model;

import lombok.Data;

/**
 * zxj
 * description: clickhouse 测试表映射的PO对象
 * date: 2023
 */


@Data
public class CHTestPO {

    private String name;

    public CHTestPO() {
    }

    public CHTestPO(String name) {
        this.name = name;
    }
}
