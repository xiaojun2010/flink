package com.imooc.RiskCtrlSys.commons.exception.enums;

/**
 * author: Wu
 * description: 异常枚举类接口
 * date:  2023
*/

public interface BizExceptionInfo {

    /**
     * zxj
     * description: 获取异常错误码
     * @param :
     * @return java.lang.String
     */
    String getExceptionCode();

    /**
     * zxj
     * description: 获取异常信息
     * @param :
     * @return java.lang.String
     */
    String getExceptionMsg();
}
