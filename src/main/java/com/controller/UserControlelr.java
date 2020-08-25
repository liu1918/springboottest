package com.controller;

import com.entity.User;
import com.mapper.UserMapper;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserControlelr {
    @Autowired
    private UserServiceImpl userService;

//    @Autowired
//    private UserMapper userMapper;

    @RequestMapping("list")
    public List<User> queryUserAll() {
        List<User> list = this.userService.findAll();
        return list;
    }

    @RequestMapping("list/{name}")
    public List<User> queryUserAll(@PathVariable String name) {
        List<User> list = this.userService.queryUserByName(name);
        return list;
    }

    @RequestMapping("list/query")
    public List<User> queryUserAll2() {
        List<User> list = this.userService.queryAll();
        return list;
    }

    @RequestMapping("list/{page}/{rows}")
    public List<User> queryUserAll(@PathVariable Integer page, @PathVariable Integer rows) {
        List<User> list = this.userService.queryUserByPage(page, rows);
        return list;
    }
}
