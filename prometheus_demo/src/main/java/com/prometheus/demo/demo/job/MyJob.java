//package com.prometheus.demo.demo.job;
//
//
//import com.prometheus.demo.demo.constant.JobMetrics;
//import io.micrometer.core.instrument.Meter;
//import io.micrometer.core.instrument.MeterRegistry;
//import io.micrometer.core.instrument.config.MeterFilter;
//import io.micrometer.core.instrument.distribution.DistributionStatisticConfig;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
///**
// * <h3>定时任务</h3>
// *
// * @author wangzhe
// * @version 1.0.0
// * @createTime 2023/3/8 11:32
// */
//@Component
//@EnableScheduling
//public class MyJob {
//
//    private Integer count1 = 0;
//
//    private Integer count2 = 0;
//
//    @Autowired
//    private JobMetrics jobMetrics;
//
//    @Autowired
//    private MeterRegistry meterRegistry;
//
//
//
//
//    @Async("main")
//    @Scheduled(fixedDelay = 1000)
//    public void doSomething() {
//        long start = System.currentTimeMillis();
//        try {
//
//            count1++;
//            jobMetrics.job1Counter.increment();
//            jobMetrics.map.put("x", Double.valueOf(count1));
//
//
//            meterRegistry.counter("JOB.COUNT", "MyJob", "doSomething").increment();
//
//
//
//            System.out.println("task1 count:" + count1);
//            if(count1%2==0){
//                System.out.println("%5==0");
//                jobMetrics.map.put("x", 1.0);
//            }
//            Random random = new Random(200);
//            long t = random.nextLong();
//            if ( t < 0){
//                t = 10L;
//            }
//
//            Thread.sleep(t);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } finally {
//            meterRegistry.summary("JOB.TIMER","MyJob", "doSomething").record(System.currentTimeMillis() - start);
//        }
//
//    }
//
//    @Async
//    @Scheduled(fixedDelay = 10000)
//    public void doSomethingOther() {
//        count2++;
//        jobMetrics.job2Counter.increment();
//        System.out.println("task2 count:" + count2);
//    }
//}
