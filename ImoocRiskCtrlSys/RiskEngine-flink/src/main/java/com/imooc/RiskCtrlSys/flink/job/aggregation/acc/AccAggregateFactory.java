package com.imooc.RiskCtrlSys.flink.job.aggregation.acc;

import com.imooc.RiskCtrlSys.flink.utils.ParameterConstantsUtil;

import java.lang.reflect.Parameter;

/**
 * zxj
 * description: 累加器计算工厂类
 * date: 2023
 */

public class AccAggregateFactory {

    public static AccAggregate getAggregate(String acc_aggregate) {
        String _package_path = ParameterConstantsUtil.PACKAGE_AGGREGATE_ACC;
        String packagePath = _package_path + ".Acc" + acc_aggregate;
        try {
            //通过反射获取Class对象
            Class accAggregate = Class.forName(packagePath);
            return (AccAggregate) accAggregate.newInstance();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
