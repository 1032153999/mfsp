package com.example.mfsp.controller;


import com.example.mfsp.entity.Orderform;
import com.example.mfsp.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddOrderController {

    @Autowired
    private orderService orderService;

    @GetMapping("AddOrder")
    @ResponseBody
    public String addOrder(Orderform orderform){

        orderService.insert(orderform);

        return "success";
    }


}
