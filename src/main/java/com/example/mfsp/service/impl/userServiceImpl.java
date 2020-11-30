package com.example.mfsp.service.impl;

import com.example.mfsp.dao.clothingMapper;
import com.example.mfsp.dao.userMapper;
import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.User;
import com.example.mfsp.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl extends baseServiceImpl<User> implements userService {

    @Autowired
    private userMapper usermapper;


    @Override
    public List<User> findByName(String username) {
        return usermapper.findByName(username);
    }

    @Override
    public void register(User user) {
        usermapper.register(user);
    }

    @Override
    public List<User> findByName(String username, String userpassword) {
        return null;
    }

    @Override
    public List<User> FuzzySearchUser(String username) {

        System.out.println(username);
        return usermapper.FuzzySearchUser(username);
    }

}
