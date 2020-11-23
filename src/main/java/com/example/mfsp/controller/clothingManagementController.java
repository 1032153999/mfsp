package com.example.mfsp.controller;


import com.example.mfsp.entity.Clothing;
import com.example.mfsp.service.clothingManagementService;
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
public class clothingManagementController {

    @Autowired
    private clothingManagementService clothingManagementservice;


    @RequestMapping(value="/QueryClothingById",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> QueryClothingById(@RequestParam("id")  Integer id) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        Clothing clothing=new Clothing();
        clothing.setClothingid(id);
        List<Clothing> clothings=new ArrayList<>();
        clothings=clothingManagementservice.selectAll(clothing);
        result.put("count",clothings.size());
        result.put("data", clothings);
        System.out.println("endddd");
        System.out.println(id);
        return result;
    }


}
