package com.service.impl;

import com.dao.UserDao;
import com.entity.User;
import com.github.pagehelper.PageHelper;
import com.mapper.UserMapper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        List<User> list = this.userDao.findAll();
        return list;
    }

    public List<User> queryUserByName(String name) {
        List<User> list = this.userMapper.queryUserByName(name);
        return list;
    }

    // 调用使用UserMapper.xml的Mapper
    public List<User> queryAll() {
        List<User> list = this.userMapper.queryAll();
        return list;
    }

    // 使用通用Mapper和分页助手
    public List<User> queryUserByPage(Integer page, Integer rows) {
        // 设置分页
        PageHelper.startPage(page, rows);
        // 使用通用Mapper的方法进行查询所有数据
        List<User> list = this.userMapper.select(null);
        return list;
    }
}
