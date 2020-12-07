package com.example.mfsp.controller;

import com.example.mfsp.entity.Favourites;
import com.example.mfsp.entity.Shoppingcart;
import com.example.mfsp.service.favouritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class AddtoFavouritesController {

    @Autowired
    private favouritesService favouritesService;
    
    //,@RequestParam("id")  Integer id


//    @GetMapping("Addtofavourties")
//    @ResponseBody
//    public String addtoFavourties(Favourites favourites,@RequestParam("id")  Integer id) {
//
//        Favourites favourites2 = new Favourites();
//        favourites2.setUserid((id));
//        List<Favourites> favourite2=new ArrayList<>();
//        favourite2 =favouritesService.selectAll(favourites2);
//        favourites.setClothingid(4);
//        favourites.setFavouritesid(18);
//        favourites.setUserid(4);
//        System.out.println("设置成功");
//        if (favourite2.size() == 1 ){
//            System.out.println("该商品已存在收藏夹中");
//
//        }else {
//            favouritesService.insert(favourites);
//            System.out.println("添加成功");
//        }
//        return "success";
//    }

    @GetMapping("Addtofavourties")
    @ResponseBody
    public Map<String, Object> addtoFavourties(Favourites favourites) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        Favourites favourites2 = new Favourites();
        favourites2.setClothingid(favourites.getClothingid());
        favourites2.setUserid(favourites.getUserid());
        List<Favourites> favourite2=new ArrayList<>();
        favourite2 =favouritesService.selectAll(favourites2);
//        favourites.setClothingid(4);
//        favourites.setFavouritesid(18);
//        favourites.setUserid(4);
        System.out.println("设置成功");
        if (favourite2.size() == 1 ){
            System.out.println("该商品已存在收藏夹中");
            result.put("msg", "该商品已存在收藏夹中");
        }else {
            favouritesService.insert(favourites);
            System.out.println("添加成功");
            result.put("msg", "添加成功");
        }
        return result;
    }
}
