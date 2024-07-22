package scripts.cep

import com.imooc.RiskCtrlSys.flink.job.groovy.GroovyRule
import com.imooc.RiskCtrlSys.flink.job.groovy.LoginFailBySingletonCondition
import org.apache.flink.api.common.time.Time
import org.apache.flink.cep.pattern.Pattern
/**
 * 基于个体模式检测最近1分钟内登录失败超过3次的用户 Groovy脚本
 * @param <EventPO>
 */
class LoginFailBySingleton<EventPO> implements GroovyRule<EventPO> {
    @Override
    Pattern getPattern() {
        return Pattern
                .begin("login_fail")
        .where(new LoginFailBySingletonCondition("__FIELD__","__EXP__"))
        .times(4)
        .within(Time.seconds(60))
    }
}
