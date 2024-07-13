package RuleEngleDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * zxj
 * description: 指标组对象
 * date: 2023
 */

public class RuleIndexes {

    private List<RuleIndex> ruleIndexList;

    public RuleIndexes() {

        this.ruleIndexList = new ArrayList<>();
    }

    /**
     * zxj
     * description: 将指标对象添加到指标组里
     * @param ruleIndex:
     * @return void
     */
    public void put(RuleIndex ruleIndex) {
        ruleIndexList.add(ruleIndex);
    }

    /**
     * zxj
     * description: 获取指标组
     * @param :
     * @return java.util.List<RuleEngleDemo.Index>
     */
    public List<RuleIndex> getIndexList() {
        return ruleIndexList;
    }
}
