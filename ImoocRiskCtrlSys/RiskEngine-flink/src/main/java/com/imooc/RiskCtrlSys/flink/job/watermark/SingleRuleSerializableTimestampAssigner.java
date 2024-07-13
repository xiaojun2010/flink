package com.imooc.RiskCtrlSys.flink.job.watermark;

import com.imooc.RiskCtrlSys.model.SingleRulePO;
import org.apache.flink.api.common.eventtime.SerializableTimestampAssigner;

/**
 * zxj
 * description: 原子规则流自定义生成水印
 * date: 2023
 */

public class SingleRuleSerializableTimestampAssigner implements SerializableTimestampAssigner<SingleRulePO> {
    @Override
    public long extractTimestamp(SingleRulePO singleRulePO, long l) {
        return singleRulePO.getTs_ms();
    }
}
