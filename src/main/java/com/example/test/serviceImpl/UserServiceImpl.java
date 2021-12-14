package com.example.test.serviceImpl;

import com.example.test.bean.UserBean;
import com.example.test.mapper.UserMapper;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBean loginIn(String name, String password) {
        return userMapper.getInfo(name, password);
    }

    @Override
    public int register(int id, String name, String password) {
        return userMapper.Register(id, name, password);
    }

    @Override
    public UserBean findid(int id) {
        return userMapper.findid(id);
    }

    @Override
    public UserBean findname(String name) {
        return userMapper.findname(name);
    }
}
