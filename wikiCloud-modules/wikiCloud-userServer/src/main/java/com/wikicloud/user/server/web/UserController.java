package com.wikicloud.user.server.web;

import com.wikicloud.user.model.User;
import com.wikicloud.user.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("addBatch")
    public void addBatch(){
        List<User> list=new ArrayList<>();
        for(int i=0;i<100;i++){
            User user=new User();
            user.setName(i+1+"name");
            list.add(user);
        }
        userService.saveBatch(list);
    }

}
