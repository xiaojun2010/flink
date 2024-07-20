package aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.AbstractVariadicFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.yuque.com/boyan-avfmj/aviatorscript/ugbmqm
 * https://blog.csdn.net/yy7517053/article/details/128648018
 * description: Aviator Demo
 * date: 2023
 */

/* **********************
 *
 * 知识点：
 *
 * 1.
 *
 * Aviator 用法:
 * AviatorEvaluator.compile()
 * AviatorEvaluator.execute()
 *
 * 2.
 * Aviator只支持4种数值类型
 * a.long
 * b.double
 * c.bigint
 * d.decimal
 *
 * 3.
 * compile的用法步骤：
 * a. 生成Expression对象
 * b. 执行 Expression对象 的 execute(),传入变量值。
 *
 * 4
 * 为什么使用 compile()
 * compile() 可以缓存字符串表达式
 *
 *
 * *********************/
public class AviatorDemo {
    public static void main(String[] args) {
        //数学运算 (Long)
        String exp1 = "1+2+3";
        Long result = (Long) AviatorEvaluator.execute(exp1);
        System.out.println(result);

        //数学运算 (Double)
        String exp4 = "1.1+2.2+3.3";
        Double result2 = (Double) AviatorEvaluator.execute(exp4);
        System.out.println(result2);


        //包含关系运算和逻辑运算
        String exp2 = "(1>0||0<1)&&1!=0";
        System.out.println(AviatorEvaluator.execute(exp2));

        //三元运算
        String exp3 = "4 > 3 ? \"4 > 3\" : 999";
        System.out.println(AviatorEvaluator.execute(exp3));

        //变量传入
        String exp5 = "a>b";
        Integer a1 = 7;
        Integer b1 = 5;
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("a",a1);
        map.put("b",b1);
        System.out.println(AviatorEvaluator.execute(exp5,map));

        //自定义函数的调用
        AviatorEvaluator.addFunction(new ImoocAviatorFunc());
        String exp6 = "imooc(a,b)";
        Map<String,Object> map2 = new HashMap<String,Object>();
        Double a2 = 7.7d;
        Double b2 = 5.5d;
        map2.put("a",a2);
        map2.put("b",b2);

        Expression compileExp = AviatorEvaluator.compile(exp6,true);
        System.out.println(compileExp.execute(map2));

        //自定义函数的调用 (可变参数)
        AviatorEvaluator.addFunction(new ImoocAviatorFuncWithCustomArgs());
        String exp7 = "imoocWithCustomArgs(a,b,c)";
        Map<String,Object> map7 = new HashMap<String,Object>();
        Double a7 = 7.7d;
        Double b7 = 5.5d;
        Double c7 = 6.6d;
        map7.put("a",a7);
        map7.put("b",b7);
        map7.put("c",c7);

        Expression compileExp7 = AviatorEvaluator.compile(exp7,true);
        System.out.println(compileExp7.execute(map7));

    }
}
