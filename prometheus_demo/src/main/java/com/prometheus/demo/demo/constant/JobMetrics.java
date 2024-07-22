//package com.prometheus.demo.demo.constant;
//
//import io.micrometer.core.instrument.Counter;
//import io.micrometer.core.instrument.Gauge;
//import io.micrometer.core.instrument.Meter;
//import io.micrometer.core.instrument.MeterRegistry;
//import io.micrometer.core.instrument.binder.MeterBinder;
//import io.micrometer.core.instrument.config.MeterFilter;
//import io.micrometer.core.instrument.distribution.DistributionStatisticConfig;
//import org.springframework.stereotype.Component;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class JobMetrics implements MeterBinder {
//    public Counter job1Counter;
//    public Counter job2Counter;
//
//    public Map<String, Double> map;
//
////    private final Counter httpRequestsTotal = Counter.build()
////            .name("http_requests_total")
////            .help("Total number of http requests by response status code")
////            .labelNames("endpoint", "status")
////            .register();
////
////    private final Histogram httpRequestDurationMs = Histogram.build()
////            .name("http_request_duration_milliseconds")
////            .help("Http request latency histogram")
////            .exponentialBuckets(25, 2, 7)
////            .labelNames("endpoint", "status")
////            .register();
//
//    JobMetrics() {
//        map = new HashMap<>();
//    }
//
//    @Override
//    public void bindTo(MeterRegistry meterRegistry) {
//        meterRegistry.config()
//                .meterFilter(new MeterFilter() {
//                    @Override
//                    public DistributionStatisticConfig configure(Meter.Id id, DistributionStatisticConfig config) {
//                        return DistributionStatisticConfig.builder()
//                                .percentiles(0.95, 0.9, 0.5)
//                                .build()
//                                .merge(config);
//                    }
//                });
//
//
//
//        //
//        this.job1Counter = Counter.builder("counter_builder_job_counter1")
//                .tags(new String[]{"name", "tag_job_counter1"})
//                .description("description-Job counter1 execute count").register(meterRegistry);
//
//        this.job2Counter = Counter.builder("counter_builder_job_counter2")
//                .tags(new String[]{"name", "tag_job_counter2"})
//                .description("description-Job counter2 execute count ").register(meterRegistry);
//
//        Gauge.builder("gauge_builder_job_gauge", map, x -> x.get("x"))
//                .tags("name", "tag_job_gauge")
//                .description("description-Job gauge")
//                .register(meterRegistry);
//    }
//
//}