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
        Orderform orderFormVo= new Orderform();
        orderFormVo.setOrderformid(orderform.getOrderformid());
        List<Orderform> orderforms=orderService.selectAll(orderFormVo);
        System.out.println("selectAllEnd");
        orderforms.get(0).setOrderstatus(orderform.getOrderstatus());
        orderforms.get(0).setOrderformaddress(orderform.getOrderformaddress());
        orderforms.get(0).setRealityreturmtime(orderform.getRealityreturmtime());
        orderFormVo.setOrderstatus(orderform.getOrderstatus());
//        System.out.println("orderforms.get(0)"+orderforms.get(0).toString());
//        orderforms.get(0).setOrderformaddress(orderform.getOrderformaddress());

        orderService.updateByPrimaryKeySelective(orderFormVo);
//        orderService.updateByExampleSelective(orderform,orderforms.get(0));

//        System.out.println(orderform.toString());

        return "success";
    }

}
