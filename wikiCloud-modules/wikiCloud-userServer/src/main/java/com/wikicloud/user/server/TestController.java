package com.wikicloud.user.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Value("${a}")
    private String a;

    @Value("${b}")
    private String b;

    @Value("${c}")
    private String c;

    @Value("${d}")
    private String d;

    @GetMapping("test1")
    public String test(){

        return d;
    }


}
