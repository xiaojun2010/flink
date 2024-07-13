package com.imooc.RiskCtrlSys.flink.job.cep.condition.ClipCouponsDeep;

import com.imooc.RiskCtrlSys.model.EventPO;
import org.apache.flink.cep.pattern.conditions.SimpleCondition;

/**
 * zxj
 * description: TODO
 * date: 2023
 */

public class EventIntervalCondition extends SimpleCondition<EventPO> {

    @Override
    public boolean filter(EventPO eventPO) throws Exception {

        if (!eventPO.getEvent_context().getProfile().getGrade().equals("L1")) {
            return true;
        }
        return false;
    }
}
