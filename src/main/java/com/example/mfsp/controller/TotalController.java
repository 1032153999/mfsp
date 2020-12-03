package com.example.mfsp.controller;


import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.Orderform;
import com.example.mfsp.service.clothingService;
import com.example.mfsp.service.orderService;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TotalController {

    @Autowired
    private clothingService clothingService;

    @Autowired
    private orderService orderService;

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

//    @RequestMapping(value = "ordertotal")
//    @ResponseBody
//    public Integer totalorders(){
//        List<Orderform> orderforms;
//        Orderform orderform = new Orderform();
//        orderform.setOrderstatus("已处理");
//        orderforms = orderService.selectAll(orderform);
//
//        return  1;
//    }
}
