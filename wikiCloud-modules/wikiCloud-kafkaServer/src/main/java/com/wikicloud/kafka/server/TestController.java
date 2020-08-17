package com.wikicloud.kafka.server;

import com.wikicloud.base.server.TestMQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by wiki on 2020/8/17 21:37
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    StreamBridge streamBridge;

    @GetMapping("test1")
    public String test(@RequestParam(value = "a") String a){
        for (int i=0;i<100;i++){
            TestMQ testMQ=new TestMQ();
            testMQ.setId(i);
            testMQ.setName("test"+i);
            streamBridge.send(a,testMQ,MimeTypeUtils.APPLICATION_JSON);
        }


        return  "test1";
    }
}
