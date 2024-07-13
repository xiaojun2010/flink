package com.imooc.RiskCtrlSys.flink.job.watermark;

import com.imooc.RiskCtrlSys.flink.model.MysqlTestPO;
import org.apache.flink.api.common.eventtime.SerializableTimestampAssigner;

/**
 * zxj
 * description: TODO
 * date: 2023
 */

public class CustomSerializableTimestampAssignerTest implements SerializableTimestampAssigner<MysqlTestPO> {
    @Override
    public long extractTimestamp(MysqlTestPO mysqlTestPO, long l) {
        return mysqlTestPO.getTs_ms();
    }
}
