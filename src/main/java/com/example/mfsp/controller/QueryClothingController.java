package com.example.mfsp.controller;


import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.Orderform;
import com.example.mfsp.service.clothingService;
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
public class QueryClothingController {

    @Autowired
    private clothingService clothingService;


    @RequestMapping(value = "/QueryClothing" , method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> QueryClothing() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");

        List<Clothing> clothings=new ArrayList<>();
        clothings=clothingService.selectAll();
        result.put("count",clothings.size());
        result.put("data", clothings);
        System.out.println("endddd");
        return result;
    }

// 通过ID查询单个服装数据    @RequestMapping(value="/QueryClothingById",method= RequestMethod.GET)
//    @ResponseBody
//    public Map<String, Object> QueryClothingById(@RequestParam("id")  Integer id) {
//        Map<String, Object> result = new HashMap<String, Object>();
//        result.put("code", 0);
//        result.put("msg", "");
//        Clothing clothing=new Clothing();
//        clothing.setClothingid(id);
//        List<Clothing> clothings=new ArrayList<>();
//        clothings=clothingService.selectAll(clothing);
//        result.put("count",clothings.size());
//        result.put("data", clothings);
//        System.out.println("endddd");
//        return result;
//    }

    //通过衣服种类查询单一种类衣服查询。
    @RequestMapping(value="/QueryClothingByType",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> QueryClothingById(@RequestParam("type")  String type) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        Clothing clothing=new Clothing();
        clothing.setClothingtype(type);
        clothing.setClothingstatus("库存");
        List<Clothing> clothings=new ArrayList<>();
        clothings=clothingService.selectAll(clothing);
//        result.put("count",clothings.size());
//        result.put("data", clothings);
        System.out.println("endddd");
        System.out.println(type);
        if (clothings.size() == 0  ){
            result.put("data","搜索不到相关服装");
        }else{
            result.put("count",clothings.size());
            result.put("data", clothings);
        }
        return result;
    }


}

