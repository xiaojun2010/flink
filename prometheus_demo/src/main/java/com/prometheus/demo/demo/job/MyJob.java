package com.prometheus.demo.demo.job;


import com.prometheus.demo.demo.constant.JobMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <h3>定时任务</h3>
 *
 * @author wangzhe
 * @version 1.0.0
 * @createTime 2023/3/8 11:32
 */
@Component
@EnableScheduling
public class MyJob {

    private Integer count1 = 0;

    private Integer count2 = 0;

    @Autowired
    private JobMetrics jobMetrics;

    @Async("main")
    @Scheduled(fixedDelay = 1000)
    public void doSomething() {
        count1++;
        jobMetrics.job1Counter.increment();
        jobMetrics.map.put("x", Double.valueOf(count1));
        System.out.println("task1 count:" + count1);
        if(count1%2==0){
            System.out.println("%5==0");
            jobMetrics.map.put("x", 1.0);
        }

    }

    @Async
    @Scheduled(fixedDelay = 10000)
    public void doSomethingOther() {
        count2++;
        jobMetrics.job2Counter.increment();
        System.out.println("task2 count:" + count2);
    }
}
