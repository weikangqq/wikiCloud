package com.wikicloud.user.server;


import com.alibaba.fastjson.JSON;
import com.wikicloud.base.server.TestMQ;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.function.Consumer;


@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(value = {"com.wikicloud.*"})
public class UserServerStart {


    public static void main(String[] args) {

        SpringApplication.run(UserServerStart.class,args);

    }

    @Bean
    public Consumer<TestMQ> receive() {
        return message -> {
            System.out.println("******************");
            System.out.println("At Sink2");
            System.out.println("******************");
            System.out.println("Received message " + JSON.toJSONString(message));
        };
    }

}
