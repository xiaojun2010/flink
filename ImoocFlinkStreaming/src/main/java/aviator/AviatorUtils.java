package aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.function.AbstractVariadicFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: Aviator表达式转换工具
 */
public class AviatorUtils {

    static {
        AviatorEvaluator.addFunction(new AvgFunction());
        AviatorEvaluator.addFunction(new SumFunction());
    }

    /**
     * 自定义 avg 函数
     */
    static class AvgFunction extends AbstractVariadicFunction {

        @Override
        public AviatorObject variadicCall(Map<String, Object> env,  AviatorObject... args) {
            Double sum = 0D;
            Integer count = 0;
            for(AviatorObject arg:args){
                Number number = FunctionUtils.getNumberValue(arg, env);
                sum+=number.doubleValue();
                count++;
            }
            return new AviatorDouble(sum / count);
        }

        @Override
        public String getName() {
            return "udfAvg";
        }

    }

    /**
     * 自定义 sum 函数
     */
    static class SumFunction extends AbstractVariadicFunction {

        @Override
        public AviatorObject variadicCall(Map<String, Object> env,  AviatorObject... args) {
            Double sum = 0D;
            for(AviatorObject arg:args){
                Number number = FunctionUtils.getNumberValue(arg, env);
                sum+=number.doubleValue();
            }
            return new AviatorDouble(sum);
        }

        @Override
        public String getName() {
            return "udfSum";
        }

    }

    public static void main(String[] args) {
        String exp = "udfAvg(a+b,b,udfSum(b,c),udfAvg(d,e))+2";
        Map<String, Object> map = new HashMap<>();
        map.put("a",5);
        map.put("b",6);
        map.put("c",7);
        map.put("d",7.5);
        map.put("e",9.7);
        Expression compiledExp = AviatorEvaluator.compile(exp,true);
        Double result =  (Double)compiledExp.execute(map);
        System.out.println(result);
    }

}
