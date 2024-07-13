package com.imooc.RiskCtrlSys.flink.job.aggregation.acc;

import com.imooc.RiskCtrlSys.model.EventPO;

/**
 * zxj
 * description: 累加器计算: 直接+1
 * date: 2023
 */

public class AccAdd implements AccAggregate {

    public Double aggregate(
            String value_before,
            String value_after) {
        return 1.0;
    }
}
