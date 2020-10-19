package com.wikicloud.user.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wikicloud.user.model.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<User> selectAll();

}
