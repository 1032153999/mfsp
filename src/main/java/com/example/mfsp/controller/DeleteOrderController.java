package com.example.mfsp.controller;


import com.example.mfsp.entity.Orderform;
import com.example.mfsp.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeleteOrderController {

    @Autowired
    private orderService orderService;

    @GetMapping("/deleteOrder")
    @ResponseBody
    public String deleteOrder(){

        Orderform orderform=new Orderform();
        orderform.setOrderformid(4);
        orderService.delete(orderform);


        return "success";
    }
}
