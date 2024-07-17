package com.prometheus.demo.demo.cache;


import com.google.common.cache.CacheBuilder;

import java.util.concurrent.*;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.cache.GuavaCacheMetrics;
import io.micrometer.core.instrument.binder.jvm.ExecutorServiceMetrics;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
//@EnableCaching
public class CacheConfigration {

//    @Bean
//    public CacheManager cacheManager() {
//
//        CacheBuilder<Object, Object> ObjectCacheBuilder = CacheBuilder.newBuilder()
//                // 存活时间（30秒内没有被访问则被移除）
//                .expireAfterAccess(30, TimeUnit.SECONDS)
//                // 存活时间（写入10分钟后会自动移除）
//                .expireAfterWrite(10, TimeUnit.MINUTES)
//                // 最大size
//                .maximumSize(1000)
//                // 最大并发量同时修改
//                .concurrencyLevel(6)
//                // 初始化大小为100个键值对
//                .initialCapacity(100)
//                // 变成软引用模式（在jvm内存不足时会被回收）
//                .softValues();
//
//        GuavaCacheManager cacheManager = new GuavaCacheManager();
//        cacheManager.setCacheBuilder(ObjectCacheBuilder);
//        return cacheManager;
//    }

    @Resource
    private  MeterRegistry meterRegistry;

    @Bean
    public LoadingCache loadingCache(){
         LoadingCache<String, String> loadingCache = GuavaCacheMetrics.monitor(
                meterRegistry,
                CacheBuilder.newBuilder()
                        .recordStats()
                        // 存活时间（30秒内没有被访问则被移除）
                        .expireAfterAccess(30, TimeUnit.SECONDS)
                        // 存活时间（写入10分钟后会自动移除）
                        .expireAfterWrite(10, TimeUnit.MINUTES)
                        // 最大size
                        .maximumSize(1000)
                        // 最大并发量同时修改
                        .concurrencyLevel(6)
                        // 初始化大小为100个键值对
                        .initialCapacity(100)
                        // 变成软引用模式（在jvm内存不足时会被回收）
                        .softValues()
                        .build(
                                new CacheLoader<String, String>() {
                                    @Override
                                    public String load(String key) throws Exception {
                                        return "";
                                    }
                                }
                        )
                ,
                "refresh-cache"
        );
         return loadingCache;
    }


//
//    private static final ScheduledExecutorService REFRESH_EXECUTOR = ExecutorServiceMetrics.monitor(
//            meterRegistry,
//            Executors.newScheduledThreadPool(
//                    1,
//                    new ThreadFactory() {
//                        @Override
//                        public Thread newThread(Runnable r) {
//                            Thread thread = new Thread(r);
//                            thread.setDaemon(true);
//                            thread.setName("refresh-" + thread.getId());
//                            return thread;
//                        }
//                    }
//            ),
//            "refresh-executor"
//    );
}