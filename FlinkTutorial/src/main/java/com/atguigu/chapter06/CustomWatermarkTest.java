package com.atguigu.chapter06;

/**
 * Copyright (c) 2020-2030 zhangxiaojun All Rights Reserved
 * <p>
 * Project:  FlinkTutorial
 * <p>
 * Created by  zhangxiaojun
 */

import com.atguigu.chapter05.ClickSource;
import com.atguigu.chapter05.Event;
import org.apache.flink.api.common.eventtime.*;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

// 自定义水位线的产生
public class CustomWatermarkTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        env
                .addSource(new ClickSource())
                .assignTimestampsAndWatermarks(new CustomWatermarkStrategy())
                .print();

        env.execute();
    }

    public static class CustomWatermarkStrategy implements WatermarkStrategy<Event> {
        @Override
        public TimestampAssigner<Event> createTimestampAssigner(TimestampAssignerSupplier.Context context) {
            return new SerializableTimestampAssigner<Event>() {
                @Override
                public long extractTimestamp(Event element, long recordTimestamp) {
                    return element.timestamp; // 告诉程序数据源里的时间戳是哪一个字段
                }
            };
        }

        @Override
        public WatermarkGenerator<Event> createWatermarkGenerator(WatermarkGeneratorSupplier.Context context) {
            return new CustomPeriodicGenerator();
        }
    }

    public static class CustomPeriodicGenerator implements WatermarkGenerator<Event> {
        private Long delayTime = 5000L; // 延迟时间
        private Long maxTs = Long.MIN_VALUE + delayTime + 1L; // 观察到的最大时间戳

        /**
         * 断点式触发
         * 每个事件（数据）到来都会调用的方法，它的参数有当前事件、时间戳，
         * 以及允许发出水位线的一个 WatermarkOutput，可以基于事件做各种操作
         * @param event
         * @param eventTimestamp
         * @param output
         */
        @Override
        public void onEvent(Event event, long eventTimestamp, WatermarkOutput output) {
            // 每来一条数据就调用一次
            maxTs = Math.max(event.timestamp, maxTs); // 更新最大时间戳
        }

        /**
         * 周期性触发
         * @param output
         */
        @Override
        public void onPeriodicEmit(WatermarkOutput output) {
            // 发射水位线，默认200ms调用一次
            output.emitWatermark(new Watermark(maxTs - delayTime - 1L));
        }
    }
}

