package com.wikicloud.user.server;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Value("${alipay.gateway_url}")
    private String asdasd;


    @GetMapping("test1")
    public String test(){

        return asdasd;
    }


}
