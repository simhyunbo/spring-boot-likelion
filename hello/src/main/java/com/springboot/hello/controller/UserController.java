package com.springboot.hello.controller;

import com.springboot.hello.dao.UserDao;
import com.springboot.hello.domain.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/add")
    public String add(@RequestBody User user) {

            userDao.add(user);
            return "add성공 : " + user.getId();

    }

    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable String id) {
        userDao.delete(id);
        return "delete성공";
    }

    @DeleteMapping(value = "/deleteAll")
    public String deleteAll(){
        userDao.deleteAll();
        return "deleteAll 성공";
    }

}



