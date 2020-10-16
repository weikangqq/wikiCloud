package com.wikicloud.user.server.api.impl;

import com.wikicloud.user.server.service.UserService;
import com.wikicloud.user.api.UserApi;
import com.wikicloud.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(UserApi.mapping)
public class UserApiImpl implements UserApi {

    @Autowired
    private UserService userService;

    @Override
    public User getUserById(Long id) {
        return userService.getById(id);
    }

    @Override
    public Flux<User> list() {
        return  Flux.fromIterable(userService.list());
    }

    @Override
    public Mono<User> get() {

        return Mono.just(userService.getById(1L));
    }

}
