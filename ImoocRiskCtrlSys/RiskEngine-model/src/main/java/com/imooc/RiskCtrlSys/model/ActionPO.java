package com.imooc.RiskCtrlSys.model;

import lombok.Data;

/**
 * zxj
 * description: 策略动作 POJO
 * date: 2023
 */

@Data
public class ActionPO {

    /**
     * 策略动作方法
     */
    private String action;
    /**
     * 风险信息
     */
    private RiskInfoPO info;
}
