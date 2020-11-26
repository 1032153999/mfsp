package com.example.mfsp.controller;

import com.example.mfsp.entity.Shoppingcart;
import com.example.mfsp.service.shoppingcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AddtoShoppingcartController {


    @Autowired
    private shoppingcartService shoppingcartService;

    @GetMapping("Addtoshoppingcart")
    @ResponseBody
    public String addtoShoppingcart(Shoppingcart shoppingcart) {

        shoppingcart.setShoppingcartid(65165156);
        shoppingcart.setClothingid(4);
        shoppingcart.setUserid(15);
        shoppingcart.setSccnum(151);
        System.out.println("设置成功");

        shoppingcartService.insert(shoppingcart);

        System.out.println("添加成功");

        return "success";
    }
}
