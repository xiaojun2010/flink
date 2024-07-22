package com.prometheus.demo.demo.metric.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MetricAnnotation {

    String name();

    String[] tags();

    boolean timerMetrics() default false;


}



