package com.wikicloud.user.api;

import com.wikicloud.user.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@FeignClient(value = "wiki-userServer",path = UserApi.mapping)
public interface UserApi {

    public final static String mapping = "api/user";

    @RequestMapping(method = RequestMethod.GET, value = "/getUserById")
    public User getUserById(@RequestParam(value = "id") Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public Flux<User> list();

    public Mono<User> get();

}
