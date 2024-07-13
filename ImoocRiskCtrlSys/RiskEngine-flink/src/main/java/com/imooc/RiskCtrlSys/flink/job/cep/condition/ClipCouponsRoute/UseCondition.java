package com.imooc.RiskCtrlSys.flink.job.cep.condition.ClipCouponsRoute;

import com.imooc.RiskCtrlSys.flink.utils.EventConstantUtil;
import com.imooc.RiskCtrlSys.model.EventPO;
import org.apache.flink.cep.pattern.conditions.SimpleCondition;

/**
 * zxj
 * description: 过滤使用优惠券行为事件
 * date: 2023
 */

public class UseCondition extends SimpleCondition<EventPO> {

    @Override
    public boolean filter(EventPO eventPO) throws Exception {
        return eventPO.getEvent_name().equals(EventConstantUtil.ORDER);
    }
}
