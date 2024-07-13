package com.imooc.RiskCtrlSys.flink.job.aggregation.acc;

/**
 * zxj
 * description: 累加器计算方法接口
 * date: 2023
 */

public interface AccAggregate {

    public Double aggregate(String value_before, String value_after);
}
