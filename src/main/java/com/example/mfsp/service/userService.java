package com.example.mfsp.service;

import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.User;

import java.util.List;

public interface userService extends baseService<User>{
    List<User> FuzzySearchUser(String username);
}
