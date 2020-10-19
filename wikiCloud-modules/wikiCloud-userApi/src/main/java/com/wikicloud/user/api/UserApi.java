package com.wikicloud.user.api;

import com.wikicloud.base.common.response.Rs;
import com.wikicloud.user.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "wiki-userServer",path = UserApi.mapping)
public interface UserApi {

    public final static String mapping = "api/user";

    @RequestMapping(method = RequestMethod.GET, value = "/getUserById")
     Rs<User> getUserById(@RequestParam(value = "id") Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    Rs<List<User>> list();


}
