package aviator;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.Map;

/**
 * zxj
 * description: Aviator 自定义函数 (不可变参数)
 * date: 2023
 */

/* **********************
 *
 * 知识点：
 *
 * 1. 自定义函数
 * a. 实现 com.googlecode.aviator.runtime.type.AviatorFunction 接口
 * b. 注册到 AviatorEvaluator
 *
 * 2.
 *
 * 继承 AbstractFunction 类后,
 * 要实现了 getName() 和call() 方法
 *
 * 3.
 * AbstractFunction 类里call() 方法的参数，
 * 方法参数 AviatorObject arg1 从1到20,
 *
 * 思考：call() 如何支持可变参数
 * 解决方案：
 *
 * 在AbstractVariadicFunction 类中的 variadicCall() 方法,
 * 参数 AviatorObject... args 支持可变。
 *
 *
 * *********************/

public class ImoocAviatorFunc extends AbstractFunction {
    /**
     * zxj
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
     * zxj
     * description: 定义函数名
     * @param :
     * @return java.lang.String
     */
    @Override
    public String getName() {
        return "imoocAviator";
    }

}

