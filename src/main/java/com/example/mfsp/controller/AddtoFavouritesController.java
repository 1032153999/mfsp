package com.example.mfsp.controller;

import com.example.mfsp.entity.*;
import com.example.mfsp.service.clothingRecommentService;
import com.example.mfsp.service.clothingService;
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

    @Autowired
    private clothingService clothingservice;

    @Autowired
    private clothingRecommentService clothingrecommentservice;
    
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


            /*已经存在clothingid userid
            查询是否具有此推荐项
            有则推荐值+2
            无则 insert 此推荐 推荐值置值2
            * */

            Clothing clothing=new Clothing();
            clothing.setClothingid(favourites.getClothingid());
            List<Clothing> clothings=new ArrayList<>();
            clothings=clothingservice.selectAll(clothing);

            String firstkind=clothings.get(0).getFirstKind();
            String secondkind=clothings.get(0).getSecondKind();
            String thirdlykind=clothings.get(0).getThirdlyKind();

            System.out.println(firstkind+secondkind+thirdlykind);
            clothingclass clothingclass=clothingservice.selectclassid(firstkind,secondkind,thirdlykind);

            System.out.println(clothingclass.toString());
            Clothingrecomment recomment=new Clothingrecomment();
            recomment.setUserid(favourites.getUserid());
            recomment.setClothingclassid(clothingclass.getClassid());
            System.out.println(recomment.getClothingclassid());
            List<Clothingrecomment> recomments=clothingrecommentservice.selectAll(recomment);
            if(recomments.size()>0){

                clothingrecommentservice.updateweight2(recomments.get(0).getClothingrecommentid());
                System.out.println(recomments.get(0).getClothingrecommentid()+"的推荐值+2");
            }else {
                recomment.setRecommendweight(2);
                clothingrecommentservice.insert(recomment);
                System.out.println("insert clothingweight ");
            }


        }
        return result;
    }
}
