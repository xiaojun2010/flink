package aviator;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.Map;

/**
 * author: Imooc
 * description: Aviator 自定义函数 (不可变参数)
 * date: 2023
 */

/* **********************
 *
 * 知识点：
 *
 * 1. 自定义函数
 * a. 继承 AbstractFunction
 * b. 实现 getName(): 定义函数名
 * c. 实现 call(): 定义函数逻辑
 * d. 在 AviatorEvaluator 注册
 *
 *
 * 2. 自定义函数的入参
 * AbstractFunction 提供了1~20 数量的入参
 * AbstractVariadicFunction 提供可变数量的入参
 *
 *
 * *********************/

public class ImoocAviatorFunc extends AbstractFunction {
    /**
     * author: Imooc
     * description: 实现函数逻辑
     * @param :
     * @return com.googlecode.aviator.runtime.type.AviatorObject
     */
    @Override
    public AviatorObject call(
            Map<String, Object> env,
            AviatorObject arg1,
            AviatorObject arg2) {

        Number num1 = FunctionUtils.getNumberValue(arg1, env);
        Number num2 = FunctionUtils.getNumberValue(arg2, env);
        return new AviatorDouble(num1.doubleValue() + num2 .doubleValue());
    }

    /**
     * author: Imooc
     * description: 定义函数名
     * @param :
     * @return java.lang.String
     */
    @Override
    public String getName() {
        return "imooc";
    }

}

