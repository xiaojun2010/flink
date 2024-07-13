package scripts.cep.template

import com.imooc.RiskCtrlSys.flink.job.groovy.LoginFailBySingletonCondition
import com.imooc.RiskCtrlSys.flink.job.groovy.GroovyRule
import org.apache.flink.cep.pattern.Pattern
import org.apache.flink.streaming.api.windowing.time.Time

/**
 * 组合模式（3个模式）检测严格连续事件Pattern模板
 * @param <EventPO>
 */
class CompositeBy3WithConsecutive<EventPO> implements GroovyRule<EventPO> {
    @Override
    Pattern<EventPO, EventPO> getPattern() {
        return Pattern
                .<EventPO>begin("__START__")
                .where(new LoginFailBySingletonCondition("__START_FIELD__","__START_EXP__"))
                .next("__SECOND__")
                .where(new LoginFailBySingletonCondition("__SEC_FIELD__","__SEC_EXP__"))
                .next("__THIRD__")
                .where(new LoginFailBySingletonCondition("__TIR_FIELD__","__TIR_EXP__"))
                .within(Time.seconds(Integer.parseInt("__WITHIN__")))
    }
}
