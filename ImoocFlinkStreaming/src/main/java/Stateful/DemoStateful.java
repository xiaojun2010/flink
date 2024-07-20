package Stateful;

import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

/**
 * author: Imooc
 * description: 状态计算测试类
 * date: 2023
 */

/* **********************
 *
 * 状态计算步骤：
 * 1. 继承Rich函数
 * 2. 重写Open函数，初始化状态
 * 3. 实现flatmap/map函数
 *
 * *********************/
//相同的单词的数量计算 Tuple2<"hadoop",1>
public class DemoStateful extends RichFlatMapFunction<Tuple2<String,Integer>,Tuple2<String,Integer>> {

    private ValueState<Tuple2<String,Integer>> total;

    @Override
    public void open(Configuration parameters) throws Exception {
        total = getRuntimeContext().getState(new ValueStateDescriptor<Tuple2<String,Integer>>(
                "total",
                /* **********************
                 *
                 * TypeInformation.of参数有两种的输入方式
                 * 1. Class类型
                 * 2. TypeHint
                 * *********************/
                TypeInformation.of(new TypeHint<Tuple2<String,Integer>>() {})
        ));
    }

    @Override
    public void flatMap(Tuple2<String, Integer> input,
                        Collector<Tuple2<String, Integer>> out) throws Exception {

        Tuple2<String, Integer> value = total.value();
        if(value == null) {
            total.update(input);
            out.collect(input);
        }else {
            Integer count = value.f1 + input.f1;
            Tuple2<String, Integer> newState = Tuple2.of(input.f0,count);
            total.update(newState);
            out.collect(newState);
        }
    }
}
