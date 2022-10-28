package com.springboot.hello.controller;

import com.springboot.hello.dao.UserDao;
import com.springboot.hello.domain.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    UserDao userDao;
    @PostMapping("/add")
    public String add(@RequestBody User user) {
        {
            userDao.add(user);
            return "add성공 : " + user.getId();
        }

//    @DeleteMapping
//    public String deleteUser(){
//        userDao.deleteAll();
//        return "delete";
//    }
    }
}
