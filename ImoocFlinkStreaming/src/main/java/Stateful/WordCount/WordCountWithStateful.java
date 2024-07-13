package Stateful.WordCount;

import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

import java.util.Arrays;

/**
 * zxj
 * description: 基于状态(KeyedState)计算实现词频统计
 * date: 2023
 */

public class WordCountWithStateful {

    public static void main(String[] args) throws Exception {

        // 加载上下文环境
        StreamExecutionEnvironment env =
                StreamExecutionEnvironment.getExecutionEnvironment();

        // Source 加载数据
        DataStream<String> lines =
                env.socketTextStream("127.0.0.1",8888,"\n");

        // Transformations 数据转换处理

        /* **********************************
         * wordcount大致经过4个步骤：切割、标记、分组、聚合
         *
         * **********************************
         */

        lines.flatMap((String input, Collector<WordCount> output)-> {
                            //第1步：切割 和 标记
                            String[] words = input.split(" ");
                            for(String word:words) {
                                output.collect(new WordCount(word,1));
                            }
                        }
                ).returns(WordCount.class)
                //第2步 分组
                /* **********************
                 * 知识点：
                 *
                 * 双冒号是Lambda语法
                 * 指方法引用, 方法引用的调用有很多种，
                 * 静态方法形式的调用是方法引用的其中一种调用。
                 *
                 * *********************/
                .keyBy(WordCount::getWord)
                /* **********************
                 *
                 * 知识点：
                 *
                 * keyBy 将DataStream转换为KeyedStream,KeyedStream是特殊的DataStream。
                 *
                 * Flink的状态分为：KeyedState和OperatorState，
                 * KeyedState只能应用于KeyedStream，
                 * 所以KeyedState的计算只能放在KeyBy之后
                 *
                 * *********************/
                //第3步 状态计算
                .flatMap(new WordCountStateFunc())
                //打印
                .print();



        // Sink 数据输出
        System.out.println("####### 基于状态(KeyedState)计算实现词频统计 ###########");

        // DataStream 要执行 execute 方法才会触发程序运行
        env.execute();

    }
}
