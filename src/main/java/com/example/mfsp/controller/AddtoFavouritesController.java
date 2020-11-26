package com.example.mfsp.controller;

import com.example.mfsp.entity.Favourites;
import com.example.mfsp.entity.Shoppingcart;
import com.example.mfsp.service.favouritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AddtoFavouritesController {

    @Autowired
    private favouritesService favouritesService;


    @GetMapping("Addtofavourties")
    @ResponseBody
    public String addtoFavourties(Favourites favourites) {

        favourites.setClothingid(4);
        favourites.setFavouritesid(18);
        favourites.setUserid(4);
        System.out.println("设置成功");

        favouritesService.insert(favourites);

        System.out.println("添加成功");

        return "success";
    }
}
