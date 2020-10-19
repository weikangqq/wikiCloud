package com.wikicloud.order.web;

import com.wikicloud.base.common.response.Rs;
import com.wikicloud.user.api.UserApi;
import com.wikicloud.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private UserApi userApi;

    @GetMapping("order/test")
    public Rs<User> getUser(){
        return userApi.getUserById(1L);
    }

    @GetMapping("order/list")
    public Rs<List<User>> list(){
        return Rs.success(userApi.list());

    }
}
