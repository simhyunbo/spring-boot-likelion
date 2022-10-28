package com.springboot.hello.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    //SpringBoot가 Factory를 구성해서 DI를 해준다.
    public UserDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int deleteAll(){
        return this.jdbcTemplate.update("delete from users");
    }
}
