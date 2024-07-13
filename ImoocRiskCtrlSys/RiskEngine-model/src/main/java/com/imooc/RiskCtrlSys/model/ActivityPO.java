package com.imooc.RiskCtrlSys.model;

import lombok.Data;

import java.util.List;

/**
 * zxj
 * description: 策略 POJO
 * date: 2023
 */

@Data
public class ActivityPO {

    /**
     * 策略名称
     */
    private String activation_name;

    /**
     * 策略动作
     */
    private List<ActionPO> actions;
}
