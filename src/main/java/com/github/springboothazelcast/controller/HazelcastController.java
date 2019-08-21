package com.github.springboothazelcast.controller;

import com.github.springboothazelcast.pojo.UserDO;
import com.github.springboothazelcast.repository.IUserDoRepository;
import com.github.springboothazelcast.service.HazelcastService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 00:07 2019-06-25
 * 项目名称 spring-boot-hazelcast
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
public class HazelcastController {

    @Resource
    private IUserDoRepository repository;

    @Resource
    private HazelcastService service;

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<UserDO> findAll(@PageableDefault(size = 4, page = 1, sort = "id,asc") Pageable pageable) {
        return repository.findAll(pageable);
    }

    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserDO findById(@PathVariable String id) {
        return repository.findById(id).orElse(UserDO.builder().build());
    }

    @PostMapping(value = "user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserDO saveUser(@RequestBody UserDO userDO) {
        return repository.save(userDO);
    }

    @PostMapping(value = "sum", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Long sum(@RequestBody UserDO userDO) {
        return service.count(userDO);
    }


}
