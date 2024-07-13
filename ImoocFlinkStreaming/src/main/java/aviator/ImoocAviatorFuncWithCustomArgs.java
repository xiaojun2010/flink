package aviator;

import com.googlecode.aviator.runtime.function.AbstractVariadicFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.Map;

/**
 * zxj
 * description: Aviator 自定义函数 (可变参数)
 * date: 2023
 */

public class ImoocAviatorFuncWithCustomArgs extends AbstractVariadicFunction {


    @Override
    public AviatorObject variadicCall(Map<String, Object> map, AviatorObject... args) {
        Double sum = 0D;
        for(AviatorObject arg:args){
            Number number = FunctionUtils.getNumberValue(arg, map);
            sum+=number.doubleValue();
        }
        return new AviatorDouble(sum);
    }

    @Override
    public String getName() {
        return "imoocSum";
    }
}
