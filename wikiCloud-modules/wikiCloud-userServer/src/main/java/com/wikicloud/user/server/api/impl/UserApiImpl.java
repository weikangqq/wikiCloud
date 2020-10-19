package com.wikicloud.user.server.api.impl;

import com.wikicloud.base.common.response.Rs;
import com.wikicloud.user.api.UserApi;
import com.wikicloud.user.model.User;
import com.wikicloud.user.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(UserApi.mapping)
public class UserApiImpl implements UserApi {

    @Autowired
    private UserService userService;

    @Override
    public Rs<User> getUserById(Long id) {
        return Rs.success(userService.getById(id));
    }

    @Override
    public Rs<List<User>> list() {

        return  Rs.success(userService.selectAll());
    }

}
