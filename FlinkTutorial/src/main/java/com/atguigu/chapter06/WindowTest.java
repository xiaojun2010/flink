package com.atguigu.chapter06;

import com.atguigu.chapter05.ClickSource;
import com.atguigu.chapter05.Event;
import org.apache.flink.api.common.eventtime.SerializableTimestampAssigner;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.EventTimeSessionWindows;
import org.apache.flink.streaming.api.windowing.assigners.SlidingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;

import java.time.Duration;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojun
 * Date: 2024/6/29
 * Time: 下午11:16
 * To change this template use File | Settings | File Templates.
 */
public class WindowTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

//        env.getConfig().setAutoWatermarkInterval(100);

        SingleOutputStreamOperator<Event> stream = env.fromElements(
                new Event("Mary", "./home", 1000L),
                new Event("Bob", "./cart", 2000L),
                new Event("Alice", "./prod?id=100", 3000L),
                new Event("Alice", "./prod?id=200", 3500L),
                new Event("Bob", "./prod?id=2", 2500L),
                new Event("Alice", "./prod?id=300", 3600L),
                new Event("Bob", "./home", 3000L),
                new Event("Bob", "./prod?id=1", 2300L),
                new Event("Bob", "./prod?id=3", 3300L))
        //乱序流 watermark 生成
        .assignTimestampsAndWatermarks(
                WatermarkStrategy.<Event>forBoundedOutOfOrderness(Duration.ZERO) //针对乱序流插入水位线，延迟时间设置为2s
                        .withTimestampAssigner(new SerializableTimestampAssigner<Event>() {

                            /**
                             * 抽取时间戳的逻辑
                             * @param element The element that the timestamp will be assigned to.
                             * @param recordTimestamp The current internal timestamp of the element, or a negative value, if
                             *     no timestamp has been assigned yet.
                             * @return
                             */
                            @Override public long extractTimestamp(Event element, long recordTimestamp) {
                                return element.timestamp;
                            }
                        }));

        stream.map(new MapFunction<Event, Tuple2<String,Long>>() {
            @Override public Tuple2<String, Long> map(Event value) throws Exception {
                return Tuple2.of(value.user,1L);
            }
        }).keyBy(data -> data.f0)
//                .window(EventTimeSessionWindows.withGap(Time.seconds(2))) //事件时间会话窗口
//                .window(SlidingEventTimeWindows.of(Time.seconds(10),Time.seconds(2)))  // 滑动事件时间窗口
                .window(TumblingEventTimeWindows.of(Time.seconds(10))) //滚动事件事件窗口
                .reduce(new ReduceFunction<Tuple2<String, Long>>() {
                    //归约方法
                    @Override
                    public Tuple2<String, Long> reduce(Tuple2<String, Long> value1,
                            Tuple2<String, Long> value2) throws Exception {
                        return Tuple2.of(value1.f0, value1.f1 + value2.f1 );
                    }
                }) .print();
        env.execute();

    }
}
