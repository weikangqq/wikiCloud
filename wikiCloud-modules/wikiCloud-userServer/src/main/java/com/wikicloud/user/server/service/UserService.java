package com.wikicloud.user.server.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wikicloud.user.server.mapper.UserMapper;
import com.wikicloud.user.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Autowired
    private UserMapper userMapper;

    public List<User> selectAll(){


        return userMapper.selectAll();

    };

    public Page<User> getPage(@Param("pg") Page<User> page) {
        return userMapper.selectPage(page);
    }

}
