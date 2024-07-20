package RuleEngleDemo;

import java.util.List;

/**
 * author: Imooc
 * description: 风控规则执行对象
 * date: 2023
 */

public class RuleExecution {

    /**
     * author: Imooc
     * description: 规则执行
     * @param rules: 规则组
     * @param indexes:  指标组
     * @return void
     */
    public void execute(Rules rules,RuleIndexes indexes) {

       List<RuleIndex> indexList = indexes.getIndexList();
       List<Rule> ruleList =  rules.getRules();

       for(RuleIndex index : indexList) {

           for(Rule rule:ruleList) {

               boolean b =  rule.condition(index);
               rule.action(b);
           }

       }
    }
}
