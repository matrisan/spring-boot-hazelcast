package com.github.springboothazelcast.pojo;

import com.alibaba.fastjson.JSON;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * <p>
 * 创建时间为 00:00 2019-06-25
 * 项目名称 spring-boot-hazelcast
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class UserDO implements Serializable {

    @Id
    private String id;

    private String name;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
