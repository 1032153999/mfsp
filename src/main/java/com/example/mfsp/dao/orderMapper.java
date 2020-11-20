package com.example.mfsp.dao;


import com.example.mfsp.entity.Orderform;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface orderMapper {

    public int addOrder(Orderform orderform);
    public int deleteOrder(Orderform orderform);
    public List<Orderform> selAllOrder();
    public int updateOrder(Orderform orderform);
}
