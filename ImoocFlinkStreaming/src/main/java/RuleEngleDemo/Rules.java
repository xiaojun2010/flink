package RuleEngleDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * zxj
 * description: 规则组对象
 * date: 2023
 */

public class Rules {

    private List<Rule> rules;

    public Rules() {

        this.rules = new ArrayList<>();
    }

    /**
     * zxj
     * description: 将规则对象添加到规则组里
     * @param rule:
     * @return void
     */
    public void register(Rule rule) {

        rules.add(rule);
    }

    /**
     * zxj
     * description: 获取规则组对象
     * @param :
     * @return java.util.List<RuleEngleDemo.Rule>
     */
    public List<Rule> getRules() {
        return rules;
    }
}
