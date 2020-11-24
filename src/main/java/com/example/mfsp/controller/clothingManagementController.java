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
@RequestMapping("/admin")
public class clothingManagementController {

    @Autowired
    private clothingService clothingservice;


    @RequestMapping(value="/QueryClothing ById",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> QueryClothingById(@RequestParam("id")  Integer id) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        Clothing clothing=new Clothing();
        clothing.setClothingid(id);
        List<Clothing> clothings=new ArrayList<>();
        clothings=clothingservice.selectAll(clothing);
        result.put("count",clothings.size());
        result.put("data", clothings);
        System.out.println("endddd");
        System.out.println(id);
        return result;
    }
  /* questMapping(value="/QueryOrder",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> QueryOrder() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");

        List<Orderform> orderforms=new ArrayList<>();
        orderforms=orderService.selectAll();
        result.put("count",orderforms.size());
        result.put("data", orderforms);
//    System.out.println("endddd");
//
//    System.out.println("orderforms.get(0);"+orderforms.get(0).getOrderformid()+orderforms.get(0).getTotalprice());
        return result;
    }
*/


}
