package com.example.mfsp.controller;

import com.example.mfsp.entity.Shoppingcart;
import com.example.mfsp.service.shoppingcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class DeleteshoppingcartController {

    @Autowired
    private com.example.mfsp.service.shoppingcartService shoppingcartService;


    //删除单一商品的购物车
    @RequestMapping(value = "deleteone")
    @ResponseBody
    public String deleteshoppingcart(Shoppingcart shoppingcart) {
        if (shoppingcart.getShoppingcartid() != null) {
            shoppingcartService.delete(shoppingcart);
            return "";
        } else {
            return "";
        }
    }

//删除所有购物车的商品
    @RequestMapping(value = "deleteall")
    @ResponseBody
    public String deleteallshoppingcart(Shoppingcart shoppingcart){
        if (shoppingcart.getShoppingcartid() != 0){
            return "传值错误";
        }else if(shoppingcart.getUserid() != 0){
            shoppingcartService.delete(shoppingcart);
            return "删除成功";
        }else {
            return "";
        }
    }


}
