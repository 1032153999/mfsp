package com.example.mfsp.dao;


import com.example.mfsp.entity.Orderform;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface orderMapper {

    public long addOrder(Orderform orderform);
    public long deleteOrder(Orderform orderform);
    public List<Orderform> selAllOrder();
    public long updateOrder(Orderform orderform);
}
