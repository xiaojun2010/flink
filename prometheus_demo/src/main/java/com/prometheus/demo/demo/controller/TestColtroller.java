package com.prometheus.demo.demo.controller;

import com.prometheus.demo.demo.service.DemoService;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.cache.CacheMeterBinder;
import io.micrometer.core.instrument.binder.cache.GuavaCacheMetrics;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.cglib.core.internal.LoadingCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestColtroller {

    private DemoService demoService;

    public TestColtroller(DemoService demoService) {
        this.demoService = demoService;
    }

    @Timed(value = "main_page_request_duration", description = "Time taken to return main page", histogram = true)
    @GetMapping(value = "/index")
    public @ResponseBody String index() {
        return "Hello World";
    }


    @GetMapping(value = "/visit")
    public @ResponseBody String visit() {
        return demoService.visit();
    }



}
