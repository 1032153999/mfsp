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

//
//  一次将所有服装的数据导出  @RequestMapping(value = "/QueryClothing" , method = RequestMethod.GET)
//    @ResponseBody
//    public Map<String, Object> QueryClothing() {
//        Map<String, Object> result = new HashMap<String, Object>();
//        result.put("code", 0);
//        result.put("msg", "");
//
//        List<Clothing> clothings=new ArrayList<>();
//        clothings=clothingService.selectAll();
//        result.put("count",clothings.size());
//        result.put("data", clothings);
//        System.out.println("endddd");
//
//        //System.out.println("orderforms.get(0);"+orderforms.get(0).getOrderformid()+orderforms.get(0).getTotalprice());
//        return result;
//    }

// 通过ID查询单个服装数据
//    @RequestMapping(value="/QueryClothingById",method= RequestMethod.GET)
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
//        System.out.println(id);
//        return result;
//    }

    @RequestMapping(value="/QueryClothingByName",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> QueryClothingById(@RequestParam("id")  String id) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        Clothing clothing=new Clothing();
        clothing.setClothingdescr(id);
        System.out.println(clothing.toString());
        List<Clothing> clothings=new ArrayList<>();

        clothings=clothingService.selectAll(clothing);
        System.out.println("clothings"+clothings.get(0).getClothingdescr());
        result.put("count",clothings.size());
        result.put("data", clothings);
        System.out.println("endddd");

        return result;
    }


}

