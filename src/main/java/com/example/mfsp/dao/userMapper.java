package com.example.mfsp.dao;

import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface userMapper extends Mapper<User> {
    List<User> FuzzySearchUser(String username);

    //从mapper开始写一个功能

    /**
     * 登录
     */
    List<User> findByName(String username);

    /**
     * 注册
     * @param user
     */
    void register(User user);
}
