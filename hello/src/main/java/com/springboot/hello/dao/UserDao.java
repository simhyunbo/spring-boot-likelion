package com.springboot.hello.dao;

import com.springboot.hello.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    //SpringBoot가 Factory를 구성해서 DI를 해준다.
    public UserDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public void add(User user){

        this.jdbcTemplate.update("insert into users(id,name,password) " +
                "values(?,?,?)",user.getId(),user.getName(),user.getPassword());
    }

    public void delete(String id){
        this.jdbcTemplate.update("delete from users where id = ?",id);
    }
    public void deleteAll(){
        this.jdbcTemplate.update("delete from users");
    }
}
