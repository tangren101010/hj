package com.example.test.service;

import com.example.test.bean.UserBean;


public interface UserService {
    UserBean loginIn(String name, String password);

    int register(int id, String name, String password);

    UserBean findid(int id);

    UserBean findname(String name);
}
