package Stateful.WordCount;

import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

/**
 * author: Imooc
 * description: KeyedState计算
 * date: 2023
 */


/* **********************
 *
 * keyedState状态计算步骤：
 *
 * 1. 继承Rich函数
 * 2. 重写Open方法，对状态变量进行初始化
 * 3. 状态计算逻辑
 *
 * 为什么要进行有状态的计算 ？
 * 如果Flink发生了异常退出,checkpoint机制可以读取保存的状态，进行恢复。
 *
 * 什么是Flink的状态 ？
 * 状态其实是个变量，这个变量保存了数据流的历史数据,
 * 如果有新的数据流进来，会读取状态变量，将新的数据和历史一起计算.
 *
 * keyBy之后，每个key都有对应的状态，同一个key只能操作自己对应的状态。
 *
 * *********************/

public class WordCountStateFunc extends RichFlatMapFunction<WordCount,WordCount> {

    //状态变量
    /* **********************
     *
     * KeyedState的数据类型有：
     * ValueState<T>: 状态的数据类型为单个值，这个值是类型T
     * ListState<T>: 状态的数据类型为列表，列表值是类型T
     *
     * *********************/
    private ValueState<WordCount> keyedState;

    /**
     * author: Imooc
     * description: 状态变量的初始化
     * @param parameters:
     * @return void
     */
    @Override
    public void open(Configuration parameters) throws Exception {

        ValueStateDescriptor<WordCount> valueStateDescriptor =
                // valueState描述器
                new ValueStateDescriptor<WordCount>(
                        // 描述器的名称
                        "wordcountstate",
                        //描述器的数据类型
                        /* **********************
                         *
                         * 知识点：
                         *
                         * Flink有自己的一套数据类型，包含了JAVA和Scala的所有数据类型
                         * 这些数据类型都是TypeInformation对象的子类。
                         * TypeInformation对象统一了所有数据类型的序列化实现
                         *
                         * *********************/
                        TypeInformation.of(WordCount.class)
                );

        keyedState = getRuntimeContext().getState(valueStateDescriptor);
    }


    /**
     * author: Imooc
     * description: keyedState计算逻辑
     * @param input:
     * @param output:
     * @return void
     */
    @Override
    public void flatMap(WordCount input, Collector<WordCount> output) throws Exception {

        //读取状态
        WordCount lastKeyedState = keyedState.value();

        //更新状态
        if(lastKeyedState == null) {
            //状态还未赋值的情况

            //更新状态
            keyedState.update(input);
            //返回原数据
            output.collect(input);

        }else {

            //状态存在旧的状态数据的情况
            Integer count = lastKeyedState.getCount() + input.getCount();
            WordCount newWordCount = new WordCount(input.getWord(),count);

            //更新状态
            keyedState.update(newWordCount);
            //返回新的数据
            output.collect(newWordCount);


        }

    }


}
