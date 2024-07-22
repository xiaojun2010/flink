package com.prometheus.demo.demo.service;

import com.prometheus.demo.demo.metric.aop.MetricAnnotation;
import com.prometheus.demo.demo.metric.aop.MetricsConstant;
import com.prometheus.demo.demo.metric.aop.TagAnnotation;
import io.micrometer.core.instrument.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class MetricsService {
    long count1 = 0;
//    int count2 = 0;

    @MetricAnnotation(name = MetricsConstant.DATA_WARE_HOUSE, tags = { MetricsConstant.TABLE_NAME, MetricsConstant.ADS_RISK_SHARE_TRAIT_SAME_USER_ACT_STAT_HI,MetricsConstant.METHOD_NAME , "queryShareTraitTgtUseridList"}, timerMetrics = true)
//    @MetricAnnotation(name = MetricsConstant.DATA_WARE_HOUSE, tags = {
//            @TagAnnotation(key = "tablename", value = MetricsConstant.ADS_RISK_SHARE_TRAIT_SAME_USER_ACT_STAT_HI),
//            @TagAnnotation(key = "method", value = "queryShareTraitTgtUseridList")
//    }, timerMetrics = true)
    public void queryShareTraitTgtUseridList() {

//        log.info("count1 = {}",count1++);
        try {
            Thread.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //@MetricAnnotation(name = MetricsConstant.DATA_WARE_HOUSE, tags = {MetricsConstant.ADS_RISK_SHARE_TRAIT_SAME_USER_ACT_STAT_HI, "queryByUserAndCount"}, timerMetrics = true)
//    @MetricAnnotation(name = MetricsConstant.DATA_WARE_HOUSE, tags = {
//            @TagAnnotation(key = "tableName", value = MetricsConstant.ADS_RISK_SHARE_TRAIT_SAME_USER_ACT_STAT_HI),
//            @TagAnnotation(key = "method", value = "queryByUserAndCount")
//    }, timerMetrics = true)

    @MetricAnnotation(name = MetricsConstant.DATA_WARE_HOUSE,
            tags = { MetricsConstant.TABLE_NAME, MetricsConstant.ADS_RISK_SHARE_TRAIT_SAME_USER_ACT_STAT_HI,MetricsConstant.METHOD_NAME , "queryByUserAndCount"},
            timerMetrics = true)
    public void queryByUserAndCount() {
//         log.info("count1 = {}",count1++);
        try {
            Thread.sleep(new Random().nextInt(20));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // @MetricAnnotation(name = MetricsConstant.DATA_WARE_HOUSE, tags = {MetricsConstant.ADS_RISK_SHARE_TRAIT_SAME_USER_ACT_STAT_HI, "queryUserIds"}, timerMetrics = true)
//    @MetricAnnotation(name = MetricsConstant.DATA_WARE_HOUSE, tags = {
//            @TagAnnotation(key = "tablename", value = MetricsConstant.ADS_RISK_SHARE_TRAIT_SAME_USER_ACT_STAT_HI),
//            @TagAnnotation(key = "method", value = "queryUserIds")
//    }, timerMetrics = true)
    @MetricAnnotation(name = MetricsConstant.DATA_WARE_HOUSE,
            tags = { MetricsConstant.TABLE_NAME, MetricsConstant.ADS_RISK_SHARE_TRAIT_SAME_USER_ACT_STAT_HI,MetricsConstant.METHOD_NAME , "queryUserIds"},
            timerMetrics = true)
    public void queryUserIds() {

//          log.info("count1 = {}",count1++);
        try {
            Thread.sleep(new Random().nextInt(30));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // @MetricAnnotation(name = MetricsConstant.DATA_WARE_HOUSE, tags = {MetricsConstant.ADS_RISK_SHARE_TRAIT_SAME_USER_ACT_STAT_HI, "queryTgtUserIds"}, timerMetrics = true)
//    @MetricAnnotation(name = MetricsConstant.DATA_WARE_HOUSE, tags = {
//            @TagAnnotation(key = "tablename", value = MetricsConstant.ADS_RISK_SHARE_TRAIT_SAME_USER_ACT_STAT_HI),
//            @TagAnnotation(key = "method", value = "queryTgtUserIds")
//    }, timerMetrics = true)
    @MetricAnnotation(name = MetricsConstant.DATA_WARE_HOUSE,
            tags = { MetricsConstant.TABLE_NAME, MetricsConstant.ADS_RISK_SHARE_TRAIT_SAME_USER_ACT_STAT_HI,MetricsConstant.METHOD_NAME , "queryTgtUserIds"},
            timerMetrics = true)
    public void queryTgtUserIds() {

        //log.info("count1 = {}",count1);
        try {
            Thread.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


//    @MetricAnnotation(name = MetricsConstant.DATA_WARE_HOUSE, tags = {
//            @TagAnnotation(key = "tablename", value = MetricsConstant.ADS_USR_OFFLINE_FEATURES_DF),
//            @TagAnnotation(key = "method", value = "queryByParentUserId")
//    }, timerMetrics = true)
@MetricAnnotation(name = MetricsConstant.DATA_WARE_HOUSE,
        tags = { MetricsConstant.TABLE_NAME, MetricsConstant.ADS_USR_OFFLINE_FEATURES_DF,MetricsConstant.METHOD_NAME , "queryByParentUserId"},
        timerMetrics = true)
    public void queryByParentUserId() {

        //log.info("count2 = {}",count2);
        try {
            Thread.sleep(new Random().nextInt(30));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
