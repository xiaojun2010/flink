package BatchAndStream;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.configuration.RestOptions;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;


/**
 * author: Imooc
 * description: 通过 DataStream Api，以批处理的方式进行词频统计~
 * date: 2023
 */

public class WordCountByBatchWithDataStreamApi {

    public static void main(String[] args) throws Exception {

        // 加载上下文环境 (流计算的上下文环境)
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // Source 加载数据
        DataStream<String> lines = env.fromElements(
                "imooc hadoop flink",
                "imooc hadoop flink",
                "imooc hadoop",
                "imooc"
        );

        // Transformations 数据转换处理

        /* *************************************
         * wordcount的步骤：分割，标记，分组，聚合
         * 这里会涉及 Flink 的重要算子：map 和 flatMap, 以及 Flink 的 Tuple 类型
         *
         * map算子：将输入转换为另一种数据（例如将小写转换为大写）
         * flatMap算子：将一个输入转换为0-N条数据输出
         * Tuple 是 Flink 内置的元组类型
         * Tuple2 是二元组，Tuple3 是三元组
         *
         * **************************************
         */

        /* **************************************
         * wordcount 第1步：切割
         * 使用算子：flatMap
         *
         * ***************************************
         */

        DataStream<String> wordsDS = lines.flatMap(new FlatMapFunction<String, String>() {
            /**
             * author: Imooc
             * description: 实现字符串切割
             * @param input: 输入
             * @param output:  输出 (Collector对象)
             * @return void
             */
            @Override
            public void flatMap(String input, Collector<String> output) throws Exception {
                // 以空格切割每一行的单词, 将每一行切割出来的单词放入数组
                String[] words = input.split(" ");
                // 循环这个数组，并将数组内的单词一一输出
                for(String word:words) {
                    // 通过Collector对象的collect方法输出
                    output.collect(word);
                }
            }
        });

        /* ************************************
         * wordcount 第2步：对每个单词标记为 1 ( Tuple2<"hadoop",1> )
         * 使用算子：map
         *
         * ************************************`
         */

        DataStream<Tuple2<String,Integer>> wordDS = wordsDS.map(new MapFunction<String, Tuple2<String,Integer>>() {
            /**
             * author: Imooc
             * description: 实现对每个单词标记为1
             * @param input:  输入
             * @return Tuple2<String,Integer>
             */
            @Override
            public Tuple2<String,Integer> map(String input) throws Exception {
                // Tuple2.of() 是构造二元组
                return Tuple2.of(input,1);
            }
        });

        /* ********************************************
         * wordcount 第3步：对标记完成的单词进行分组
         * 使用的算子：keyBy
         *
         * ********************************************
         */
        // Flink 支持 JDK8 Lambda表达式
        KeyedStream<Tuple2<String,Integer>,String> grouped =
                wordDS.keyBy(key -> key.f0 );


        /* *******************************
         * wordcount 第4步：聚合(求和)
         * 使用算子：sum
         *
         * ********************************
         */

        SingleOutputStreamOperator<Tuple2<String,Integer>> out = grouped.sum(1);

        // Sink 数据输出

        System.out.println("####### 通过 DataStream Api，以批处理的方式进行词频统计 ###########");
        out.print();

        // DataStream 要执行 execute 方法才会触发程序运行
        env.execute();


    }

}
