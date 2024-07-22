package com.prometheus.demo.demo.metric.aop;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.config.MeterFilter;
import io.micrometer.core.instrument.distribution.DistributionStatisticConfig;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.Signature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class MetricAspect implements Ordered {
    public static final int ORDER = 999;

    private final MeterRegistry meterRegistry;

    public MetricAspect(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        this.meterRegistry.config()
                .meterFilter(new MeterFilter() {
                    @Override
                    public DistributionStatisticConfig configure(Meter.Id id, DistributionStatisticConfig config) {
                        return DistributionStatisticConfig.builder()
                                .percentiles(0.99, 0.95, 0.9, 0.5)
                                .build()
                                .merge(config);
                    }
                });



    }

    @Override
    public int getOrder() {
        return ORDER;
    }


    /**
     * 定义了一个切点
     * 这里的路径填自定义注解的全路径
     */
    @Pointcut("@annotation(com.prometheus.demo.demo.metric.aop.MetricAnnotation)")
    public void authCut() {
    }

    @Around("authCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

//        log.info("around ......");
//        System.out.println("注解方式AOP拦截开始进入环绕通知.......");

        Signature signature = joinPoint.getSignature();

        MethodSignature methodSignature = (MethodSignature) signature;

        MetricAnnotation metricAnnotation = methodSignature.getMethod().getAnnotation(MetricAnnotation.class);
   //     log.info("around ......" + methodSignature.getName());


//        Metrics.counter(metricAnnotation.name(), metricAnnotation.tags()).increment();


        meterRegistry.counter(metricAnnotation.name(),metricAnnotation.tags()).increment();
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();

//        Metrics.summary((metricAnnotation.name() + ".timer").intern(),metricAnnotation.tags()).record(System.currentTimeMillis() - start);
        meterRegistry.summary((metricAnnotation.name() + ".timer").intern(), metricAnnotation.tags()).record(System.currentTimeMillis() - start);
//        System.out.println("准备退出环绕......");

        return proceed;
    }


}
