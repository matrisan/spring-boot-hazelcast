package com.github.springboothazelcast.service;

import com.github.springboothazelcast.pojo.UserDO;
import com.hazelcast.aggregation.Aggregators;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 创建时间为 17:55 2019-07-01
 * 项目名称 spring-boot-hazelcast
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class HazelcastService {

    @Resource
    private HazelcastInstance instance;

    public Long count(UserDO userDO) {
        String key = userDO.getId();
        IMap<String, Integer> iMap = instance.getMap(key);
        iMap.merge(key, 1, Integer::sum);
        iMap.setTtl(key, 10, TimeUnit.SECONDS);
        return iMap.aggregate(Aggregators.integerSum());
    }

}
