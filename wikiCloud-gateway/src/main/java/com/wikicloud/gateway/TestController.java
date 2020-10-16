package com.wikicloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping(value = "/hello/test")
    public String apiHello() {
        return "asdasd";
    }
}