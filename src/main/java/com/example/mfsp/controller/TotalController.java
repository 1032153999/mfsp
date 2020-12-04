package com.example.mfsp.controller;


import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.Orderform;
import com.example.mfsp.entity.User;
import com.example.mfsp.service.clothingService;
import com.example.mfsp.service.orderService;
import com.example.mfsp.service.userService;

import org.omg.CORBA.WStringSeqHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class TotalController {

    @Autowired
    private clothingService clothingService;

    @Autowired
    private orderService orderService;

    @Autowired
    private userService userService;

    @RequestMapping(value = "zuliang")
    @ResponseBody
    public Integer totalrent(){
        List<Clothing> clothings;

        clothings = clothingService.selectAll();
        int sum= clothings.stream().mapToInt(Clothing::getClothingmonrentalamount).sum();
        return sum;
    }

    @RequestMapping(value = "xiaoliang")
    @ResponseBody
    public Integer totalsales(){
        List<Clothing> clothings;
        clothings = clothingService.selectAll();
        int sum= clothings.stream().mapToInt(Clothing::getClothingmonthlysales).sum();

        return sum;
    }

    @RequestMapping(value = "ordertotal")
    @ResponseBody
    public Integer totalorders(){
        List<Orderform> orderforms;
        Orderform orderform = new Orderform();
        orderform.setOrderstatus("已处理");
        orderforms = orderService.selectAll(orderform);
        List<String> total = orderforms.stream().map(Orderform::getTotalprice).collect(Collectors.toList());
        System.out.println(total);
        List<Integer> numtotal =new ArrayList<>();
        for (int i = 0; i<total.size(); i++){
            int zhongzhuan = Integer.parseInt(total.get(i));
            System.out.println(zhongzhuan);
            numtotal.add(i,zhongzhuan);
            System.out.println(numtotal);
        }
        int sum = numtotal.stream().reduce(Integer::sum).orElse(0);
        return  sum;
    }


    @RequestMapping(value = "usertotal")
    @ResponseBody
    public Integer usertotal(){
        List<User> users;
        users = userService.selectAll();
        int sum = users.size();

        return sum;
    }
}
