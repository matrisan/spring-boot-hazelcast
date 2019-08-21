package com.github.springboothazelcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.hazelcast.repository.config.EnableHazelcastRepositories;


/**
 * @author shao
 */
@SpringBootApplication
@EnableHazelcastRepositories
public class SpringBootHazelcastApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHazelcastApplication.class, args);
    }

}
