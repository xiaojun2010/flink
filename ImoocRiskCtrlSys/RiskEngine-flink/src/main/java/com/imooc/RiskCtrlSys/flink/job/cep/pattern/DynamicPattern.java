package com.imooc.RiskCtrlSys.flink.job.cep.pattern;

import org.apache.flink.cep.pattern.Pattern;

import java.io.Serializable;

/**
 * zxj
 * description: TODO
 * date: 2023
 */

public class DynamicPattern<T> implements Serializable {

    //反射执行的脚本方法
    private final static String  METHOD = "getPattern";

    private final String clazz;

    private final String rule_code;

    public DynamicPattern(String clazz, String rule_code) {
        this.clazz = clazz;
        this.rule_code = rule_code;
    }

    /**
     * zxj
     * description: 根据 Pattern 规则的配置生成 Pattern
     * @param :
     * @return boolean
     */
    public Pattern<T,?> getDynamicPattern() {

        return Pattern.<T>begin("a").oneOrMore();
        //return (Pattern<T,?>) GroovyUtil.groovyEval(clazz,METHOD,null);

    }

    /**
     * zxj
     * description: Pattern 规则的配置是否发生了改变
     * @param :
     * @return boolean
     */
    public boolean patternChange() {
        return true;
    }
}
