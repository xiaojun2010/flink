package RuleEngleDemo;

/**
 * zxj
 * description: 单个规则对象
 * date: 2023
 */

public class Rule {

    /**
     * zxj
     * description: 规则计算
     * @param ruleIndex:
     * @return boolean
     */
    public boolean condition(RuleIndex ruleIndex) {
        //TODO 计算关系表达式的计算

        return true;
    }

    /**
     * zxj
     * description: 策略执行
     * @param b:
     * @return RuleEngleDemo.RuleTactics
     */
    public RuleTactics action(boolean b) {
        return new RuleTactics();
    }
}
