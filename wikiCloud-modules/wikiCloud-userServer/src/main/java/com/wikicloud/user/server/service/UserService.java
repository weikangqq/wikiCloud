package com.wikicloud.user.server.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wikicloud.user.server.mapper.UserMapper;
import com.wikicloud.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Autowired
    private UserMapper userMapper;




}
