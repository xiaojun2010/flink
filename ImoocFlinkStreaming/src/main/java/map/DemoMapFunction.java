package map;

import org.apache.flink.api.common.functions.MapFunction;

/**
 * author: Imooc
 * description: MapFunction Demo
 * date: 2023
 */

public class DemoMapFunction implements MapFunction<String,String> {

    /**
     * author: Imooc
     * description: TODO
     * @param input:  输入
     * @return java.lang.String
     */
    @Override
    public String map(String input) throws Exception {
        //两个字符串的拼接
        String out = "hello " + input;
        return out;

    }
}
