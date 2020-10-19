package com.wikicloud.user.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wikicloud.user.model.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<User> selectAll();

    Page<User> selectPage(@Param("page") Page<User> page);

}
