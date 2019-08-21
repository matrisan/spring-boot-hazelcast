package com.github.springboothazelcast.repository;

import com.github.springboothazelcast.pojo.UserDO;
import org.springframework.data.hazelcast.repository.HazelcastRepository;

/**
 * <p>
 * 创建时间为 00:01 2019-06-25
 * 项目名称 spring-boot-hazelcast
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IUserDoRepository extends HazelcastRepository<UserDO, String> {}