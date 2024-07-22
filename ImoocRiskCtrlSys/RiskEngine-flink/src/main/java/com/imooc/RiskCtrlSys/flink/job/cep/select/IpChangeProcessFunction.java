package com.imooc.RiskCtrlSys.flink.job.cep.select;

import com.imooc.RiskCtrlSys.model.EventPO;
import org.apache.flink.cep.functions.PatternProcessFunction;
import org.apache.flink.util.Collector;

import java.util.List;
import java.util.Map;

/**
 * zxj
 * description: 最近15分钟内IP更换次数超过3次的用户的提取
 * date: 2023
 */

public class IpChangeProcessFunction extends PatternProcessFunction<EventPO, EventPO> {

    /**
     * @param map     map<模式名,模式名对应的匹配事件>
     * @param context   enables access to time features and emitting results through side outputs
     * @param collector Collector used to output the generated elements
     * @throws Exception
     */
    @Override
    public void processMatch(Map<String, List<EventPO>> map, Context context, Collector<EventPO> collector) throws Exception {
//        collector.collect(map);
    }
}
