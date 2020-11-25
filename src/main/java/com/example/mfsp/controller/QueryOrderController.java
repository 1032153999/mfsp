package com.example.mfsp.controller;

import com.example.mfsp.entity.Orderform;
import com.example.mfsp.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class QueryOrderController {

   @Autowired
    private orderService orderService;

@RequestMapping(value="/QueryOrder",method= RequestMethod.GET)
@ResponseBody
    public Map<String, Object> queryOrder() {
    Map<String, Object> result = new HashMap<String, Object>();
    result.put("code", 0);
    result.put("msg", "");

    List<Orderform> orderforms=new ArrayList<>();
    orderforms=orderService.selectAll();
    result.put("count",orderforms.size());
    result.put("data", orderforms);
//    System.out.println("endddd");
//
//    System.out.println("orderforms.get(0);"+orderforms.get(0).getOrderformid()+orderforms.get(0).getTotalprice());
    return result;
    }


    @RequestMapping(value="/QueryOrderById",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryOrderById(@RequestParam("orderformid")  Integer orderformid) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");

        List<Orderform> orderforms=new ArrayList<>();
        if(orderformid==null){
            orderforms=orderService.selectAll();
        }else {
            Orderform orderform=new Orderform();
            orderform.setOrderformid(orderformid);
            orderforms=orderService.selectAll(orderform);
        }

        result.put("count",orderforms.size());
        result.put("data", orderforms);
        System.out.println("endddd");
        return result;
    }









}