package com.wikicloud.order.web;

import com.wikicloud.user.api.UserApi;
import com.wikicloud.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private UserApi userApi;

    @GetMapping("order/test")
    public User getUser(){
        return userApi.getUserById(1L);
    }

    @GetMapping("order/list")
    public List<User> list(){
       List<User> a=userApi.list().collectList().block();
        User user=userApi.get().block();
        return  null;
    }
}
