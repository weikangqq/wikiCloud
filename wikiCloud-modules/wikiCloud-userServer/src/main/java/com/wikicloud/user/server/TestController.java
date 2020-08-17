package com.wikicloud.user.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    private String asdasd;


    @GetMapping("test1")
    public String test(){

        return asdasd;
    }


}
