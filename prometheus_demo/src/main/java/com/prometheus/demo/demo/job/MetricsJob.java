package com.prometheus.demo.demo.job;

import com.prometheus.demo.demo.metric.aop.MetricAnnotation;
import com.prometheus.demo.demo.service.MetricsService;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.info.ConditionalOnEnabledInfoContributor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

import static com.prometheus.demo.demo.metric.aop.MetricsConstant.*;

/**
 * <h3>定时任务</h3>
 *
 * @author wangzhe
 * @version 1.0.0
 * @createTime 2023/3/8 11:32
 */
@Slf4j
@Component
@EnableScheduling
public class MetricsJob {

    private final MetricsService metricsService;

    public MetricsJob(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @Async("main")
    @Scheduled(fixedDelay = 1000)
    public void doBiz1() {
//        CompletableFuture.runAsync(() -> {
            int count = 0;
            while (count < 50000) {
                metricsService.queryShareTraitTgtUseridList();
                count++;
            }
//        });
    }

    @Async
    @Scheduled(fixedDelay = 1000)
    public void doLogic2() {
//        CompletableFuture.runAsync(() -> {
            int count = 0;
            while (count < 50000) {
                metricsService.queryByUserAndCount();
                count++;
            }
//        });
    }

    @Async
    @Scheduled(fixedDelay = 1000)
    public void doLogic3() {
//        CompletableFuture.runAsync(() -> {
            int count = 0;
            while (count < 50000) {
                metricsService.queryUserIds();
                count++;
            }
//        });
    }

    @Async
    @Scheduled(fixedDelay = 1000)
    public void doLogic4() {
//        CompletableFuture.runAsync(() -> {
            int count = 0;
            while (count < 50000) {
                 metricsService.queryByParentUserId();
                count++;
            }
//        });
    }

    @Async
    @Scheduled(fixedDelay = 1000)
    public void doLogic5() {
//        CompletableFuture.runAsync(() -> {
//            log.info("doLogic5....");
            int count = 0;
            while (count < 50000) {
                metricsService.queryTgtUserIds();
                count++;
            }
//        });
    }

    @Async
    @Scheduled(fixedDelay = 1000)
    public void doLogic6() {
//        CompletableFuture.runAsync(() -> {
//            log.info("doLogic6....");
            int count = 0;
            while (count < 50000){
                metricsService.queryByParentUserId();
                count++;
            }
//        });
    }


}
