package com.example.mfsp.controller;

import com.example.mfsp.entity.Shoppingcart;
import com.example.mfsp.service.shoppingcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class QueryShoppingcartController {

    @Autowired
    private shoppingcartService shoppingcartService;

    //通过userid查询用户的购物车
//    @RequestMapping(value="/QueryShoppingcart",method= RequestMethod.GET)
//    @ResponseBody
//    public Map<String, Object> QueryShoppingcartbyid(@RequestParam("userid")  Integer id) {
//        Map<String, Object> result = new HashMap<String, Object>();
//        result.put("code", 0);
//        result.put("msg", "");
//        Shoppingcart shoppingcart =new Shoppingcart();
//        shoppingcart.setUserid(id);
//        List<Shoppingcart> shoppingcarts=new ArrayList<>();
//        shoppingcarts= shoppingcartService.selectAll(shoppingcart);
//        result.put("count",shoppingcarts.size());
//        result.put("data", shoppingcarts);
//        System.out.println("endddd");
//        return result;
//    }

    @RequestMapping(value="/QueryShoppingcart",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> QueryShoppingcartbyid(Shoppingcart shoppingcart) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
    System.out.println(shoppingcart.toString());
        List<Shoppingcart> shoppingcarts=new ArrayList<>();

        shoppingcarts= shoppingcartService.selectAll(shoppingcart);
        result.put("count",shoppingcarts.size());
        result.put("data", shoppingcarts);
        System.out.println("endddd");
        return result;
    }

}
