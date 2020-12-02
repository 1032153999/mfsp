package com.example.mfsp.controller;


import com.example.mfsp.entity.Orderform;
import com.example.mfsp.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UpdateOrderController {

    @Autowired
    private orderService orderService;
    @RequestMapping(value="/updateOrder",method= RequestMethod.GET)
    @ResponseBody
    public String updateOrder(Orderform orderform){
   orderService.updateByPrimaryKeySelective(orderform);


        return "success";
    }

}
