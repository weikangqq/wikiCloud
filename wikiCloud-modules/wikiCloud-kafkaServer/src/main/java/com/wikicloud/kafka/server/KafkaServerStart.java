package com.wikicloud.kafka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

/**
 * Created by wiki on 2020/8/17 19:51
 */
@SpringBootApplication
@EnableDiscoveryClient
public class KafkaServerStart {

    public static void main(String[] args) {
        SpringApplication.run(KafkaServerStart.class,args);
    }

}
