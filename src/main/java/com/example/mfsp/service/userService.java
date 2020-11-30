package com.example.mfsp.service;

import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.User;

import java.util.Collection;
import java.util.List;

public interface    userService extends baseService<User>{

    //然后写serice,直接复制

    /**
     * 登录
     */
    List<User> findByName(String username);

    /**
     * 注册
     * @param user
     */
    void register(User user);

    List<User> findByName(String username, String userpassword);

    List<User> FuzzySearchUser(String username);

}
