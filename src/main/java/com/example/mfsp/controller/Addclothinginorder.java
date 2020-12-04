package com.example.mfsp.controller;

import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.Clothinginorder;
import com.example.mfsp.service.clothinginorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
public class Addclothinginorder {

    @Autowired
    private clothinginorderService clothinginorderService;



    @GetMapping(value = "/clothinginorder")
    @ResponseBody
    private  String  inoder(Clothing clothing, HttpSession httpSession){
        Object zhongzhuan = httpSession.getAttribute("orderid");
        int id =Integer.parseInt(zhongzhuan.toString());
        Clothinginorder clothinginorder = new Clothinginorder();
        clothinginorder.setOrderformid(id);
        clothinginorder.setClothingid(clothing.getClothingid());
        clothinginorder.setClothingprice(clothing.getClothingprice());
        clothinginorder.setClothingname(clothing.getClothingname());
        clothinginorder.setClothingdescr(clothing.getClothingdescr());
        clothinginorder.setCionum(clothing.getClothingnum());
        clothinginorderService.insert(clothinginorder);
        return "";



    }
}
