package com.github.springboothazelcast.controller;

import com.github.springboothazelcast.pojo.UserDO;
import com.github.springboothazelcast.repository.IUserDoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * <p>
 * 创建时间为 13:12 2019-08-15
 * 项目名称 spring-boot-hazelcast
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@DirtiesContext
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("junit")
@RunWith(SpringRunner.class)
public class HazelcastControllerTest {

    /**
     * 模拟mvc测试对象
     */
    @Resource
    private MockMvc mockMvc;

    @Resource
    private IUserDoRepository repository;

    @Before
    public void setUp() {
        for (int i = 0; i < 5; i++) {
            repository.save(getUserDO("name:" + i));
        }
        repository.save(UserDO.builder().id("1").name("name:").build());
    }

    @Test
    public void findAll() throws Exception {
        mockMvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements").value(5))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Test
    public void findById() throws Exception {
        mockMvc.perform(get("/user/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Test
    public void saveUser() {
    }

    @Test
    public void sum() {
    }

    private UserDO getUserDO(String name) {
        return UserDO.builder().name(name).build();
    }


}