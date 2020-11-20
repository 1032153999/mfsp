package com.example.mfsp.service;

import com.example.mfsp.entity.Orderform;

import java.util.List;

public interface orderService {
    public int addOrder(Orderform orderform);
    public int deleteOrder(Orderform orderform);
    public List<Orderform> selAllOrder();
    public int updateOrder(Orderform orderform);

}
