package com.example.mfsp.controller;

import com.example.mfsp.entity.Shoppingcart;
import com.example.mfsp.service.shoppingcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller
public class AddtoShoppingcartController {


    @Autowired
    private shoppingcartService shoppingcartService;

    @GetMapping("Addtoshoppingcart")
    @ResponseBody
    public String addtoShoppingcart(Shoppingcart shoppingcart) {

        Shoppingcart shoppingcart2 =new Shoppingcart();
        shoppingcart2.setUserid(shoppingcart.getUserid());
        shoppingcart2.setClothingid(shoppingcart.getClothingid());
        List<Shoppingcart> shoppingcarts2=new ArrayList<>();
        shoppingcarts2= shoppingcartService.selectAll(shoppingcart2);
//        Integer zhongzhuan = shoppingcarts2.get(0).getSccnum();


//        shoppingcart.setShoppingcartid(1515);
//        shoppingcart.setClothingid(4);
//        shoppingcart.setUserid(19);
//        shoppingcart.setSccnum(151);
        System.out.println("设置成功"+shoppingcart.toString());


        if (shoppingcarts2.size() == 1){

//            shoppingcart.setSccnum(zhongzhuan+1000);
//            shoppingcartService.updateByPrimaryKeySelective(shoppingcart);
            System.out.println("添加成功1");
        }
        else {
//            shoppingcartService.insert(shoppingcart);
            System.out.println("添加成功");}

        return "success";
    }
}
