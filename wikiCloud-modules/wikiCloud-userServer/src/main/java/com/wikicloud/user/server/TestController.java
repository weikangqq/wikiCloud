package com.wikicloud.user.server;

import com.wikicloud.user.server.service.TestService;
import com.wikicloud.userapi.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private TestService testService;

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
       List<Test> list=testService.list();
//        redisTemplate.opsForValue().set("1",1);
        for (int i=0;i<100;i++){
            Test test=new Test();
           test.setName(i+"_asd");
            testService.save(test);

            
        }
        return list.size()+"";
    }
    @GetMapping("test2")
    public String test2(){

        return "test2";
    }

}
