package com.wikicloud.kafka.server;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by wiki on 2020/8/17 22:35
 */
public interface Test {

    String INPUT = "aaaa";

    @Input("aaaa")
    SubscribableChannel input();
}
