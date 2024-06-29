package com.atguigu.chapter05;

/**
 * Copyright (c) 2020-2030 zhangxiaojun All Rights Reserved
 * <p>
 * Project:  FlinkTutorial
 * <p>
 * Created by  zhangxiaojun
 */

import java.sql.Timestamp;

public class Event {
    public String user;
    public String url;
    public Long timestamp;

    public Event() {
    }

    public Event(String user, String url, Long timestamp) {
        this.user = user;
        this.url = url;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Event{" +
                "user='" + user + '\'' +
                ", url='" + url + '\'' +
                ", timestamp=" + new Timestamp(timestamp) +
                '}';
    }
}
