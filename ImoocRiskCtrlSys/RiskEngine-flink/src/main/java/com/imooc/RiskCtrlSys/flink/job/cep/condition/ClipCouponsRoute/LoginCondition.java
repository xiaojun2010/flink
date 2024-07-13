package com.imooc.RiskCtrlSys.flink.job.cep.condition.ClipCouponsRoute;

import com.imooc.RiskCtrlSys.flink.utils.EventConstantUtil;
import com.imooc.RiskCtrlSys.model.EventPO;
import org.apache.flink.cep.pattern.conditions.SimpleCondition;

/**
 * zxj
 * description: 过滤登录行为事件
 * date: 2023
 */

public class LoginCondition extends SimpleCondition<EventPO> {

    @Override
    public boolean filter(EventPO eventPO) throws Exception {
        return eventPO.getEvent_name().equals(EventConstantUtil.LOGIN_SUCCESS);
    }
}
