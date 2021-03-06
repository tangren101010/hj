package com.example.test.mapper;

import com.example.test.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserBean getInfo(String name, String password);

    int Register(int id, String name, String password);

    UserBean findid(int id);

    UserBean findname(String name);
}
