package com.atguigu.chapter06;

import com.atguigu.chapter05.Event;
import org.apache.flink.api.common.eventtime.SerializableTimestampAssigner;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.time.Duration;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojun
 * Date: 2024/6/28
 * Time: 下午10:06
 * To change this template use File | Settings | File Templates.
 */
public class WatermarkTest01 {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        env.getConfig().setAutoWatermarkInterval(100);

        DataStreamSource<Event> stream = env.fromElements(new Event("Mary", "./home", 1000L),
                new Event("Bob", "./cart", 2000L), new Event("Alice", "./prod?id=100", 3000L),
                new Event("Alice", "./prod?id=200", 3500L), new Event("Bob", "./prod?id=2", 2500L),
                new Event("Alice", "./prod?id=300", 3600L), new Event("Bob", "./home", 3000L),
                new Event("Bob", "./prod?id=1", 2300L), new Event("Bob", "./prod?id=3", 3300L));

        //有序流 watermark 生成
        //        stream.assignTimestampsAndWatermarks(WatermarkStrategy.<Event>forMonotonousTimestamps()
        //                .withTimestampAssigner(new SerializableTimestampAssigner<Event>() {
        //                    @Override public long extractTimestamp(Event event, long recordTimestamp) {
        //                        return event.timestamp;
        //                    }
        //                })
        //
        //        );

        //乱序流 watermark 生成
        stream.assignTimestampsAndWatermarks(WatermarkStrategy.<Event>forBoundedOutOfOrderness(Duration.ofSeconds(2)) //针对乱序流插入水位线，延迟时间设置为2s
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
        env.execute();

    }
}
