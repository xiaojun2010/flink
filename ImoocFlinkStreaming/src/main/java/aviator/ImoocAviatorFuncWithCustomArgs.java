package aviator;

import com.googlecode.aviator.runtime.function.AbstractVariadicFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.Map;

/**
 * https://blog.csdn.net/yy7517053/article/details/128648018
 * author: Imooc
 * description: Aviator 自定义函数 (可变参数)
 * date: 2023
 */

public class ImoocAviatorFuncWithCustomArgs extends AbstractVariadicFunction {


    @Override
    public AviatorObject variadicCall(Map<String, Object> map, AviatorObject... args) {
        Double sum = 0d;
        for(AviatorObject arg:args){
            Number a = FunctionUtils.getNumberValue(arg, map);
            System.out.println("a = "+a);
            sum+=a.doubleValue();
        }
        return new AviatorDouble(sum);
    }

    @Override
    public String getName() {
        return "imoocWithCustomArgs";
    }
}
