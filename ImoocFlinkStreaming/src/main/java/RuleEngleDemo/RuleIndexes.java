package RuleEngleDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Imooc
 * description: 指标组对象
 * date: 2023
 */

public class RuleIndexes {

    private List<RuleIndex> ruleIndexList;

    public RuleIndexes() {

        this.ruleIndexList = new ArrayList<>();
    }

    /**
     * author: Imooc
     * description: 将指标对象添加到指标组里
     * @param ruleIndex:
     * @return void
     */
    public void put(RuleIndex ruleIndex) {
        ruleIndexList.add(ruleIndex);
    }

    /**
     * author: Imooc
     * description: 获取指标组
     * @param :
     * @return java.util.List<RuleEngleDemo.Index>
     */
    public List<RuleIndex> getIndexList() {
        return ruleIndexList;
    }
}
