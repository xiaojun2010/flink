package com.atguigu.chapter06;

import com.atguigu.chapter05.ClickSource;
import com.atguigu.chapter05.Event;
import org.apache.flink.api.common.eventtime.SerializableTimestampAssigner;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.SlidingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.OutputTag;

import java.time.Duration;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojun
 * Date: 2024/6/29
 * Time: 下午22:45
 * To change this template use File | Settings | File Templates.
 */
public class LateDataTest {
    public static void main(String[] args) throws Exception {
        //创建执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        env.getConfig().setAutoWatermarkInterval(100);

        SingleOutputStreamOperator<Event> stream = env.socketTextStream("localhost", 7777)
                .map(new MapFunction<String, Event>() {

                    @Override public Event map(String value) throws Exception {
                        String[] fields = value.split(",");

                        return new Event(fields[0].trim(), fields[1].trim(), Long.valueOf(fields[2].trim()));
                    }
                })
                //乱序流的 watermark 生成
                .assignTimestampsAndWatermarks(WatermarkStrategy.<Event>forBoundedOutOfOrderness(Duration.ofSeconds(2))
                        .withTimestampAssigner(new SerializableTimestampAssigner<Event>() {
                            @Override public long extractTimestamp(Event element, long recordTimestamp) {
                                return element.timestamp;
                            }
                        }));
        stream.print("input");
        //定义一个输出标签
        OutputTag<Event> late = new OutputTag<Event>("late") {

        };

        // 需要按照url分组，开滑动窗口统计
        SingleOutputStreamOperator<UrlViewCount> result = stream.keyBy(data -> data.url)
                //10秒钟的滚动窗口
                .window(TumblingEventTimeWindows.of(Time.seconds(10)))
                //允许1分钟的延迟
                .allowedLateness(Time.minutes(1))
                //侧输出流
                .sideOutputLateData(late)
                // 同时传入增量聚合函数和全窗口函数
                .aggregate(new UrlViewCountExample.UrlViewCountAgg(), new UrlViewCountExample.UrlViewCountResult());

        result.print("result");
        result.getSideOutput(late).print("late");

        env.execute();
    }
}

