package BatchAndStream;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

import java.util.Arrays;


/**
 * zxj
 * description: 通过 DataStream Api 和 Lambda表达式，以流计算的方式进行词频统计
 * date: 2023
 */

public class WordCountByStreamWithLambda {

    public static void main(String[] args) throws Exception {
        // 加载上下文环境 (流计算的上下文环境)
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        /* **********************
         *
         * 注意：
         *
         * 需要开启socket 流,
         * 课程是使用 ubuntu内置的 nc 监听本地主机,模拟socket流
         * nc -l 8888
         *
         * *********************/

        // Source 加载数据
        DataStream<String> lines = env.socketTextStream(
                "127.0.0.1",
                8888,
                "\n"
        );


        // Transformations 数据转换处理

        /* *************************************
         * 知识点：
         *
         * lambda表达式：函数式编程
         * 一句话，lambda表达式让代码更简洁
         * 标准格式：(参数列表) -> {代码}
         *
         *************************************
         */

        /* *************************************
         *
         * 注意：
         *
         * lambda表达式使用Java的泛型时，要明确指出返回的类型
         * 否则Flink无法推断出正确的类型
         *
         * **************************************
         */


        System.out.println("####### 通过 DataStream Api 和 Lambda表达式,以流处理的方式进行词频统计 ###########");


        // 第1步：切割
        lines.flatMap((String input,Collector<String> output)-> {

            // 以空格切割每一行的单词, 将每一行切割出来的单词放入数组
            String[] words = input.split(" ");
            // 循环这个数组，并将数组内的单词一一输出
            for(String word:words) {
                // 通过Collector对象的collect方法输出Sp
                output.collect(word);
            }
        })
        // 通过 returns 函数指定返回的类型
        .returns(Types.STRING)
        // 第2步：对每个单词标记为 1 ( Tuple2<"hadoop",1> )
        .map(word -> Tuple2.of(word,1))
        .returns(Types.TUPLE(Types.STRING,Types.INT))
        // 第3步：分组
        .keyBy(tuple->tuple.f0)
        // 第4步：聚合
        .sum(1)
        // Sink 数据输出
        .print();

        // DataStream 要执行 execute 方法才会触发程序运行
        env.execute();

    }

}
