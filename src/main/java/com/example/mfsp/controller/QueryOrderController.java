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

    return result;
    }


    @RequestMapping(value="/QueryOrderById",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryOrderById(@RequestParam("orderformid")  Integer orderformid) {

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");

        List<Orderform> orderforms;
        if(orderformid==0){
            orderforms=orderService.selectAll();
        }else {
            Orderform orderform=new Orderform();
            orderform.setOrderformid(orderformid);
            orderforms=orderService.selectAll(orderform);
        }

        result.put("count",orderforms.size());
        result.put("data", orderforms);

        return result;
    }


    @RequestMapping(value="/QueryOrderByUid",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryOrderByUid(@RequestParam("userid")  Integer userid) {

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");

        List<Orderform> orderforms=new ArrayList<>();
        if(userid==0){
            orderforms=orderService.selectAll();
        }else {
            Orderform orderform=new Orderform();
            orderform.setOrderformid(userid);
            orderforms=orderService.selectAll(orderform);
        }

        result.put("count",orderforms.size());
        result.put("data", orderforms);

        return result;
    }







    @RequestMapping(value="/QueryOrderByIdTest",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryOrderByIdTest(@RequestParam("orderformid")  Integer orderformid) {

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        System.out.println("QueryOrderByIdTest"+orderformid);
        List<Orderform> orderforms=new ArrayList<>();
        if(orderformid==0){
            orderforms=orderService.selectAll();
        }else {
            Orderform orderform=new Orderform();
            orderform.setOrderformid(orderformid);
            orderforms=orderService.selectAll(orderform);
        }

        result.put("count",orderforms.size());
        result.put("data", orderforms);

        return result;
    }

    @RequestMapping(value="/QueryOrderByObjTest",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> queryOrderByObjTest(@RequestBody(required = true) Orderform orderform) {

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        System.out.println("queryOrderByObjTest"+orderform.toString());
        List<Orderform> orderforms=new ArrayList<>();
        if(orderform.getOrderformid()==0){
            orderforms=orderService.selectAll();
        }else {
//            Orderform orderform=new Orderform();
//            orderform.setOrderformid(orderformid);
            orderforms=orderService.selectAll(orderform);
        }

        result.put("count",orderforms.size());
        result.put("data", orderforms);

        return result;
    }








}