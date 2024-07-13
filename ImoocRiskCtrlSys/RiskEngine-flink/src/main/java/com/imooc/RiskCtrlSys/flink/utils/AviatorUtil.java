package com.imooc.RiskCtrlSys.flink.utils;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.function.AbstractFunction;

/**
 * zxj
 * description: Aviator 工具类, 应用于规则条件的判断
 * date: 2023
 */

public class AviatorUtil {

    /**
     * zxj
     * description: 方法重载, 解析字符串表达式
     * @param str: 字符串表达式,不包含自定义函数, 也不包含变量
     * @return java.lang.Object
     */
    public static Object execute(String str) {

        //执行AviatorEvaluator 对象的 execute(),获取字符串表达式运算后结果
        return AviatorEvaluator.execute(str);

    }

    /**
     * zxj
     * description: 方法重载, 解析字符串表达式
     * @param str: 字符串表达式, 包含变量
     * @param map: 变量参数
     * @return java.lang.Object
     */
//    public static Object execute(
//            String str,
//            Map<String,Object> map) {
//
//        //将字符串表达式解析为 Expression 对象
//        Expression compileExp = AviatorEvaluator.compile(str,true);
//        //执行Expression 对象的 execute(),获取字符串表达式运算后结果
//        return compileExp.execute(map);
//
//    }

    /**
     * zxj
     * description: 方法重载, 解析字符串表达式
     * @param str:   字符串表达式, 包含自定义函数
     * @param func:  自定义函数
     * @return java.lang.Object
     */
    public static Object execute(
            String str,
            AbstractFunction func) {

        //注册自定义函数
        AviatorEvaluator.addFunction(func);
        //将字符串表达式解析为 Expression 对象
        Expression compileExp = AviatorEvaluator.compile(str,true);
        //执行Expression 对象的 execute(),获取字符串表达式运算后结果
        return compileExp.execute();

    }

}
