package com.example.mfsp.service.impl;


import com.example.mfsp.dao.orderMapper;
import com.example.mfsp.entity.Orderform;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class orderServiceImpl {

    @Autowired
    private orderMapper orderMapper;

    public int addOrder(Orderform orderform) {

        return orderMapper.addOrder(orderform);
    }


    public int deleteOrder(long stuID) {
        // TODO Auto-generated method stub
        return 0;
    }


    public int updateOrder(Orderform orderform) {
        // TODO Auto-generated method stub
        return 0;
    }


    public List<Orderform> selAllStudent() {
        // TODO Auto-generated method stub
        return orderMapper.selAllOrder();
    }

}
