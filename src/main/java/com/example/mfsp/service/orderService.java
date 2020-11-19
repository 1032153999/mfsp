package com.example.mfsp.service;

import com.example.mfsp.entity.Orderform;

import java.util.List;

public interface orderService {
    public long addOrder(Orderform orderform);
    public long deleteOrder(Orderform orderform);
    public List<Orderform> selAllOrder();
    public long updateOrder(Orderform orderform);

}
